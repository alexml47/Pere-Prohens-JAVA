package org.example.nasa.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.service.NasaService;
import org.example.nasa.service.NasaServiceFactory;

import java.io.IOException;

@WebServlet(name="deleteServlet", value="/delete")
public class DeleteServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            NasaService service = NasaServiceFactory.createNasaService();
            int id = Integer.parseInt(req.getParameter("id"));
            service.deleteAsteroid(service.findAsteroid(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("/nasa");
    }
}


