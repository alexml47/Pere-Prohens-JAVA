package org.example.nasa;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.controller.NasaService;
import org.example.nasa.controller.NasaServiceFactory;

import java.io.IOException;

@WebServlet(name="deleteServlet", value="/delete")
public class DeleteServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            NasaService service = NasaServiceFactory.createNasaService();
            int id = Integer.parseInt(req.getParameter("id"));
            service.delete(service.findAsteroid(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("/nasa");
    }
}


