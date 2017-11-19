package tests;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.PlayGame;
import model.SlotMachine;
import view.EnglishView;
import view.IView;


public class PlayGameTest {
	
	private PlayGame sut;
	IView view;
	SlotMachine slotMachine;

	@Before
	public void setUp() throws Exception {
		sut = new PlayGame();
		view = mock(EnglishView.class);
		slotMachine = new SlotMachine();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldDisplayWelcomeMessage() {
		sut.play(slotMachine, view);
		verify(view).displayWelcomeMessage();
	}
	
	@Test
	public void shouldDisplayInstructions() {
		sut.play(slotMachine, view);
		verify(view).displayInstructions();
	}
	
	@Test
	public void shouldDisplayBettingMessage() {
		sut.play(slotMachine, view);
		verify(view).displayBettingMessage();
	}
	
	@Test
	public void shouldDisplayWelcomeMessageInstructionsAndQuit() {
		when(view.wantsToQuit()).thenReturn(true);
		sut.play(slotMachine, view);		
		verify(view).displayWelcomeMessage();
		verify(view).displayInstructions();
		verify(view).displayQuitMessage();
	}
	
	@Test
	public void shouldDisplayWelcomeMessageAndInstructionsNotQuit() {
		when(view.wantsToQuit()).thenReturn(false);
		sut.play(slotMachine, view);		
		verify(view).displayWelcomeMessage();
		verify(view).displayInstructions();
		verify(view, never()).displayQuitMessage();
	}

}
