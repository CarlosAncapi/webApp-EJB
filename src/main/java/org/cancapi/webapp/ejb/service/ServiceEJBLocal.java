package org.cancapi.webapp.ejb.service;

import jakarta.ejb.Local;
import org.cancapi.webapp.ejb.models.Producto;

import java.util.List;

@Local
public interface ServiceEJBLocal {
    String saludar(String nombre);
    List<Producto> listar();

    Producto crear(Producto producto);

}
