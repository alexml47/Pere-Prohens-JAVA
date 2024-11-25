package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.dao.orm.AsteroidOrmDaoImpl;
import org.example.nasa.service.AsteroidService;
import org.example.nasa.model.Asteroid;
import org.example.nasa.factory.ServiceFactory;
import org.example.nasa.utils.Session;

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
        boolean dangerous = Objects.equals(req.getParameter("dangerous"), "on");

        try {
            AsteroidService service = ServiceFactory.implementation(req.getAttribute("implementation").toString()).createAsteroidService();
            service.saveAsteroid(new Asteroid(name,magnitude,diameter,dangerous,false));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("/nasa");
    }
}


