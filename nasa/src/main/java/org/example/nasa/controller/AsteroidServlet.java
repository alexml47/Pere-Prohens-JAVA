package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.dao.orm.AsteroidOrmDaoImpl;
import org.example.nasa.factory.ServiceFactory;
import org.example.nasa.factory.ServiceOrmFactory;
import org.example.nasa.service.*;
import org.example.nasa.utils.Session;


import java.io.IOException;


@WebServlet(name="asteroidServlet",value="/asteroid")
public class AsteroidServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        try {
            String impl = Session.getAttribute(req,"implementation") == null ? "ORM" : Session.getAttribute(req,"implementation");
            AsteroidService service = ServiceFactory.implementation(impl).createAsteroidService();

            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("asteroid",service.findAsteroid(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {
            req.getRequestDispatcher("asteroid.jsp").forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }
}


