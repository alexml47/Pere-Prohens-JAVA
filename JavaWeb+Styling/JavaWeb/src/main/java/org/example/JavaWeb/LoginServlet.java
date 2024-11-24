package org.example.JavaWeb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="loginServlet",value="/login")
public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String correctUsername = "root";
        String correctPassw = "root";

        if(username.equals(correctUsername) && password.equals(correctPassw)){
            HttpSession session = req.getSession();
            session.setAttribute("loggedIn",true);
            res.sendRedirect("movies");
        } else {
            req.setAttribute("error","login incorrecte");
            req.getRequestDispatcher("login.jsp").forward(req,res);
        }
    }
}
