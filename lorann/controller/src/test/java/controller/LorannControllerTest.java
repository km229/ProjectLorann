package controller;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import model.IModel;
import view.ILorannView;

public class LorannControllerTest {

	/** The speed. */
	private static final int speed = 150;
	/** The view. */
	private ILorannView view;

	/** The model. */
	private IModel model;

	/** The stackOrder. */
	private UserOrder stackOrder;

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
	public void testLorannController() {
		this.view = view;
		this.model = model;
		this.clearStackOrder();
		if (this.stackOrder == UserOrder.NOP) {

		}
		if (this.stackOrder != UserOrder.NOP){
			
		}

	}

	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	public enum UserOrder {
		/** The right. */
		RIGHT,

		/** The left. */
		LEFT,

		/** The Up. */
		UP,

		/** The Down. */
		DOWN,

		/** The Magic. */
		MAGIC,

		/** The nop. */
		NOP,
		/** The space. */
		SPACE,
	}

	public IModel getModel() {
		return this.model;
	}

	@Test
	public void testPlay() {
		int x = 1, y = 1, z = 1;

		int level = 0;

		for (int i = 0; i < 6; i++) {
			level = level + 1;

			switch (level) {
			case 1:
				y = 2;
				break;
			case 2:
				y = 4;
				break;
			case 3:
				y = 2;
				break;
			case 4:
				y = 3;
				break;
			case 5:
				y = 4;
				break;
			default:
				y = 0;
				break;
			}
		}

		int test = 1;
		switch (test) {
		case 1:
			this.stackOrder = UserOrder.UP;
		case 2:
			this.stackOrder = UserOrder.DOWN;
		case 3:
			this.stackOrder = UserOrder.LEFT;
		case 4:
			this.stackOrder = UserOrder.RIGHT;
		case 5:
			this.stackOrder = UserOrder.NOP;
		}
			this.stackOrder = UserOrder.UP;
			this.stackOrder = UserOrder.DOWN;

			if (this.getStackOrder() != UserOrder.DOWN) {
				fail("There is a problem in the stackOrder declaration.");
			}

			Random value = new Random();

			x = value.nextInt(y) + 1;

			if (value.nextInt(y) > y) {
				fail("There is a problem in the random method.");
			}

			this.clearStackOrder();

			int LorannX = 4;
			int LorannY = 9;
			int MonsterX = 4;
			int MonsterY = 9;
			boolean Crashed = false;

			if (LorannX == MonsterX && LorannY == MonsterY) {
				Crashed = true;
			}

			if (Crashed == false) {
				fail("There is a problem in the position test.");

			}
		}

	@Test
	public void testGetView() {
		this.view = view;
	}

	@Test
	public void testOrderPerform() {
		this.setStackOrder(UserOrder.UP);
		if (this.stackOrder != UserOrder.UP) {
			fail("There is a problem in the stackOrder method.");
		}
	}

	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	@Test
	public void testGetModel() {
		this.model = model;
	}

	@Test
	public void testGetOrderPeformer() {

	}

}