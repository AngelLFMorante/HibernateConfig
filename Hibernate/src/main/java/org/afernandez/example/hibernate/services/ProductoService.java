package org.afernandez.example.hibernate.services;

import java.util.List;
import org.afernandez.example.hibernate.dao.ProductoDAO;
import org.afernandez.example.hibernate.model.Producto;

/**
 * Servicio para la gestión de productos.
 * Encapsula la lógica de negocio y delega las operaciones de persistencia al DAO.
 */
public class ProductoService {

    // Instancia del DAO para interactuar con la base de datos
    private final ProductoDAO productoDAO = new ProductoDAO();

    /**
     * Guarda un nuevo producto en la base de datos.
     *
     * @param producto El objeto Producto a guardar.
     */
    public void guardar(Producto producto) {
        productoDAO.guardar(producto);
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param id Identificador único del producto.
     * @return El objeto Producto encontrado o null si no existe.
     */
    public Producto obtenerPorId(Long id) {
        return productoDAO.obtenerPorId(id);
    }

    /**
     * Lista todos los productos disponibles en la base de datos.
     *
     * @return Una lista con todos los productos almacenados.
     */
    public List<Producto> listarTodos() {
        return productoDAO.listarTodos();
    }

    /**
     * Actualiza la información de un producto existente.
     *
     * @param producto El objeto Producto con los datos actualizados.
     */
    public void actualizar(Producto producto) {
        productoDAO.actualizar(producto);
    }

    /**
     * Elimina un producto de la base de datos por su ID.
     *
     * @param id Identificador único del producto a eliminar.
     */
    public void eliminar(Long id) {
        productoDAO.eliminar(id);
    }
}
