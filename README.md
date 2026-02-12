# 📱 Sistema de Gestión de Celulares - TecnoStore

## 📖 Descripción

Aplicación de consola desarrollada en **Java** que permite gestionar celulares utilizando una base de datos **MySQL** mediante **JDBC**.

El proyecto es de carácter académico y está enfocado en la práctica de:

- CRUD 
- Conexión a base de datos con JDBC
- Organización básica por capas
- Manejo de relaciones entre tablas

---

## 🚀 Funcionalidades

- ✅ Registro de marcas
- ✅ Registro de clientes
- ✅ Registro de celulares
- ✅ Gestión de ventas
- ✅ Control de stock
- ✅ Persistencia de datos en MySQL
- ✅ Validación de datos (precio, stock, etc.)

---

## 🛠 Tecnologías utilizadas

- **Java 17**
- **MySQL**
- **JDBC (MySQL Connector/J)**

---

## 🗄 Base de Datos - TecnoStore

### 🔹 Creación de la base de datos

```sql
DROP DATABASE IF EXISTS tecnostore;
CREATE DATABASE tecnostore;
USE tecnostore;
```

---

### 🔹 Creación de tablas

```sql
-- Tabla marcas
CREATE TABLE marcas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Tabla clientes
CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    identificacion VARCHAR(20) NOT NULL UNIQUE,
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(20)
);

-- Tabla celulares
CREATE TABLE celulares (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_marca INT NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    sistema_operativo VARCHAR(30) NOT NULL,
    gama ENUM('ALTA', 'MEDIA', 'BAJA') NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    FOREIGN KEY (id_marca) REFERENCES marcas(id)
);

-- Tabla ventas
CREATE TABLE ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    fecha DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

-- Tabla detalle_ventas
CREATE TABLE detalle_ventas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_celular INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES ventas(id),
    FOREIGN KEY (id_celular) REFERENCES celulares(id)
);
```

---

### 🔹 Datos de prueba

```sql
INSERT INTO marcas (nombre) VALUES
('Samsung'),
('Apple'),
('Xiaomi'),
('Motorola');

INSERT INTO clientes (nombre, identificacion, correo, telefono) VALUES
('Juan Pérez', '1001234567', 'juan@gmail.com', '3001234567'),
('María Gómez', '1007654321', 'maria@gmail.com', '3019876543'),
('Carlos López', '1001112223', 'carlos@gmail.com', '3024567890');

INSERT INTO celulares (id_marca, modelo, sistema_operativo, gama, precio, stock) VALUES
(1, 'Galaxy S23', 'Android', 'ALTA', 3800.00, 10),
(1, 'Galaxy A54', 'Android', 'MEDIA', 1800.00, 15),
(2, 'iPhone 14', 'iOS', 'ALTA', 4500.00, 8),
(3, 'Redmi Note 12', 'Android', 'MEDIA', 1200.00, 20),
(4, 'Moto G54', 'Android', 'BAJA', 900.00, 25);

INSERT INTO ventas (id_cliente, total) VALUES
(1, 5600.00),
(2, 1200.00);

INSERT INTO detalle_ventas (id_venta, id_celular, cantidad, subtotal) VALUES
(1, 1, 1, 3800.00),
(1, 2, 1, 1800.00),
(2, 4, 1, 1200.00);
```

---

## 🔌 Configuración de conexión MySQL

Configurar en la clase `ConexionDB`:

- **URL:** `jdbc:mysql://localhost:3306/tecnostore`
- **Usuario:** `root`
- **Contraseña:** tu contraseña de MySQL
- **Driver:** `com.mysql.cj.jdbc.Driver`

---

## 📦 Requisitos

- MySQL en ejecución
- MySQL Connector/J agregado al proyecto
- Java 17 o superior

---

## 📌 Notas Finales

Proyecto académico orientado a reforzar conocimientos en:

- JDBC
- Bases de datos relacionales
- Relaciones uno a muchos
- Manejo de claves foráneas
- Arquitectura básica por capas en Java
