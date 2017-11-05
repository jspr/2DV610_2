import controller.PlayGame;
import model.SlotMachine;
import view.EnglishView;
import view.IView;

public class Program {

	public static void main(String[] args) {
		SlotMachine slotMachine = new SlotMachine();
		IView view = new EnglishView();
		PlayGame playGame = new PlayGame();
	}

}
