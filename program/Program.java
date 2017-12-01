package program;
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
	
	

}
