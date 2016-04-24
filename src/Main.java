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
                
                
/*
                ImagePanel panel = new ImagePanel();
                frame.setLayout(new BorderLayout());
                frame.add(panel, BorderLayout.CENTER);
*/
                frame.setVisible(true);

		int w,h,N;
		w = 20;
		h = 20;
		N = 3;
		
		try {
			Universe u = new Universe(w,h,N);
                frame.setLayout(new BorderLayout());
                frame.add(u, BorderLayout.CENTER);
//                        Organism m = new StraightBullet(u,10,10,0,2,2);
                        Organism m3 = new SpiralBullet(u,10,10,0,1,1,3.f);

 //                       u.add(m);
                        u.add(m3);
                        
			while( true ){
                            try {
                                Thread.sleep(1000);
                            }
                            catch(Exception e){
                            }
                           Model.FilterFunction f = new SpiralOnly();
                           System.out.println(u.findNearest(0,0,f));

                            u.update(1000);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}

        }

}