package sk.hupcejova.tajj.films.factory;

import sk.hupcejova.tajj.films.dao.GenreDao;
import sk.hupcejova.tajj.films.dao.StateDao;
import sk.hupcejova.tajj.films.dao.impl.FilmDaoImpl;
import sk.hupcejova.tajj.films.dao.impl.GenreDaoImpl;
import sk.hupcejova.tajj.films.dao.impl.StateDaoImpl;
import sk.hupcejova.tajj.films.database.Database;
import sk.hupcejova.tajj.films.database.impl.DatabaseMySQL;
import sk.hupcejova.tajj.films.dto.Film;
import sk.hupcejova.tajj.films.dto.Genre;
import sk.hupcejova.tajj.films.dto.State;

/**
 * 
 * Implementacia navrhoveho vzoru Tovaren pre vytvorenie instancii objektov
 *
 */

public class Factory {
	
	/**
	 * 
	 * Vytvorenie instancie Databazy
	 */
	public static Database getInstance() {
        return DatabaseMySQL.getInstance();
    }
	
	/**
	 * 
	 * Vytvorenie instancie Filmu
	 */
	public static Film getFilmInstance(){
		return new Film();
	}
	
	/**
	 * 
	 * Vytvorenie instancie implemetacie Dao pre Film
	 */
	public static FilmDaoImpl getFilmDaoImplInstance(){
		return new FilmDaoImpl();
	}
	
	/**
	 * 
	 * Vytvorenie instancie Stavu
	 */
	public static State getStateInstance(){
		return new State();
	}
	
	/**
	 * 
	 * Vytvorenie instancie dao pre stav
	 */
	public static StateDao getStateDaoInstance(){
		return new StateDaoImpl();
	}
	
	/**
	 * 
	 * Vytvorenie instancie Zanru
	 */
	public static Genre getGenreInstance(){
		return new Genre();
	}
	
	/**
	 * 
	 * Vytvorenie instancie dao pre Zaner
	 */
	public static GenreDao getGenreDaoInstance(){
		return new GenreDaoImpl();
	}
}
