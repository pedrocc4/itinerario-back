Hacer programa Restful escuchando en el puerto 8081.
Poner los valores “url” y “password” como propiedades del fichero “application.properties”.
Devolverá el valor de estas variables, al hacer una petición GET a http://localhost:8081/parametros
Crear una clase de configuración que lea del fichero “miconfiguracion.properties” y coja los valores
de las variables “valor1” y “valor2”. Imprimir todas las variables al arrancar el programa. Mostrarlas
en el en el endpoint http://localhost:8081/miconfiguracion

Crear un interfaz llamado “Perfiles” con una función llamada “public void miFuncion()” que escribirá
un texto. Crear la clase ‘perfil1’ y la clase ‘perfil2’ que implementen ese interfaz y anotarla con
@Component. Cada una de las implementaciones tendrá la variable ‘perfil’ que tendrá el valor
‘perfil1’ y ‘perfil2’.
Crear endpoint en http://localhost:8081/perfil que devuelva el valor de la variable ‘perfil’.
Dependiendo del perfil con que se lance la aplicación, Spring debe usar una clase y por lo tanto
devolverá diferente texto