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

@WebServlet(name="movieServlet",value="/movie")
public class MovieServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        MovieDao dao = new MovieDaoImpl();

        req.setAttribute("peli",dao.findById(Long.valueOf(req.getParameter("id"))));

        try {
            req.getRequestDispatcher("movie.jsp").forward(req,res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
}
