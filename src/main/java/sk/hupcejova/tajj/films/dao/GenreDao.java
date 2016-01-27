package sk.hupcejova.tajj.films.dao;

import java.util.List;

import sk.hupcejova.tajj.films.dto.Genre;

/**
 * 
 * Interface pre vyvorenie datoveho objektu Zaner
 *
 */

public interface GenreDao {
	
	/**
	 * 
	 * struktura metody pre ziskanie vsetkych hodnot zanru
	 */
	public List<Genre> findAll();
	
	/**
	 * 
	 * struktura metody pre najdenie zanru podla id
	 */
	public Genre findGenreById(Long id);

}
