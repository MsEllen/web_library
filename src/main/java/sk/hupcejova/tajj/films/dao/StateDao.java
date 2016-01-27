package sk.hupcejova.tajj.films.dao;

import java.util.List;

import sk.hupcejova.tajj.films.dto.State;

/**
 * 
 * Interface pre vytvorenie datoveho objektu Stav
 *
 */

public interface StateDao {
	
	/**
	 * 
	 * struktura metody pre vypis vsetkych hodnot
	 */
	public List<State> findAll();
	
	/**
	 * 
	 * struktura metody pre najdenie stavu podla id 
	 * 
	 */
	public State findStateById(Long id);
}
