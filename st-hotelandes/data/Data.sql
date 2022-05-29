
--HOTEL DATA
INSERT INTO HOTEL ( idhotel , nombreHotel )
    VALUES (1, 'HotelAndes');
    
SELECT *
FROM HOTEL;



--USUARIO DATA
INSERT INTO USUARIO ( idusuario , rolusuario , idhotel)
    VALUES (1, 'gerente', 1);
    
INSERT INTO USUARIO ( idusuario , rolusuario , idhotel)
    VALUES (2, 'administrador de datos', 1);
    
INSERT INTO USUARIO ( idusuario , rolusuario , idhotel)
    VALUES (3, 'recepcionista', 1);
    
INSERT INTO USUARIO ( idusuario , rolusuario , idhotel)
    VALUES (4, 'empleado', 1);
    
INSERT INTO USUARIO ( idusuario , rolusuario , idhotel)
    VALUES (5, 'cliente', 1);

INSERT INTO USUARIO ( idusuario , rolusuario , idhotel)
    VALUES (6, 'organizador eventos', 1);
    
SELECT * 
FROM USUARIO;



--AMINISTRADOR DE DATOS ID-NOMBRE
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202014279 , 'Romeo');
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202021008 , 'Omar');
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (201920564 , 'Camilo'); 
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202120439 , 'Pedro'); 
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202019549 , 'Paula'); 
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202018456 , 'Miguel'); 
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202017123 , 'Storm'); 
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202020987 , 'Teddy');
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202020706 , 'Daniel'); 
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202021748 , 'Ana'); 
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202013610 , 'Juan'); 
    
INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202001546 , 'Ramon');

INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202010592 , 'Daniagui');

INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (202022112 , 'Panis');

INSERT INTO ADMINDATA_ID (id , nombre)
    VALUES (1 , 'Convenio');
    
SELECT * 
FROM ADMINDATA_ID;



--AMINISTRADOR DE DATOS 

INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (1 , 202014279 , 'CC' , 'er.duarte@uniandes.edu.co', '1234', 1);
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (2 , 202021008 , 'CC' , 'al.diaz@outlook.com', '1234', 1);
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (3 , 201920564 , 'CC' , 'ca.milo@hotmail.com', '1234', 1); 
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (3 , 202120439 , 'CC' , 'p.o@hotmail.com', '1234', 1); 
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (4 , 202019549 , 'CC' , 'pkellegher2@businessinsider.com', '1234', 1);
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (4 , 202018456 , 'CC' , 'marnaez7@europa.eu', '1234', 1); 
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (4 , 202017123 , 'CC' , 'sjendasa@ucoz.ru', '1234', 1); 
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (4 , 202020987 , 'CC' , 'twapleb@vinaora.com', '1234', 1);
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (5 , 202020706 , 'CC' , 'da.bernalc1@hotmail.com', '1234', 1); 
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (5 , 202021748 , 'CC' , 'a.padillad@gmail.com', '1234', 1); 
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (5 , 202013610 , 'CC' , 'j.santosp@yahoo.com', '1234', 1); 
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (5 , 202001546 , 'CC' , 'rdoused@wikipedia.org', '1234', 1);

INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (6 , 202010592 , 'CC' , 'da.agui@yahoo.com', '1234', 1); 
    
INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (6 , 202022112 , 'CC' , 'P.anis@wikipedia.org', '1234', 1);

INSERT INTO ADMINISTRADORDATOS (idusuario , numerodocumento , tipodocumento , correo , pw , idhotel) 
    VALUES (5 , 1 , 'CC' , 'convenio@hotmail.com', '1234', 1);
    
SELECT * 
FROM ADMINISTRADORDATOS;


--GERENTE ID-NOMBRE
INSERT INTO GERENTE_ID (idGerente ,nombreGerente)
    SELECT ADMINISTRADORDATOS.numeroDocumento, admindata_id.nombre
    FROM ADMINISTRADORDATOS JOIN ADMINDATA_ID
    ON ADMINISTRADORDATOS.numeroDocumento = admindata_id.id
    WHERE idUsuario = 1;

SELECT * 
FROM GERENTE_ID;



