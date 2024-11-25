package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.dao.orm.AproachOrmDaoImpl;
import org.example.nasa.dao.orm.AsteroidOrmDaoImpl;
import org.example.nasa.factory.ServiceFactory;
import org.example.nasa.model.Aproach;
import org.example.nasa.service.*;
import org.example.nasa.model.Asteroid;
import org.example.nasa.utils.Session;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="createAproachServlet",value="/createAproach")
public class CreateAproachServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String impl = Session.getAttribute(req,"implementation") == null ? "ORM" : Session.getAttribute(req,"implementation");
        AsteroidService service = ServiceFactory.implementation(impl).createAsteroidService();

        int id = Integer.parseInt(req.getParameter("id"));
        Asteroid ast = service.findAsteroid(id);
        req.setAttribute("asteroid", ast);
        try {
            req.getRequestDispatcher("createAproach.jsp").forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        AsteroidService asteroidService = ServiceFactory.implementation(req.getAttribute("implementation").toString()).createAsteroidService();
        AproachService aproachService = ServiceFactory.implementation(req.getAttribute("implementation").toString()).createAproachService();

        LocalDate name = LocalDate.parse(req.getParameter("aproachDate"));
        double velocity = Double.parseDouble(req.getParameter("velocity"));
        double distance = Double.parseDouble(req.getParameter("distance"));
        String orbitingBody = req.getParameter("orbitingBody");
        int id_asteroid = Integer.parseInt(req.getParameter("id_asteroid"));

        try {
            Asteroid asteroid = asteroidService.findAsteroid(id_asteroid);
            aproachService.saveAproach(new Aproach(name,velocity,distance,orbitingBody,asteroid));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("aproach?id=" + id_asteroid);
    }
}


