package org.example.nasa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.controller.NasaService;
import org.example.nasa.controller.NasaServiceFactory;


import java.io.IOException;


@WebServlet(name="asteroidServlet",value="/asteroid")
public class AsteroidServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        try {
            NasaService service = NasaServiceFactory.createNasaService();
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("asteroid",service.findAsteroid(id));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {
            req.getRequestDispatcher("asteroid.jsp").forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}

