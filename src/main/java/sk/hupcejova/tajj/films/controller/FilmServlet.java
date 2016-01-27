package sk.hupcejova.tajj.films.controller;

import java.io.IOException;

/**
 * GEnericky Servlet, od ktoreho dedia Servlety s specifickymi funkciami
 * 
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sk.hupcejova.tajj.films.dao.FilmDao;
import sk.hupcejova.tajj.films.factory.Factory;

public class FilmServlet extends HttpServlet implements javax.servlet.Servlet{
    protected void dispatch(String s, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(s).forward(req, resp);
    }

    protected FilmDao getFacade(){
    	return Factory.getFilmDaoImplInstance();
    }
   // protected BookFacade getFacade() {
   //     return new BookFacadeImpl();
   // }
}
