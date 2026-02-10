## 📘 Documentación del Modelo de Datos

La base de datos `tecnostore_db` fue diseñada para soportar el funcionamiento de una tienda de celulares, permitiendo el control de inventario, clientes y ventas.

---

###  Tabla: `marcas`
Almacena las marcas de los celulares disponibles en la tienda.

**Propósito:**  
Identificar y clasificar los celulares según su fabricante.

**Relaciones:**  
- Una marca puede estar asociada a muchos celulares.

---

###  Tabla: `clientes`
Contiene la información de los clientes que realizan compras.

**Propósito:**  
Registrar los datos personales y de contacto de los clientes.

**Relaciones:**  
- Un cliente puede realizar múltiples ventas.

---

###  Tabla: `celulares`
Representa los productos que se venden en la tienda.

**Propósito:**  
Gestionar el catálogo de celulares, su precio y disponibilidad.

**Relaciones:**  
- Cada celular pertenece a una marca.
- Un celular puede participar en múltiples detalles de venta.

---

###  Tabla: `ventas`
Registra cada transacción realizada por los clientes.

**Propósito:**  
Controlar las ventas realizadas y su valor total.

**Relaciones:**  
- Cada venta pertenece a un cliente.
- Una venta puede contener varios registros en el detalle de ventas.

---

###  Tabla: `detalle_ventas`
Describe los productos vendidos en cada venta.

**Propósito:**  
Desglosar una venta en los celulares vendidos, su cantidad y subtotal.

**Relaciones:**  
- Cada detalle pertenece a una venta.
- Cada detalle hace referencia a un celular.

---

###  Resumen de Relaciones

- **marcas 1 — N celulares**
- **clientes 1 — N ventas**
- **ventas 1 — N detalle_ventas**
- **celulares 1 — N detalle_ventas**

---

### 🧩 Modelo Entidad–Relación

El siguiente diagrama representa gráficamente la estructura de la base de datos y las relaciones entre sus tablas:

```mermaid
erDiagram
    marcas {
        INT id PK
        VARCHAR nombre
    }

    clientes {
        INT id PK
        VARCHAR nombre
        VARCHAR identificacion
        VARCHAR correo
        VARCHAR telefono
    }

    celulares {
        INT id PK
        INT id_marca FK
        VARCHAR modelo
        VARCHAR sistema_operativo
        ENUM gama
        DECIMAL precio
        INT stock
    }

    ventas {
        INT id PK
        INT id_cliente FK
        DATETIME fecha
        DECIMAL total
    }

    detalle_ventas {
        INT id PK
        INT id_venta FK
        INT id_celular FK
        INT cantidad
        DECIMAL subtotal
    }

    marcas ||--o{ celulares : tiene
    clientes ||--o{ ventas : realiza
    ventas ||--o{ detalle_ventas : contiene
    celulares ||--o{ detalle_ventas : incluye
