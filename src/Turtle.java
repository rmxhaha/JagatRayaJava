class Turtle extends Herbivore {
	private Race race;
	
	public Turtle( Universe universe, int x, int y, float currentAge ){
		super(universe,x,y,currentAge);
		universe.board.SetEl(ch(),y,x);
		race = null;
	}
	
	protected void update_logic(){
		if( race == null ){
			move(goRandom());
		}
		else {
			if( race.getState()==Race.State.RECRUITMENT ){
				move(goRandom());
			}
			else if( race.getState() == Race.State.WAITING_FOR_COMPETITOR ){
				move(goTo(race.getStartX(),race.getStartY()));
			}
			else if( race.getState() == Race.State.RACING ){
				move(goTo(race.getFinishX(),race.getFinishY()));
			}
			else if( race.getState() == Race.State.RACE_END ){
				race = null;
			}
		}
	}
	public char ch(){
		return 'U';
	}
	public float speed(){
		return 2;
	}
	public int power(){
		return 3;
	}
	public int age(){
		return 20000;
	}
	
	public void interact(Organism O){
		if( O instanceof Grass ){
			O.forceKill();
		}
	}
	
	public void triggerRace(Race _race){
		if( race == null ){
			if( _race.joinTurtle(this)){
				race = _race;
			}
		}
	}
}