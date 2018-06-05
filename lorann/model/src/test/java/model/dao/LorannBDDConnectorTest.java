package model.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LorannBDDConnectorTest {
	
	private static LorannBDDConnectorTest instance;
	
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
	public void testGetInstance() {
		if (instance == null) {
            testSetInstance(new LorannBDDConnectorTest());
        }
		else {
			fail("instance already up");
		}
        return;
	}
	
	 private static void testSetInstance(final LorannBDDConnectorTest instance) {
	        LorannBDDConnectorTest.instance = instance;
	        
	        assertNotNull(instance);
	    }
}

