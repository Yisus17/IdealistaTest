# Ad Ranking Challenge 💻

Este repositorio contiene un API desarrollada a partir del esquema propuesto en el challenge, para desarrollar un servicio que se encargue de medir la calidad de los anuncios. 

El proyecto se reorganizó siguiendo un esquema de arquitectura de capas tal que tuviese: 

- **Una capa de datos (Package Persistence)** con InMemoryPersitence.java simulando una BD
- **Una capa de servicios (Package Services)** donde abstraemos la lógica de negocio para el ranking de anuncios
- **Una capa de presentación (Package Controllers)**, en este caso es una REST API por lo que su capa de presentación queda resumida a endpoints cuyas respuestas se presentan en formato JSON en los servicios que lo ameriten.

Se utilizó Git-flow como estrategia de ramas.

## Documentación

Documentación de los endpoints en [Postman Docs](https://documenter.getpostman.com/view/1713197/TVYGbHiB "Postman Docs")

## Requisitos mínimos

- Java 1.8
- Apache Maven 3.6.x

## Instalación y uso

Se utilizó la misma estructura del proyecto propuesto en Java [Spring Boot](https://spring.io/projects/spring-boot "Spring Boot") por lo que la consideraciones son las mismas.

Se podrá ejecutar el proyecto usando Maven ejecutando el siguiente comando en la carpeta donde esté el fichero`pom.xml`:

```bash
mvn spring-boot:run
```

## Derechos de autor
Todos los derechos de autor sobre este código pertenecen a [Idealista](https://www.idealista.com/)

## Autor
* **Jesús Arévalo** [Website](https://jarevalo.dev/)

