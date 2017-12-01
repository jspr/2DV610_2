package tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.PlayGame;
import model.Reel;
import model.SlotMachine;
import program.Program;
import view.EnglishView;

public class ProgramTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldCreateNewSlotMachine() {
		assertThat(Program.setUpSlotMachine(new ArrayList<Reel>()), instanceOf(SlotMachine.class));
	}
	
	@Test
	public void shouldCreateNewPlayGame() {
		assertThat(Program.setUpPlayGame(), instanceOf(PlayGame.class));
	}
	
	@Test
	public void shouldCreateNewEnglishView() {
		assertThat(Program.setUpView(), instanceOf(EnglishView.class));
	}
	
	@Test
	public void shouldAddReels() {
		int expected = 3;
		Collection<Reel> reels = new ArrayList<Reel>();
		reels = Program.setUpReels(reels);
		assertEquals(expected,reels.size());
	}

}
