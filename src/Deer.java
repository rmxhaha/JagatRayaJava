/**
 * Deer class.
 * Deer can eat plants.
 * Deer can avoid tiger if tiger is near. Deer will look for other deer if tiger is far.
 */
class Deer extends Herbivore {
    /**
     * \brief Deer Constructor
     * <p>
     * \param universe Universe it belong in
     * \return Deer
     */
    public Deer(Universe u, int x, int y, float currentAge) {
        super(u, x, y, currentAge);
    }

    /**
     * \brief see Animal::update_logic
     */
    protected void update_logic() {
        IntPair preyCoordinate = new IntPair(0, 0);
        IntPair predatorCoordinate = new IntPair(x, y);
        if (findPrey('T', preyCoordinate, predatorCoordinate)) {
            move(avoid(preyCoordinate.getFirst(), predatorCoordinate.getSecond()));
        } else {
            if (findPrey('D', preyCoordinate, predatorCoordinate)) {
                move(goTo(preyCoordinate.getFirst(), predatorCoordinate.getSecond()));
            } else {
                move(goRandom());
            }
        }
    }

    /**
     * \brief see Organism::ch
     */
    public char ch() {
        return 'D';
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
        return 5;
    }

    /**
     * \brief see Organism::interact
     */
    public void interact(Organism O) {
        if (O instanceof Grass) {
            O.forceKill();
        }
    }
}