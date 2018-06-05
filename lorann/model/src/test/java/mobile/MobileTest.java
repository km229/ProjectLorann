package mobile;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MobileTest {
	
	private Point position;
	
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
	public void testMobileSpriteIMapPermeability() {
		fail("Not yet implemented");
	}

	@Test
	public void testMobileIntIntSpriteIMapPermeability() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveUp() {
		
		this.testSetY(this.testGetY() - 1);
		this.testSetHasMoved();
		
		
	
	}

	@Test
	public void testMoveLeft() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveDown() {
		fail("Not yet implemented");
	}

	@Test
	public void testMoveRight() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoNothing() {
		fail("Not yet implemented");
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

	public Point testGetPosition() {
		return this.position;
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

	@Test
	public void testElement() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetImage() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSprite() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPermeability() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSprite() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPermeability() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
