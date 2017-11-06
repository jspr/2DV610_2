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
		printStream.println(WELCOME_MESSAGE);
	}
	
	@Override
	public String getWelcomeMessage() {
		return WELCOME_MESSAGE;
	}

	@Override
	public void displayInstructions() {
		printStream.println("Enter 's' to spin or 'q' to quit.");
	}

}
