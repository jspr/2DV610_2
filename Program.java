import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import controller.PlayGame;
import model.Reel;
import model.SlotMachine;
import view.EnglishView;
import view.IView;

public class Program {

	public static void main(String[] args) {
		Collection<Reel> reels = new ArrayList<Reel>();
		for(int i=0; i<3; i++) {
			Random random = new SecureRandom();
			reels.add(new Reel(random));
		}
		SlotMachine slotMachine = new SlotMachine(1,3,10,reels);
		IView view = new EnglishView(System.out, new BufferedReader(new InputStreamReader(System.in)), TimeUnit.SECONDS);
		PlayGame playGame = new PlayGame();
		playGame.play(slotMachine, view);
	}

}
