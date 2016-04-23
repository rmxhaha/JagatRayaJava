package Model.BulletType;

import Model.Bullet;
import Model.Organism;
import Model.Universe;
import Utility.IntPair;

/**
 * Created by anthony on 4/22/16.
 * Updated by candra on 4/23/16.
 */
public class StraightBullet extends Bullet {
    private float movementAngle; // in radian
    private float movementSpeed;
    /**
     * Bullet Constructor
     * <p/>
     *
     * @param universe   Universe it belong in
     *                   \return Animal
     * @param x          x location
     * @param y          y location
     * @param currentAge current age
     * @param movementAngle bullet angle movement direction (in radian)
     */
    public StraightBullet(Universe universe, int x, int y, float currentAge, float movementAngle, float movementSpeed) {
        super(universe, x, y, currentAge);
        this.movementAngle = movementAngle;
        this.movementSpeed = movementSpeed;
    }

    
    @Override
    protected void setNextLocation(){
        targetX = x + new Double(8*Math.sin(movementAngle)).intValue();
        targetY = y + new Double(8*Math.cos(movementAngle)).intValue();
    }

    @Override
    public float speed() {
        return movementSpeed;
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
