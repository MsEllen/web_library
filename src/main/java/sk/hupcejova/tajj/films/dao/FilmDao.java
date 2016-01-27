package sk.hupcejova.tajj.films.dao;

import java.util.List;

import sk.hupcejova.tajj.films.dto.Film;

/**
 * 
 * Interface pre vytvorenie datoveho objektu Film
 *
 */

public interface FilmDao {
	
	List<Film> findAll();
	
	Film findById(Long filmId);
	
	boolean deleteById(Long filmId);
	
	boolean update(Film film);
	
	boolean insert(Film film);

}
