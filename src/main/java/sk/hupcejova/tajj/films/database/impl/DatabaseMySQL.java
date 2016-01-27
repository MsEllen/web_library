package sk.hupcejova.tajj.films.database.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sk.hupcejova.tajj.films.database.Database;

/**
 * 
 * konkretna implementacia pre MySQL databazu - pripojenie k databaze a zavretie pripojenia
 *
 */

public class DatabaseMySQL implements Database{
	
	private static Database db;

	/**
	 * konkretne pripojenie na online databazu
	 */
	@Override
	public Connection getConnection() {
		Connection connection = null;
	
	      
	      try {
				Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/tajj?"+ "user=tajjproject&password=tajj2014");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IllegalStateException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}

	/**
	 * uzavretie online databazovej konekcie
	 */
	@Override
	public void closeConnection(Connection connection) {
		
		try {
			connection.close();
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		}
	}
	

	/**
	 * 
	 * Singleton vzor pre vytvorenie instancie databazy
	 */
	public static Database getInstance() {
		
		if(DatabaseMySQL.db == null){
			DatabaseMySQL.db = new DatabaseMySQL();
		}
		
		return DatabaseMySQL.db;
	}

}