--GERENTE
INSERT INTO GERENTE (idGerente, tipodocumento , correoGerente , pwGerente ,  idHotel)
    SELECT numeroDocumento , tipodocumento , correo , pw ,  idHotel
    FROM ADMINISTRADORDATOS A
    WHERE A.idUsuario = 1;
    
SELECT * 
FROM GERENTE;



--CLIENTE ID-NOMBRE
INSERT INTO CLIENTE_ID (numerodocumento ,nombrecliente)
    SELECT ADMINISTRADORDATOS.numeroDocumento, admindata_id.nombre
    FROM ADMINISTRADORDATOS JOIN ADMINDATA_ID
    ON ADMINISTRADORDATOS.numeroDocumento = admindata_id.id
    WHERE idUsuario = 5;

SELECT * 
FROM CLIENTE_ID;



--CLIENTE
INSERT INTO CLIENTE (numeroDocumentocliente , tipodocumento , correocliente , pwCliente ,  idHotel)
    SELECT numeroDocumento , tipodocumento , correo , pw ,  idHotel
    FROM ADMINISTRADORDATOS A
    WHERE A.idUsuario = 5;
    
SELECT * 
FROM CLIENTE;



--RECEPCIONISTA ID-NOMBRE
INSERT INTO RECEPCIONISTA_ID (idRECEPCION ,nombreRECEPCIONISTA)
    SELECT ADMINISTRADORDATOS.numeroDocumento, admindata_id.nombre
    FROM ADMINISTRADORDATOS JOIN ADMINDATA_ID
    ON ADMINISTRADORDATOS.numeroDocumento = admindata_id.id
    WHERE idUsuario = 3;

SELECT * 
FROM RECEPCIONISTA_ID;



--RECEPCIONISTA
INSERT INTO RECEPCIONISTA (idRecepcionista, tipodocumento , correorecepcionista , pwRecepcionista ,  idHotel)
    SELECT numeroDocumento , tipodocumento , correo , pw , idHotel
    FROM ADMINISTRADORDATOS A
    WHERE A.idUsuario = 3;
    
SELECT * 
FROM RECEPCIONISTA;



--EMPLEADO ID-NOMBRE
INSERT INTO EMPLEADO_ID (idEMPLEADO ,nombreEMPLEADO)
    SELECT ADMINISTRADORDATOS.numeroDocumento, admindata_id.nombre
    FROM ADMINISTRADORDATOS JOIN ADMINDATA_ID
    ON ADMINISTRADORDATOS.numeroDocumento = admindata_id.id
    WHERE idUsuario = 4;

SELECT * 
FROM EMPLEADO_ID;



--EMPLEADO
INSERT INTO EMPLEADO (idEMPLEADO, tipodocumento , correoEMPLEADO , pwEmpleado ,  idHotel)
    SELECT numeroDocumento , tipodocumento , correo , pw , idHotel
    FROM ADMINISTRADORDATOS A
    WHERE A.idUsuario = 1;
    
SELECT * 
FROM EMPLEADO;



--OE ID-NOMBRE
INSERT INTO ORGANIZADOREVENTOS_ID (idOE ,nombreOE)
    SELECT ADMINISTRADORDATOS.numeroDocumento, admindata_id.nombre
    FROM ADMINISTRADORDATOS JOIN ADMINDATA_ID
    ON ADMINISTRADORDATOS.numeroDocumento = admindata_id.id
    WHERE idUsuario = 6;

SELECT * 
FROM ORGANIZADOREVENTOS_ID;



--OE
INSERT INTO ORGANIZADOREVENTOS (idOE, tipodocumento , correoOE , pwOE ,  idHotel)
    SELECT numeroDocumento , tipodocumento , correo , pw , idHotel
    FROM ADMINISTRADORDATOS A
    WHERE A.idUsuario = 6;
    
SELECT * 
FROM ORGANIZADOREVENTOS;


--RESERVA
INSERT INTO RESERVA (idreserva , cantpersonas , checkin , checkout, activo)
    VALUES (1 , 2 , '01-SEP-2020' , '02-SEP-2020', 0);

SELECT * 
FROM RESERVA;



--TIPO HABITACION
INSERT INTO TIPO (idTipo, nombreTipo, dotacion, capacidad)
    VALUES (1 , 'familiar' , 'xd' , 8);
    
INSERT INTO TIPO (idTipo, nombreTipo, dotacion, capacidad)
    VALUES (2 , 'doble' , 'lol' , 2); 
    
