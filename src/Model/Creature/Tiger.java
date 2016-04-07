package Model.Creature;


import Utility.IntPair;
import Model.Universe;
import Model.Creature.Carnivore;

/**
 * Tiger class.
 * Tiger will chase deer and horse.
 * Tiger can eat deer and horse.
 */

public class Tiger extends Carnivore {
    /**
     * \brief Tiger Constructor
     * <p>
     * \param universe Universe it belong in
     * \return Tiger
     */
    public Tiger(Universe u, int x, int y, float currentAge) {
        super(u, x, y, currentAge);
    }

    /**
     * \brief see Animal::update_logic
     */
    protected void update_logic() {
        IntPair preyCoordinate = new IntPair(0, 0);
        IntPair predatorCoordinate = new IntPair(x, y);
        if (findPrey('D', preyCoordinate, predatorCoordinate)) {
            move(goTo(preyCoordinate.getFirst(), predatorCoordinate.getSecond()));
        } else if (findPrey('H', preyCoordinate, predatorCoordinate)) {
            move(goTo(preyCoordinate.getFirst(), predatorCoordinate.getSecond()));
        } else {
            move(goRandom());
        }
    }

    /**
     * \brief see Organism::ch
     */
    public char ch() {
        return 'T';
    }

    /**
     * \brief see Organism::age
     */
    public int age() {
        return 30000;
    }

    /**
     * \brief see Organism::power
     */
    public int power() {
        return 8;
    }

    /**
     * \brief see Animal::speed
     */
    public float speed() {
        return 5;
    }

    /**
     * \brief see Organism::interact
     */
    public void interact(Organism O) {
        if (O instanceof Deer) {
            O.forceKill();
        } else if (O instanceof Horse) {
            O.forceKill();
        }
    }
}