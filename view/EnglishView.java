package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class EnglishView implements IView{

	private PrintStream printStream;
	private BufferedReader bufferedReader;
	private boolean quit = false;
	
	private final String WELCOME_MESSAGE = "Welcome to try your luck on the Slot Machine!";
	private final String INSTRUCTIONS = "Enter '%s' to spin or '%s' to quit: ";
	private final String QUIT_MESSAGE = "Thank you for playing! Bye for now.";
	private final String BETTING_MESSAGE = "Enter amount to bet (min: %s, max: %s): ";
	private final String CREDIT = "CREDIT:";
	private final String SPIN_COMMAND = "S";
	private final String QUIT_COMMAND = "Q";
	
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
	public boolean wantsToQuit() {
		return quit;
	}
	
	@Override
	public boolean collectValidCommand() throws IOException {
		String input = bufferedReader.readLine().trim().toUpperCase();
		if(input.equals(QUIT_COMMAND))
			quit = true;
		return (input.equals(SPIN_COMMAND) || input.equals(QUIT_COMMAND));
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

	@Override
	public void displayCredit(int credit) {
	    printStream.println(getCreditMessage(credit));
	}
	

	@Override
	public String getCreditMessage(int credit) {
		String border = repeatString("#", 5 + CREDIT.length() + Integer.toString(credit).length());
		String creditMessage = border + 
								System.lineSeparator() +
								"# " + CREDIT + " " + credit + " #" +
								System.lineSeparator() +
								border;
		return creditMessage;
	}
	
	private String repeatString(String string, int times) {
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i<times; i++) {
			sb.append(string);
		}
		return sb.toString();
	}





}
