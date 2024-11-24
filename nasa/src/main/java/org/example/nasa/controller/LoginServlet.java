package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.nasa.model.User;
import org.example.nasa.service.ServiceFactory;
import org.example.nasa.service.UserService;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name="loginServlet",value="/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        UserService service = ServiceFactory.createUserService();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = service.getUser(username);

        if (user == null){
            req.setAttribute("error","Invalid username");
            req.getRequestDispatcher("login.jsp").forward(req,res);
        } else {
            if (user.getPassword().equals(password)){
                HttpSession session = req.getSession();

                session.setAttribute("Observer",true);
                session.setAttribute("Astronomer",false);

                if(Objects.equals(user.getRol().getRol(), "astronomer")){
                    session.setAttribute("Astronomer",true);
                }
                res.sendRedirect("asteroids");
            } else {
                req.setAttribute("error","Invalid password");
                req.getRequestDispatcher("login.jsp").forward(req,res);
            }
        }
    }
}
