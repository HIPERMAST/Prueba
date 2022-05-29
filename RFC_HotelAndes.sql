--RFC1
WITH 
habitacionCliente
AS(
    SELECT habitacion.numeroHabitacion AS numeroHabitacion, cliente.numeroDocumentocliente AS numeroDocumento
    FROM cliente, habitacion
    WHERE cliente.idhabitacion = habitacion.numeroHabitacion
),
costoServices
AS(
    SELECT habitacionCliente.numeroHabitacion, SUM(servicioxcliente.costo) AS costoServicios
    FROM servicioxcliente, habitacionCliente
    WHERE servicioxcliente.idcliente = habitacionCliente.numeroDocumento
    AND servicioxcliente.fecha >= '02-DEC-2018' AND servicioxcliente.fecha <= '02-DEC-2023'
    GROUP BY habitacionCliente.numeroHabitacion
)

SELECT * 
FROM costoServices;





--RFC2
WITH 
consumoServicios
AS(
    SELECT servicioxcliente.idEspecifico, SUM(servicioxcliente.cantVisitas) AS cantVisitas
    FROM servicioxcliente
    WHERE servicioxcliente.fecha >= '02-DEC-2018' AND servicioxcliente.fecha <= '02-DEC-2019'
    GROUP BY servicioxcliente.idEspecifico
)

SELECT *
FROM consumoServicios
FETCH FIRST 20 ROWS ONLY;





--RFC3
    SELECT habitacion.numerohabitacion, habitacion.ocupacionTotal AS ocupacion
    FROM habitacion


--RFC5

    SELECT servicioxcliente.IdCliente, SUM(servicioxcliente.costo) AS costo
    FROM servicioxcliente
    WHERE servicioxcliente.fecha >= '02-DEC-2018' AND servicioxcliente.fecha <= '02-DEC-2023'
    GROUP BY servicioxcliente.IdCliente






--RFC6
WITH
cantEfectivo
AS(
    SELECT servicioxcliente.fecha, SUM(servicioxcliente.costo) AS costo
    FROM servicioxcliente
    GROUP BY servicioxcliente.fecha
    ORDER BY costo DESC
),

cantDemanda
AS(
    SELECT servicioxcliente.fecha AS fecha, SUM(servicioxcliente.cantVisitas) AS cantVisitas
    FROM servicioxcliente
    GROUP BY servicioxcliente.fecha
)



SELECT fecha
FROM cantDemanda
ORDER BY cantVisitas ASC
FETCH FIRST 1 ROWS ONLY;


/*
SELECT fecha
FROM cantDemanda
ORDER BY cantDemanda.cantVisitas DESC
FETCH FIRST 1 ROWS ONLY;
*/

/*
SELECT fecha
FROM cantDemanda
ORDER BY cantDemanda.cantVisitas DESC
FETCH FIRST 1 ROWS ONLY;
*/



--RFC7
    SELECT servicioxcliente.fecha, SUM(servicioxcliente.costo) AS costo
    FROM servicioxcliente
    WHERE servicioxcliente.fecha >= '02-DEC-2018' AND servicioxcliente.fecha <= '02-DEC-2018'
    AND servicioxcliente.costo > 15000000



--RFC8
WITH
serviciosDemanda
AS(
    SELECT servicioxcliente.idServicio, servicioxcliente.fecha
    FROM servicioxcliente
    WHERE servicioxcliente.fecha >= '02-DEC-2021' AND servicioxcliente.fecha <= '02-DEC-2022'
)


