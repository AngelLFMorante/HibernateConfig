package org.afernandez.example.hibernate.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Clase de utilidad para la configuración de Hibernate.
 * Proporciona una única instancia de EntityManagerFactory para manejar sesiones de base de datos.
 */
public class HibernateUtil {

    // EntityManagerFactory es un objeto pesado, se recomienda crearlo una única vez
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    /**
     * Construye la instancia de EntityManagerFactory basándose en la configuración de Hibernate.
     *
     * @return EntityManagerFactory configurada.
     */
    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
            // Carga la configuración desde persistence.xml
            return Persistence.createEntityManagerFactory("my-persistence-unit");
        } catch (Throwable ex) {
            // Manejo de error si Hibernate no se inicializa correctamente
            System.err.println("Error en la inicialización del EntityManagerFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Obtiene una nueva instancia de EntityManager.
     *
     * @return EntityManager para manejar transacciones y operaciones de persistencia.
     */
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    /**
     * Cierra la EntityManagerFactory y libera los recursos de Hibernate.
     */
    public static void shutdown() {
        entityManagerFactory.close();
    }
}
