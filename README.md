# Actividad práctica individual: “Gestor de Tareas Web”
Caso práctico para cusro CoreNetworks

Objetivo:
Desarrollar una aplicación web que permita a un usuario gestionar sus tareas personales, aplicando los conocimientos adquiridos a lo largo del curso: Java, Spring, MySQL, Angular, HTML/CSS/JS y control de versiones con Git.

## Requisitos funcionales mínimos:
1. Frontend (Angular):
   - [X] Interfaz con formulario para crear nuevas tareas (título y descripción).
   - [X] Listado de tareas.
   - [X] Botón para editar y borrar tareas.
   - [X] Validación básica de formularios.
2. Backend (Java + Spring Boot): 
   - [X] API REST que permita:
       - [X] Crear una tarea.
       - [X] Obtener todas las tareas.
       - [X] Actualizar una tarea.
       - [X] Eliminar una tarea.
       - extra Eliminar todas las tareas
   - [X] Uso de controladores, servicios y repositorios (DAO).
3. Base de datos (MySQL):
   - [X] Base de datos con una tabla tareas:
      - [X] id (clave primaria, autoincremental)
      - [X] titulo (varchar)
      - [X] descripcion (text)
      - [X] fecha_creacion (timestamp)
4. Seguridad y despliegue:
   - [ ] Añadir autenticación básica con JWT (puede ser simulada con un token fijo).
   - [ ] Despliegue local de frontend y backend (no es necesario en servidor real, aunque se valorará si se hace).
5. Control de versiones:
   - [X] Repositorio en GitHub con los distintos commits bien organizados (mínimo 3-4 commits significativos).
   - [X] Se valorará el uso de ramas.

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

# Implementación
## Diagrama del diseño 
[PlantUML diagram](https://www.plantuml.com/plantuml/png/XLJlQzim4Ftkl-B6ODYqQTcWfHZZDVq1IzTs9Kst3sCKsRe4KLaoab8QjlxlaspLhYr2Vdo8xhrtkdidwLGReiowuj47Yaic46h5Ag8sZq-uYLyIo8eyAoMNAlrOd9mSVxRBJnRAiyCcciDBTbZadNef5RALwDHUIffF83teT3QohiHx2IxTrqegf8nC59PIqO4sYafEj8O5qK_w5nRJkhO_pafYc1JmDmBOWuem4TyRnSJgzvyaXMV9QFGQHJKfdyZARIoCafoZWYoROsc8M77CyqRUvh_Pk1tEUwA302QWKJsp4bFFk6-N3RW7zRgmfGJYUC1DF7c5PifvqqYSG0fprBKK6Y-5OMQJNJDjibQOvxt4hSysCnepOP90vFcUJYXrIxzz0ZlewveIWoxYak-3b-rGKUHeS51MkD6Pb1o966hwxWF-LyTyVJypx_kEWNcBksafhALcHghDsy3cNIIOsG2Dnu5jOti_fwrZQl5jO_7mhZ7qhAssUv-tsknkmjZPtgFGNB1vKIr9YO510_2g9ZtYtTY7cSLNg6mcNz2I2MhB2NthuQORXylQtMZ2Xsrhyem3um9BcWH-vmHyooC_jbbHIKlPSSIwiyLewXpmAyCCnnJQLyV7AEfIiQQF4L8g92vyGGnQAsH9kFkxO1MEQp9kThImLLa6AOX-AmgRgzBYRL63TvnHs-J3m-p2Ak---oV4L_bpEZ__Dft7NuwE4hZziO3RX-jhHnYKFA0vj2lxaJPrBsOtb_UBwSrTV9oybHq5B-V1GJvwB0ShXuU7Qno0oUHVFZnca0A-61HKX-m-fyTif7Kgv6QMx5rCuUfk6ftQdEkA_mS0)
<!-- To update this diagram:
1. edit [diagram.plantuml](src/main/resources/diagram.plantuml)
2. chek it here https://www.plantuml.com/plantuml/uml/ 
3. get the url and replace it
-->

# Testing
For testing purposes, you can use:
- API REST http://localhost:8080/
  - Swagger UI: http://localhost:8080/swagger-ui/index.html
- Loaded db in memory: http://localhost:8080/h2-console (db, db1)
  - MySQL testing environment. Copy configuration from your testing environment and set it into your IntelliJ IDEA Configuration, inside Environment variables. [environment_TEST.env](src/main/resources/environment_TEST.env) to update configuration 
