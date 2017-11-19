import controller.PlayGame;
import model.SlotMachine;
import view.EnglishView;
import view.IView;

public class Program {

	public static void main(String[] args) {
		SlotMachine slotMachine = new SlotMachine(1,3,10);
		IView view = new EnglishView(System.out);
		PlayGame playGame = new PlayGame();
	}

}
