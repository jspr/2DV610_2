package view;

import java.io.PrintStream;

public class EnglishView implements IView{

	private PrintStream printStream;
	
	private final String WELCOME_MESSAGE = "Welcome to try your luck on the Slot Machine!";
	
	public EnglishView(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void displayWelcomeMessage() {
		// TODO Auto-generated method stub
		printStream.println(WELCOME_MESSAGE);
	}
	
	@Override
	public String getWelcomeMessage() {
		return WELCOME_MESSAGE;
	}

	@Override
	public void displayInstructions() {
		// TODO Auto-generated method stub
		
	}

}
