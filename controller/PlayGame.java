package controller;

import model.SlotMachine;
import view.IView;

public class PlayGame {
	
	public void play(SlotMachine slotMachine, IView view) {
		view.displayWelcomeMessage();
		while(!slotMachine.isGameOver() && !view.wantsToQuit()) { //game loop
			view.displayCredit(slotMachine.getCredit());
		}
		if(slotMachine.isGameOver())
			view.displayGameOverMessage();
		if(view.wantsToQuit())
			view.displayQuitMessage();
	}

}
