package org.example.nasa.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.dao.orm.AsteroidOrmDaoImpl;
import org.example.nasa.service.AsteroidService;
import org.example.nasa.factory.ServiceFactory;
import org.example.nasa.utils.Session;

import java.io.IOException;

@WebServlet(name="deleteServlet", value="/delete")
public class DeleteServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String impl = Session.getAttribute(req,"implementation") == null ? "ORM" : Session.getAttribute(req,"implementation");
            AsteroidService service = ServiceFactory.implementation(impl).createAsteroidService();
            int id = Integer.parseInt(req.getParameter("id"));
            service.deleteAsteroid(service.findAsteroid(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("/nasa");
    }
}


