--Administradores de hoteles
insert into admin_hotel (cedula, correo, nombre, password) values ("2111", "lurios@gmail.com", "Luis Rios", "jgydor");
insert into admin_hotel (cedula, correo, nombre, password) values ("2112", "anarest@gmail.com", "Ana Restrepo", "hrebb");
insert into admin_hotel (cedula, correo, nombre, password) values ("2113", "josequi@gmail.com", "Jose Quiceno", "krvufe");
insert into admin_hotel (cedula, correo, nombre, password) values ("2114", "angecar@gmail.com", "Angela Carvajal", "w67ig");
insert into admin_hotel (cedula, correo, nombre, password) values ("2115", "esteloz@gmail.com", "Estela Lozano", "stuijh");
insert into admin_hotel (cedula, correo, nombre, password) values ("2116", "vibote@gmail.com", "Victor Botero", "kiug");
insert into admin_hotel (cedula, correo, nombre, password) values ("2117", "claugir@gmail.com", "Claudia Giraldo", "ertfyu");
insert into admin_hotel (cedula, correo, nombre, password) values ("2118", "ivamar@gmail.com", "Ivan Martinez", "uhrsw3");
insert into admin_hotel (cedula, correo, nombre, password) values ("2119", "acano@gmail.com", "Andres Cano", "uyr33e");
insert into admin_hotel (cedula, correo, nombre, password) values ("2120", "rodrirre@gmail.com", "Rodrigo Aguirre", "7uufwws");

--Administradores generales
insert into administrador (cedula, nombre, correo, password)
values ("3111", "Juan David Saraza", "juanda@gmail.com", "1234");
insert into administrador (cedula, nombre, correo, password)
values ("3112", "Esteban Torres", "es.tola2010@hotmail.com", "root");

--Usuarios
insert into usuario (cedula,nombre,correo,password) values ("1111", "Ana Perez", "anape@gmail.com", "12345");
insert into usuario (cedula,nombre,correo,password) values ("1112", "Jhon Arango", "jarango@gmail.com", "uyn6oer");
insert into usuario (cedula,nombre,correo,password) values ("1113", "Julian Ramirez", "julir@gmail.com", "70984");
insert into usuario (cedula,nombre,correo,password) values ("1114", "Carlos Sosa", "carsosa@gmail.com", "nyiut");
insert into usuario (cedula,nombre,correo,password) values ("1115", "Raul Ruiz", "rrui@gmail.com", "vriykkt");
insert into usuario (cedula,nombre,correo,password) values ("1116", "Sebastian Jaramillo", "sejaramillo@gmail.com", "444yb");
insert into usuario (cedula,nombre,correo,password) values ("1117", "Camilo Mesa", "camesa@gmail.com", "ynuj5b");
insert into usuario (cedula,nombre,correo,password) values ("1118", "Jose Vanegas", "jovane@gmail.com", "7iu5h6");
insert into usuario (cedula,nombre,correo,password) values ("1119", "Laura Garcia", "lgarcia@gmail.com", "vetwr");
insert into usuario (cedula,nombre,correo,password) values ("1120", "Carolina Gonzales", "carolgo@gmail.com", "8uoi45");

--Ciudades
insert into ciudad (id,nombre) values (1,"Bogota");
insert into ciudad (id,nombre) values (2,"Medellin");
insert into ciudad (id,nombre) values (3,"Cali");
insert into ciudad (id,nombre) values (4,"Barranquilla");
insert into ciudad (id,nombre) values (5,"Manizales");
insert into ciudad (id,nombre) values (6,"Armenia");
insert into ciudad (id,nombre) values (7,"Neiva");
insert into ciudad (id,nombre) values (8,"Pereira");
insert into ciudad (id,nombre) values (9,"Santa Marta");
insert into ciudad (id,nombre) values (10,"Bucaramanga");
insert into ciudad (id,nombre) values (11,"Cartagena");
insert into ciudad (id,nombre) values (12,"Ibague");
insert into ciudad (id,nombre) values (13,"Popayan");
insert into ciudad (id,nombre) values (14,"Cucuta");
insert into ciudad (id,nombre) values (15,"Yopal");
insert into ciudad (id,nombre) values (16,"Monteria");
insert into ciudad (id,nombre) values (17,"Sincelejo");
insert into ciudad (id,nombre) values (18,"Quibdo");
insert into ciudad (id,nombre) values (19,"Pasto");
insert into ciudad (id,nombre) values (20,"Florencia");

--Hoteles
insert into hotel (codigo,nombre,direccion, num_estrellas,administrador_cedula,ciudad_id)
values (1,"Dann","Avenida del Rio", 3,"2111",1);
insert into hotel (codigo,nombre,direccion, num_estrellas,administrador_cedula,ciudad_id)
values (2,"El Remanso","Avenida del Rio", 2,"2112",2);
insert into hotel (codigo,nombre,direccion, num_estrellas,administrador_cedula,ciudad_id)
values (3,"Estelar","Avenida del Rio", 4,"2113",3);
insert into hotel (codigo,nombre,direccion, num_estrellas,administrador_cedula,ciudad_id)
values (4,"El Parque","Avenida del Rio", 2,"2114",4);
insert into hotel (codigo,nombre,direccion, num_estrellas,administrador_cedula,ciudad_id)
values (5,"Hollywood","Avenida del Rio", 1,"2115",5);

