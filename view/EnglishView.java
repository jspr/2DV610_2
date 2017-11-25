package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class EnglishView implements IView{

	private PrintStream printStream;
	private BufferedReader bufferedReader;
	private boolean quit = false;
	
	private final String WELCOME_MESSAGE = "Welcome to try your luck on the Slot Machine!";
	private final String INSTRUCTIONS = "Enter '%s' to spin or '%s' to quit: ";
	private final String QUIT_MESSAGE = "Thank you for playing! Bye for now.";
	private final String BETTING_MESSAGE = "Enter amount to bet (min: %s, max: %s): ";
	private final String GAME_OVER_MESSAGE = "GAME OVER! All your credits are belong to us!";
	private final String LOSE_MESSAGE = "No luck this time.";
	private final String WIN_MESSAGE = "Congratulations! You won: %s credit(s).";
	private final String CREDIT = "CREDIT:";
	private final String SPIN_COMMAND = "S";
	private final String QUIT_COMMAND = "Q";
	
	public EnglishView(PrintStream printStream, BufferedReader bufferedReader, TimeUnit timeUnit) {
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

	@Override
	public void displayGameOverMessage() {
		printStream.println(GAME_OVER_MESSAGE);	
	}

	@Override
	public String getGameOverMessage() {
		return GAME_OVER_MESSAGE;
	}

	@Override
	public Collection<String> getReelMessages(Collection<String> inputCollection) {
		String line1 = "  #########  ";
		String line2 = "  #       #  ";
		String line3a = "  #  ";
		String line3b = "  #  ";
		String line4 = "  #       #  ";
		String line5 = "  #########  ";
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		StringBuilder sb5 = new StringBuilder();
		
		Collection<String> returnCollection = new ArrayList<String>();
		
		for(String string : inputCollection) {
			sb1.append(line1);
			sb2.append(line2);
			sb3.append(line3a + string + line3b);
			sb4.append(line4);
			sb5.append(line5);
			returnCollection.add(System.lineSeparator() +
					sb1 + System.lineSeparator() +
					sb2 + System.lineSeparator() +
					sb3 + System.lineSeparator() +
					sb4 + System.lineSeparator() +
					sb5 + System.lineSeparator() +
					System.lineSeparator());
		}
		
		return returnCollection;
	}

	@Override
	public void displayReelMessage(Collection<String> inputCollection) throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		for(String string : getReelMessages(inputCollection)) {
			 printStream.println(string);
			 TimeUnit.SECONDS.sleep(1);
		}
	}

	@Override
	public void displayWinMessage(int winnings) {
		printStream.printf(WIN_MESSAGE + System.lineSeparator(), winnings);	
	}

	@Override
	public void displayLoseMessage() {
		printStream.println(LOSE_MESSAGE);	
	}

	@Override
	public String getWinMessage() {
		return WIN_MESSAGE;
	}

	@Override
	public String getLoseMessage() {
		return LOSE_MESSAGE;
	}


}
