import Model.ImagePanel;
import Model.Board;
import Model.Pattern;
import Model.Organism;
import Model.Universe;
import Model.BulletType.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Main {
        public static class SpiralOnly implements Model.FilterFunction {
            public boolean call(Organism o){
                return o instanceof SpiralBullet;
            }
        }
	public static void main(String[] args){
            JFrame frame = new JFrame("Test the game");
            frame.setSize(600,800);
            frame.setResizable(false);
                
                
            int w,h,N;
            w = 200;
            h = 300;
            N = 100;

            try {
                Universe u = new Universe(w,h,N);
                frame.setLayout(new BorderLayout());
                frame.add(u, BorderLayout.CENTER);
                frame.setVisible(true);

//                        Organism m = new StraightBullet(u,10,10,0,2,2);
                Pattern pattern = new Pattern(u,100,150,30,10);

                while( true ){
                    try {
                        Thread.sleep(10);
                    }
                    catch(Exception e){
                    }
                    
  //                 Model.FilterFunction f = new SpiralOnly();
//                   System.out.println(u.findNearest(0,0,f));

                    u.update(10);
                    pattern.update(10);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

}