package sk.hupcejova.tajj.films.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.hupcejova.tajj.films.dao.FilmDao;
import sk.hupcejova.tajj.films.dao.GenreDao;
import sk.hupcejova.tajj.films.dao.StateDao;
import sk.hupcejova.tajj.films.dto.Film;
import sk.hupcejova.tajj.films.dto.State;
import sk.hupcejova.tajj.films.factory.Factory;

/**
 * 
 * Servlet pre upravu dat
 *
 */

@WebServlet("/SFilmEdit")
public class UpdateFilmServlet extends FilmServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String filmIdString = req.getParameter("filmId");
		Long filmId = Long.parseLong(filmIdString);
		
		FilmDao filmDao = getFacade();
		GenreDao genres = Factory.getGenreDaoInstance();
		StateDao states = Factory.getStateDaoInstance();

		req.setAttribute("genres", genres.findAll());	
		req.setAttribute("states", states.findAll());		
		req.setAttribute("editingFilm", filmDao.findById(filmId));
		dispatch("FilmEdit.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
        
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy");
        Date FilmYear;
        GenreDao genreDao = Factory.getGenreDaoInstance();
        FilmDao facade = getFacade();
		try {
			Long filmId = Long.parseLong(req.getParameter("filmId"));
			Long filmStateId = Long.parseLong(req.getParameter("filmState"));
			String FilmName = req.getParameter("filmName");
			FilmYear = ft.parse(req.getParameter("filmYear"));
			
	        Film f = Factory.getFilmInstance();
	        f.setId(filmId);
	        f.setName(FilmName);
	        f.setYear(FilmYear);
	        State state = new State();
	        state.setId(filmStateId);
	        f.setState(state);
	        f.setGenre(genreDao.findGenreById(Long.parseLong(req.getParameter("filmGenre"))));
	        if(facade.update(f)){
	        	req.setAttribute("message", "film.update.succ");     	
	        }   
	        FilmDao filmDao = getFacade();
			GenreDao genres = Factory.getGenreDaoInstance();
			StateDao states = Factory.getStateDaoInstance();

			req.setAttribute("genres", genres.findAll());	
			req.setAttribute("states", states.findAll());		
			req.setAttribute("editingFilm", filmDao.findById(filmId));
	        dispatch("FilmEdit.jsp", req, resp);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
