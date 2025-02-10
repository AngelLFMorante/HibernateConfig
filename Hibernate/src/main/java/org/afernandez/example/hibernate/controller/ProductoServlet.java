package org.afernandez.example.hibernate.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import org.afernandez.example.hibernate.model.Producto;
import org.afernandez.example.hibernate.services.ProductoService;

/**
 * Servlet para manejar las operaciones CRUD de la entidad Producto.
 */
@WebServlet("/productos")
public class ProductoServlet extends HttpServlet {

    private final ProductoService productoService = new ProductoService();
    private final Gson gson = new Gson();

    /**
     * Maneja las solicitudes GET para listar todos los productos.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Producto> productos = productoService.listarTodos();
        String json = gson.toJson(productos);

        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    /**
     * Maneja las solicitudes POST para crear un nuevo producto.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Producto producto = gson.fromJson(reader, Producto.class);

        productoService.guardar(producto);

        resp.setContentType("application/json");
        resp.getWriter().write("{\"mensaje\": \"Producto creado\"}");
    }

    /**
     * Maneja las solicitudes PUT para actualizar un producto existente.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Producto producto = gson.fromJson(reader, Producto.class);

        productoService.actualizar(producto);

        resp.setContentType("application/json");
        resp.getWriter().write("{\"mensaje\": \"Producto actualizado\"}");
    }

    /**
     * Maneja las solicitudes DELETE para eliminar un producto por su ID.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));

        productoService.eliminar(id);

        resp.setContentType("application/json");
        resp.getWriter().write("{\"mensaje\": \"Producto eliminado\"}");
    }
}
