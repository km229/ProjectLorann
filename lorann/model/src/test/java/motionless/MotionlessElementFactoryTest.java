package motionless;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Sprite;

public class MotionlessElementFactoryTest {

	MotionlessElementFactory factory = new MotionlessElementFactory();
	
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
	public void testGetFromFileSymbol() {
		
		MotionlessElement element = MotionlessElementFactory.getFromFileSymbol('|');

		if(element.getSprite().getConsoleImage() == '|'){
			
		}else{
			fail("Error to find the horizontal bone.");
		}
		
		element = MotionlessElementFactory.getFromFileSymbol('g');

		if(element.getSprite().getConsoleImage() == 'g'){
			
		}else{
			fail("Error to find the gate.");
		}
		
		element = MotionlessElementFactory.getFromFileSymbol('&');

		if(element.getSprite().getConsoleImage() == ' '){
			
		}else{
			fail("Error to assign a ground to an unidentified object.");
		}
		
	}

}
