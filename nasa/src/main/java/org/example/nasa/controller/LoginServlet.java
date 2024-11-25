package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.nasa.dao.orm.UserOrmDaoImpl;
import org.example.nasa.factory.ServiceOrmFactory;
import org.example.nasa.model.User;
import org.example.nasa.factory.ServiceFactory;
import org.example.nasa.service.AsteroidService;
import org.example.nasa.service.UserService;
import org.example.nasa.utils.Encryptor;
import org.example.nasa.utils.Session;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name="loginServlet",value="/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String impl = Session.getAttribute(req,"implementation") == null ? "ORM" : Session.getAttribute(req,"implementation");
        ServiceFactory factory = ServiceFactory.implementation(impl);

        UserService service = factory.createUserService();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String implementation = req.getParameter("implementation");

        User user = service.getUser(username);

        if (user == null){
            req.setAttribute("error","Invalid username");
            req.getRequestDispatcher("login.jsp").forward(req,res);
        } else {
            if (Encryptor.verifyPassword(password, user.getPassword())){
                Session.setAttribute(req,"Observer",true);
                Session.setAttribute(req,"Astronomer",false);

                if(Objects.equals(user.getRol().getRol(), "astronomer")){
                    Session.setAttribute(req,"Astronomer",true);
                } else {
                    Session.setAttribute(req,"Astronomer",false);
                }


                Session.setAttribute(req,"implementation",implementation);
                res.sendRedirect("asteroids");
            } else {
                req.setAttribute("error","Invalid password");
                req.getRequestDispatcher("login.jsp").forward(req,res);
            }
        }
    }
}
