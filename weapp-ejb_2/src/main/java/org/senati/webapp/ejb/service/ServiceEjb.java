package org.senati.webapp.ejb.service;


import jakarta.ejb.Stateless;
import org.senati.webapp.ejb.models.Producto;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ServiceEjb {

    private int contador;
    public String saludar(String nombre) {
        System.out.println("Imprimiendo dentro del ejb con instancia: " +this);
        contador ++;
        System.out.println("La cantidad es:" + contador);
        return "Hola que tal " + nombre;
    }

    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto ("Autos"));
        productos.add(new Producto ("Aviones"));
        productos.add(new Producto ("Barcos"));
        return productos;
    }

    public Producto crear (Producto producto) {
        System.out.println("guardando producto ..." + producto);
        Producto p = new Producto();
        p.setNombre (producto.getNombre());
        return p;
    }
}
