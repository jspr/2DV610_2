package tests;

import static org.mockito.Mockito.*;

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
	public void shouldDisplayWelcomeMessageAndCredit_IfGameOverAndWantsToQitIsFalse() {
		when(slotMachine.isGameOver()).thenReturn(false,true); //otherwise we'll get stuck in a loop ad infinitum
		when(view.wantsToQuit()).thenReturn(false,true);
		when(slotMachine.getCredit()).thenReturn(10);
		sut.play(slotMachine, view);
		verify(view).displayWelcomeMessage();
		verify(view).displayCredit(10);
	}
	
	@Test
	public void shouldDisplayWelcomeMessage_ShouldNotDisplayCredit_ShouldDisplayGameOverMessage_IfGameOverIsTrue() {
		when(slotMachine.isGameOver()).thenReturn(true);
		when(view.wantsToQuit()).thenReturn(false);
		when(slotMachine.getCredit()).thenReturn(10);
		sut.play(slotMachine, view);
		verify(view).displayWelcomeMessage();
		verify(view, never()).displayCredit(10);
		verify(view).displayGameOverMessage();
	}
	
	@Test
	public void shouldDisplayWelcomeMessage_ShouldNotDisplayCredit_ShouldDisplayQuitMessage_IfWantsToQuitIsTrue() {
		when(slotMachine.isGameOver()).thenReturn(true);
		when(view.wantsToQuit()).thenReturn(false);
		when(slotMachine.getCredit()).thenReturn(10);
		sut.play(slotMachine, view);
		verify(view).displayWelcomeMessage();
		verify(view, never()).displayCredit(10);
		verify(view).displayQuitMessage();
	}
	
	
}
