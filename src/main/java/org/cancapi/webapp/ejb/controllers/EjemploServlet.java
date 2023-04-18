package org.cancapi.webapp.ejb.controllers;


import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cancapi.webapp.ejb.service.ServiceEJB;


import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    @Inject
    private ServiceEJB service;

    @Inject
    private ServiceEJB service2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("service si es igual a service2 = " + service.equals(service2) );
        req.setAttribute("saludo", service.saludar("Andres"));
        req.setAttribute("saludo2", service2.saludar("Jhon"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
