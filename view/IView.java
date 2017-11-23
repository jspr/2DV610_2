package view;

import java.io.IOException;

public interface IView
{
  void displayWelcomeMessage();
  String getWelcomeMessage();
  void displayInstructions();
  String getInstructions();
  void displayQuitMessage();
  String getQuitMessage();
  void displayBettingMessage(int min, int max);
  String getBettingMessage();
  boolean wantsToQuit() throws IOException;
  String getSpinCommand();
  String getQuitCommand();
  void displayCredit(int credit);
  String getCreditMessage(int credit);
  boolean wantsToSpin() throws IOException;
  boolean collectValidCommand();
}
