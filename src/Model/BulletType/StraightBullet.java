package Model.BulletType;

import Model.Bullet;
import Model.Organism;
import Model.Universe;

/**
 * Created by anthony on 4/22/16.
 */
public class StraightBullet extends Bullet {
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
    public StraightBullet(Universe universe, int x, int y, float currentAge) {
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
