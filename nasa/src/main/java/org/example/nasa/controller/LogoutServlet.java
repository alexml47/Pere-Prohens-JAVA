package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.nasa.utils.Session;

import java.io.IOException;

@WebServlet(name="logoutServlet",value="/logout")
public class LogoutServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws  IOException {
        Session.deleteSession(req);
        res.sendRedirect("login");
    }
}