--Habitaciones
insert into Habitacion (numero, precio, capacidad, estado,hotel_codigo) values("A101",000,120000.00,0,1);
insert into Habitacion (numero, precio, capacidad, estado,hotel_codigo) values("A102",90000.00,0,0,1);
insert into Habitacion (numero, precio, capacidad, estado,hotel_codigo) values("A103",80000.00,0,0,1);
insert into Habitacion (numero, precio, capacidad, estado,hotel_codigo) values("A104",120000.00,0,1,2);
insert into Habitacion (numero, precio, capacidad, estado,hotel_codigo) values("A201",115000.00,0,0,2);
insert into Habitacion (numero, precio, capacidad, estado,hotel_codigo) values("A202",90000.00,0,0,3);
insert into Habitacion (numero, precio, capacidad, estado,hotel_codigo) values("A203",120000.00,0,0,3);
insert into Habitacion (numero, precio, capacidad, estado,hotel_codigo) values("A204",115000.00,0,1,3);
insert into Habitacion (numero, precio, capacidad, estado,hotel_codigo) values("A301",120000.00,0,1,4);
insert into Habitacion (numero, precio, capacidad, estado,hotel_codigo) values("A303",120000.00,0,0,5);

--Fotos
insert into foto (codigo,url, habitacion_numero, hotel_codigo) values (1,"enlacefoto.png","A101",1 );
insert into foto (codigo, url, habitacion_numero, hotel_codigo) values (2, "enlacefoto2.png", "A102",2);

--Características
insert into caracteristica (codigo,nombre, descripcion) values (1,"Piscina doble", "Importante para el entretenimiento");
insert into caracteristica (codigo,nombre, descripcion) values (2,"Luz fluorescente", "Para la comodidad");
insert into caracteristica (codigo,nombre, descripcion) values (3,"Tv smart", "Importante para el entretenimiento");

--Camas
insert into cama (codigo, tipo) values (1, 1);
insert into cama (codigo, tipo) values (2, 0);
insert into cama (codigo, tipo) values (3, 0);
insert into cama (codigo, tipo) values (4, 1);

--Comentarios
insert into comentario (codigo,calificacion, contenido, fecha, hotel_codigo, usuario_cedula)
values (1,3, "Buena actitud", "2020-02-13", 1, "1113");
insert into comentario (codigo,calificacion, contenido, fecha, hotel_codigo, usuario_cedula)
values (2,0,"Pesimo servicio", "2018-05-25", 2, "1116");
insert into comentario (codigo,calificacion, contenido, fecha, hotel_codigo, usuario_cedula)
values (3,2, "Regular","2021-08-30", 3, "1114");

--Reservas
insert into reserva (codigo,fecha, fecha_inicio, fecha_fin, estado, precio_total,cantidad_personas, usuario_cedula)
values (1,"2022-05-02","2022-05-03","2022-05-12",0,354000.00,2,"1120");
insert into reserva (codigo,fecha, fecha_inicio, fecha_fin, estado, precio_total,cantidad_personas, usuario_cedula)
values (2,"2022-05-02","2022-05-13","2022-05-16",2,1130000.00,3,"1117");
insert into reserva (codigo,fecha, fecha_inicio, fecha_fin, estado, precio_total,cantidad_personas, usuario_cedula)
values (3,"2022-05-03","2022-05-05","2022-05-07",0,150000.00,1,"1119");

--Vuelos
insert into vuelo (codigo,estado,aerolinea,origen_id,destino_id)
values(1,4,"LAN",1,6);
insert into vuelo (codigo,estado,aerolinea,origen_id,destino_id)
values(2,1,"Avianca",2,3);
insert into vuelo (codigo,estado,aerolinea,origen_id,destino_id)
values(3,2,"American Airlines",5,1);
insert into vuelo (codigo,estado,aerolinea,origen_id,destino_id)
values(4,0,"EasyFly",7,2);

--Sillas
insert into silla (codigo,posicion, precio ,vuelo_codigo) values (1,"A22P",180000.00,1);
insert into silla (codigo,posicion, precio ,vuelo_codigo) values (2,"B35V",145000.00,2);
insert into silla (codigo,posicion, precio ,vuelo_codigo) values (3,"A12P",180000.00,2);
insert into silla (codigo,posicion, precio ,vuelo_codigo) values (4,"C41V",128000.00,1);
insert into silla (codigo,posicion, precio ,vuelo_codigo) values (5,"B27P",145000.00,1);


--Logs
insert into control_Log (id_registro,user, id_user, fecha, message)
values (1,"Fernado","abc123","2022-05-03","registro de prueba 1");
insert into control_Log (id_registro,user, id_user, fecha, message)
values (2,"Sergio","patito","2022-05-15","registro de prueba 2");
insert into control_Log (id_registro,user, id_user, fecha, message)
values (3,"Raquel","dios","2022-05-25","registro de prueba 3");

