package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.service.NasaService;

import java.io.IOException;

@WebServlet(name="asteroidsServlet",value="/asteroids")
public class AsteroidsServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        try {
            NasaService service = new NasaService();

            req.setAttribute("asteroids",service.findAllAsteroids());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {
            req.getRequestDispatcher("asteroids.jsp").forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}
