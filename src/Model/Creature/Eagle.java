package Model.Creature;


import Model.Universe;
import Model.Creature.Rabbit;
import Model.Creature.Turtle;
import Model.Creature.Carnivore;
import Model.Direction;

public class Eagle extends Carnivore {
    /**
     * \brief Eagle Constructor
     * <p>
     * \param universe Universe it belong in
     * \return Eagle
     */
    public Eagle(Universe u, int x, int y, float currentAge) {
        super(u, x, y, currentAge);
    }

    /**
     * \brief see Organism::ch
     */
    public char ch() {
        return 'E';
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
        return 5;
    }

    /**
     * \brief see Animal::speed
     */
    public float speed() {
        return 7;
    }

    /**
     * \brief see Organism::interact
     */
    public void interact(Organism O) {
        if (O instanceof Turtle) {
            O.forceKill();
        }
        if (O instanceof Rabbit) {
            O.forceKill();
        }
    }

    /**
     * \brief see Animal::update_logic
     */
    protected void update_logic() {
        if (y == 0 && x != universe.board.GetW() - 1) {
            move(Direction.RIGHT);
        } else if (y == universe.board.GetH() - 1 && x != 0) {
            move(Direction.LEFT);
        } else {
            if (x == 0) {
                move(Direction.DOWN);
            } else if (x == universe.board.GetW() - 1) {
                move(Direction.UP);
            } else {
                move(Direction.LEFT);
            }
        }
    }
}