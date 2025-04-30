# Microservices-houses back-end

## Specificities:
- Language/version: java 17
- Data base: MySQL
- [User histories](https://github.com/nateusse/microservices-houses/wiki/Historias-de-usuario)

# Historias de usuario

| Historia de Usuario   | Resumen |  Descripcion | Criterios de aceptacion| Desafios |
|----| ------|------|-------|----| 
| HU001 | Crear categoria de inmuebles | Yo como admin necesito crear una Categoria de inmuebles para poder relacionar y encontrar las casas con mayor facilidad|- Cada Categoria de inmueble: tiene 3 campos: id,nombre y descripcion <br>&nbsp;&nbsp; -el nombre de la categoria no se puede repetir <br>&nbsp;&nbsp;-todas las categoria deben tener una descripcion  <br>&nbsp;&nbsp;-el tamaño maximo del nombre debe ser de 50 caracteres <br>&nbsp;&nbsp; -el tamaño maximo de la descripcion debe ser de 90 caracteres| - [Clean arquitecture](https://github.com/nateusse/microservices-houses/wiki/HU001) |  
| HU002 | Listar categoria de inmuebles | Yo como todos los roles necesito listar las Categoria de inmuebles para poder seleccionar la categoria de casas que mas necesito|-se debe poder parametrizar si quiero traerme las categorias de casas -este servicio debe estar paginado| Paginado generico | 
| HU003 | Crear ubicaciones |Yo como admin necesito crear ubicacion para poder relacionar y encontrar las casas que yo quiero con mayor facilidad| -Cada ubicación tiene una ciudad, un departamento al que pertenece <br>&nbsp;&nbsp; -el nombre del departamento no se puede repetir-todas las ciudades y departamentos deben tener una descripcion-el tamaño maximo del nombre de ciudad y departamento debe ser de 50 caracteres <br>&nbsp;&nbsp; -el tamaño maximo de la descripcion de ciudad y departamento debe ser de 120 caracteres| | 
 HU004 | Buscar ubicaciones |Yo como todos los roles necesito buscar las ubicaciones para poder seleccionar la ubicaciones que mas necesite|- la busqueda debe retornar un listado de ubicaciones que coincidan con un texto ingresado, ya sea por nombre de ciudad o nombre de departamento, pero aqui solo se ingresa  un texto, para los dos. <br>&nbsp;&nbsp; - no debe discriminar entre mayusculas, minusculas, tildes, etc. <br>&nbsp;&nbsp; -se debe poder parametrizar si quiero traerme las ubicaciones ordenadas ascendentemente o descendentemente por el nombre de ciudad y/o departamento -este servicio debe estar paginado| | 


