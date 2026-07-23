# 🚗 Ejercicio Java - Sistema de Gestión de Parqueadero

Aplicación en **Java** estructurada bajo el patrón de arquitectura **MVC (Modelo-Vista-Controlador)**. El sistema gestiona las operaciones de un parqueadero interactivo, administrando entidades principales como vehículos, conductores, motores y pasajeros mediante los principios fundamentales de la Programación Orientada a Objetos (POO).

---

## 🚀 Características Principales

- **Arquitectura MVC:** Separación clara entre la lógica de negocio, el control de datos y la interfaz de usuario.
- **Gestión POO:** Encapsulamiento de datos, uso de constructores, atributos privados y métodos *getters/setters*.
- **Control de Vehículos y Usuarios:** Registro y administración de información sobre vehículos, conductores y componentes.
- **Interfaz Interactiva:** Flujo de navegación intuitivo para el usuario.

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java (JDK 17+)
- **Arquitectura:** Model-View-Controller (MVC)
- **Control de Versiones:** Git & GitHub

---

## 📂 Estructura del Proyecto

```text
src/
├── model/       # Entidades y lógica de negocio (Vehiculo, Conductor, Motor, etc.)
├── controller/  # Controladores para manejar la lógica entre vista y modelo
└── view/        # Interfaz de usuario (Consola / Swing)
```

---

## 📋 Instalación y Ejecución

### Prerrequisitos
- Java Development Kit (JDK) 17 o superior.
- Git (para clonar el repositorio).

### Pasos de Instalación
1. **Clonar el repositorio:**
   ```bash
   git clone <url-del-repositorio>
   cd Ejercicio_java
   ```

2. **Compilar el código:**
   ```bash
   javac Main/TiendaParking.java
   ```

3. **Ejecutar la aplicación:**
   ```bash
   java Main.TiendaParking
   ```
