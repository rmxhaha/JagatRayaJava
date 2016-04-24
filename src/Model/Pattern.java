package Model;
import Model.BulletType.*;

/**
 * Created by Rmx on 4/23/16.
 */
public class Pattern {
    private final Universe universe;

    public Pattern(Universe u, int cx, int cy, int n, int speed){
        universe = u;

        float a;
        for( a = 0; a < 6.28; a += 6.28 / n ){
            Bullet b = new StraightBullet(universe,cx,cy,0,a,100.f);
            universe.add(b);
        }
    }
    
    public void update(float dt){
        
        
    }
}
