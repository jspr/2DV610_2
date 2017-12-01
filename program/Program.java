package program;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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
	
	private static Collection<Reel> reels = new ArrayList<Reel>();;
	private static SlotMachine slotMachine = setUpSlotMachine(setUpReels(reels));
	private static IView view = setUpView();
	private static PlayGame playGame = setUpPlayGame();

	public static void main(String[] args) throws IOException, InterruptedException {
		playGame.play(slotMachine, view);
	}

	public static SlotMachine setUpSlotMachine(Collection<Reel> reels) {
		return new SlotMachine(1,3,10,reels);
	}

	public static PlayGame setUpPlayGame() {
		return new PlayGame();
	}

	public static IView setUpView() {
		return new EnglishView(System.out, new BufferedReader(new InputStreamReader(System.in)), TimeUnit.SECONDS);
	}

	public static Collection<Reel> setUpReels(Collection<Reel> reels) {
        for(int i=0; i<3; i++) {
			Random random = new SecureRandom();
			reels.add(new Reel(random));
		}
        return reels;
    }
	
	public static void setPlayGame(PlayGame playGame) {
        Program.playGame = playGame;
    }
	
	public static void setSlotMachine(SlotMachine slotMachine) {
        Program.slotMachine = slotMachine;
    }
	
	public static void setView(IView view) {
        Program.view = view;
    }

	public static void setPrintStream(PrintStream printStream) {
		// TODO Auto-generated method stub
		
	}
	

}
