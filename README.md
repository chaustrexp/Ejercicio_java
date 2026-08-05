# 🛒 Sistema de Gestión de Tienda - Ejercicio Java

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![GUI](https://img.shields.io/badge/GUI-Java_Swing-blue?style=for-the-badge)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![Architecture](https://img.shields.io/badge/Architecture-MVC-green?style=for-the-badge)]()
[![License](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](LICENSE)

¡Bienvenido al repositorio **Ejercicio_java**! Este proyecto es un **Sistema de Gestión de Tienda** desarrollado en Java que ilustra la evolución del software desde una aplicación basada en consola de comandos hasta un entorno visual moderno con interfaz gráfica (GUI).

---

## 📑 Tabla de Contenidos

- [Visión General](#-visión-general)
- [Características Destacadas](#-características-destacadas)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Arquitectura de Software](#-arquitectura-de-software)
- [Requisitos de Instalación](#-requisitos-de-instalación)
- [Guía de Ejecución](#-guía-de-ejecución)
- [Contribuciones](#-contribuciones)
- [Autor](#-autor)
- [Licencia](#-licencia)

---

## 🌐 Visión General

El proyecto se dividió estratégicamente en dos versiones de aprendizaje e implementación:

1. **Versión Consola:** Diseñada para validar la lógica pura del dominio, el manejo de colecciones en memoria, validaciones de datos y flujo de trabajo interactivo mediante terminal.
2. **Versión Interfaz Gráfica:** Transición de la lógica de negocio a un entorno visual desarrollado en **Java Swing**, implementando componentes interactivos, paneles modulares y arquitectura MVC para separar la vista de los modelos y controladores.

---

## ✨ Características Destacadas

- 📦 **Gestión de Productos:** Registro, actualización, eliminación y consulta de stock de inventario.
- 💵 **Control de Ventas y Compras:** Registro de operaciones comerciales con cálculo automático de totales.
- 🔄 **Dos Modalidades de Uso:**
  - **Modo Consola:** Rápido, ligero y centrado en la lógica.
  - **Modo GUI (Swing):** Formularios interactivos, tablas dinámicas y ventanas de diálogo.
- 🏗️ **Diseño Modular:** Código altamente desacoplado siguiendo principios de **Programación Orientada a Objetos (POO)**.

---

## 📁 Estructura del Proyecto

```text
Ejercicio_java/
├── 💻 Tienda version consola/
│   └── Tienda/
│       ├── src/
│       │   ├── modelo/         # Clases de dominio (Producto, Venta, Cliente, etc.)
│       │   ├── servicio/       # Lógica de negocio y reglas comerciales
│       │   └── Main.java       # Menú interactivo en consola
│       └── build/
│
├── 🎨 Tienda version interfaz/
│   └── Tienda/
│       ├── src/
│       │   ├── controller/     # Controladores del patrón MVC
│       │   ├── model/          # Entidades y objetos de datos
│       │   ├── view/           # Formularios, frames y componentes Swing
│       │   └── Main.java       # Punto de entrada de la aplicación GUI
│       └── build/
│
└── 📄 README.md                # Documentación del repositorio
