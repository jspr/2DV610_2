package controller;

import java.io.IOException;

import model.SlotMachine;
import view.IView;

public class PlayGame {
	
	public void play(SlotMachine slotMachine, IView view) throws IOException {
		view.displayWelcomeMessage();
		view.displayInstructions();
		if(view.wantsToQuit()) {
			view.displayQuitMessage();
		} else {
			view.displayBettingMessage(slotMachine.getMinBet(), slotMachine.getMaxBet());
		}
	}

}
