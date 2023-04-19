package org.cancapi.webapp.ejb.controllers;


import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cancapi.webapp.ejb.service.ServiceEJB;
import org.cancapi.webapp.ejb.service.ServiceEJBLocal;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    //@Inject
    //private ServiceEJBLocal service;

    //@Inject
    //private ServiceEJBLocal service2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEJBLocal service = null;
        ServiceEJBLocal service2 = null;

        try {
            InitialContext ctx = new InitialContext();
            service = (ServiceEJBLocal) ctx.lookup("java:global/webapp-ejb/ServiceEJB!org.cancapi.webapp.ejb.service.ServiceEJBLocal");
            service2 = (ServiceEJBLocal) ctx.lookup("java:global/webapp-ejb/ServiceEJB!org.cancapi.webapp.ejb.service.ServiceEJBLocal");
        } catch (NamingException e){
            e.printStackTrace();
        }

        System.out.println("service si es igual a service2 = " + service.equals(service2) );
        req.setAttribute("saludo", service.saludar("Andres"));
        req.setAttribute("saludo2", service2.saludar("Jhon"));
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
