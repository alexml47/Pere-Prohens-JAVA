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
import org.example.nasa.controller.NasaServiceFactory;
import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name="aproachServlet",value="/aproach")
public class AproachServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        NasaService service = NasaServiceFactory.createNasaService();
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("aproaches",service.findAllAproachesByAsteroidId(id));

        try {
            req.getRequestDispatcher("aproach.jsp").forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}


