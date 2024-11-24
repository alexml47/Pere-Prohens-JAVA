package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.model.Aproach;
import org.example.nasa.service.NasaService;
import org.example.nasa.service.NasaServiceFactory;
import org.example.nasa.model.Asteroid;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="createAproachServlet",value="/createAproach")
public class CreateAproachServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        NasaService service = NasaServiceFactory.createNasaService();
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
        LocalDate name = LocalDate.parse(req.getParameter("aproachDate"));
        double velocity = Double.parseDouble(req.getParameter("velocity"));
        double distance = Double.parseDouble(req.getParameter("distance"));
        String orbitingBody = req.getParameter("orbitingBody");
        int id_asteroid = Integer.parseInt(req.getParameter("id_asteroid"));
        try {
            NasaService service = NasaServiceFactory.createNasaService();
            Asteroid asteroid = service.findAsteroid(id_asteroid);
            service.saveAproach(new Aproach(name,velocity,distance,orbitingBody,asteroid));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("aproach?id=" + id_asteroid);
    }
}


