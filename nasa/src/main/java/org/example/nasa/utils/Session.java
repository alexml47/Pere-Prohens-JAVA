package org.example.nasa.utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class Session {
    public static String getAttribute(HttpServletRequest req,String attribute){
        HttpSession session = req.getSession();
        return (String) session.getAttribute(attribute);
    }

    public static void setAttribute(HttpServletRequest req,String attribute,Object value){
        HttpSession session = req.getSession();
        session.setAttribute(attribute, value);
    }

    public static void deleteSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        if (session != null) {
            session.invalidate();
        }
    }

}
