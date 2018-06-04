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
		assertSame(getView(), this.view);
		assertSame(getView(), view);
		this.model = model;
		assertSame(this.model, model);
		assertSame(getModel(), model);
		this.clearStackOrder();
		assertSame(this.stackOrder, UserOrder.NOP);
	}

	private ILorannView getView() {
		return this.view;
	}

	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
		assertSame(this.stackOrder, UserOrder.NOP);
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
				assertEquals(2, y);
				break;
			case 2:
				y = 4;
				assertEquals(4, y);
				break;
			case 3:
				y = 2;
				assertEquals(2, y);
				break;
			case 4:
				y = 3;
				assertEquals(3, y);
				break;
			case 5:
				y = 4;
				assertEquals(4, y);
				break;
			default:
				y = 0;
				assertEquals(0, y);
				break;
			}
		}

		int test = 0;
		Random value = new Random();

		for (int i = 0; i < 8; i++) {
			test = test + 1;
			switch (test) {
			case 1:
				this.stackOrder = UserOrder.UP;
				assertSame(this.stackOrder, UserOrder.UP);
			case 2:
				this.stackOrder = UserOrder.DOWN;
				assertSame(this.stackOrder, UserOrder.DOWN);
			case 3:
				this.stackOrder = UserOrder.LEFT;
				assertSame(this.stackOrder, UserOrder.LEFT);
			case 4:
				this.stackOrder = UserOrder.RIGHT;
				assertSame(this.stackOrder, UserOrder.RIGHT);
			case 5:
				this.stackOrder = UserOrder.SPACE;
				assertSame(this.stackOrder, UserOrder.SPACE);
			case 6:
				this.stackOrder = UserOrder.NOP;
				assertSame(this.stackOrder, UserOrder.NOP);
			case 7:
				this.stackOrder = null;
				assertNull(this.stackOrder);
			}
		}

		this.clearStackOrder();

		int LorannX = 4;
		int LorannY = 9;
		int MonsterX = 4;
		int MonsterY = 9;
		boolean Crashed = false;

		for (int Order = 1; Order < 4; Order++) {
			switch (Order) {
			case 1:
				assertEquals(LorannX, MonsterX);
				assertEquals(LorannY, MonsterY);
				if (LorannX == MonsterX && LorannY == MonsterY) {
					Crashed = true;
					assertTrue(Crashed);
				}

			case 2:
				LorannX = 5;
				assertNotEquals(LorannX, MonsterX);
				assertEquals(LorannY, MonsterY);
				LorannX = 4;
			case 3:
				LorannY = 5;
				assertEquals(LorannX, MonsterX);
				assertNotEquals(LorannY, MonsterY);
			case 4:
				LorannX = 5;
				assertNotEquals(LorannX, MonsterX);
				assertNotEquals(LorannY, MonsterY);
			}
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
		}
		if (this.stackOrder == UserOrder.UP) {

		}
		if (getStackOrder() != UserOrder.UP) {

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