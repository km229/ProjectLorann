package main;

import java.io.IOException;
import java.sql.SQLException;

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
    private static final int startX = 10;

    /** The Constant startY. */
    private static final int startY = 6;
    
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(final String[] args) throws IOException, SQLException {
		final LorannModel model = new LorannModel(1, startX, startY);
	}
}