package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.service.NasaService;
import org.example.nasa.service.NasaServiceFactory;
import org.example.nasa.model.Rol;
import org.example.nasa.model.User;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name="registerServlet",value="/register")
public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        NasaService nasaService = NasaServiceFactory.createNasaService();
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String rol = req.getParameter("rol");

        Rol rolAssigned;
        if (Objects.equals(rol, "astronomer")) {
            rolAssigned = nasaService.getRol("astronomer");
        } else {
            rolAssigned = nasaService.getRol("observer");
        }
        User user = new User(name, password, rolAssigned);
        nasaService.saveUser(user);
        res.sendRedirect("asteroids");
    }
}
