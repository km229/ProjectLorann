package model.dao;

import java.sql.Blob;

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
public class LorannDAO extends AbstractDAO {

    /** The sql example by id. */
    private static String sqlExampleById   = "{call findExampleById(?)}";

    /** The id column index. */
    private static int    idColumnIndex    = 1;

    /**
     * Gets the level by id.
     * @param blob 
     * @param i 
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    
    public LorannDAO(int i, String map){
    	super();
    }
    
    public Blob getLevelById(final int id) throws SQLException {
        final CallableStatement callStatement = prepareCall(sqlExampleById);
        Blob loranndao = null;
        callStatement.setInt(1, id);
        if (callStatement.execute()) {
            final ResultSet result = callStatement.getResultSet();
            if (result.first()) {
                loranndao = result.getBlob("map");
            }
            result.close();
        }
        return loranndao;
    }
    
}

  