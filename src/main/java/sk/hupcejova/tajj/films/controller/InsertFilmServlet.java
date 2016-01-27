package sk.hupcejova.tajj.films.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ant.ReloadTask;

import com.mysql.jdbc.Messages;

import sk.hupcejova.tajj.films.dao.FilmDao;
import sk.hupcejova.tajj.films.dao.GenreDao;
import sk.hupcejova.tajj.films.dto.Film;
import sk.hupcejova.tajj.films.dto.State;
import sk.hupcejova.tajj.films.factory.Factory;

/**
 * 
 * Servlet pre vkladanie hodnot
 *
 */

@WebServlet
public class InsertFilmServlet extends FilmServlet{
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GenreDao genres = Factory.getGenreDaoInstance();
		req.setAttribute("genres", genres.findAll());
        dispatch("FilmInsert.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String FilmName = req.getParameter("filmName");
        
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy");
        Date FilmYear;
        GenreDao genreDao = Factory.getGenreDaoInstance();
		try {
			FilmYear = ft.parse(req.getParameter("filmYear"));
	        Film f = Factory.getFilmInstance();
	        f.setName(FilmName);
	        f.setYear(FilmYear);
	        State state = new State();
	        state.setId(1L);
	        f.setState(state);
	        f.setGenre(genreDao.findGenreById(Long.parseLong(req.getParameter("filmGenre"))));
	        FilmDao facade = getFacade();
	        if(facade.insert(f)){
	        	req.setAttribute("message", "film.insert.succ");     	
	        }
        	dispatch("SFilmList", req, resp);	   
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

}
