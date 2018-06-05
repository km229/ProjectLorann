package view;

import static org.junit.Assert.*;
import java.awt.Dimension;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import showboard.BoardFrame;

public class LorannViewTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testRun() throws IOException, InterruptedException {
		BoardFrame boardFrame = new BoardFrame("Lorran");
		boardFrame.setDimension(new Dimension(10, 10));
		boardFrame.setSize(10, 10);
		assertNotNull(boardFrame);
	}

}
