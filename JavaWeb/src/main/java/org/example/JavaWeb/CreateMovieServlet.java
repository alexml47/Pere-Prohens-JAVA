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
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="createServlet",value="/createMovie")
public class CreateMovieServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {



        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String year = req.getParameter("year");

        if (title != null && description != null && year != null) {
            MovieDao movieDao = new MovieDaoImpl();
            Movie movie = new Movie(title,description, Integer.parseInt(year));
            movieDao.save(movie);
        };

        try {
            req.getRequestDispatcher("createMovie.jsp").forward(req,res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
}
