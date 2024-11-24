package org.example.nasa.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.service.AsteroidService;
import org.example.nasa.service.ServiceFactory;


import java.io.IOException;

@WebServlet(name="synchronizeServlet", value = "/synchronize")
public class SynchronizeServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            AsteroidService service = ServiceFactory.createAsteroidService();

            service.synchronize();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        res.sendRedirect("asteroids");

    }
}