INSERT INTO TIPO (idTipo, nombreTipo, dotacion, capacidad)
    VALUES (3 , 'sencilla' , 'crack' , 1);    
    
SELECT * 
FROM TIPO;



--CUENTA
INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (1, 0);

INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (2, 0);
    
INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (3, 0);
    
INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (4, 0);

INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (5, 0);
    
INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (6, 0);

INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (7, 0);

INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (8, 0);
    
INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (9, 0);

INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (10, 0);
    
INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (11, 0);

INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (12, 0);

INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (13, 0);
    
INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (14, 0);

INSERT INTO CUENTA (idCuenta, costoTotal)
    VALUES (15, 0);

SELECT * 
FROM CUENTA;



--HABITACION
INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta , idreserva , idHotel, ocupacionTotal)
    VALUES (101 , 50000 , 1 , 1 , 1 , 1, 50);
    
INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (102 , 50000 , 1 , 2 , 1, 34);

INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (103 , 50000 , 1 , 3 , 1, 17);

INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (104 , 50000 , 1 , 4 , 1, 82);

INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (105 , 50000 , 1 , 5 , 1, 108);

INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (201 , 50000 , 2 , 6 , 1, 45);
    
INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (202 , 50000 , 2 , 7 , 1, 29);

INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (203 , 50000 , 2 , 8 , 1, 18);

INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (204 , 50000 , 1 , 9 , 1, 29);

INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (205 , 50000 , 1 , 10 , 1, 18);
    
INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (301 , 50000 , 3 , 11 , 1, 7);
    
INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (302 , 50000 , 3 , 12 , 1, 53);

INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (303 , 50000 , 3 , 13 , 1, 15);

INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (304 , 50000 , 1 , 14 , 1, 53);

INSERT INTO HABITACION (numeroHabitacion, costoHabitacion, idTipo, idCuenta, idHotel, ocupacionTotal)
    VALUES (305 , 50000 , 1 , 15 , 1, 15);

SELECT *
FROM HABITACION;


--SERVICIO
INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (1 , 'piscina' , 1);

INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (2 , 'gym' , 1);
    
INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (3 , 'salon' , 1);
    
INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (4 , 'internet' , 1);
    
INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (5 , 'bar' , 1);

INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (6 , 'restaurante' , 1);

INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (7 , 'lavanderia' , 1);

INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (8 , 'prestamoutencilios' , 1);

INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (9 , 'tienda' , 1);

INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (10 , 'spa' , 1);

INSERT INTO SERVICIO (idServicio , nombreServicio , idHotel )
    VALUES (11 , 'supermercado' , 1);

SELECT *
FROM SERVICIO;


--PISCINA ID-NOMBRE
INSERT INTO S_PISCINA_ID (idPiscina , nombrePiscina)
    VALUES (1 , 'el sol candente');

SELECT *
FROM S_PISCINA_ID;



--PISCINA
INSERT INTO S_PISCINA (idPiscina , profundidad , horarioInicial , horarioFinal , capacidad , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , 2 , '10-AUG-01' , '12-DEC-01' , 30 , 'N' , 10000 , 1);

SELECT *
FROM S_PISCINA;



--GYM ID-NOMBRE
INSERT INTO S_GYM_ID (idGYM , nombreGYM)
    VALUES (1 , 'Body Care');

SELECT *
FROM S_GYM_ID;



--GYM
INSERT INTO S_GYM (idGYM , cantMaquinas , capacidad , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , 5 , 20 , 'N' , 20000 , 1);

SELECT *
FROM S_GYM;



--A_EQUIPOADICIONAL
insert into a_equipoadicional (tipoequipo, costo, idgym) 
    values ('Musculacion', 28966, 1);
