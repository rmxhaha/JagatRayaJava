package Model.Creature;


import Model.Universe;
import Model.Creature.Carnivore;

public class Human extends Carnivore {
    private static int maxOffspring = 2;

    private int offspringCount;

    /**
     * \brief Human Constructor
     * <p>
     * \param universe Universe it belong in
     * \return Human
     */
    public Human(Universe universe, int x, int y, float currentAge) {
        super(universe, x, y, currentAge);
    }

    /**
     * \brief see Organism::ch
     */
    public char ch() {
        return 1;
    }

    /**
     * \brief see Organism::age
     */
    public int age() {
        return 50000;
    }

    /**
     * \brief see Organism::power
     */
    public int power() {
        return 1;
    }

    /**
     * \brief see Animal::speed
     */
    public float speed() {
        return 3;
    }

    /**
     * \brief see Organism::interact
     */
    public void interact(Organism o) {
        if (o instanceof Human) {
            Human h = (Human) o;
            if (offspringCount < Human.maxOffspring && h.offspringCount < Human.maxOffspring) {
                offspringCount++;
                h.offspringCount++;
                copulate();
            }
        }
    }


    /**
     * Copulate wll generate new Human if 2 Human interact, copulate has limit to prevent overpopulation.
     */
    private void copulate() {
        Human h = new Human(universe, getX(), getY(), 0);
        universe.add(h);
    }

    /**
     * \brief see Animal::update_logic
     */
    protected void update_logic() {
        move(goRandom());
    }
}