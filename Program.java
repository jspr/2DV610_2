import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import controller.PlayGame;
import model.Reel;
import model.SlotMachine;
import view.EnglishView;
import view.IView;

public class Program {

	public static void main(String[] args) {
		Collection<Reel> reels = new ArrayList<Reel>();
		for(int i=0; i<3; i++) {
			reels.add(new Reel());
		}
		SlotMachine slotMachine = new SlotMachine(1,3,10,reels);
		IView view = new EnglishView(System.out, new BufferedReader(new InputStreamReader(System.in)));
		PlayGame playGame = new PlayGame();
		try {
			playGame.play(slotMachine, view);
		} catch (IOException e) {
			System.out.println("An IOException has been thrown:");
			e.printStackTrace();
		}
	}

}
