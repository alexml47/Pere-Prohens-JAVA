package org.example.nasa.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.nasa.dao.orm.AproachOrmDaoImpl;
import org.example.nasa.service.AproachService;
import org.example.nasa.factory.ServiceFactory;
import org.example.nasa.service.AsteroidService;
import org.example.nasa.utils.Session;

import java.io.IOException;

@WebServlet(name="aproachServlet",value="/aproach")
public class AproachServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String impl = Session.getAttribute(req,"implementation") == null ? "ORM" : Session.getAttribute(req,"implementation");
        AproachService service = ServiceFactory.implementation(impl).createAproachService();

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


