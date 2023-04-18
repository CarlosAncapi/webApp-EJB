package org.cancapi.webapp.ejb.controllers;


import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cancapi.webapp.ejb.service.ServiceEJB;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    //@Inject
    //private ServiceEJB service;

    //@Inject
    //private ServiceEJB service2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEJB service = null;
        ServiceEJB service2 = null;

        try {
            InitialContext ctx = new InitialContext();
            service = (ServiceEJB) ctx.lookup("java:global/webapp-ejb/ServiceEJB!org.cancapi.webapp.ejb.service.ServiceEJB");
            service2 = (ServiceEJB) ctx.lookup("java:global/webapp-ejb/ServiceEJB!org.cancapi.webapp.ejb.service.ServiceEJB");
        } catch (NamingException e){
            e.printStackTrace();
        }

        System.out.println("service si es igual a service2 = " + service.equals(service2) );
        req.setAttribute("saludo", service.saludar("Andres"));
        req.setAttribute("saludo2", service2.saludar("Jhon"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
