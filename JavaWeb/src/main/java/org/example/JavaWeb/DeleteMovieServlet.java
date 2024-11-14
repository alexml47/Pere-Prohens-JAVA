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

@WebServlet(name="deleteServlet",value="/deleteMovie")
public class DeleteMovieServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        MovieDao dao = new MovieDaoImpl();
        dao.delete(Integer.parseInt(req.getParameter("id")));
        try {
            req.getRequestDispatcher("movies").forward(req,res);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

    }
}
