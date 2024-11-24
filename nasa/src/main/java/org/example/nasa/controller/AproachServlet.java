package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.service.AproachService;
import org.example.nasa.service.ServiceFactory;

import java.io.IOException;

@WebServlet(name="aproachServlet",value="/aproach")
public class AproachServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        AproachService service = ServiceFactory.createAproachService();
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("aproaches",service.findAllAproachesByAsteroidId(id));
        req.setAttribute("asteroid", id);
        try {
            req.getRequestDispatcher("aproach.jsp").forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}


