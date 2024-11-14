package org.example.JavaWeb;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.JavaWeb.dao.MovieDao;
import org.example.JavaWeb.dao.MovieDaoImpl;
import org.example.JavaWeb.model.Movie;

import java.io.IOException;

@WebServlet(name="editServlet",value="/editMovie")
public class EditMovieServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        MovieDao dao = new MovieDaoImpl();

        req.setAttribute("peliID",req.getParameter("id"));
        req.setAttribute("peliEdit",dao.findById(Long.valueOf(req.getParameter("id"))));

        try {
            req.getRequestDispatcher("editMovie.jsp").forward(req,res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {

        Long id = Long.valueOf(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String year = req.getParameter("year");

        if (title != null && description != null && year != null) {
            MovieDao movieDao = new MovieDaoImpl();
            Movie movie = new Movie(id,title,description, Integer.parseInt(year));
            movieDao.update(movie);
        }

        res.sendRedirect("movies");
    }
}
