package controller;

import model.SlotMachine;
import view.IView;

public class PlayGame {
	
	public void play(SlotMachine slotMachine, IView view) {
		view.displayWelcomeMessage();
		while(!slotMachine.isGameOver() && !view.wantsToQuit()) {
			view.displayCredit(slotMachine.getCredit());
		}
	}

}
