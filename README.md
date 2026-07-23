# 🛒 Ejercicio Java - Sistema de Tienda (MVC)

Aplicación de escritorio desarrollada en **Java** para la gestión de productos, clientes y procesos de venta en una tienda, implementando el patrón de diseño **Modelo-Vista-Controlador (MVC)** y componentes de interfaz gráfica **Java Swing**.

---

## 🚀 Características

* **Patrón de Arquitectura MVC:** Separación clara entre la lógica de negocio, la interfaz gráfica y los controladores.
* **Gestión de Vistas:** Módulos e interfaces desacopladas para controlar flujos de pasajeros, productos y motores de la aplicación.
* **Persistencia / Fuentes de datos:** Manejo de datos y lectura a través de archivos planos (`sources.txt`).

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java (JDK 17+)
* **GUI Framework:** Java Swing / AWT
* **IDE Recomendado:** VS Code / NetBeans / Eclipse / IntelliJ IDEA
* **Control de Versiones:** Git & GitHub

---

## 📂 Estructura del Proyecto

```text
Ejercicio_java/
├── Tienda version actualizada/
│   └── Tienda/
│       ├── Controlador/   # Lógica de comunicación entre Vista y Modelo
│       ├── Main/          # Punto de entrada de la aplicación (Clase principal)
│       ├── Modelo/        # Lógica de negocio y estructuras de datos
│       ├── Vista/         # Interfaces gráficas de usuario (Swing)
│       └── sources.txt    # Archivos de datos / recursos
├── .gitignore             # Archivos excluidos del control de versiones
└── README.md              # Documentación del proyecto




---

## Pasos para guardarlo y subirlo a GitHub

<Sequence>
{/* Reason: Guardar y publicar el nuevo archivo README.md mediante un commit formal en el repositorio. */}
  <Step subtitle="Guardado local" title="1. Editar el README.md">
    Abre tu archivo `README.md` en la raíz en VS Code, reemplaza todo el contenido por el bloque anterior y guarda los cambios (`Ctrl + S`).
  </Step>
  <Step subtitle="Indexación" title="2. Agregar cambios a Git">
    En tu terminal de PowerShell ejecuta:
    ```powershell
    git add README.md
    ```
  </Step>
  <Step subtitle="Commit" title="3. Registrar la actualización">
    ```powershell
    git commit -m "docs: Añadir documentación principal en README.md"
    ```
  </Step>
  <Step subtitle="Publicación" title="4. Subir a GitHub">
    ```powershell
    git push origin main
    ```
  </Step>
</Sequence>

---

1. git clone https://github.com/chaustrexp/Ejercicio_java.git

2. cd Ejercicio_java


Autor
Cristian Chaustre - @chaustrexp