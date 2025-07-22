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

# Implementación
## Diagrama del diseño 
[PlantUML diagram](//www.plantuml.com/plantuml/png/XLJlQzim4Ftkl-B6ODYiQTcWfHZZDVq1IzTs9Kst3sCKnRe4KLaoab8QjlxlavoR4zkOjFrGtNjFUlTErfbrpBXLAQDt71T28LH6bCoidvvn7RycaCtphD1Ic_Jz_FJqv9DVVl1GdXtLrHnUiwDvtgWNsg1OgaPDKbR_zAI7ZSvNLgNQbU0Y_7f9YLomaS526zxIHb4XcRKmO_RP_iJvkAhydnG5Sq8h-1C1V8II2HK_E2FKyjVl98KNBNZq5aKLAvxPCXoidD5Iee4icsBXc5fApFDQljd_TXrEkDWI0mGm0elcHHIO4kDXi_HWEBXQpRsLdZXkSHCYBz6DfQmRYHD8OOgsqihYbNB2hRCROLss4URvLXBMv-i9ZuLoIKz4VA8ppiEIZazW3trLSUOmLCBc1q2oFIgE4XssRFKFEjTQ8bDjpRRx7lzBOBxjpenotpCmYhYPbi5AM-6qMQV4c3QLtinQQDmj38rjPqx3OzhWGsCXUDyO6jPmx9JpGCpq9NIItMRK3nVylcWMhC1UG2tmkc9RXD8uW8d7bsZyJcHe8HJtTePo2t3TJS1r5Rve9jjjM_Q20y5Hk_K6T782r78dZw4eIkqfUwvOSxS4JqC2j7B2IKnXy-fGZQCjZAZxw225GHRAbyoXZq8NJ8P_PwB4hYSNPiVdtfLdi3cpIAQm_bGsE9dQVSS5zqq-FauklVB-6pqXvFB7U7hnTJoDFnyV9t3tVGPtZpStWT2otA85jB7zn6lViydjrSDiV7iVdoJ_RKUzb_FmCEyybgqLuPtBrIt0QFGtRrypI05V7Ifk--pjdeJv2YMLmlNzE3hpkbKf_m40)