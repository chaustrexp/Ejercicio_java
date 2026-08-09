# 🚗 Sistema de Gestión de Parqueadero - Ejercicio Java

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![GUI](https://img.shields.io/badge/GUI-Java_Swing-blue?style=for-the-badge)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![Architecture](https://img.shields.io/badge/Architecture-MVC-green?style=for-the-badge)]()
[![MySQL](https://img.shields.io/badge/Database-MySQL-blue?style=for-the-badge&logo=mysql&logoColor=white)]()

¡Bienvenido al repositorio **Ejercicio_java**! Este proyecto es un **Sistema de Gestión de Parqueadero / Tienda** desarrollado en Java que ilustra la evolución del software desde una aplicación basada en consola de comandos hasta un entorno visual moderno con interfaz gráfica (GUI) conectado a una base de datos MySQL.

---

## 📑 Tabla de Contenidos

- [Visión General](#-visión-general)
- [Características Destacadas](#-características-destacadas)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Configuración de Base de Datos](#-configuración-de-base-de-datos)

---

## 🌐 Visión General

El proyecto se dividió estratégicamente en dos versiones de aprendizaje e implementación:

1. **Versión Consola:** Diseñada para validar la lógica pura del dominio, el manejo de colecciones en memoria, validaciones de datos y flujo de trabajo interactivo mediante terminal.
2. **Versión Interfaz Gráfica:** Transición de la lógica de negocio a un entorno visual desarrollado en **Java Swing**, implementando componentes interactivos, persistencia en base de datos MySQL y arquitectura estricta MVC para separar las vistas de los modelos y controladores.

---

## ✨ Características Destacadas

- 📦 **Gestión de Vehículos y Usuarios:** Registro y control de carros, choferes, motores y pasajeros.
- 🔄 **Dos Modalidades de Uso:**
  - **Modo Consola:** Rápido, ligero y centrado en la lógica.
  - **Modo GUI (Swing):** Formularios interactivos con conexión real a base de datos relacional.
- 🏗️ **Diseño MVC:** Código altamente desacoplado siguiendo principios de **Programación Orientada a Objetos (POO)**.
- 🗄️ **Persistencia SQL:** La versión de interfaz cuenta con esquemas SQL para su integración inmediata con bases de datos MySQL.

---

## 📁 Estructura del Proyecto

```text
Ejercicio_java/
├── 💻 Tienda version consola/
│   └── Tienda/
│       ├── Controlador/      # Controladores que manejan la lógica en consola
│       ├── Main/             # Punto de entrada (TiendaParking.java)
│       ├── Modelo/           # Entidades del dominio
│       ├── Vista/            # Interfaces simuladas por texto y consola
│       └── clean_and_build.bat # Script automático de compilación
│
├── 🎨 Tienda version interfaz/
│   └── Tienda/
│       ├── src/
│       │   ├── Conexion/     # Clase de conexión a MySQL
│       │   ├── Controlador/  # Lógica entre Vista y Modelo
│       │   ├── Main/         # Punto de arranque GUI (TiendaParking.java)
│       │   ├── Modelo/       # Entidades y consultas SQL
│       │   └── Vista/        # Formularios (JFrame) y vistas Swing
│       ├── lib/              # Dependencias (mysql-connector-j)
│       ├── tienda_parking.sql # Script de base de datos
│       └── Tienda_Parking_Schema.sql
│
└── 📄 README.md                # Documentación principal del repositorio
```

---

## ⚙️ Configuración de Base de Datos

La **versión de interfaz gráfica** requiere de una base de datos MySQL para funcionar correctamente. 

1. Abre tu gestor de base de datos (por ejemplo, XAMPP, MySQL Workbench o DBeaver).
2. Ejecuta los scripts `tienda_parking.sql` o `Tienda_Parking_Schema.sql` que se encuentran dentro de `Tienda version interfaz/Tienda`.
3. Asegúrate de actualizar las credenciales (`root`, contraseñas) dentro del controlador para que coincidan con tu entorno local.
