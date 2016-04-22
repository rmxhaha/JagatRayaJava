package Model;

/**
 * Created by anthony on 4/22/16.
 */
public class Wall extends Plant {
    /**
     * \brief Plant Constructor
     * <p/>
     * \param u universe it belongs in
     *
     * @param u
     * @param x
     * @param y
     * @param currentAge
     */
    public Wall(Universe u, int x, int y, float currentAge) {
        super(u, x, y, currentAge);
    }

    @Override
    protected void grow() {

    }

    @Override
    protected float tgrow() {
        return 0;
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
