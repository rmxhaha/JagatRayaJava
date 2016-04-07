package Model.Creature;


import Model.Universe;
import Model.Creature.Plant;

/**
 * Grass class.
 * Grass can grow or make a new grass object around this object.
 */

public class Grass extends Plant {
    /** \brief Grass Constructor
     *
     * \param universe Universe it belong in
     * \return Grass
     *
     */
    public Grass(Universe u, int x, int y,float currentAge){
        super(u,x,y,currentAge);
        universe.board.SetEl(ch(),y,x);
    }
     /** \brief see Organism::ch
     */
    public char ch(){
        return 'G';
    }
     /** \brief see Organism::power
     */
    public int power(){
        return 2;
    }
     /** \brief see Organism::age
     */
    public int age(){
        return 30000;
    }
     /** \brief see Plant::grow
     */
    public void grow(){
        boolean place=false;
        int ni,nj;
		ni = 0;
		nj = 0;

        while(!place){
            int i1=randomGenerator.nextInt(3)-1;
            int j1=randomGenerator.nextInt(3)-1;
            if(i1!=0||j1!=0)
            {
                ni=y+i1;
                nj=x+j1;
                place=true;
            }
        }
        if( (nj < universe.board.GetW()&&nj >=0)&& (ni < universe.board.GetH()&& ni >= 0 ) )
        {
            Grass G=new Grass(universe,nj,ni,0);
            universe.add(G);
        }
    }
     /** \brief see Plant::tgrow
     */
    public float tgrow(){
        return 0.5f;
    }
	/** \brief see Plant::update_grow
     */
    public void update_grow(){
        grow();
    }
     /** \brief see Organism::interact
     */
    public void interact(Organism O){

    }

}