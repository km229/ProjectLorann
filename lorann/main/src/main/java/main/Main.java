package main;

import java.io.IOException;
import java.sql.SQLException;

import model.LorannModel;

/**
 * <h1>Class Main</h1>
 *
 * @author group2
 * @version 1.0
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(final String[] args) throws IOException, SQLException {
		final LorannModel model = new LorannModel(1, 10, 6);
	}
}