package sk.hupcejova.tajj.films.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.hupcejova.tajj.films.dao.FilmDao;
import sk.hupcejova.tajj.films.dto.Film;

/**
 * 
 * Servlet pre ziskanie hodnot z databazy
 *
 */

@WebServlet("/SFilmList")
public class ListFilmServlet extends FilmServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmDao facade = getFacade();
        List<Film> films = facade.findAll();
        req.setAttribute("films", films);
        dispatch("FilmIndex.jsp", req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
    	try {
			doGet(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
