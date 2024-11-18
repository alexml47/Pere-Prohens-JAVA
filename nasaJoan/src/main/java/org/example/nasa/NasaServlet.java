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

@WebServlet(name="nasaServlet",value="/nasa")
public class NasaServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        try {
            NasaService service = new NasaService();

            req.setAttribute("asteroids",service.findAllAsteroids());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {
            req.getRequestDispatcher("nasa.jsp").forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}
