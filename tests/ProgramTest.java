package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;


import java.io.IOException;
import java.io.PrintStream;
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
import view.IView;

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
	
	@Test
	public void shouldCallPlayOnPlayGame() throws IOException, InterruptedException {
		PlayGame playGame = mock(PlayGame.class);
		IView view = mock(EnglishView.class);
		SlotMachine slotMachine = mock(SlotMachine.class);
		doNothing().when(playGame).play(slotMachine, view); //maybe not really needed
		Program.setView(view);
		Program.setPlayGame(playGame);
		Program.setSlotMachine(slotMachine);
		Program.main(new String[0]);
		verify(playGame).play(slotMachine, view);
	}
	
	@Test
	public void shouldPrintMessageOnIOException() throws IOException, InterruptedException {
		PlayGame playGame = mock(PlayGame.class);
		IView view = mock(EnglishView.class);
		SlotMachine slotMachine = mock(SlotMachine.class);
		PrintStream printStream = mock(PrintStream.class);
		doThrow(new IOException()).when(playGame).play(slotMachine, view);
		Program.setView(view);
		Program.setPlayGame(playGame);
		Program.setSlotMachine(slotMachine);
		Program.setPrintStream(printStream);
		Program.main(new String[0]);
		verify(printStream).println("An IOException has been thrown.");
	}
	
	@Test
	public void shouldCreateProgram() {
		Program sut = new Program();
		assertThat(sut, instanceOf(Program.class));
	}

}
