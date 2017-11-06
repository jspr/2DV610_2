package view;

import java.io.PrintStream;

public class EnglishView implements IView{

	private PrintStream printStream;
	
	private final String WELCOME_MESSAGE = "Welcome to try your luck on the Slot Machine!";
	private final String INSTRUCTIONS = "Enter 's' to spin or 'q' to quit.";
	
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
		printStream.println(INSTRUCTIONS);
	}
	
	@Override
	public String getInstructions() {
		return INSTRUCTIONS;
	}

	@Override
	public void displayQuitMessage() {
		printStream.println("Thank you for playing! Bye for now.");	
	}

}
