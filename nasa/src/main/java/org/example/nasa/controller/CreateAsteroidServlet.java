package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.service.NasaService;
import org.example.nasa.service.NasaServiceFactory;
import org.example.nasa.model.Asteroid;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name="createAsteroidServlet",value="/createAsteroid")
public class CreateAsteroidServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            req.getRequestDispatcher("createAsteroid.jsp").forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        double magnitude = Double.parseDouble(req.getParameter("magnitude"));
        double diameter = Double.parseDouble(req.getParameter("diameter"));
        boolean dangerous = false;
        if (Objects.equals(req.getParameter("dangerous"), "on")){
            dangerous = true;
        }

        try {
            NasaService service = NasaServiceFactory.createNasaService();
            service.saveAsteroid(new Asteroid(name,magnitude,diameter,dangerous,false));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/nasa");
    }
}


