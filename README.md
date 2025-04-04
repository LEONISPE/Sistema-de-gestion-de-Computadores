# Sistema de Gestión de Computadoras

## Descripción
Este es un sistema backend desarrollado con **Spring Boot** para la gestión de computadoras dentro de una organización. Permite realizar operaciones **CRUD** sobre computadoras y otros elementos relacionados, así como gestionar su estado (activas o desactivadas). También incorpora autenticación y autorización con **JWT**.

## Características
- **Gestión de computadoras**: Agregar, actualizar, eliminar y desactivar computadoras.
- **Manejo de estados**: Computadoras pueden estar activas o desactivadas.
- **Relaciones con otras entidades**:
  - **Mantenimiento**: Registro de mantenimientos realizados a cada computadora.
  - **Ubicación**: Asignación de una ubicación específica a cada equipo.
  - **Historial de uso**: Permite mostar el histrial de uso de los equipos de computo
  - **Lectura y Divulgación**: Información relevante sobre normativas y documentación.
- **Seguridad y autenticación**:
  - Registro e inicio de sesión de usuarios.
  - Implementación de **JWT** para autenticación segura.
  - Control de acceso con **Spring Security**.
- **Base de datos**: Persistencia de datos con **MySQL**.

## Tecnologías utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Security & JWT**
- **Spring Data JPA & Hibernate**
- **MySQL**
- **Maven**

## Instalación y configuración
1. Clonar el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   ```
2. Configurar la base de datos en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tu_base_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   ```
3. Construir el proyecto con **Maven**:
   ```bash
   mvn clean install
   ```
4. Ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```

## Endpoints principales
| Método | Endpoint                 | Descripción |
|--------|--------------------------|-------------|
| GET    | /computadoras            | Obtener todas las computadoras |
| POST   | /computadoras            | Agregar una nueva computadora |
| PUT    | /computadoras/{id}        | Actualizar una computadora |
| DELETE | /computadoras/{id}        | Eliminar una computadora |
| PUT  | /computadoras/{id}/estado | Cambiar estado de una computadora |

## Autenticación
El sistema usa **JWT** para autenticación y autorización. Para acceder a los endpoints protegidos, primero debes obtener un token enviando credenciales a:
   ```bash
   POST /login
   ```

## Contribución
Si deseas contribuir, puedes hacer un **fork** del repositorio y enviar un **pull request** con tus cambios.

## Autor
- **LEO  NISPERUZA** - [GitHub](https://github.com/LEONISPE)

## Licencia
Este proyecto está bajo la licencia **MIT**.
