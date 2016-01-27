package sk.hupcejova.tajj.films.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sk.hupcejova.tajj.films.dao.FilmDao;
import sk.hupcejova.tajj.films.dao.GenreDao;
import sk.hupcejova.tajj.films.dao.StateDao;
import sk.hupcejova.tajj.films.database.Database;
import sk.hupcejova.tajj.films.dto.Film;
import sk.hupcejova.tajj.films.factory.Factory;

/**
 * 
 * Implementacia interface FilmDao
 *
 */
public class FilmDaoImpl implements FilmDao {
	
	private Database db = Factory.getInstance();

	/**
	 * impelmentacia metody pre ziskanie hodnot v objekte film
	 */
	@Override
	public List<Film> findAll() {
		
		List<Film> films = new ArrayList<>();
		GenreDao genreDao = Factory.getGenreDaoInstance();
		StateDao stateDao = Factory.getStateDaoInstance();
		Connection conn = this.db.getConnection();
		PreparedStatement statement;
		ResultSet result;
		try{
			statement = conn.prepareStatement("SELECT * FROM Film");
			result = statement.executeQuery();
			
			while(result.next()){
				Film f = Factory.getFilmInstance();
				f.setId(result.getLong("ID"));
				f.setName(result.getString("Nazov"));
				f.setYear(result.getDate("Rok"));
				f.setGenre(genreDao.findGenreById(result.getLong("ID_Zaner")));
				f.setState(stateDao.findStateById(result.getLong("ID_Stav")));
				
				films.add(f);
			}
			statement.close();
			result.close();
			
			return films;
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		finally{
			this.db.closeConnection(conn);
		}
	}

	/**
	 * implementacia metody pre najdenie filmu podla jeho id
	 */
	@Override
	public Film findById(Long filmId) {
		Film f = Factory.getFilmInstance();
		GenreDao genreDao = Factory.getGenreDaoInstance();
		StateDao stateDao = Factory.getStateDaoInstance();
		Connection conn = this.db.getConnection();
		
		try{
			ResultSet result;
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM Film WHERE ID = ?");
			statement.setLong(1, filmId);
			result = statement.executeQuery();
			
			while(result.next()){
				f.setId(result.getLong("ID"));
				f.setName(result.getString("Nazov"));
				f.setYear(result.getDate("Rok"));
				f.setGenre(genreDao.findGenreById(result.getLong("ID_Zaner")));
				f.setState(stateDao.findStateById(result.getLong("ID_Stav")));						
			}
			statement.close();
			result.close();
			return f;
		}
		catch(SQLException e){
//			throw e;
			e.printStackTrace();
			return null;
			
		}
		finally{
			this.db.closeConnection(conn);
		}
	}

	/**
	 * implementacia metody pre zmazanie filmu podla jeho id
	 */
	@Override
	public boolean deleteById(Long filmId) {
		Connection conn = this.db.getConnection();
		PreparedStatement statement;
		
		try{
			statement = conn.prepareStatement("DELETE FROM Film WHERE ID = ?");
			statement.setLong(1, filmId);
			boolean b = statement.executeUpdate() > 0;			
			statement.close();
			return b;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{
			this.db.closeConnection(conn);
		}		
	}

	/**
	 * implementacia metody pre uravu udajov filmu
	 */
	@Override
	public boolean update(Film film) {
		Connection conn = this.db.getConnection();
		PreparedStatement statement;
		
		try{
			statement = conn.prepareStatement("UPDATE Film SET Nazov = ?, Rok = ?, ID_Zaner = ?, ID_Stav = ? WHERE ID = ?");
			statement.setString(1, film.getName());
			statement.setDate(2, new java.sql.Date(film.getYear().getTime()));
			statement.setLong(3, film.getGenreId());
			statement.setLong(4, film.getStateId());
			statement.setLong(5, film.getId());
			boolean b = (statement.executeUpdate() > 0);
			
			statement.close();
			return b;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{
			this.db.closeConnection(conn);
		}
	}

	/**
	 * implementacia metody pre vlozenie udajov o filme
	 */
	@Override
	public boolean insert(Film film) {
		Connection conn = db.getConnection();
		PreparedStatement statement;
		
		try{
            statement = conn.prepareStatement("INSERT INTO Film (Nazov, Rok, ID_Zaner, ID_Stav) VALUES (?,?,?,?)");
            statement.setString(1, film.getName());
            statement.setDate(2, new Date(film.getYear().getTime()));
            statement.setLong(3, film.getGenreId());
            statement.setLong(4, film.getStateId());
            boolean b = (statement.executeUpdate() > 0);

            statement.close();

            return b;
        } catch (SQLException e) {
//            throw e;
        	e.printStackTrace();
        	return false;
        } finally {
            this.db.closeConnection(conn);
        }
	}
}
