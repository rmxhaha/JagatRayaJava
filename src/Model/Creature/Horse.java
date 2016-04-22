package Model.Creature;

import Model.Organism;
import Model.Universe;
import Utility.IntPair;

/**
 * Horse class.
 * Horse can eat plants.
 */
@Deprecated
public class Horse extends Herbivore{
    /** \brief Horse Constructor
     *
     * \param universe Universe it belong in
     * \return Horse
     *
     */
    public Horse(Universe u,int x,int y,float currentAge){
        super(u,x,y,currentAge);
        universe.board.SetEl(ch(),y,x);
    }
    /** \brief see Animal::update_logic
    */
    protected void update_logic(){
        //Update Horse move
        IntPair preyCoordinate = new IntPair(0, 0);
        IntPair predatorCoordinate = new IntPair(x, y);
		if(!findPrey('G',preyCoordinate, predatorCoordinate)&&!findPrey('P',preyCoordinate, predatorCoordinate)){
			move(goRandom());
		}
		else{
			move(goTo(preyCoordinate.getFirst(), predatorCoordinate.getSecond()));
		}
    }
    /** \brief see Organism::ch
     */
    public char ch(){
        return 'H';
    }
    /** \brief see Organism::age
     */
    public int age(){
        return 30000;
    }
    /** \brief see Organism::power
     */
    public int power(){
        return 5;
    }
    /** \brief see Animal::speed
     */
    public float speed(){
        return 5.0f;
    }
    /** \brief see Organism::interact
     */
    public void interact(Organism O){
        if(O instanceof Grass){
            O.forceKill();
		}
    }
}
