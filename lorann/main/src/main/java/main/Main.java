package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import controller.LorannController;
import model.LorannModel;
import view.LorannView;

/**
 * <h1>Class Main</h1>
 *
 * @author group2
 * @version 1.0
 */
public abstract class Main {

	/** The Constant startX. */
	private static int startX = 0;

	/** The Constant startY. */
	private static int startY = 0;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws SQLException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	/**
	 * @param args
	 * @throws IOException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void main(final String[] args) throws IOException, SQLException, InterruptedException {

		System.out.println("Enter level (1-5) : ");

		try {

			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String levelString = bufferRead.readLine();
			Boolean iswholeNumber = WholeNumber(levelString);

			if (!iswholeNumber) {
				int level = Integer.parseInt(levelString);

				if (level > 0 && level < 6) {
					setSpawnXY(level);
					Start(level);

				} else {

					Error();

				}
			} else {

				Error();

			}

		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param level
	 *            The level
	 */
	private static void setSpawnXY(int level) {
		switch (level) {
		case 1:
			startX = 17;
			startY = 5;
			break;
		case 2:
			startX = 18;
			startY = 1;
			break;
		case 3:
			startX = 1;
			startY = 1;
			break;
		case 4:
			startX = 2;
			startY = 2;
			break;
		case 5:
			startX = 1;
			startY = 6;
			break;
		}

	}

	/**
	 * 
	 * @param string
	 * @return return the wholeNumber
	 */

	public static boolean WholeNumber(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return true;
		}

		return false;
	}

	/**
	 * @throws IOException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void Error() throws IOException, SQLException, InterruptedException {

		System.out.println("Invalid number.");
		main(null);

	}

	/**
	 * @param level
	 * 		Start the chosen level
	 * @throws IOException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void Start(int level) throws IOException, SQLException, InterruptedException {
		System.out.println("Game start!");
		final LorannModel model = new LorannModel(level, startX, startY);
		final LorannView view = new LorannView(model.getMap(), model.getLorann(), model);
		final LorannController controller = new LorannController(view, model);
		view.setOrderPerformer(controller.getOrderPeformer());
		controller.play();
	}
}