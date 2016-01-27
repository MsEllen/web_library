package sk.hupcejova.tajj.films.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sk.hupcejova.tajj.films.dao.GenreDao;
import sk.hupcejova.tajj.films.database.Database;
import sk.hupcejova.tajj.films.dto.Genre;
import sk.hupcejova.tajj.films.factory.Factory;

/**
 * 
 * Implementacia Interface GenreDao
 *
 */

public class GenreDaoImpl implements GenreDao {
	
	private Database db = Factory.getInstance();
	
	/**
	 * implementacia metody pre vypis vsetkych hodnot zanru
	 */
	@Override
	public List<Genre> findAll() {
		
		ArrayList<Genre> genres = new ArrayList<Genre>();
		
		Connection conn = this.db.getConnection();
		PreparedStatement statement;
		ResultSet result;
		try{
			statement = conn.prepareStatement("SELECT * FROM Zaner");
			result = statement.executeQuery();
			
			while(result.next()){
				Genre g = Factory.getGenreInstance();
				
				g.setId(result.getLong("ID"));
				g.setName(result.getString("Nazov"));
				
				genres.add(g);
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return genres;
	}

	/**
	 * implementacia pre zisaknie zanru podla jeho id
	 */
	@Override
	public Genre findGenreById(Long id) {
		Genre genre = Factory.getGenreInstance();
		Connection conn = this.db.getConnection();
		try {
			PreparedStatement stateStatement = conn.prepareStatement("SELECT * FROM Zaner WHERE ID = ?");
			stateStatement.setLong(1, id);
			ResultSet stateResult = stateStatement.executeQuery();
			
			while(stateResult.next()){
				genre.setId(stateResult.getLong("ID"));
				genre.setName(stateResult.getString("Nazov"));
			}
			return genre;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
}
