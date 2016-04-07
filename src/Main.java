import Factory.OrganismFactory;
import Model.Board;
import Model.Universe;
import Model.Creature.Organism;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int w,h,N;
		Scanner scanner = new Scanner(System.in);
		w = scanner.nextInt();
		h = scanner.nextInt();
		N = scanner.nextInt();
		
		try {
			Board b = new Board(w,h);
			Universe u = new Universe(b,N);
			OrganismFactory organismFactory = new OrganismFactory(u,0.f);
			Organism eagle =  organismFactory.CreateEagle(0,0);
			Organism human = organismFactory.CreateHuman(1,1);
			
			while( true ){
				try {
					Thread.sleep(100);
				}
				catch(Exception e){
				}
				u.board.PrintBoard();
				u.update(100);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}