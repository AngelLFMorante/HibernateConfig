package org.afernandez.example.hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase de utilidad para la configuración de Hibernate.
 * Proporciona una única instancia de SessionFactory para manejar sesiones de base de datos.
 */
public class HibernateUtil {

    // SessionFactory es un objeto pesado, se recomienda crearlo una única vez
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Construye la instancia de SessionFactory basándose en la configuración de Hibernate.
     *
     * @return SessionFactory configurada.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Carga la configuración desde hibernate.cfg.xml
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Manejo de error si Hibernate no se inicializa correctamente
            System.err.println("Error en la inicialización de la SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Obtiene la instancia única de SessionFactory.
     *
     * @return SessionFactory para manejar sesiones de Hibernate.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Cierra la SessionFactory y libera los recursos de Hibernate.
     */
    public static void shutdown() {
        getSessionFactory().close();
    }
}
