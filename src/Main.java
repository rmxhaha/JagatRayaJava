import Model.ImagePanel;
import Model.Board;
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
            N = 3;

            try {
                Universe u = new Universe(w,h,N);
                frame.setLayout(new BorderLayout());
                frame.add(u, BorderLayout.CENTER);
                frame.setVisible(true);

//                        Organism m = new StraightBullet(u,10,10,0,2,2);
                Organism m3 = new StraightBullet(u,100,150,0.f,1.f,10.f);
                Organism m4 = new StraightBullet(u,100,150,0.f,2.f,10.f);
                Organism m5 = new StraightBullet(u,100,150,0.f,3.f,10.f);
                Organism m6 = new StraightBullet(u,100,150,0.f,0.f,10.f);

//                       u.add(m);
                u.add(m3);
                u.add(m4);
                u.add(m5);
                u.add(m6);

                while( true ){
                    try {
                        Thread.sleep(10);
                    }
                    catch(Exception e){
                    }
                    
  //                 Model.FilterFunction f = new SpiralOnly();
//                   System.out.println(u.findNearest(0,0,f));

                    u.update(10);
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

}