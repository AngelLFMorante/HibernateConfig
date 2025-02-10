package org.afernandez.example.hibernate.config;

import org.afernandez.example.hibernate.controller.ProductoServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración para registrar y mapear un servlet en una aplicación Spring Boot.
 * Esta clase se encarga de registrar el servlet ProductoServlet y mapearlo a la URL "/productos".
 *
 * Spring Boot no detecta automáticamente servlets como los haría un contenedor tradicional de servlets,
 * por lo que es necesario registrarlos explícitamente en una clase de configuración.
 */
@Configuration
public class ServletConfig {

    /**
     * Método que registra el servlet ProductoServlet en la aplicación de Spring Boot.
     * Este servlet se mapeará a la URL "/productos".
     *
     * @return Un ServletRegistrationBean que registra el servlet y mapea la URL
     */
    @Bean
    public ServletRegistrationBean<ProductoServlet> productoServlet() {
        // Crea y devuelve un ServletRegistrationBean que mapea la URL "/productos" al servlet ProductoServlet.
        // Esto permite que las solicitudes a "/productos" se manejen por el servlet ProductoServlet.
        return new ServletRegistrationBean<>(new ProductoServlet(), "/productos");
    }
}


