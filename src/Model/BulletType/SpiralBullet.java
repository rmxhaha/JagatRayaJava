package Model.BulletType;

import Model.Bullet;
import Model.Organism;
import Model.Universe;

/**
 * Created by anthony on 4/22/16.
 * Updated by candra on 4/23/16.
 */
public class SpiralBullet extends Bullet {
    private float movementAngle; // in radian
    private final float movementSpeed;
    private final float movementAngleSpeed; // in rad / s
    /**
     * SpiralBullet Constructor
     *
     * @param universe   Universe it belong in
     *                   \return Animal
     * @param x          x location
     * @param y          y location
     * @param currentAge current age
     * @param startingMovementAngle bullet angle movement direction (in radian)
     * @param movementSpeed movement speed
     * @param movementAngleSpeed angle trajactory changes in the bullet
     */
    public SpiralBullet(Universe universe, int x, int y, float currentAge, float startingMovementAngle, float movementSpeed, float movementAngleSpeed) {
        super(universe, x, y, currentAge);
        this.movementAngle = startingMovementAngle;
        this.movementSpeed = movementSpeed;
        this.movementAngleSpeed = movementAngleSpeed;
        setNextLocation();

    }

    @Override
    protected void update_logic() {
        float dt = 1 / speed();
        movementAngle += dt * movementAngleSpeed;
        super.update_logic();
    }
    
    @Override
    protected final void setNextLocation(){
        targetX = x + new Double(8*Math.sin(movementAngle)).intValue();
        targetY = y + new Double(8*Math.cos(movementAngle)).intValue();
        System.out.println("nl" + targetX + " " + targetY );
    }

    @Override
    public float speed() {
        return movementSpeed;
    }


    @Override
    public char ch() {
        return 'S';
    }

    @Override
    public int age() {
        return 10000;
    }

    @Override
    public int power() {
        return 0;
    }

    @Override
    public void interact(Organism o) {

    }
}
