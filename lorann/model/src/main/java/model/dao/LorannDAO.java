package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * <h1>The Class ExampleDAO.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class LorannDAO extends AbstractDAO {

    /** The sql example by id. */
    private static String sqlExampleById   = "{call findExampleById(?)}";

    /** The sql example by name.
    private static String sqlExampleByName = "{call findExampleByName(?)}";*/

    /** The sql all examples. 
    private static String sqlAllExamples   = "{call findAllExamples()}"; */

    /** The id column index. */
    private static int    idColumnIndex    = 1;

    /** The name column index. */
    private static int    nameColumnIndex  = 2;

    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    
    public LorannDAO(){
    	super();
    }
    
    public static Example getExampleById(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleById);
        Example example = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                example = new Example(result.getInt(idColumnIndex), result.getString(nameColumnIndex));
            }
            result.close();
        }
        return example;
    }

  