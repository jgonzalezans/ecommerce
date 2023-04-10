# Prices API
Este repositorio contiene un proyecto que consiste en un API REST para la consulta del precio de un producto de Inditex en función de la fecha de aplicación para una cadena determinada

# Instalación
Para poder ejecutar la API, es necesario tener instalado Java 11 y Maven. A continuación, se detallan los pasos necesarios para descargar el proyecto y ejecutar la aplicación:

Descargar el código fuente del proyecto desde GitHub.
Desde la línea de comandos, situarse en la carpeta raíz del proyecto.
Ejecutar el comando `mvn clean install` para compilar el proyecto y generar el archivo JAR.
Ejecutar el comando `java -jar target/prices-0.0.1-SNAPSHOT` para lanzar la aplicación.

# Uso
Una vez que la aplicación esté en ejecución, se puede acceder a la API a través de la URL http://localhost:8080/prices. A continuación, se describen los parámetros necesarios para hacer consultas a la API:

* productId: ID del producto para el que se desea consultar el precio.
* brandId: ID de la marca a la que pertenece el producto.
* applicationDate: Fecha y hora de aplicación del precio, en formato ISO-8601.

Para realizar una consulta a la API, se puede hacer una petición GET a la URL correspondiente, proporcionando los parámetros necesarios. Por ejemplo:
http://localhost:8080/prices/35455/1?applicationDate=2020-06-14T10:00:00
Esta petición devolverá un objeto JSON con la información del precio correspondiente a los parámetros proporcionados.

Puede consultarse la base de datos (h2) cuando la aplicación esté levantada en el siguiente enlace : http://localhost:8080/h2-console/login.jsp?jsessionid=bb7672306c0d1f1a544693b73c5c06e6

# Estructura del proyecto
El proyecto está organizado en los siguientes paquetes:

- com.inditex: Contiene las clases principales de la aplicación.
- com.inditex.api: Contiene los controladores de la API REST.
- com.inditex.exception: Contiene las excepciones personalizadas de la aplicación.
- com.inditex.model: Contiene las clases de modelo utilizadas para representar los precios y sus utilidades.
- com.inditex.mapper: Contiene las clases de mapeo.
- com.inditex.repository: Contiene las interfaces de los repositorios utilizados para acceder a los datos.
- com.inditex.service: Contiene las implementaciones de los servicios utilizados para procesar las peticiones a la API.

# Pruebas
Se han implementado pruebas unitarias y de integración para comprobar el correcto funcionamiento de la aplicación. Estas pruebas pueden ser ejecutadas mediante el comando `mvn test` desde la carpeta raíz del proyecto.

# Autor
Este proyecto ha sido desarrollado por José González Anasagasti.

# Licencia
Consultar el fichero LICENSE.ME

<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Licencia Creative Commons" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a><br />Esta obra está bajo una <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Licencia Creative Commons Atribución-NoComercial-SinDerivadas 4.0 Internacional</a>.
