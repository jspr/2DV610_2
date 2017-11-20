package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class EnglishView implements IView{

	private PrintStream printStream;
	private BufferedReader bufferedReader;
	
	private final String WELCOME_MESSAGE = "Welcome to try your luck on the Slot Machine!";
	private final String INSTRUCTIONS = "Enter '%s' to spin or '%s' to quit: ";
	private final String QUIT_MESSAGE = "Thank you for playing! Bye for now.";
	private final String BETTING_MESSAGE = "Enter amount to bet (min: %s, max: %s): ";
	private final String SPIN_COMMAND = "s";
	private final String QUIT_COMMAND = "q";
	
	public EnglishView(PrintStream printStream, BufferedReader bufferedReader) {
		this.printStream = printStream;
		this.bufferedReader = bufferedReader;
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
		printStream.printf(INSTRUCTIONS,SPIN_COMMAND,QUIT_COMMAND);
	}
	
	@Override
	public String getInstructions() {
		return INSTRUCTIONS;
	}

	@Override
	public void displayQuitMessage() {
		printStream.println(QUIT_MESSAGE);	
	}
	
	@Override
	public String getQuitMessage() {
		return QUIT_MESSAGE;
	}

	@Override
	public boolean wantsToQuit() throws IOException {
		return bufferedReader.readLine().trim().toUpperCase().equals("Q");
	}

	@Override
	public void displayBettingMessage(int min, int max) {
		printStream.printf(BETTING_MESSAGE, min, max);	
	}

	@Override
	public String getBettingMessage() {
		return BETTING_MESSAGE;
	}

	@Override
	public String getSpinCommand() {
		return SPIN_COMMAND;
	}

	@Override
	public String getQuitCommand() {
		return QUIT_COMMAND;
	}

}
