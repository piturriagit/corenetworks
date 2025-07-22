# Actividad práctica individual: “Gestor de Tareas Web”
Caso práctico para cusro CoreNetworks

Objetivo:
Desarrollar una aplicación web que permita a un usuario gestionar sus tareas personales, aplicando los conocimientos adquiridos a lo largo del curso: Java, Spring, MySQL, Angular, HTML/CSS/JS y control de versiones con Git.

## Requisitos funcionales mínimos:
1. Frontend (Angular):
   - [ ] Interfaz con formulario para crear nuevas tareas (título y descripción).
   - [ ] Listado de tareas.
   - [ ] Botón para editar y borrar tareas.
   - [ ] Validación básica de formularios.
2. Backend (Java + Spring Boot): 
   - [ ] API REST que permita:
       - [X] Crear una tarea.
       - [X] Obtener todas las tareas.
       - [X] Actualizar una tarea.
       - [X] Eliminar una tarea.
       - extra Eliminar todas las tareas
   - [ ] Uso de controladores, servicios y repositorios (DAO).
3. Base de datos (MySQL):
   - [ ] Base de datos con una tabla tareas:
      - [ ] id (clave primaria, autoincremental)
      - [ ] titulo (varchar)
      - [ ] descripcion (text)
      - [ ] fecha_creacion (timestamp)
4. Seguridad y despliegue:
   - [ ] Añadir autenticación básica con JWT (puede ser simulada con un token fijo).
   - [ ] Despliegue local de frontend y backend (no es necesario en servidor real, aunque se valorará si se hace).
5. Control de versiones:
   - [ ] Repositorio en GitHub con los distintos commits bien organizados (mínimo 3-4 commits significativos).
   - [ ] Se valorará el uso de ramas.

## Entregables:
- [ ] Código fuente completo.
- [ ] Archivo README.md con instrucciones para ejecutar el proyecto.
- [ ] Capturas de pantalla del funcionamiento de la app.
- [ ] (Opcional) Vídeo de menos de 2 minutos mostrando el uso de la aplicación.

## Evaluación:
- Se valorará la correcta integración entre frontend y backend.
- Buen uso de Angular y Spring Boot.
- Limpieza y claridad del código.
- Que se utilice Git de forma básica (mínimo 3-4 commits significativos).
- Que se aplique el modelo MVC y uso de capas en el backend.
