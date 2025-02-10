package org.afernandez.example.hibernate.dao;

import org.afernandez.example.hibernate.config.HibernateUtil;
import org.afernandez.example.hibernate.model.Producto;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Data Access Object (DAO) para la entidad Producto.
 * Gestiona las operaciones CRUD utilizando Hibernate.
 */
public class ProductoDAO {

    /**
     * Guarda un producto en la base de datos.
     *
     * @param producto El producto a guardar.
     */
    public void guardar(Producto producto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(producto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param id Identificador del producto.
     * @return El producto encontrado o null si no existe.
     */
    public Producto obtenerPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Producto.class, id);
        }
    }

    /**
     * Lista todos los productos almacenados en la base de datos.
     *
     * @return Lista de productos.
     */
    public List<Producto> listarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Producto", Producto.class).list();
        }
    }

    /**
     * Actualiza un producto existente en la base de datos.
     *
     * @param producto El producto con los nuevos datos.
     */
    public void actualizar(Producto producto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(producto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    /**
     * Elimina un producto de la base de datos por su ID.
     *
     * @param id Identificador del producto a eliminar.
     */
    public void eliminar(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Producto producto = session.get(Producto.class, id);
            if (producto != null) {
                session.delete(producto);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
