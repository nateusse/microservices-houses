

- [X] HU001 
1. Cada Categoria de inmueble: tiene 3 campos: id,nombre y descripcion
2. el nombre de la categoria no se puede repetir
3. todas las categoria deben tener una descripcion
4. el tamaño maximo del nombre debe ser de 50 caracteres
5. el tamaño maximo de la descripcion debe ser de 90 caracteres
- [X] HU002  
1. se debe poder parametrizar si quiero traerme las categorias de casas
2. este servicio debe estar paginado
- [] HU003 (admin)
1. Cada ubicación tiene una ciudad, un departamento al que pertenece 
2. el nombre del departamento no se puede repetir
3. todas las ciudades y departamentos deben tener una descripcion
4. el tamaño maximo del nombre de ciudad y departamento debe ser de 50 caracteres
5. el tamaño maximo de la descripcion de ciudad y departamento debe ser de 120 caracteres
- [] HU004  (todos)
1. la busqueda debe retornar un listado de ubicaciones que coincidan con un texto ingresado, ya sea por nombre de ciudad o nombre de departamento, pero aqui solo se ingresa  un texto, para los dos.
2. no debe discriminar entre mayusculas, minusculas, tildes, etc.
3. se debe poder parametrizar si quiero traerme las ubicaciones ordenadas ascendentemente o descendentemente por el nombre de ciudad y/o departamento
4. este servicio debe estar paginado
- [] HU005  (admin)
1. Al crear una cuenta, se deben solicitar los siguientes campos obligatorios:
Nombre, Apellido, Documento De Identidad, celular, fechaNacimiento, correo y clave(encriptada con bcrypt), al almacenar la clave, debe ser cifrada, no al solicitar la data.
2. Se debe verificar estructura de email válida, el teléfono debe contener un máximo de 13 caracteres y puede contener el símbolo +. Ejemplo: +573005698325, El documento de identidad debe ser únicamente numérico.
3. El usuario quedara con el rol vendedor.
4. El usuario debe ser mayor de edad
  - [] HU006  (vendedor)
1. cada casa tiene los sigueintes campos:id,nombre, descripcion, Categoria de inmueble, cantidad de cuartos, cantidad de baños, precio, ubicación (ciudad y departamento), fecha de publicación activa (los usuarios solo podran ver la casa, cuando se lista despues de la fecha de publicación, esta fecha no puede exeder un mes de la fecha actual), estado de la publicación (PUBLICADA, PUBLICACION_PAUSADA,TRASACCION_CURSO, TRANSACCION_FINALIZADA), fecha de la publicación
2. las casas solo pueden tener una categoria de casa asociada
- [] HU007 (todos los roles)
1. se debe poder parametrizar si quiero listar las casas en orden descendente o ascendente, por la ubicación, Categoria de inmueble, cantidad de cuartos, cantidad de baños, precio maximo, precio minimo
2. este servicio debe estar paginado
3. solo se podran listar las casas cuya fecha de publicación sea mayor a la fecha actual
- [] HU008 (todos)
 1. El inicio de sesión es a través de correo y clave.
2. Se debe validar usuario y contraseña correcta.
3. El número de intentos debe ser ilimitado.
4. Una vez iniciada la sesión, se debe garantizar que con esa sesión iniciada, cada usuario tiene los permisos para realizar las acciones que le correspondan a su rol.
5. Agregar validacion de autenticacion a los siguientes endpoint:
    -si creo un categoria de casa, ubciaciones, validar que la persona que llamo el servicio sea un usuario admin.
    -si creo un usuario vendedor, validar que la persona que llamo el servicio sera usuario admin.
    -si publico una casa, validar que la persona que llamo el servicio sea un usuario vendedor
- [] HU009 (vendedor)
1. Cada horario disponible tiene los siguientes campos:vendedor_id, casa_id, fecha y hora de inicio, fecha y hora fin
3. Un vendedor puede registrar múltiples horarios de visitas para una casa específica.
4. No se pueden crear dos espacios en una misma fecha y hora por vendedor.
5. Solo se pueden registrar horarios dentro de los próximos 3 semanas.
6. Un vendedor solo puede disponibilizar horarios para sus propias casas.
- [] HU010 (todos)
1. Se debe poder filtrar los horarios de visita, por 
- el rango de fecha y hora de inicio, fecha y hora de fin, 
- si la cantidad de persona agendadas es menor a 2
- dada una ubicacion
2. debe estar ordenado por la fecha y hora de inicio, en orden descendente
3. Este servicio debe estar paginado
4. no se mostraran los horarios cuya fecha de inicio sea menor a la fecha y hora actual, y que tengan ya 2 compradores agendados
- [] HU011 (comprador)
1. Cada Visita agendada tiene los siguientes campos: horario_disponible_id, comprador_email
2. En la misma casa, fecha y hora, maximo se pueden agendar maximo 2 compradores"


Nota: En esta versión de la aplicación, no está contemplada la recuperación de contraseña.
- [Link avances](https://docs.google.com/forms/d/e/1FAIpQLSdsmJGIl6OVXiIe50KxkGexvQo_si0_olbkyJ_rRWIWhGGmHQ/alreadyresponded)