/*
insert into a_equipoadicional (tipoequipo, costo, idgym) 
    values ('Entrenamiento Funcional', 35725, 2);
insert into a_equipoadicional (tipoequipo, costo, idgym) 
    values ('Cardio', 14938, 3);
insert into a_equipoadicional (tipoequipo, costo, idgym) 
    values ('Cardio', 13014, 4);
insert into a_equipoadicional (tipoequipo, costo, idgym) 
    values ('Actividades Dirigidas', 41716, 5);
insert into a_equipoadicional (tipoequipo, costo, idgym) 
    values ('Actividades Dirigidas', 27141, 6);
insert into a_equipoadicional (tipoequipo, costo, idgym) 
    values ('Entrenamiento Funcional', 22412, 7);
insert into a_equipoadicional (tipoequipo, costo, idgym) 
    values ('Actividades Dirigidas', 30941, 8);
insert into a_equipoadicional (tipoequipo, costo, idgym) 
    values ('Actividades Dirigidas', 13610, 9);
insert into a_equipoadicional (tipoequipo, costo, idgym) 
    values ('Cardio', 38081, 10);
*/

SELECT *
FROM A_EQUIPOADICIONAL;



--SALON ID-NOMBRE
INSERT INTO S_SALON_ID (idSALON , nombreSALON)
    VALUES (1 , 'Lleras');

SELECT *
FROM S_SALON_ID;



--SALON
INSERT INTO S_SALON (idSALON , tipoSalon , tiempoLimpieza , capacidad , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , 'reunion' , 1 , 20 , 'N' , 20000 , 1);

SELECT *
FROM S_SALON;



--INTERNET ID-NOMBRE
INSERT INTO S_INTERNET_ID (idINTERNET , nombreINTERNET)
    VALUES (1 , 'WIFIANDES');
   
SELECT *
FROM S_INTERNET_ID;



--INTERNET
INSERT INTO S_INTERNET (idINTERNET , capacidad , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , 50 , 'N' , 5000 , 1);

SELECT *
FROM S_INTERNET;



--BAR ID-NOMBRE
INSERT INTO S_BAR_ID (idBAR , nombreBAR)
    VALUES (1 , 'Donde Cris');
    
SELECT *
FROM S_BAR_ID;    


    
--BAR
INSERT INTO S_BAR (idBar , estiloBar , capacidad , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , 'electro swing' , 40 , 'N' , 2000 , 1);

SELECT *
FROM S_BAR;   



--RESTAURANTE ID-NOMBRE
INSERT INTO S_RESTAURANTE_ID (idRESTAURANTE , nombreRESTAURANTE)
    VALUES (1 , 'Corral Gourmet');
    
SELECT *
FROM S_RESTAURANTE_ID;


    
--RESTAURANTE
INSERT INTO S_RESTAURANTE (idRestaurante , estiloRestaurante , capacidad , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , 'formal' , 25 , 'N' , 10000 , 1);

SELECT *
FROM S_RESTAURANTE;



--LAVANDERIA ID-NOMBRE
INSERT INTO S_LAVANDERIA_ID (idLAVANDERIA , nombreLAVANDERIA)
    VALUES (1 , 'Lava todo');
    
SELECT *
FROM S_LAVANDERIA_ID;



--LAVANDERIA
INSERT INTO S_LAVANDERIA (idLavanderia , tipoLavanderia , cantPrendas , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , 'secado' , 15 , 'N' , 500 , 1);

SELECT *
FROM S_LAVANDERIA;



--PRESTAMOUTENCILIOS ID-NOMBRE
INSERT INTO S_PRESTAMOUTENCILIOS_ID (idPRESTAMOUTENCILIOS , nombrePRESTAMOUTENCILIOS)
    VALUES (1 , 'tenedor');
    
SELECT *
FROM S_PRESTAMOUTENCILIOS_ID;



--PRESTAMOUTENCILIOS
INSERT INTO S_PRESTAMOUTENCILIOS (idPrestamoUtencilios , tipoUtencilios , cantUtencilios , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , 'plastico' , 1 , 'N' , 200 , 1);

SELECT *
FROM S_PRESTAMOUTENCILIOS;



--TIENDA ID-NOMBRE
INSERT INTO S_TIENDA_ID (idTIENDA , nombreTIENDA)
    VALUES (1 , 'La del barrio');
    
SELECT *
FROM S_TIENDA_ID;



--TIENDA
INSERT INTO S_TIENDA (idTienda , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , 'N' , 200 , 1);
    
SELECT *
FROM S_TIENDA;



--SPA ID-NOMBRE
INSERT INTO S_SPA_ID (idSPA , nombreSPA)
    VALUES (1 , 'Caluroso');
    
