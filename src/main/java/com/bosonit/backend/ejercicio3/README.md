# Ejercicio 3
1) Crear aplicación con dos clases de controlador. Controlador1.java y Controlador2.java
   En Controlador1, en la URL /controlador1/addPersona, tipo GET, en los headers tiene que recibir, el
   nombre, población y edad. (Mirar documentación sobre como pasar headers en
   https://www.baeldung.com/spring-rest-http-headers)Utilizando una clase de servicio, se creará un objeto Persona. La llamada devolverá el objeto Persona
   creado.
   En otra clase, crear el Controlador2, en la URL /controlador2/getPersona tiene que devolver el
   objeto Persona recibido en el Controlador1, multiplicando la edad por dos.
   Importante: Utilizar Inyección de dependencias.
2) Al arrancar el programa crear una lista de objetos tipo Ciudad. Ciudad tendrá dos campos:
   nombre(String) y numeroHabitantes (int)
   En controlador1, en la URL /controlador1/addCiudad, petición tipo POST, se añadirá una ciudad a la
   lista.
   En controlador2, en la URL /controlador1/getCiudad, petición tipo GET, se devolverá la lista de las
   ciudades existentes.
   Importante: Utilizar la etiqueta @Bean.
3) Crear 3 objetos Persona diferentes con funciones que tengan la etiqueta @Bean. La primera
   función pondrá el nombre a ‘bean1’, el segundo a “bean2” y el tercero a “bean3”. Usar @Qualifiers
   En un controlador con la URL /controlador/bean/{bean} dependiendo del parámetro mandado
   devolver cada uno de los Beans. Asi: /controlador/bean/bean1 devolvera el objeto cuyo nombre sea
   bean1 y así sucesivamente