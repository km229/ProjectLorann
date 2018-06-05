package main;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.LorannController;
import model.LorannModel;
import view.LorannView;

public class MainTest {

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
	public void testMain() throws IOException {
		
		Class<Main> main = Main.class;
		
		assertNotNull(main);
		String stringLevel = "1";
		int level = Integer.parseInt(stringLevel);
		
		assertEquals(1, level);
		
	}

	@Test
	public void testWholeNumber() {		
		
		String level = "53464";
		
		Boolean result = Main.WholeNumber(level);
		
		assertTrue(!result);

	}

	@Test
	public void testError() {
		
		System.out.println("Invalid number.");
				
	}

	@Test
	public void testStart() throws IOException, SQLException, InterruptedException {

		int level = 1;
		int startX = 5;
		int startY = 5;
		
		LorannModel model = new LorannModel(level, startX, startY);
		LorannView view = new LorannView(model.getMap(), model.getLorann(), model);
		LorannController controller = new LorannController(view, model);
		
		assertNotNull(model);
		assertNotNull(view);
		assertNotNull(controller);
		
	}

}
