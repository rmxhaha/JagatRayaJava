import Factory.OrganismFactory;
import Model.Board;
import Model.Organism;
import Model.Universe;
import Model.BulletType.*;
import Model.Creature.*;



import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int w,h,N;
		w = 20;
		h = 20;
		N = 3;
		
		try {
			Board b = new Board(w,h);
			Universe u = new Universe(b,N);
			OrganismFactory factory = new OrganismFactory(u,0);
                        Organism m = new StraightBullet(u,10,10,0,2,2);
                        Organism m2 = factory.CreateDeer(0, 0);

                        u.add(m);
                        u.add(m2);
                        
			while( true ){
				try {
                                    Thread.sleep(1000);
				}
				catch(Exception e){
				}
				u.board.PrintBoard();
//                                System.out.println(m.getX() + " " + m.getY());
				u.update(1000);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}