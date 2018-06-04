package model;

import java.sql.SQLException;
import java.util.List;


/**
 * <h1>Interface IModel</h1>
 *
 * @author group2
 * @version 1.0
 */
public interface IModel {

    /**
     * Gets the level by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    void getLevelById(int id) throws SQLException;

    /**
     * Return Lorann.
     *
     * @return lorann
     */
	IMobile getLorann();
	
	
    /**
     * Gets the monster wanted.
     *
     * @param monster
     *            the monster
     * @return the monster selected
     */
	IMobile getMonster(int monster);

}
