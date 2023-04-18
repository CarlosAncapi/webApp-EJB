package org.cancapi.webapp.ejb.service;

import jakarta.ejb.Stateless;

@Stateless
public class ServiceEJB {

    public String saludar(String nombre){
        System.out.println("imprimiendo dentro del ejb con instancia: " + this);
        return "Hola que tal "+nombre;
    }
}
