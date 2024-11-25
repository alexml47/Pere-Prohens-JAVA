package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.dao.orm.AsteroidOrmDaoImpl;
import org.example.nasa.service.AproachService;
import org.example.nasa.service.AsteroidService;
import org.example.nasa.model.Asteroid;
import org.example.nasa.factory.ServiceFactory;
import org.example.nasa.utils.Session;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name="editAsteroidServlet", value="/editAsteroid")
public class EditAsteroidServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String impl = Session.getAttribute(req,"implementation") == null ? "ORM" : Session.getAttribute(req,"implementation");
        AsteroidService service = ServiceFactory.implementation(impl).createAsteroidService();

        int id = Integer.parseInt(req.getParameter("id"));
        Asteroid ast = service.findAsteroid(id);
        req.setAttribute("asteroid", ast);

        try {
            req.getRequestDispatcher("editAsteroid.jsp").forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String impl = Session.getAttribute(req,"implementation") == null ? "ORM" : Session.getAttribute(req,"implementation");
        AsteroidService service = ServiceFactory.implementation(impl).createAsteroidService();

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double magnitude = Double.parseDouble(req.getParameter("magnitude"));
        double diameter = Double.parseDouble(req.getParameter("diameter"));
        boolean dangerous = Objects.equals(req.getParameter("dangerous"), "on");
        boolean nasaAsteroid = Boolean.parseBoolean(req.getParameter("nasaAsteroid"));

        try {
            service.updateAsteroid(new Asteroid(id,name,magnitude,diameter,dangerous,nasaAsteroid));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        res.sendRedirect("asteroid?id=" + id);
    }
}


