📱 Sistema de Gestión de Celulares (Java + MySQL)
📌 Descripción del proyecto

Este proyecto es una aplicación de consola desarrollada en Java, cuyo objetivo es gestionar un inventario de celulares utilizando una base de datos MySQL mediante JDBC.

El sistema permite realizar operaciones básicas de gestión (CRUD) y está diseñado siguiendo una arquitectura por capas para facilitar el mantenimiento y la escalabilidad del código.

✅ Funcionalidades principales

Registrar celulares en la base de datos

Listar celulares existentes

Gestionar información como:

Marca

Modelo

Sistema operativo

Gama

Precio

Stock

Validar datos básicos (precio y stock positivos)

🎯 Enfoque académico

El proyecto está orientado a reforzar conceptos de:

Programación Orientada a Objetos (POO)

JDBC

Separación de responsabilidades

Estructura de proyectos Java

Arquitectura en capas

🗂️ Estructura del proyecto
src/
├── dao/
│   ├── ConexionDB.java
│   └── CelularDAO.java
│
├── model/
│   ├── Celular.java
│   └── CategoriaGama.java
│
├── service/
│   └── GestorCelulares.java
│
└── Main.java

📦 Descripción de los paquetes
📁 model

Contiene las clases que representan las entidades del negocio.

🔹 Celular

Atributos:

id

idMarca

modelo

sistemaOperativo

gama

precio

stock

🔹 CategoriaGama (enum)
ALTA,
MEDIA,
BAJA

📁 dao

Contiene las clases responsables del acceso a datos mediante JDBC.

🔹 ConexionDB

Establece la conexión con la base de datos MySQL

Centraliza la configuración de:

URL

Usuario

Contraseña

Driver JDBC

🔹 CelularDAO

Inserta celulares en la base de datos

Lista los celulares registrados

Ejecuta sentencias SQL (INSERT, SELECT)

📁 service

Contiene la lógica del sistema y la interacción con el usuario.

🔹 GestorCelulares

Muestra el menú de gestión de celulares

Solicita datos por consola

Valida información básica

Invoca los métodos del DAO

📁 Main

Clase principal del sistema.

Contiene el método main

Inicia la ejecución del programa

Llama al menú principal

▶️ Ejemplo de ejecución
=== GESTIÓN DE CELULARES ===
1. Listar celulares
2. Registrar celular
0. Volver
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

🗄️ Configuración de MySQL
📌 Creación de la base de datos
CREATE DATABASE tienda_celulares;
USE tienda_celulares;

📌 Creación de la tabla celulares
CREATE TABLE celulares (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_marca INT NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    sistema_operativo VARCHAR(50) NOT NULL,
    gama ENUM('ALTA', 'MEDIA', 'BAJA') NOT NULL,
    precio DOUBLE NOT NULL,
    stock INT NOT NULL
);

🔌 Configuración JDBC

En la clase ConexionDB.java se debe configurar:

🔹 URL
jdbc:mysql://localhost:3306/tienda_celulares

🔹 Usuario
root

🔹 Contraseña
(tu contraseña de MySQL)

🔹 Driver
com.mysql.cj.jdbc.Driver

⚠️ Verificar que:

MySQL esté en ejecución

El conector MySQL Connector/J esté agregado al proyecto

La base de datos configurada coincida con la usada en el código

💻 Requisitos del sistema

Java 17 o superior

MySQL 8 o superior

MySQL Connector/J

IDE (NetBeans, IntelliJ IDEA o Eclipse)

🚀 Posibles mejoras futuras

Este proyecto sirve como base para extender funcionalidades como:

Actualizar y eliminar celulares

Gestión de clientes y ventas

Manejo de excepciones personalizadas

Reportes y análisis de datos

Aplicación de patrones de diseño

Implementación de principios SOLID
