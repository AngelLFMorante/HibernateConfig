package org.afernandez.example.hibernate.model;

import jakarta.persistence.*;

/**
 * Representa la entidad Producto en la base de datos.
 */
@Entity
@Table(name = "productos")
public class Producto {

    /**
     * Identificador único del producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Precio del producto.
     */
    private Double precio;

    /**
     * Constructor vacío necesario para Hibernate.
     */
    public Producto() {
    }

    /**
     * Constructor con parámetros para facilitar la creación de objetos Producto.
     *
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     */
    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
