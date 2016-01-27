package sk.hupcejova.tajj.films.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.hupcejova.tajj.films.dao.FilmDao;

/**
 * Servlet sluziaci na zmazanie zaznamu
 * 
 */

@WebServlet("/SFilmDelete")
public class DeleteFilmServlet extends FilmServlet{
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmDao facade = getFacade();
        Long filmId = Long.parseLong(req.getParameter("filmId"));
        boolean deleted = facade.deleteById(filmId);
        if (deleted) {
            req.setAttribute("message", "delete.success");
        }
        dispatch("SFilmList", req, resp);
    }
}
