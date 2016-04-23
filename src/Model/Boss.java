package Model;

/**
 * Created by anthony on 4/22/16.
 */
public class Boss extends Animal {
    /**
     * Boss Constructor
     * <p/>
     *
     * @param universe   Universe it belong in
     *                   \return Animal
     * @param x          x location
     * @param y          y location
     * @param currentAge current age
     */
    public Boss(Universe universe, int x, int y, float currentAge) {
        super(universe, x, y, currentAge);
    }

    @Override
    public float speed() {
        return 0;
    }

    @Override
    protected void update_logic() {

    }

    @Override
    public char ch() {
        return 0;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public int power() {
        return 0;
    }

    @Override
    public void interact(Organism o) {

    }
}
