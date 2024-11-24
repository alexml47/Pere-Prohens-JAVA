package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.service.NasaService;
import org.example.nasa.service.NasaServiceFactory;

import java.io.IOException;

@WebServlet(name="aproachServlet",value="/aproach")
public class AproachServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        NasaService service = NasaServiceFactory.createNasaService();
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


