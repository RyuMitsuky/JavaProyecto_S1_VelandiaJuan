# Sistema de Gestión de Celulares  
**Java + MySQL + JDBC**

---

## 📋 Descripción del proyecto

Aplicación de consola en **Java** para la gestión de un inventario de celulares, conectada a una base de datos **MySQL** usando **JDBC**.

Está pensada como proyecto académico para practicar:

- Programación Orientada a Objetos
- Conexión y manejo de bases de datos con JDBC
- Arquitectura por capas (separación de responsabilidades)
- Estructura limpia y mantenible de proyectos Java

### Funcionalidades principales

- Registrar nuevos celulares
- Listar todos los celulares del inventario
- Gestionar: marca, modelo, sistema operativo, gama, precio y stock
- Validaciones básicas (precio y stock > 0)

---

## 🗂 Estructura del proyecto
src/
├── dao/
│   ├── ConexionDB.java          # Configuración y conexión a MySQL
│   └── CelularDAO.java          # Operaciones CRUD (por ahora INSERT y SELECT)
│
├── model/
│   ├── Celular.java             # Entidad principal
│   └── CategoriaGama.java       # Enum: ALTA, MEDIA, BAJA
│
├── service/
│   └── GestorCelulares.java     # Lógica de negocio + menú interactivo
│
└── Main.java                    # Punto de entrada del programa
text### Resumen de responsabilidades por capa

| Capa       | Responsabilidad principal                              | Clases principales              |
|------------|----------------------------------------------------------------|---------------------------------|
| `model`    | Representar las entidades del dominio                          | `Celular`, `CategoriaGama`      |
| `dao`      | Acceso a datos (conexión y consultas SQL)                      | `ConexionDB`, `CelularDAO`      |
| `service`  | Lógica de negocio, validaciones y flujo con el usuario        | `GestorCelulares`               |
| —          | Entrada principal del programa                                 | `Main`                          |

---

## ▶ Ejemplo de uso
=== GESTIÓN DE CELULARES ===

Listar celulares
Registrar celular
Volver

Opción: 2
=== REGISTRAR NUEVO CELULAR ===
ID de la marca: 1
Modelo: Galaxy S23
Sistema operativo: Android
Gama (ALTA, MEDIA, BAJA): ALTA
Precio: 4200
Stock: 15
Celular insertado correctamente.
--- LISTADO DE CELULARES ---
ID  MARCA        MODELO             SO         GAMA    PRECIO     STOCK
1   Samsung      Galaxy S23         Android    ALTA    4200.00    15
text---

## 🗄 Configuración de la base de datos (MySQL)

### 1. Crear la base de datos y tabla

```sql
CREATE DATABASE tienda_celulares;

USE tienda_celulares;

CREATE TABLE celulares (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    id_marca        INT NOT NULL,
    modelo          VARCHAR(100) NOT NULL,
    sistema_operativo VARCHAR(50) NOT NULL,
    gama            ENUM('ALTA', 'MEDIA', 'BAJA') NOT NULL,
    precio          DOUBLE NOT NULL,
    stock           INT NOT NULL
);
2. Configuración en ConexionDB.java
Javaprivate static final String URL      = "jdbc:mysql://localhost:3306/tienda_celulares";
private static final String USUARIO  = "root";
private static final String PASSWORD = "TU_CONTRASEÑA_AQUÍ";
private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";
Requisitos para que funcione

MySQL corriendo (versión 8+ recomendada)
Base de datos y tabla creadas
Usuario/contraseña correctos
MySQL Connector/J agregado al proyecto (JAR en classpath)
Java 17 o superior


✅ Requisitos técnicos

Java: 17 o superior
MySQL: 8 o superior
Driver: MySQL Connector/J (compatible con Java 8+)
IDE recomendado: IntelliJ IDEA, Eclipse o NetBeans


🚀 Ideas para extender el proyecto

Agregar actualizar y eliminar celulares (UPDATE / DELETE)
Crear tabla de marcas y relación con celulares
Gestión de clientes y ventas
Control de stock al vender
Reportes básicos (celulares por gama, stock bajo, más caros…)
Manejo avanzado de excepciones (clases personalizadas)
Aplicar patrones de diseño (DAO mejorado, Service Layer, etc.)
Principios SOLID y refactorización
