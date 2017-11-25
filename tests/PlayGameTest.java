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
	public void shouldDisplayWelcomeMessageAndCredit() {
		when(slotMachine.getCredit()).thenReturn(10);
		sut.play(slotMachine, view);
		verify(view).displayWelcomeMessage();
		verify(view).displayCredit(10);
	}
	
	
}
