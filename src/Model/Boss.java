package Model;

/**
 * Created by anthony on 4/22/16.
 * Updated by candra on 4/23/16.
 */
public class Boss extends Animal {
	private float health;
    /**
     * Boss Constructor
     * <p/>
     *
     * @param universe   Universe it belong in
     *                   \return Animal
     * @param x          x location
     * @param y          y location
     * @param currentAge current age
     */
    public Boss(Universe universe, int x, int y, float currentAge, float chealth) {
        super(universe, x, y, currentAge);
		health = chealth;
    }

    @Override
    public float speed() {
        return 0;
    }

    @Override
    protected void update_logic() {

    }

    @Override
    public char ch() {
        return 0;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public int power() {
        return 0;
    }
	
	public float getHealth(){
		return health;
	}

    @Override
    public void interact(Organism o) {
		if( o instanceof Bullet ){
			health -= o.power();
			if( health < 0 )
				forceKill();
		}
    }
}
