/**
 * Alien class.
 * Alien will kill everything in it's way. Alien have the highest speed.
 */
class Alien extends Carnivore {
    /**
     * \brief Alien Constructor
     * <p>
     * \param universe Universe it belong in
     * \return Alien
     */
    public Alien(Universe u, int x, int y, float currentAge) {
        super(u, x, y, currentAge);
    }

    /**
     * \brief see Animal::update_logic
     */
    protected void update_logic() {
        IntPair preyCoordinate = new IntPair(0, 0);
        IntPair predatorCoordinate = new IntPair(x, y);
        if (!find(preyCoordinate, predatorCoordinate)) {
            move(goRandom());
        } else {
            move(goTo(preyCoordinate.getFirst(), predatorCoordinate.getSecond()));
        }
    }

    /**
     * \brief find the nearest organism from the alien
     * \param prey_x, prey_y Location of the prey
     * \param predator_x,predator_y Location of the alien
     */
    public boolean find(IntPair preyCoordinate, IntPair predatorCoordinate) {
        Board board = universe.board;
        int closest_prey = 1000000000;
        boolean prey_found = false;
        preyCoordinate.setFirst(predatorCoordinate.getFirst());
        preyCoordinate.setSecond(predatorCoordinate.getSecond());

        for (int x = 0; x < board.GetH(); ++x) {
            for (int y = 0; y < board.GetW(); ++y) {
                if (board.GetEl(x, y).length() != 0) {
                    prey_found = true;
                    int dx = predatorCoordinate.getFirst() - x;
                    int dy = predatorCoordinate.getSecond() - y;
                    if (closest_prey > dx * dx + dy * dy) {
                        closest_prey = dx * dx + dy * dy;
                        predatorCoordinate.setFirst(x);
                        predatorCoordinate.setSecond(y);
                    }
                }
            }
        }
        return prey_found;
    }

    /**
     * \brief see Organism::ch
     */
    public char ch() {
        return '@';
    }

    /**
     * \brief see Organism::age
     */
    public int age() {
        return 3;
    }

    /**
     * \brief see Organism::power
     */
    public int power() {
        return 50;
    }

    /**
     * \brief see Animal::speed
     */
    public float speed() {
        return 50000;
    }

    /**
     * \brief see Organism::interact
     */
    public void interact(Organism O) {
        O.forceKill();
    }
}