package sk.hupcejova.tajj.films.database;

import java.sql.Connection;

/**
 * 
 * Interface pre objekt Databaza pre pristup k datam
 *
 */

public interface Database {
	
	/**
	 * 
	 * strukura metody pre vytvorenie pripojenia
	 */
	public Connection getConnection();
	
	/**
	 * 
	 * struktura metody pre zavretie pripojenia
	 */
	public void closeConnection(Connection connection);

}
