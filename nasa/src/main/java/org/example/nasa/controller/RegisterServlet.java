package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.dao.orm.RolOrmDaoImpl;
import org.example.nasa.dao.orm.UserOrmDaoImpl;
import org.example.nasa.factory.ServiceFactory;
import org.example.nasa.service.*;
import org.example.nasa.model.Rol;
import org.example.nasa.model.User;
import org.example.nasa.utils.Encryptor;
import org.example.nasa.utils.Session;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name="registerServlet",value="/register")
public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String impl = Session.getAttribute(req,"implementation") == null ? "ORM" : Session.getAttribute(req,"implementation");

        RolService rolService = ServiceFactory.implementation(impl).createRolService();
        UserService userService = ServiceFactory.implementation(impl).createUserService();

        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String rol = req.getParameter("rol");
        if (userService.getUser(name) != null) {
            try{
                req.setAttribute("error","User already exists");
                req.getRequestDispatcher("register.jsp").forward(req,res);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        } else {
            Rol rolAssigned;
            if (Objects.equals(rol, "astronomer")) {
                rolAssigned = rolService.getRol("astronomer");
            } else {
                rolAssigned = rolService.getRol("observer");
            }
            password = Encryptor.encrypt(password);
            User user = new User(name, password, rolAssigned);
            userService.saveUser(user);
            res.sendRedirect("asteroids");
        }
    }
}
