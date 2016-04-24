package Model.BulletType;

import Model.Bullet;
import Model.Organism;
import Model.Universe;

/**
 * Created by anthony on 4/22/16.
 * Updated by candra on 4/23/16.
 */
public class StraightBullet extends Bullet {
    private final float movementAngle; // in radian
    private final float movementSpeed;
    /**
     * Bullet Constructor
     *
     * @param universe   Universe it belong in
     *                   \return Animal
     * @param x          x location
     * @param y          y location
     * @param currentAge current age
     * @param movementAngle bullet angle movement direction (in radian)
     * @param movementSpeed movement speed of the bullet
     */
    public StraightBullet(Universe universe, int x, int y, float currentAge, float movementAngle, float movementSpeed) {
        super(universe, x, y, currentAge);
        this.movementAngle = movementAngle;
        this.movementSpeed = movementSpeed;
        setNextLocation();
        System.out.println(this.movementAngle + " " + this.movementSpeed );
    }

    
    @Override
    protected final void setNextLocation(){
        targetX = x + new Double(8*Math.sin(movementAngle)).intValue();
        targetY = y + new Double(8*Math.cos(movementAngle)).intValue();
    }

    @Override
    public float speed() {
        return movementSpeed;
    }


    @Override
    public char ch() {
        return 'B';
    }

    @Override
    public int age() {
        return 10000;
    }

    @Override
    public int power() {
        return 100;
    }

    @Override
    public void interact(Organism o) {

    }
}
