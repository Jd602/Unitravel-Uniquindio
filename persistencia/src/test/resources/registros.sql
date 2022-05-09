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
insert into ciudad (nombre) values ("Medellin");
insert into ciudad (nombre) values ("Cali");
insert into ciudad (nombre) values ("Barranquilla");
insert into ciudad (nombre) values ("Manizales");
insert into ciudad (nombre) values ("Armenia");
insert into ciudad (nombre) values ("Neiva");
insert into ciudad (nombre) values ("Pereira");
insert into ciudad (nombre) values ("Santa Marta");
insert into ciudad (nombre) values ("Bucaramanga");
insert into ciudad (nombre) values ("Cartagena");
insert into ciudad (nombre) values ("Ibague");
insert into ciudad (nombre) values ("Popayan");
insert into ciudad (nombre) values ("Cucuta");
insert into ciudad (nombre) values ("Yopal");
insert into ciudad (nombre) values ("Monteria");
insert into ciudad (nombre) values ("Sincelejo");
insert into ciudad (nombre) values ("Quibdo");
insert into ciudad (nombre) values ("Pasto");
insert into ciudad (nombre) values ("Florencia");

--Hoteles
insert into hotel (codigo, nombre, direccion, num_estrellas,administrador_cedula,ciudad_id)
values (1,"Dann","Avenida del Rio", 3,"2111",1);
insert into hotel (nombre, direccion, num_estrellas,administrador_cedula,ciudad_id)
values ("El Remanso","Avenida del Rio", 2,"2112",2);
insert into hotel (nombre, direccion, num_estrellas,administrador_cedula,ciudad_id)
values ("Estelar","Avenida del Rio", 4,"2113",3);
insert into hotel (nombre, direccion, num_estrellas,administrador_cedula,ciudad_id)
values ("El Parque","Avenida del Rio", 2,"2114",4);
insert into hotel (nombre, direccion, num_estrellas,administrador_cedula,ciudad_id)
values ("Hollywood","Avenida del Rio", 1,"2115",5);

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
insert into foto (codigo, url, habitacion_numero, hotel_codigo) values (1, "enlacefoto.png","A101",1 );
insert into foto ( url, habitacion_numero, hotel_codigo) values ( "enlacefoto2.png", "A102",2);

--Características
insert into caracteristica (codigo,nombre, descripcion) values (1,"Piscina doble", "Importante para el entretenimiento");
insert into caracteristica (nombre, descripcion) values ("Luz fluorescente", "Para la comodidad");
insert into caracteristica (nombre, descripcion) values ("Tv smart", "Importante para el entretenimiento");

--Camas
insert into cama (codigo, tipo) values (1, 1);
insert into cama ( tipo) values ( 0);
insert into cama ( tipo) values ( 0);
insert into cama ( tipo) values ( 1);