package Model.Creature;


import Model.Organism;
import Model.Plant;
import Model.Universe;

import java.util.Random;

/**
 * Poison_Ivy class.
 * Poison_Ivy can grow or make a new Poison_Ivy object around this object.
 * Any object with herbivore class can die if eat Poison_Ivy class
 */
@Deprecated
public class Poison_Ivy extends Plant {
    /** \brief Poison_Ivy Constructor
     *
     * \param universe Universe it belong in
     * \return Poison_Ivy
     *
     */
    public Poison_Ivy(Universe b, int x, int y,float currentAge){
        super(b,x,y,currentAge);
        universe.board.SetEl(ch(),y,x);
    }
     /** \brief see Organism::ch
     */
    public char ch(){
        return 'P';
    }
     /** \brief see Organism::power
     */
    public int power(){
        return 13;
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
        int ni = x ,nj = y;
        while(!place)
        {
                Random randomG = new Random();
                int i1=randomG.nextInt(3)-1;
                int j1=randomG.nextInt(3)-1;
                if(i1!=0||j1!=0)
                {
                    ni=y+i1;
                    nj=x+j1;
                    place=true;
                }
        }
        if( (nj < universe.board.GetW()&&nj >=0)&& (ni < universe.board.GetH()&& ni >= 0 ) )
        {
            Poison_Ivy P=new Poison_Ivy(universe,nj,ni,0);
            universe.add(P);
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
        if(O instanceof Herbivore){
            O.forceKill();
	}
    }
}