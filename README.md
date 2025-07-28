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
   - [X] Añadir autenticación básica con JWT (puede ser simulada con un token fijo).
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
[PlantUML diagram](https:////www.plantuml.com/plantuml/png/XLPjRzis4FxkNy5Xm21ZJPeLQn4OWbQdJL1tIHeuoVPX60fAFBj4A58WgIp6bl--eyI8eMYbUP7CUvvx9tb-RopLjgt5x0S66ow1D9hNLE--ti4kUvYJl2poIWcb5p-MnyVlVi7bJmWL-UjEMf27_7LP3DeRfO5lvQ3jLMdtawWU3deeQMlvN0KsxXTLQc2S7cYeb6QHxgoXrHtT0Zd1zwba9C_NK5agjmAAWlmxuCkcGMoZ10FT0RDAK6F83JLtvaye4SS_mIjgkPA84_8pgIcNsRNLN6x_-dk-8FUAizdZJ2eBnAfcGOIggFYcZ5qS7nqVXMWg9QrMGe16fsV1AI6zrukTy_iXi1n4o04neEzv1GlFkEwN2BfmchR401FbBEBEFNaBTYc40qms9mko1jCeQU1KMcvt-JatDkyLYoAekFN9RiKoBkqyKV9yJwUCkQLtF_QHqDk6KGjEueo_ycbypma30HQYi5979qe9e3BM2Tad_DySyt7s61hcwpxPhL3VeLKQ6cMuLNgty8pr84aQ5g7PM33Li-TDcknHZq_snCClzo2mfclkYpnPOtSuncKDDHfN5es2tj0Aakf4uEU61iINuXLP8Ru5ZPPyD1ik6SQI5Yt0NIeELuqxuLJ4EHjw3qdLebmx0zupKdo-SJ6cwb0hfBoqkOPTnTd2fUzNbbi12z9VGLx6m5IQTqcCa4e3TUAFr0BMmTrDxkCDhs4Sa7LTOoM6X0nQKWC-AEXEI8_tGKNJW3FCyFPszH4rhtxtDuUFye_b-iEdvJfxy_Rjd5n-kI6Nj-VdZX257D4SEeJzbNLntwmkJgzlbXTNsRlvKzYpvC8yF2n6TsIqSdYwiyO2Sd3mNn7lCMmiF5YGpAJiODDZAEahbN9p9FSOMlnyjPn5vJ_JcCbBuuhwSPLi5nnI-7dV1FhrpT7HG5khreB1vPF11XycSKV8ay8dLSEpvQdMIdVLHuTOfkB9OlzofUXLtCEjl4Q0lQ1xkdKQKgNgHacGreHKHq41HQ4NuGvtPRcawD2TaQQrMR-17f-fd2bbOvNMVbFwIMCaTXkALZP1UOq1Nb0k435yAwa8YiAcGB1upkKTC2xtcto6fcQdGQiOtGMBevHNplAgSjzQOc_NkjeVnbAaALU2LtTdhQpSKPpqTGR0IkpVs5LYpjq9gRG6O_Qn_w5QShbDv09BaiJY_aTpUt87TTCfdjpExXPicB9VIcU5bWBoOc0qodIKp3rw5jr7QyUiWUH4WHXcQYRRkWGTirFUH7191VnecKm_QXL3Yxtxf54cJ9BHb8d0PD0WwbuXjlwcUm-IjRNu7m00)
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
- Frontend https://localhost:4200 Angular
- Default user when security enabled: (test, test1)
