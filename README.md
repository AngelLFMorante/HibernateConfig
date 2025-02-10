# Hibernate con Servlets y JavaEE - Ejemplo para Entrevistas Técnicas

Este proyecto es un ejemplo sencillo de cómo utilizar **Hibernate** con **Servlets** en **JavaEE**, pensado para entrevistas técnicas que requieran demostrar conocimientos en **persistencia**, **manejo de base de datos** y **arquitectura web en Java**.

**Spring Boot** se usa únicamente para la configuración básica del servidor embebido y la gestión de la persistencia.

## Tecnologías Utilizadas

- **Java EE** (Jakarta EE) - Para la implementación de Servlets
- **Hibernate** - ORM para la gestión de la base de datos
- **Spring Boot** - Para configuración básica del servidor embebido
- **H2 Database** - Base de datos en memoria para pruebas rápidas
- **Tomcat Embebido** - Servidor web
- **Postman** - Para pruebas de los endpoints REST

---

## Instalación y Configuración

### Requisitos Previos

Asegúrate de tener instalado:
- **JDK 17+**
- **Maven**
- **Postman** (para pruebas de API, opcional pero recomendado)

### Pasos para Montar el Proyecto

1. **Clonar el repositorio**
```bash
 git clone https://github.com/tu-usuario/tu-repositorio.git
```

2. **Entrar en el directorio del proyecto**
```bash
 cd tu-repositorio
```

3. **Compilar el proyecto con Maven**
```bash
 mvn clean install
```

4. **Ejecutar la aplicación**
```bash
 mvn spring-boot:run
```

5. **Acceder a la aplicación**
    - Servidor en: `http://localhost:8080`
    - Endpoints disponibles en `http://localhost:8080/productos`

---

## Configuración de Hibernate

El archivo `persistence.xml` se encuentra en `src/main/resources/META-INF/persistence.xml` y configura Hibernate con una base de datos en memoria H2.

Ejemplo de configuración:
```xml
<persistence xmlns="http://jakarta.ee/xml/ns/persistence"
             version="3.0">
    <persistence-unit name="my-persistence-unit">
        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:h2:mem:testdb"/>
            <property name="jakarta.persistence.jdbc.user" value="sa"/>
            <property name="jakarta.persistence.jdbc.password" value=""/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.H2Dialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

---

## Pruebas con Postman

Para probar los endpoints, puedes importar la siguiente colección de Postman o utilizar las siguientes peticiones:

### 1. Obtener todos los productos
**GET** `http://localhost:8080/productos`

### 2. Obtener un producto por ID
**GET** `http://localhost:8080/productos/{id}`

### 3. Crear un nuevo producto
**POST** `http://localhost:8080/productos`

**Body JSON:**
```json
{
  "nombre": "Producto de prueba",
  "precio": 10.5
}
```

### 4. Actualizar un producto existente
**PUT** `http://localhost:8080/productos/{id}`

**Body JSON:**
```json
{
  "nombre": "Producto actualizado",
  "precio": 12.99
}
```

### 5. Eliminar un producto
**DELETE** `http://localhost:8080/productos/{id}`

---

## Estructura del Proyecto

```
/src
 ├── main
 │   ├── java
 │   │   ├── org.afernandez.example.hibernate
 │   │   │   ├── config (Configuración de Hibernate)
 │   │   │   ├── dao (Acceso a datos con Hibernate)
 │   │   │   ├── services (Lógica de negocio)
 │   │   │   ├── controller (Servlets)
 │   ├── resources
 │   │   ├── META-INF
 │   │   │   ├── persistence.xml
```

---

## Consideraciones Finales

Este es un proyecto de ejemplo que **no debe usarse en producción**, ya que usa una base de datos en memoria y configuración básica.

Para desplegarlo en producción, se recomienda:
- Usar una base de datos real como **PostgreSQL** o **MySQL**.
- Configurar un **servidor externo** en lugar de usar Tomcat embebido.
- Manejo adecuado de **transacciones** y seguridad en los Servlets.

Este proyecto puede ser fácilmente modificado para adaptarse a distintas necesidades en entrevistas técnicas.
