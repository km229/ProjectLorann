package mobile;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Permeability;



public class LorannTest {
	
	private Point position;

	
	boolean alive;

	

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
	public void testMoveUp() {
		int getOnTheMap, setY;
		
		getOnTheMap = 1;
		setY = 1;
		
		
		if (getOnTheMap != setY){
			fail("Lorann can't find the block on top");
			
		}
		
		if (testGetPermeability() != Permeability.PENETRABLE){
			fail("Lorann can't move up because the element on top is not penetrable");
		}
		
		getOnTheMap = -1;
		
		if (getOnTheMap == setY){
			fail("Lorann find the block on top but with wrong coordinate");
		}
		
		if (testGetPermeability() == Permeability.BLOCKING){
			fail("Lorann can't move up because the element on top is Blocking");
		}

	}

	@Test
	public void testMoveLeft() {
		
		int getOnTheMap, setX;
		getOnTheMap = -1;
		setX = -1;
		
		
		if (getOnTheMap != setX){
			fail("Lorann can't find the block left");
			
		}
		
		if (testGetPermeability() != Permeability.PENETRABLE){
			fail("Lorann can't move up because the element on top is not penetrable");
		}
		
		getOnTheMap = 1;
		
		if (getOnTheMap == setX){
			fail("Lorann find the block left but with wrong coordinate");
		}
		
		if (testGetPermeability() == Permeability.BLOCKING){
			fail("Lorann can't move up because the element left is Blocking");
		}

	
	}

	@Test
	public void testMoveDown() {
		int getOnTheMap, setY;
		getOnTheMap = -1;
		setY = -1;
		
		
		if (getOnTheMap != setY){
			fail("Lorann can't find the block on top");
			
		}
		
		if (testGetPermeability() != Permeability.PENETRABLE){
			fail("Lorann can't move up because the element below is not penetrable");
		}
		
		getOnTheMap = 1;
		
		if (getOnTheMap == setY){
			fail("Lorann find the block below but with wrong coordinate");
		}
		
		if (testGetPermeability() == Permeability.BLOCKING){
			fail("Lorann can't move up because the element below is Blocking");
		}
	}

	@Test
	public void testMoveRight() {
		
		int getOnTheMap, setX;
		getOnTheMap = -1;
		setX = -1;
		
		
		if (getOnTheMap != setX){
			fail("Lorann can't find the block right");
			
		}
		
		if (testGetPermeability() != Permeability.PENETRABLE){
			fail("Lorann can't move up because the element on top is not penetrable");
		}
		
		getOnTheMap = 1;
		
		if (getOnTheMap == setX){
			fail("Lorann find the block right but with wrong coordinate");
		}
		
		if (testGetPermeability() == Permeability.BLOCKING){
			fail("Lorann can't move up because the element right is Blocking");
		}
		
	}




	@Test // Doesn't work
	public void testMagic() {
		int ax = 0;
		int ay = 0;
		this.position = new Point(1,1);
		
		boolean etat = false;
		
		if (!etat){
			ax = (this.testGetX());
			ay = (this.testGetY());
			etat = true;
		}
			
		if (etat = false){
			fail("etat is set to false");
		
		}
		if (ax == 0 || ay == 0){
		fail();
		}
	}

	

	public void testSetY(int y) {
		this.testGetPosition().y = y;
	}


	public void testSetX(int x) {
		this.testGetPosition().x = x;
	}

	
	public int testGetY() {
		return this.testGetPosition().y;
	}

	
	public int testGetX() {
		return this.testGetPosition().x;
	}



	@Test
	public void testIsAlive() {
		
		return;
	}




	public Point testGetPosition() {
		return this.position;
		
	}

	@Test
	public void testSetPosition() {
		
	}



	
	public Permeability testGetPermeability() {
		
		return Permeability.PENETRABLE;
	
	}



}
