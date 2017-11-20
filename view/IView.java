package view;

public interface IView
{
  void displayWelcomeMessage();
  String getWelcomeMessage();
  void displayInstructions();
  String getInstructions();
  void displayQuitMessage();
  String getQuitMessage();
  boolean wantsToQuit();
  void displayBettingMessage(int min, int max);
}
