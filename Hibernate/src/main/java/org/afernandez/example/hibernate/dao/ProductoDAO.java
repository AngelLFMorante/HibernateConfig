package org.afernandez.example.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.afernandez.example.hibernate.config.HibernateUtil;
import org.afernandez.example.hibernate.model.Producto;
import java.util.List;

/**
 * Data Access Object (DAO) para la entidad Producto.
 * Gestiona las operaciones CRUD utilizando JPA con EntityManager.
 */
public class ProductoDAO {

    /**
     * Guarda un producto en la base de datos.
     *
     * @param producto El producto a guardar.
     */
    public void guardar(Producto producto) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(producto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param id Identificador del producto.
     * @return El producto encontrado o null si no existe.
     */
    public Producto obtenerPorId(Long id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            return entityManager.find(Producto.class, id);
        } finally {
            entityManager.close();
        }
    }

    /**
     * Lista todos los productos almacenados en la base de datos.
     *
     * @return Lista de productos.
     */
    public List<Producto> listarTodos() {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        try {
            return entityManager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Actualiza un producto existente en la base de datos.
     *
     * @param producto El producto con los nuevos datos.
     */
    public void actualizar(Producto producto) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(producto);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Elimina un producto de la base de datos por su ID.
     *
     * @param id Identificador del producto a eliminar.
     */
    public void eliminar(Long id) {
        EntityManager entityManager = HibernateUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Producto producto = entityManager.find(Producto.class, id);
            if (producto != null) {
                entityManager.remove(producto);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
