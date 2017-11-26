package controller;

import java.io.IOException;

import model.SlotMachine;
import view.IView;

public class PlayGame {
	
	public void play(SlotMachine slotMachine, IView view) throws IOException, InterruptedException {
		view.displayWelcomeMessage();
		while(!slotMachine.isGameOver() && !view.wantsToQuit()) { //game loop
			view.displayCredit(slotMachine.getCredit());
			do {
				view.displayInstructions();
			}while(!view.collectValidCommand());
			if(!view.wantsToQuit()) {
				do {
					view.displayBettingMessage(slotMachine.getMinBet(),slotMachine.getMaxBet());
				}while(!view.collectValidBet(slotMachine.getMinBet(),slotMachine.getMaxBet()));
				slotMachine.spin(view.getBet());
				view.displayReelMessage(slotMachine.getSymbols());
			}
		}
		if(slotMachine.isGameOver())
			view.displayGameOverMessage();
		if(view.wantsToQuit())
			view.displayQuitMessage();
	}

}