SELECT *
FROM S_SPA_ID;

    
    
--SPA
INSERT INTO S_SPA (idSPA , reserva , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , '02-DEC-2018' , 'N' , 200 , 1);

SELECT *
FROM S_SPA;



--A_SERVICIOSSPA
INSERT INTO A_SERVICIOSSPA (idSPA , duracion , costo , nombre)
    VALUES (1 , '02-SEP-2020' , 15000 , 'rocas calientes');
    
SELECT *
FROM A_SERVICIOSSPA;



--SUPERMERCADO ID-NOMBRE
INSERT INTO S_SUPERMERCADO_ID (idSUPERMERCADO , nombreSUPERMERCADO)
    VALUES (1 , 'Carrulla');

SELECT *
FROM S_SUPERMERCADO_ID;



--SUPERMERCADO
INSERT INTO S_SUPERMERCADO (idSUPERMERCADO , pagoCuenta , costoServicio , idHotel)
    VALUES (1 , 'N' , 200 , 1);

SELECT *
FROM S_SUPERMERCADO;



--SERVICIOXCLIENTE
/*
insert into servicioxcliente (fecha, idCliente, idservicio, idespecifico, cantvisitas, costo) 
    values ('2021-01-25', 202001546, 1, 3, 5, 213659);
*/
insert into servicioxcliente (historial, fecha, idCliente, idservicio, idespecifico, cantvisitas, costo, consumo) 
    values (1, '23-NOV-2021', 202001546, 2, 1, 3, 204854, 0);
/*
insert into servicioxcliente (fecha, idCliente, idservicio, idespecifico, cantvisitas, costo) 
    values ('2021-12-07', 202013610, 3, 3, 9, 408778);
insert into servicioxcliente (fecha, idCliente, idservicio, idespecifico, cantvisitas, costo) 
    values ('2021-03-01', 202013610, 4, 4, 6, 484506);
insert into servicioxcliente (fecha, idCliente, idservicio, idespecifico, cantvisitas, costo) 
    values ('2021-08-02', 202001546, 5, 3, 8, 355605);
*/
insert into servicioxcliente (historial, fecha, idCliente, idservicio, idespecifico, cantvisitas, costo, consumo) 
    values (2,'05-NOV-2021', 202013610, 6, 1, 9, 342343, 0);
/*
insert into servicioxcliente (fecha, idCliente, idservicio, idespecifico, cantvisitas, costo) 
    values ('2021-07-01', 202020706, 7, 5, 6, 429820);
insert into servicioxcliente (fecha, idCliente, idservicio, idespecifico, cantvisitas, costo) 
    values ('2021-11-17', 202020706, 8, 2, 5, 496989);
insert into servicioxcliente (fecha, idCliente, idservicio, idespecifico, cantvisitas, costo) 
    values ('2021-10-31', 202001546, 9, 2, 6, 399730);
insert into servicioxcliente (fecha, idCliente, idservicio, idespecifico, cantvisitas, costo) 
    values ('2021-06-17', 202001546, 10, 2, 8, 435204);
*/
insert into servicioxcliente (historial, fecha, idCliente, idservicio, idespecifico, cantvisitas, costo, consumo) 
    values (3,'03-FEB-2022', 202021748, 11, 1, 10, 131992, 0);


update servicioxcliente set consumo = 50000 where idCliente = 202001546;
update servicioxcliente set consumo = 43500 where idCliente = 202013610;
update servicioxcliente set consumo = 37400 where idCliente = 202021748;


SELECT *
FROM SERVICIOXCLIENTE;



--PRODUCTO ID-NOMBRE
INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (1 , 'coca cola');

INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (2 , 'detergente');
    
INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (3 , 'papel higienico');
    
INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (4 , 'comida de perros');
    
INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (5 , 'hamburguesa');
    
INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (6 , 'mojito');

INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (7 , 'choclitos');
    
INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (8 , 'whisky');
    
INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (9 , 'tequila');
    
INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (10 , 'queso');
    
INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (11 , 'leche');
    
INSERT INTO PRODUCTO_ID (idProducto, nombreProducto)
    VALUES (12 , 'huevos revueltos');

SELECT *
FROM PRODUCTO_ID;



