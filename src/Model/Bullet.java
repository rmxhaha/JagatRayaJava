package Model;

/**
 * Created by anthony on 4/22/16.
 */
public abstract class Bullet extends Animal {
    /**
     * Bullet Constructor
     * <p/>
     *
     * @param universe   Universe it belong in
     *                   \return Animal
     * @param x          x location
     * @param y          y location
     * @param currentAge current age
     */
    public Bullet(Universe universe, int x, int y, float currentAge) {
        super(universe, x, y, currentAge);
    }
}
