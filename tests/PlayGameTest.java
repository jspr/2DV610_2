package tests;

import static org.mockito.Mockito.*;

import java.io.IOException;

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
	public void setUp() throws Exception {
		sut = new PlayGame();
		view = mock(IView.class);
		slotMachine = mock(SlotMachine.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldDisplayWelcomeMessage() throws IOException {
		sut.play(slotMachine, view);
		verify(view).displayWelcomeMessage();
	}
	
	@Test
	public void shouldDisplayInstructions() throws IOException {
		sut.play(slotMachine, view);
		verify(view).displayInstructions();
	}
	
	@Test
	public void shouldDisplayCredit() throws IOException {
		sut.play(slotMachine, view);
		verify(view).displayCredit(10);
	}
	
	@Test
	public void shouldDisplayBettingMessage() throws IOException {
		when(slotMachine.getMinBet()).thenReturn(1);
		when(slotMachine.getMaxBet()).thenReturn(3);
		sut.play(slotMachine, view);
		verify(view).displayBettingMessage(1,3);
	}
	
	@Test
	public void shouldDisplayWelcomeMessageInstructionsNotBettingMessageAndQuit() throws IOException {
		when(view.wantsToQuit()).thenReturn(true);
		sut.play(slotMachine, view);		
		verify(view).displayWelcomeMessage();
		verify(view).displayInstructions();
		verify(view).displayQuitMessage();
		verify(view, never()).displayBettingMessage(1,3);
	}
	
	@Test
	public void shouldDisplayWelcomeMessageInstructionsAndBettingMessageNotQuit() throws IOException {
		when(view.wantsToQuit()).thenReturn(false);
		when(slotMachine.getMinBet()).thenReturn(1);
		when(slotMachine.getMaxBet()).thenReturn(3);
		sut.play(slotMachine, view);		
		verify(view).displayWelcomeMessage();
		verify(view).displayInstructions();
		verify(view).displayBettingMessage(1,3);
		verify(view, never()).displayQuitMessage();
	}

}
