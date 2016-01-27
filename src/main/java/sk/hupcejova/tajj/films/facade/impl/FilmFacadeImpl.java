package sk.hupcejova.tajj.films.facade.impl;

import java.util.List;

import sk.hupcejova.tajj.films.dao.FilmDao;
import sk.hupcejova.tajj.films.dto.Film;
import sk.hupcejova.tajj.films.factory.Factory;

/**
 * 
 * Implementacia navrhoveho vzoru Fasada
 *
 */

public class FilmFacadeImpl implements FilmDao{
	
	private FilmDao filmDao = Factory.getFilmDaoImplInstance();

	/**
	 * 
	 * Metoda pre vypis vsetkych udajov Film
	 */
	@Override
	public List<Film> findAll() {
		List<Film> films = this.filmDao.findAll();
        return films;
	}

	/**
	 * 
	 * Metoda pre najdenie konkretneho udaju Film
	 */
	@Override
	public Film findById(Long filmId) {
		return this.filmDao.findById(filmId);
	}

	/**
	 * 
	 * Metoda pre mazanie udaju Film
	 */
	@Override
	public boolean deleteById(Long filmId) {
		return this.filmDao.deleteById(filmId);
	}

	/**
	 * 
	 * Metoda pre upravu udajov Film
	 */
	@Override
	public boolean update(Film film) {
		return this.filmDao.update(film);
	}

	/**
	 * 
	 * Metoda pre vkladanie udajov Film
	 */
	@Override
	public boolean insert(Film film) {
		return this.filmDao.insert(film);
	}

	
	
}
