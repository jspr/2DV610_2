package tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.PlayGame;
import model.Reel;
import model.SlotMachine;
import program.Program;

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

}
