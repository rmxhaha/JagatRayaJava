package Model;

import Utility.IntPair;

public abstract class Animal extends Organism {
    protected float timeBuffer;

    /**
     * Animal Constructor
     * <p/>
     *
     * @param universe   Universe it belong in
     *                   \return Animal
     * @param x x location
     * @param y y location
     * @param currentAge current age
     */
    public Animal(Universe universe, int x, int y, float currentAge) {
        super(universe, x, y, currentAge);
        timeBuffer = (float) 0.0;
    }

    /**
     *  speed of animal for moving
     * @return float
     */
    public abstract float speed();

    /**
     *  Time buffer of the animal
     * @return float
     */
    public float getTimeBuffer() {
        return timeBuffer;
    }

    /**
     *  do the animal behaviour if reach time.
     * @param dt delta time for doing the animal behaviour
     */
    public void update(float dt) {
        super.update(dt);
        if (isDead()) {
            return;
        }
        float d = 1000 / speed();
        timeBuffer += dt;

        while (timeBuffer > d) {
            update_logic();
            timeBuffer -= d;
        }
    }

    /**
     *  find the direction where animal should move to, if the animal want to run from its predator.
     * @param tx,ty Location of the thing animal should avoid
     * \return Direction
     */
    protected Direction avoid(int tx, int ty) {
        if (tx < x) { // run right
            if (ty < y) // run up
                return Direction.UP_RIGHT;
            if (ty > y) // run down
                return Direction.DOWN_RIGHT;
            return Direction.RIGHT;
        }
        if (x < tx) { // run left
            if (ty < y) // run up
                return Direction.UP_LEFT;
            if (ty > y) // run down
                return Direction.DOWN_LEFT;
            return Direction.LEFT;
        }
        if (ty < y) // run up
            return Direction.UP;
        if (ty > y) // run down
            return Direction.DOWN;
        // on the same coor
        return Direction.UP_LEFT;
    }

    /**
     *  find the direction where animal should move to, if the animal want to go to its prey / herd.
     * @param tx,ty Location of the thing animal should go to.
     * \return Direction
     */
    protected Direction goTo(int tx, int ty) {
        if (tx > x) { // run right
            if (ty > y) // run up
                return Direction.UP_RIGHT;
            if (ty < y) // run down
                return Direction.DOWN_RIGHT;
            return Direction.RIGHT;
        }
        if (x > tx) { // run left
            if (ty > y) // run up
                return Direction.UP_LEFT;
            if (ty < y) // run down
                return Direction.DOWN_LEFT;
            return Direction.LEFT;
        }
        if (ty > y) // run up
            return Direction.UP;
        if (ty < y) // run down
            return Direction.DOWN;
        return Direction.NO_WHERE;
    }

    /**
     *  return random direction.
     * \return Direction
     */
    protected Direction goRandom() {
        int d = randomGenerator.nextInt(8);
        switch (d) {
            case 0:
                return Direction.UP;
            case 1:
                return Direction.DOWN;
            case 2:
                return Direction.LEFT;
            case 3:
                return Direction.RIGHT;
            case 4:
                return Direction.UP_LEFT;
            case 5:
                return Direction.UP_RIGHT;
            case 6:
                return Direction.DOWN_LEFT;
            case 7:
                return Direction.DOWN_RIGHT;
            default:
                return Direction.UP;
        }
    }

    /**
     *  find the nearest target from the Animal
     * @param prey_ch symbol of the target
     * @param preyCoordinate Location of the prey
     * @param predatorCoordinate Location of the Animal
     */
    protected boolean findPrey(char prey_ch, IntPair preyCoordinate, IntPair predatorCoordinate) {
        Board board = universe.board;
        int closest_prey = 1000000000;
        boolean prey_found = false;
        preyCoordinate.setFirst(predatorCoordinate.getFirst());
        preyCoordinate.setSecond(predatorCoordinate.getSecond());

        for (int x = 0; x < board.GetH(); ++x) {
            for (int y = 0; y < board.GetW(); ++y) {
                if (board.GetEl(x, y).indexOf(prey_ch + "") != -1) {
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
     *  move to the direction
     * @param direction direction where the animal should move to
     */
    protected void move(Direction direction) {
        int dx = 0, dy = 0;

        switch (direction) {
            case NO_WHERE:
                break;
            case UP:
                dy = 1;
                break;
            case DOWN:
                dy = -1;
                break;
            case LEFT:
                dx = -1;
                break;
            case RIGHT:
                dx = 1;
                break;
            case UP_LEFT:
                dy = 1;
                dx = -1;
                break;
            case DOWN_LEFT:
                dy = -1;
                dx = -1;
                break;
            case UP_RIGHT:
                dy = 1;
                dx = 1;
                break;
            case DOWN_RIGHT:
                dy = -1;
                dx = 1;
                break;
        }


        // plus GetW GetH is for negative number mod
        int tx = x + dx;
        int ty = y + dy;

        if (tx >= universe.board.GetW())
            tx = universe.board.GetW() - 1;
        else if (tx < 0)
            tx = 0;

        if (ty >= universe.board.GetH())
            ty = universe.board.GetH() - 1;
        else if (ty < 0)
            ty = 0;


        // update The board here


        if (x == tx && y == ty) return;

        universe.board.DelEl(ch(), y, x);
        universe.board.SetEl(ch(), ty, tx);
        x = tx;
        y = ty;
        universe.notifyMovement(this);
    }

    /**
     *  behaviour of the animal
     */
    protected abstract void update_logic();

}