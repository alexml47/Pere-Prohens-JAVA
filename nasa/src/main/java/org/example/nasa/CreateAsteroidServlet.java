package org.example.nasa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.controller.NasaService;
import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        boolean dangerous = Boolean.parseBoolean(req.getParameter("dangerous"));

        try {
            NasaService service = new NasaService();
            service.saveAsteroid(new Asteroid(name,magnitude,diameter,dangerous));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/nasa");
    }
}


