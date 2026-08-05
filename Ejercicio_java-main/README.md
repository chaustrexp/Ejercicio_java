# 🚗 Sistema de Gestión de Parqueadero - Ejercicio Java

Aplicación de escritorio desarrollada en **Java** para la gestión de parqueaderos y control de vehículos, implementando el patrón de arquitectura **Modelo-Vista-Controlador (MVC)** e interfaz gráfica interactiva con **Java Swing**.

---

## 🚀 Características Principales

* **Patrón MVC:** Separación clara entre la lógica del negocio, el modelo de datos y la interfaz de usuario.
* **Gestión de Vehículos:** Registro, control e información detallada de vehículos y conductores.
* **Interfaz Gráfica (GUI):** Ventana interactiva y amigable construida con Java Swing para un uso intuitivo.
* **Modo Consola:** Compatibilidad con la ejecución e interacciones desde la terminal/consola.
* **Cálculo de Tarifas:** Lógica orientada a objetos para gestionar y procesar tiempos y cobros de estacionamiento.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 17 o superior)
* **Arquitectura:** Modelo-Vista-Controlador (MVC)
* **IDE Recomendado:** VS Code / NetBeans / Eclipse / IntelliJ IDEA
* **Control de Versiones:** Git & GitHub

---

## 📂 Estructura del Proyecto (MVC)

```text
src/
 ├── controller/       # Controladores (Gestión de eventos y lógica entre Vista y Modelo)
 ├── model/            # Clases del modelo (Vehículo, Conductor, Tarifa, etc.)
 ├── view/             # Vistas de la aplicación (Formularios e Interfaces Java Swing)
 └── Main.java         # Punto de entrada de la aplicación