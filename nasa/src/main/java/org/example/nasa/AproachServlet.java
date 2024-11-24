package org.example.nasa;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.controller.NasaService;
import org.example.nasa.controller.NasaServiceFactory;

import java.io.IOException;

@WebServlet(name="aproachServlet",value="/aproach")
public class AproachServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        NasaService service = NasaServiceFactory.createNasaService();
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("aproaches",service.findAllAproachesByAsteroidId(id));

        try {
            req.getRequestDispatcher("aproach.jsp").forward(req,res);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}


