/**
 * Alien class.
 * Alien will kill everything in it's way. Alien have the highest speed.
 */
class Alien extends Carnivore {
    /**
     * Alien Constructor.
     * <p>
     * @param x coordinate alien spawns
     * @param y coordinate alien spawns
     * @param currentAge current age of the alien
     * @param u Universe it belong in
     * \return Alien
     */
    Alien(final Universe u, final int x, final int y, final float currentAge) {
        super(u, x, y, currentAge);
    }

    /**
     * {@inheritDoc}
     */
    protected void update_logic() {
        IntPair preyCoordinate = new IntPair(0, 0);
        IntPair predatorCoordinate = new IntPair(x, y);
        if (!find(preyCoordinate, predatorCoordinate)) {
            move(goRandom());
        } else {
            move(goTo(
                    preyCoordinate.getFirst(),
                    predatorCoordinate.getSecond()
            ));
        }
    }

    /**
     *  find the nearest organism from the alien.
     * @param preyCoordinate Location of the prey
     * @param predatorCoordinate Location of the alien
     * @return true if the prey is found
     */
    public boolean find(final IntPair preyCoordinate,
                        final IntPair predatorCoordinate) {
        Board board = universe.board;
        final int theImpossible = 1000000000;
        int closestPrey = theImpossible;
        boolean preyFound = false;
        preyCoordinate.setFirst(predatorCoordinate.getFirst());
        preyCoordinate.setSecond(predatorCoordinate.getSecond());

        for (int x = 0; x < board.GetH(); ++x) {
            for (int y = 0; y < board.GetW(); ++y) {
                if (board.GetEl(x, y).length() != 0) {
                    preyFound = true;
                    int dx = predatorCoordinate.getFirst() - x;
                    int dy = predatorCoordinate.getSecond() - y;
                    if (closestPrey > dx * dx + dy * dy) {
                        closestPrey = dx * dx + dy * dy;
                        predatorCoordinate.setFirst(x);
                        predatorCoordinate.setSecond(y);
                    }
                }
            }
        }
        return preyFound;
    }

    /**
     * {@inheritDoc}
     */
    public char ch() {
        return '@';
    }

    /**
     * {@inheritDoc}
     */
    public int age() {
        final int theAge = 3;
        return theAge;
    }

    /**
     * {@inheritDoc}
     */
    public int power() {
        final int thePower = 50;
        return thePower;
    }

    /**
     * {@inheritDoc}
     */
    public float speed() {
        final int theSpeed = 50000;
        return theSpeed;
    }

    /**
     * {@inheritDoc}
     */
    public void interact(final Organism partner) {
        partner.forceKill();
    }
}