--PRODUCTO
INSERT INTO PRODUCTO (idProducto, precioProducto, idRestaurante)
    VALUES (1 , 1800 , 1);

INSERT INTO PRODUCTO (idProducto, precioProducto, idRestaurante)
    VALUES (12 , 12500 , 1);
    
INSERT INTO PRODUCTO (idProducto, precioProducto, idRestaurante)
    VALUES (5 , 20000 , 1);
    
INSERT INTO PRODUCTO (idProducto, precioProducto, idBar)
    VALUES (6 , 4500 , 1);
    
INSERT INTO PRODUCTO (idProducto, precioProducto, idBar)
    VALUES (8 , 3500 , 1);  

INSERT INTO PRODUCTO (idProducto, precioProducto, idBar)
    VALUES (9 , 8500 , 1);
  
INSERT INTO PRODUCTO (idProducto, precioProducto, idSupermercado)
    VALUES (2 , 1250 , 1);
    
INSERT INTO PRODUCTO (idProducto, precioProducto, idSupermercado)
    VALUES (3 , 1500 , 1);
    
INSERT INTO PRODUCTO (idProducto, precioProducto, idSupermercado)
    VALUES (4 , 1200 , 1);

INSERT INTO PRODUCTO (idProducto, precioProducto, idTienda)
    VALUES (7 , 10000, 1);

INSERT INTO PRODUCTO (idProducto, precioProducto, idTienda)
    VALUES (10 , 5000 , 1);
    
INSERT INTO PRODUCTO (idProducto, precioProducto, idTienda)
    VALUES (11 , 15000 , 1);
    
SELECT *
FROM PRODUCTO;



--PLANCONSUMO ID-NOMBRE
INSERT INTO PLANCONSUMO_ID (idPlanConsumo , nombrePlanConsumo)
    VALUES (1 , 'promocion particular');
    
INSERT INTO PLANCONSUMO_ID (idPlanConsumo , nombrePlanConsumo)
    VALUES (2 , 'larga estadia');
    
INSERT INTO PLANCONSUMO_ID (idPlanConsumo , nombrePlanConsumo)
    VALUES (3 , 'tiempo compartido');
    
INSERT INTO PLANCONSUMO_ID (idPlanConsumo , nombrePlanConsumo)
    VALUES (4 , 'todo incluido');
    
SELECT *
FROM PLANCONSUMO_ID;



--PLANCONSUMO
INSERT INTO PLANCONSUMO (idPlanConsumo , idHotel)
    VALUES (1 , 1);
    
INSERT INTO PLANCONSUMO (idPlanConsumo , idHotel)
    VALUES (2 , 1);

INSERT INTO PLANCONSUMO (idPlanConsumo , idHotel)
    VALUES (3 , 1);
    
INSERT INTO PLANCONSUMO (idPlanConsumo , idHotel)
    VALUES (4 , 1);

SELECT *
FROM PLANCONSUMO;



--PC_PROMOPARTICULAR
INSERT INTO PC_PROMOPARTICULAR (idPROMOPAR , descuentoReserva)
    VALUES (1 , 25000);

SELECT *
FROM PC_PROMOPARTICULAR;


--PC_LARGAESTADIA
INSERT INTO PC_LARGAESTADIA (idLargaEstadia , descuentoAlojamiento , numerohabitacion)
    VALUES (1 , 50000 , 101);

SELECT *
FROM PC_LARGAESTADIA;



--PC_TIEMPOCOMPARTIDO
INSERT INTO PC_TIEMPOCOMPARTIDO (idTIEMPOCOMPARTIDO , descuentoBar , descuentoRestaurante , idBar , idRestaurante)
    VALUES (1 , 20000 , 20000 , 1 , 1);

SELECT *
FROM PC_TIEMPOCOMPARTIDO;



--PC_TODOINCLUIDO
INSERT INTO PC_TODOINCLUIDO (idProducto , idRestaurante)
    VALUES (1 , 1);

SELECT *
FROM PC_TODOINCLUIDO;



--CONVENCION
INSERT INTO CONVENCION (idConvencion , checkIn , checkOut , cantPersonas, idPlanConsumo)
    VALUES (1 , '15-FEB-2022' , '28-FEB-2022' , 20 , 1);

SELECT *
FROM CONVENCION;


SELECT *
FROM RESERVA;

SELECT *
FROM recepcionista;
