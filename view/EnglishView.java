package view;

import java.io.PrintStream;

public class EnglishView implements IView{

	private PrintStream printStream;
	
	public EnglishView(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void displayWelcomeMessage() {
		// TODO Auto-generated method stub
		printStream.println();
	}

}
