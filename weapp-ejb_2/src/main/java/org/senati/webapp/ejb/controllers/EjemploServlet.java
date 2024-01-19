package org.senati.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.senati.webapp.ejb.models.Producto;
import org.senati.webapp.ejb.service.ServiceEjb;
import org.senati.webapp.ejb.service.ServiceEjbLocal;

import java.io.IOException;

@WebServlet("/index")   
public class EjemploServlet extends HttpServlet {
    @EJB
    private ServiceEjb service;
    @EJB
    private ServiceEjb service2;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("saludo", service.saludar ("Pablo Junior"));
        //req.setAttribute("saludo2", service2.saludar ("Edison Orlando"));
        //getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

        System.out.println("Service si es igual a service2 =" + service.equals(service2));

        Producto p = service.crear(new Producto ( "Camiones"));
        System.out.println("nuevo producto:" + p);

        req.setAttribute("saludo", service.saludar ("Pablo Junior"));
        req.setAttribute("saludo2", service2.saludar ("Edison Orlando"));
        req.setAttribute("listado", service.listar());
        getServletContext().getRequestDispatcher( "/index.jsp").forward(req, resp);
    }
}
