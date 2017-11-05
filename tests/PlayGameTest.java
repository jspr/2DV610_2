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

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//failing
	public void shouldDisplayWelcomeMessage() {
		sut = new PlayGame();
		IView view = mock(EnglishView.class);
		SlotMachine slotMachine = new SlotMachine();
		sut.Play(slotMachine, view);
		verify(view).displayWelcomeMessage();
	}

}
