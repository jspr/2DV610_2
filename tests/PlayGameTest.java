package tests;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.PlayGame;
import model.SlotMachine;
import view.IView;


public class PlayGameTest {
	
	private PlayGame sut;
	IView view;
	SlotMachine slotMachine;

	@Before
	public void setUp() {
		sut = new PlayGame();
		view = mock(IView.class);
		slotMachine = mock(SlotMachine.class);
	}

	@After
	public void tearDown() {
	}

	
	@Test
	public void shouldDisplayWelcomeMessageAndCredit_IfGameOverAndWantsToQitIsFalse() throws IOException, InterruptedException {
		when(slotMachine.isGameOver()).thenReturn(false,true); //otherwise we'll get stuck in a loop ad infinitum
		when(view.wantsToQuit()).thenReturn(false,true);
		when(slotMachine.getCredit()).thenReturn(10);
		when(view.collectValidCommand()).thenReturn(true);
		when(slotMachine.getMinBet()).thenReturn(1);
		when(slotMachine.getMaxBet()).thenReturn(3);
		when(view.collectValidBet(1,3)).thenReturn(true);
		when(view.getBet()).thenReturn(2);
		Collection<String> inputCollection = new ArrayList<String>();
		inputCollection.add("010");
		inputCollection.add("010");
		inputCollection.add("010");	
		when(slotMachine.getSymbols()).thenReturn(inputCollection);
		sut.play(slotMachine, view);
		verify(view).displayWelcomeMessage();
		verify(view).displayCredit(10);
	}
	
	@Test
	public void shouldDisplayWelcomeMessage_ShouldNotDisplayCredit_ShouldDisplayGameOverMessage_IfGameOverIsTrue() throws IOException, InterruptedException {
		when(slotMachine.isGameOver()).thenReturn(true);
		when(view.wantsToQuit()).thenReturn(false);
		when(slotMachine.getCredit()).thenReturn(10);
		sut.play(slotMachine, view);
		verify(view).displayWelcomeMessage();
		verify(view, never()).displayCredit(10);
		verify(view).displayGameOverMessage();
	}
	
	@Test
	public void shouldDisplayWelcomeMessage_ShouldNotDisplayCredit_ShouldDisplayQuitMessage_IfWantsToQuitIsTrue() throws IOException, InterruptedException {
		when(slotMachine.isGameOver()).thenReturn(false);
		when(view.wantsToQuit()).thenReturn(true);
		when(slotMachine.getCredit()).thenReturn(10);
		sut.play(slotMachine, view);
		verify(view).displayWelcomeMessage();
		verify(view, never()).displayCredit(10);
		verify(view).displayQuitMessage();
	}
	
	@Test
	public void shouldDisplayInstructionsAgainWhenInvalidCommand() throws IOException, InterruptedException {
		when(slotMachine.isGameOver()).thenReturn(false,true);
		when(view.wantsToQuit()).thenReturn(false);
		when(slotMachine.getCredit()).thenReturn(10);
		when(view.collectValidCommand()).thenReturn(false,false,false,true);
		when(slotMachine.getMinBet()).thenReturn(1);
		when(slotMachine.getMaxBet()).thenReturn(3);
		when(view.collectValidBet(1,3)).thenReturn(true);
		when(view.getBet()).thenReturn(2);
		Collection<String> inputCollection = new ArrayList<String>();
		inputCollection.add("010");
		inputCollection.add("010");
		inputCollection.add("010");	
		when(slotMachine.getSymbols()).thenReturn(inputCollection);
		sut.play(slotMachine, view);		
		verify(view, times(4)).displayInstructions();
	}
	
	@Test
	public void shouldDisplayBettingMessageAgainWhenInvalidCommand() throws IOException, InterruptedException {
		when(slotMachine.isGameOver()).thenReturn(false,true);
		when(view.wantsToQuit()).thenReturn(false);
		when(slotMachine.getCredit()).thenReturn(10);
		when(view.collectValidCommand()).thenReturn(true);
		when(slotMachine.getMinBet()).thenReturn(1);
		when(slotMachine.getMaxBet()).thenReturn(3);
		when(view.collectValidBet(1,3)).thenReturn(false,false,false,true);
		when(view.getBet()).thenReturn(2);
		Collection<String> inputCollection = new ArrayList<String>();
		inputCollection.add("010");
		inputCollection.add("010");
		inputCollection.add("010");	
		when(slotMachine.getSymbols()).thenReturn(inputCollection);
		sut.play(slotMachine, view);		
		verify(view, times(4)).collectValidBet(1,3);
	}
	
	@Test
	public void shouldCallSpinOnSlotMachine() throws IOException, InterruptedException {
		when(slotMachine.isGameOver()).thenReturn(false,true);
		when(view.wantsToQuit()).thenReturn(false);
		when(slotMachine.getCredit()).thenReturn(10);
		when(view.collectValidCommand()).thenReturn(true);
		when(slotMachine.getMinBet()).thenReturn(1);
		when(slotMachine.getMaxBet()).thenReturn(3);
		when(view.collectValidBet(1,3)).thenReturn(true);
		when(view.getBet()).thenReturn(2);
		Collection<String> inputCollection = new ArrayList<String>();
		inputCollection.add("010");
		inputCollection.add("010");
		inputCollection.add("010");	
		when(slotMachine.getSymbols()).thenReturn(inputCollection);
		sut.play(slotMachine, view);		
		verify(slotMachine).spin(2);
	}
	
	@Test
	public void shouldDisplayReelMessage() throws IOException, InterruptedException {
		when(slotMachine.isGameOver()).thenReturn(false,true);
		when(view.wantsToQuit()).thenReturn(false);
		when(slotMachine.getCredit()).thenReturn(10);
		when(view.collectValidCommand()).thenReturn(true);
		when(slotMachine.getMinBet()).thenReturn(1);
		when(slotMachine.getMaxBet()).thenReturn(3);
		when(view.collectValidBet(1,3)).thenReturn(true);
		when(view.getBet()).thenReturn(2);
		when(slotMachine.spin(2)).thenReturn(2);
		Collection<String> inputCollection = new ArrayList<String>();
		inputCollection.add("010");
		inputCollection.add("010");
		inputCollection.add("010");	
		when(slotMachine.getSymbols()).thenReturn(inputCollection);
		sut.play(slotMachine, view);		
		verify(view).displayReelMessage(inputCollection);
	}
	
	
}
