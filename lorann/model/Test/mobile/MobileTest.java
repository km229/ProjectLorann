package mobile;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class MobileTest {
	
	private Boolean alive ;
	
	private int position ;
	
	private int setposition ;
	
	private int getposition ;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.alive = true;
		this.position = 1;
		this.setposition = 4;
		this.getposition = 6;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMoveUp() {

		final int expected = 1;
		
		assertEquals(expected, this.position);
	}

	@Test
	public void testMoveLeft() {

		final int expected = 1;
		
		assertEquals(expected, this.position);
	}

	@Test
	public void testMoveDown() {

		final int expected = 1;
		
		assertEquals(expected, this.position);

	}

	@Test
	public void testMoveRight() {
		
		final int expected = 1;
		
		assertEquals(expected, this.position);
	}

	@Test
	public void testDoNothing() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testSetY() {
		final int expected = 1;
		
		assertEquals(expected, this.setposition);
	}

	@Test
	public void testSetX() {
		final int expected = 1;
		
		assertEquals(expected, this.setposition);
	}

	@Test
	public void testGetY() {
	
		final int expected = 1;
		
		assertEquals(expected, this.getposition);
	}

	@Test
	public void testGetX() {
		final int expected = 1;
		
		assertEquals(expected, this.getposition);
	}

	@Test
	public void testSetHasMoved() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHasFoundTheCrystal() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetHasFoundThePurse() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsAlive() {
		final boolean expected = true;
		
//		assertEquals(expected, this.testIsAlive()); 
		
		fail("Not yet implemented");
	}

	@Test
	public void testDie() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsCrashed() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVictory() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetVictory() {
		fail("Not yet implemented");
	}

}
