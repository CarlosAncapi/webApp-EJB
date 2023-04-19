package org.cancapi.webapp.ejb.service;

import jakarta.ejb.Stateless;

//@RequestScoped
@Stateless
public class ServiceEJB implements ServiceEJBLocal {

    private int contador;

    public String saludar(String nombre){
        System.out.println("imprimiendo dentro del ejb con instancia: " + this);
        contador++;
        System.out.println("valor del contador del metodo saludar: "+ contador);
        return "Hola que tal "+nombre;
    }
}
