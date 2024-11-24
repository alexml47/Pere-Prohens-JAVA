package org.example.nasa.interceptor;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(servletNames = {"aproachServlet","asteroidServlet","asteroidsServlet"})
public class ObserverInterceptor implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        HttpSession session = request.getSession(false);

        if (session != null && (Boolean.TRUE.equals(session.getAttribute("Observer")) || Boolean.TRUE.equals(session.getAttribute("Astronomer")))) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect("login");
        }
    }
}
