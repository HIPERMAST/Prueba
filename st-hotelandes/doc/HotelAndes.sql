DROP TABLE HOTEL CASCADE CONSTRAINTS;
DROP TABLE USUARIO CASCADE CONSTRAINTS;
DROP TABLE ADMINDATA_ID CASCADE CONSTRAINTS;
DROP TABLE ADMINISTRADORDATOS CASCADE CONSTRAINTS;
DROP TABLE A_EQUIPOADICIONAL CASCADE CONSTRAINTS;
DROP TABLE A_SERVICIOSSPA CASCADE CONSTRAINTS;
DROP TABLE CLIENTE CASCADE CONSTRAINTS;
DROP TABLE CLIENTE_ID CASCADE CONSTRAINTS;
DROP TABLE CUENTA CASCADE CONSTRAINTS;
DROP TABLE EMPLEADO CASCADE CONSTRAINTS;
DROP TABLE EMPLEADO_ID CASCADE CONSTRAINTS;
DROP TABLE GERENTE CASCADE CONSTRAINTS;
DROP TABLE GERENTE_ID CASCADE CONSTRAINTS;
DROP TABLE HABITACION CASCADE CONSTRAINTS;
DROP TABLE PC_LARGAESTADIA CASCADE CONSTRAINTS;
DROP TABLE PC_PROMOPARTICULAR CASCADE CONSTRAINTS;
DROP TABLE PC_TIEMPOCOMPARTIDO CASCADE CONSTRAINTS;
DROP TABLE PC_TODOINCLUIDO CASCADE CONSTRAINTS;
DROP TABLE PLANCONSUMO CASCADE CONSTRAINTS;
DROP TABLE PLANCONSUMO_ID CASCADE CONSTRAINTS;
DROP TABLE PRODUCTO CASCADE CONSTRAINTS;
DROP TABLE PRODUCTO_ID CASCADE CONSTRAINTS;
DROP TABLE RECEPCIONISTA CASCADE CONSTRAINTS;
DROP TABLE RECEPCIONISTA_ID CASCADE CONSTRAINTS;
DROP TABLE RESERVA CASCADE CONSTRAINTS;
DROP TABLE SERVICIO CASCADE CONSTRAINTS;
DROP TABLE S_BAR CASCADE CONSTRAINTS;
DROP TABLE S_BAR_ID CASCADE CONSTRAINTS;
DROP TABLE S_GYM CASCADE CONSTRAINTS;
DROP TABLE S_GYM_ID CASCADE CONSTRAINTS;
DROP TABLE S_INTERNET CASCADE CONSTRAINTS;
DROP TABLE S_INTERNET_ID CASCADE CONSTRAINTS;
DROP TABLE S_LAVANDERIA CASCADE CONSTRAINTS;
DROP TABLE S_LAVANDERIA_ID CASCADE CONSTRAINTS;
DROP TABLE S_PISCINA CASCADE CONSTRAINTS;
DROP TABLE S_PISCINA_ID CASCADE CONSTRAINTS;
DROP TABLE S_PRESTAMOUTENCILIOS CASCADE CONSTRAINTS;
DROP TABLE S_PRESTAMOUTENCILIOS_ID CASCADE CONSTRAINTS;
DROP TABLE S_RESTAURANTE CASCADE CONSTRAINTS;
DROP TABLE S_RESTAURANTE_ID CASCADE CONSTRAINTS;
DROP TABLE S_SALON CASCADE CONSTRAINTS;
DROP TABLE S_SALON_ID CASCADE CONSTRAINTS;
DROP TABLE S_SPA CASCADE CONSTRAINTS;
DROP TABLE S_SPA_ID CASCADE CONSTRAINTS;
DROP TABLE S_SUPERMERCADO CASCADE CONSTRAINTS;
DROP TABLE S_SUPERMERCADO_ID CASCADE CONSTRAINTS;
DROP TABLE S_TIENDA CASCADE CONSTRAINTS;
DROP TABLE S_TIENDA_ID CASCADE CONSTRAINTS;
DROP TABLE TIPO CASCADE CONSTRAINTS;
DROP SEQUENCE proyecto_sequence;



CREATE SEQUENCE proyecto_sequence;

CREATE TABLE a_equipoadicional (
    tipoequipo VARCHAR2(255 BYTE) NOT NULL,
    costo      NUMBER NOT NULL,
    idgym      NUMBER NOT NULL
)
LOGGING;

ALTER TABLE a_equipoadicional ADD CONSTRAINT a_equipoadicional_pk PRIMARY KEY ( tipoequipo );

CREATE TABLE a_serviciosspa (
    idspa    NUMBER NOT NULL,
    nombre   VARCHAR2(255 BYTE) NOT NULL,
    duracion DATE NOT NULL,
    costo    NUMBER NOT NULL
)
LOGGING;

ALTER TABLE a_serviciosspa ADD CONSTRAINT a_serviciosspa_pk PRIMARY KEY ( nombre );

CREATE TABLE admindata_id (
    id     NUMBER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE admindata_id ADD CONSTRAINT admindata_id_pk PRIMARY KEY ( id );

CREATE TABLE administradordatos (
    numerodocumento NUMBER NOT NULL,
    tipodocumento   VARCHAR2(255 BYTE) NOT NULL,
    correo          VARCHAR2(255 BYTE) NOT NULL,
    idusuario       NUMBER NOT NULL,
    idhotel         NUMBER NOT NULL
)
LOGGING;

ALTER TABLE administradordatos ADD CONSTRAINT administradordatos_pk PRIMARY KEY ( numerodocumento );

CREATE TABLE cliente (
    numerodocumentocliente NUMBER NOT NULL,
    tipodocumento          VARCHAR2(255 BYTE) NOT NULL,
    correocliente          VARCHAR2(255 BYTE) NOT NULL,
    idhotel                NUMBER NOT NULL,
    idhabitacion           NUMBER
)
LOGGING;

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( numerodocumentocliente );

CREATE TABLE cliente_id (
    numerodocumento NUMBER NOT NULL,
    nombrecliente   VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE cliente_id ADD CONSTRAINT cliente_id_pk PRIMARY KEY ( numerodocumento );

CREATE TABLE cuenta (
    idcuenta   NUMBER NOT NULL,
    costototal NUMBER NOT NULL
)
LOGGING;

ALTER TABLE cuenta ADD CONSTRAINT cuenta_pk PRIMARY KEY ( idcuenta );

CREATE TABLE empleado (
    idempleado       NUMBER NOT NULL,
    tipodocumento    VARCHAR2(255 BYTE) NOT NULL,
    correoempleado   VARCHAR2(255 BYTE) NOT NULL,
    numerohabitacion NUMBER,
    idcliente        NUMBER,
    idhotel          NUMBER NOT NULL
)
LOGGING;

ALTER TABLE empleado ADD CONSTRAINT empleado_pk PRIMARY KEY ( idempleado );

CREATE TABLE empleado_id (
    idempleado     NUMBER NOT NULL,
    nombreempleado VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE empleado_id ADD CONSTRAINT empleado_id_pk PRIMARY KEY ( idempleado );

CREATE TABLE gerente (
    idgerente     NUMBER NOT NULL,
    tipodocumento VARCHAR2(255 BYTE) NOT NULL,
    correogerente VARCHAR2(255 BYTE) NOT NULL,
    idhotel       NUMBER NOT NULL
)
LOGGING;

ALTER TABLE gerente ADD CONSTRAINT gerente_pk PRIMARY KEY ( idgerente );

CREATE TABLE gerente_id (
    idgerente     NUMBER NOT NULL,
    nombregerente VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE gerente_id ADD CONSTRAINT gerente_id_pk PRIMARY KEY ( idgerente );

CREATE TABLE habitacion (
    numerohabitacion NUMBER NOT NULL,
    costohabitacion  NUMBER NOT NULL,
    idtipo           NUMBER NOT NULL,
    idcuenta         NUMBER NOT NULL,
    idreserva        NUMBER,
    idhotel          NUMBER NOT NULL
)
LOGGING;

ALTER TABLE habitacion ADD CONSTRAINT habitacion_pk PRIMARY KEY ( numerohabitacion );

CREATE TABLE hotel (
    idhotel     NUMBER NOT NULL,
    nombrehotel VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE hotel ADD CONSTRAINT hotel_pk PRIMARY KEY ( idhotel );

CREATE TABLE pc_largaestadia (
    idlargaestadia       NUMBER NOT NULL,
    idreserva            NUMBER,
    descuentoalojamiento NUMBER NOT NULL,
    numerohabitacion     NUMBER
)
LOGGING;

ALTER TABLE pc_largaestadia ADD CONSTRAINT pc_largaestadia_pk PRIMARY KEY ( idlargaestadia );

CREATE TABLE pc_promoparticular (
    idpromopar       INTEGER NOT NULL,
    idreserva        NUMBER,
    descuentoreserva NUMBER NOT NULL
)
LOGGING;

ALTER TABLE pc_promoparticular ADD CONSTRAINT pc_promoparticular_pk PRIMARY KEY ( idpromopar );

CREATE TABLE pc_tiempocompartido (
    idtiempocompartido   NUMBER NOT NULL,
    idreserva            NUMBER,
    descuentobar         NUMBER NOT NULL,
    descuentorestaurante NUMBER NOT NULL,
    idbar                NUMBER NOT NULL,
    idrestaurante        NUMBER NOT NULL
)
LOGGING;

ALTER TABLE pc_tiempocompartido ADD CONSTRAINT pc_tiempocompartido_pk PRIMARY KEY ( idtiempocompartido );

CREATE TABLE pc_todoincluido (
    idproducto    NUMBER NOT NULL,
    idreserva     NUMBER,
    idrestaurante NUMBER NOT NULL
)
LOGGING;

ALTER TABLE pc_todoincluido ADD CONSTRAINT pc_todoincluido_pk PRIMARY KEY ( idproducto );

CREATE TABLE planconsumo (
    idplanconsumo NUMBER NOT NULL,
    idhotel       NUMBER NOT NULL
)
LOGGING;

ALTER TABLE planconsumo ADD CONSTRAINT planconsumo_pk PRIMARY KEY ( idplanconsumo );

CREATE TABLE planconsumo_id (
    idplanconsumo     NUMBER NOT NULL,
    nombreplanconsumo VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE planconsumo_id ADD CONSTRAINT planconsumo_id_pk PRIMARY KEY ( idplanconsumo );

CREATE TABLE producto (
    idproducto     NUMBER NOT NULL,
    precioproducto NUMBER NOT NULL,
    idrestaurante  NUMBER,
    idbar          NUMBER,
    idsupermercado NUMBER,
    idtienda       NUMBER
)
LOGGING;

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( idproducto );

CREATE TABLE producto_id (
    idproducto     NUMBER NOT NULL,
    nombreproducto VARCHAR2(255 BYTE)
)
LOGGING;

ALTER TABLE producto_id ADD CONSTRAINT producto_id_pk PRIMARY KEY ( idproducto );

CREATE TABLE recepcionista (
    idrecepcionista     NUMBER NOT NULL,
    tipodocumento       VARCHAR2(255 BYTE) NOT NULL,
    correorecepcionista VARCHAR2(255 BYTE) NOT NULL,
    idreserva           NUMBER,
    idcliente           NUMBER,
    idhotel             NUMBER NOT NULL
)
LOGGING;

ALTER TABLE recepcionista ADD CONSTRAINT recepcionista_pk PRIMARY KEY ( idrecepcionista );

CREATE TABLE recepcionista_id (
    idrecepcion         NUMBER NOT NULL,
    nombrerecepcionista VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE recepcionista_id ADD CONSTRAINT recepcionista_id_pk PRIMARY KEY ( idrecepcion );

CREATE TABLE reserva (
    idreserva     NUMBER NOT NULL,
    cantpersonas  NUMBER NOT NULL,
    checkin       DATE NOT NULL,
    checkout      DATE NOT NULL,
    idplanconsumo NUMBER
)
LOGGING;

ALTER TABLE reserva ADD CONSTRAINT reserva_pk PRIMARY KEY ( idreserva );

CREATE TABLE s_bar (
    idbar         NUMBER NOT NULL,
    estilobar     VARCHAR2(255 BYTE) NOT NULL,
    capacidad     NUMBER NOT NULL,
    pagocuenta    CHAR(1) NOT NULL,
    costoservicio NUMBER NOT NULL,
    idcliente     NUMBER,
    idhotel       NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_bar ADD CONSTRAINT s_bar_pk PRIMARY KEY ( idbar );

CREATE TABLE s_bar_id (
    idbar     NUMBER NOT NULL,
    nombrebar VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_bar_id ADD CONSTRAINT s_bar_id_pk PRIMARY KEY ( idbar );

CREATE TABLE s_gym (
    idgym         NUMBER NOT NULL,
    cantmaquinas  NUMBER NOT NULL,
    capacidad     NUMBER NOT NULL,
    pagocuenta    CHAR(1) NOT NULL,
    costoservicio NUMBER NOT NULL,
    idcliente     NUMBER,
    idhotel       NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_gym ADD CONSTRAINT s_gym_pk PRIMARY KEY ( idgym );

CREATE TABLE s_gym_id (
    idgym     NUMBER NOT NULL,
    nombregym VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_gym_id ADD CONSTRAINT s_gym_id_pk PRIMARY KEY ( idgym );

CREATE TABLE s_internet (
    idinternet    NUMBER NOT NULL,
    capacidad     NUMBER NOT NULL,
    pagocuenta    CHAR(1) NOT NULL,
    costoservicio NUMBER NOT NULL,
    idcliente     NUMBER,
    idhotel       NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_internet ADD CONSTRAINT s_internet_pk PRIMARY KEY ( idinternet );

CREATE TABLE s_internet_id (
    idinternet     NUMBER NOT NULL,
    nombreinternet VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_internet_id ADD CONSTRAINT s_internet_id_pk PRIMARY KEY ( idinternet );

CREATE TABLE s_lavanderia (
    idlavanderia   NUMBER NOT NULL,
    tipolavanderia VARCHAR2(255 BYTE) NOT NULL,
    cantprendas    NUMBER NOT NULL,
    pagocuenta     CHAR(1) NOT NULL,
    costoservicio  NUMBER NOT NULL,
    idcliente      NUMBER,
    idhotel        NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_lavanderia ADD CONSTRAINT s_lavanderia_pk PRIMARY KEY ( idlavanderia );

CREATE TABLE s_lavanderia_id (
    idlavanderia     NUMBER NOT NULL,
    nombrelavanderia VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_lavanderia_id ADD CONSTRAINT s_lavanderia_id_pk PRIMARY KEY ( idlavanderia );

CREATE TABLE s_piscina (
    idpiscina      NUMBER NOT NULL,
    profundidad    NUMBER NOT NULL,
    horarioinicial DATE NOT NULL,
    horariofinal   DATE NOT NULL,
    capacidad      NUMBER NOT NULL,
    pagocuenta     CHAR(1) NOT NULL,
    costoservicio  NUMBER NOT NULL,
    idcliente      NUMBER,
    idhotel        NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_piscina ADD CONSTRAINT s_piscina_pk PRIMARY KEY ( idpiscina );

CREATE TABLE s_piscina_id (
    idpiscina     NUMBER NOT NULL,
    nombrepiscina VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_piscina_id ADD CONSTRAINT s_id_piscina_pk PRIMARY KEY ( idpiscina );

CREATE TABLE s_prestamoutencilios (
    idprestamoutencilios NUMBER NOT NULL,
    tipoutencilios       VARCHAR2(255 BYTE) NOT NULL,
    cantutencilios       NUMBER NOT NULL,
    pagocuenta           CHAR(1) NOT NULL,
    costoservicio        NUMBER NOT NULL,
    idcliente            NUMBER,
    idhotel              NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_prestamoutencilios ADD CONSTRAINT s_prestamoutencilios_pk PRIMARY KEY ( idprestamoutencilios );

CREATE TABLE s_prestamoutencilios_id (
    idprestamoutencilios     NUMBER NOT NULL,
    nombreprestamoutencilios VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_prestamoutencilios_id ADD CONSTRAINT s_prestamoutencilios_id_pk PRIMARY KEY ( idprestamoutencilios );

CREATE TABLE s_restaurante (
    idrestaurante     NUMBER NOT NULL,
    estilorestaurante VARCHAR2(255 BYTE) NOT NULL,
    capacidad         NUMBER NOT NULL,
    pagocuenta        CHAR(1) NOT NULL,
    costoservicio     NUMBER NOT NULL,
    idcliente         NUMBER,
    idhotel           NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_restaurante ADD CONSTRAINT s_restaurante_pk PRIMARY KEY ( idrestaurante );

CREATE TABLE s_restaurante_id (
    idrestaurante     NUMBER NOT NULL,
    nombrerestaurante VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_restaurante_id ADD CONSTRAINT s_restaurante_id_pk PRIMARY KEY ( idrestaurante );

CREATE TABLE s_salon (
    idsalon        NUMBER NOT NULL,
    reserva        INTEGER,
    tiposalon      VARCHAR2(255 BYTE) NOT NULL,
    tiempolimpieza VARCHAR2(255 BYTE) NOT NULL,
    capacidad      NUMBER NOT NULL,
    pagocuenta     CHAR(1) NOT NULL,
    costoservicio  NUMBER NOT NULL,
    idcliente      NUMBER,
    idhotel        NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_salon ADD CONSTRAINT s_salon_pk PRIMARY KEY ( idsalon );

CREATE TABLE s_salon_id (
    idsalon     NUMBER NOT NULL,
    nombresalon VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_salon_id ADD CONSTRAINT s_salon_id_pk PRIMARY KEY ( idsalon );

CREATE TABLE s_spa (
    idspa         NUMBER NOT NULL,
    reserva       DATE NOT NULL,
    pagocuenta    CHAR(1) NOT NULL,
    costoservicio NUMBER NOT NULL,
    idcliente     NUMBER,
    idhotel       NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_spa ADD CONSTRAINT s_spa_pk PRIMARY KEY ( idspa );

CREATE TABLE s_spa_id (
    idspa     NUMBER NOT NULL,
    nombrespa VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_spa_id ADD CONSTRAINT s_spa_id_pk PRIMARY KEY ( idspa );

CREATE TABLE s_supermercado (
    idsupermercado NUMBER NOT NULL,
    pagocuenta     CHAR(1) NOT NULL,
    costoservicio  NUMBER NOT NULL,
    idcliente      NUMBER,
    idhotel        NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_supermercado ADD CONSTRAINT s_supermercado_pk PRIMARY KEY ( idsupermercado );

CREATE TABLE s_supermercado_id (
    idsupermercado     NUMBER NOT NULL,
    nombresupermercado VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_supermercado_id ADD CONSTRAINT s_supermercado_id_pk PRIMARY KEY ( idsupermercado );

CREATE TABLE s_tienda (
    idtienda      NUMBER NOT NULL,
    pagocuenta    CHAR(1) NOT NULL,
    costoservicio NUMBER NOT NULL,
    idcliente     NUMBER,
    idhotel       NUMBER NOT NULL
)
LOGGING;

ALTER TABLE s_tienda ADD CONSTRAINT s_tienda_pk PRIMARY KEY ( idtienda );

CREATE TABLE s_tienda_id (
    idtienda     NUMBER NOT NULL,
    nombretienda VARCHAR2(255 BYTE) NOT NULL
)
LOGGING;

ALTER TABLE s_tienda_id ADD CONSTRAINT s_tienda_id_pk PRIMARY KEY ( idtienda );

CREATE TABLE servicio (
    idservicio     NUMBER NOT NULL,
    nombreservicio VARCHAR2(255 BYTE) NOT NULL,
    idhotel        NUMBER NOT NULL,
    idcliente      NUMBER
)
LOGGING;

ALTER TABLE servicio ADD CONSTRAINT servicio_pk PRIMARY KEY ( idservicio );

CREATE TABLE tipo (
    idtipo     NUMBER NOT NULL,
    nombretipo VARCHAR2(255 BYTE) NOT NULL,
    dotacion   VARCHAR2(255 BYTE) NOT NULL,
    capacidad  NUMBER NOT NULL
)
LOGGING;

ALTER TABLE tipo ADD CONSTRAINT tipo_pk PRIMARY KEY ( idtipo );

CREATE TABLE usuario (
    idusuario  NUMBER NOT NULL,
    rolusuario VARCHAR2(255 BYTE) NOT NULL,
    idhotel    NUMBER NOT NULL
)
LOGGING;

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( idusuario );

ALTER TABLE a_equipoadicional
    ADD CONSTRAINT a_equipoadicional_s_gym_fk FOREIGN KEY ( idgym )
        REFERENCES s_gym ( idgym )
    NOT DEFERRABLE;

ALTER TABLE a_serviciosspa
    ADD CONSTRAINT a_serviciosspa_s_spa_fk FOREIGN KEY ( idspa )
        REFERENCES s_spa ( idspa )
    NOT DEFERRABLE;

ALTER TABLE administradordatos
    ADD CONSTRAINT admindata_admindata_id_fk FOREIGN KEY ( numerodocumento )
        REFERENCES admindata_id ( id )
    NOT DEFERRABLE;

ALTER TABLE cliente
    ADD CONSTRAINT cliente_admindata_fk FOREIGN KEY ( numerodocumentocliente )
        REFERENCES administradordatos ( numerodocumento )
    NOT DEFERRABLE;

ALTER TABLE cliente
    ADD CONSTRAINT cliente_habitacion_fk FOREIGN KEY ( idhabitacion )
        REFERENCES habitacion ( numerohabitacion )
    NOT DEFERRABLE;

ALTER TABLE cliente
    ADD CONSTRAINT cliente_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE cliente_id
    ADD CONSTRAINT cliente_id_admindata_fk FOREIGN KEY ( numerodocumento )
        REFERENCES administradordatos ( numerodocumento )
    NOT DEFERRABLE;

ALTER TABLE empleado
    ADD CONSTRAINT empleado_admindata_fk FOREIGN KEY ( idempleado )
        REFERENCES administradordatos ( numerodocumento )
    NOT DEFERRABLE;

ALTER TABLE empleado
    ADD CONSTRAINT empleado_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE empleado
    ADD CONSTRAINT empleado_habitacion_fk FOREIGN KEY ( numerohabitacion )
        REFERENCES habitacion ( numerohabitacion )
    NOT DEFERRABLE;

ALTER TABLE empleado
    ADD CONSTRAINT empleado_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE empleado_id
    ADD CONSTRAINT empleado_id_admindata_fk FOREIGN KEY ( idempleado )
        REFERENCES administradordatos ( numerodocumento )
    NOT DEFERRABLE;

ALTER TABLE gerente
    ADD CONSTRAINT gerente_administradordatos_fk FOREIGN KEY ( idgerente )
        REFERENCES administradordatos ( numerodocumento )
    NOT DEFERRABLE;

ALTER TABLE gerente
    ADD CONSTRAINT gerente_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE gerente_id
    ADD CONSTRAINT gerente_id_admindata_fk FOREIGN KEY ( idgerente )
        REFERENCES administradordatos ( numerodocumento )
    NOT DEFERRABLE;

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_cuenta_fk FOREIGN KEY ( idcuenta )
        REFERENCES cuenta ( idcuenta )
    NOT DEFERRABLE;

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva )
    NOT DEFERRABLE;

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_tipo_fk FOREIGN KEY ( idtipo )
        REFERENCES tipo ( idtipo )
    NOT DEFERRABLE;

ALTER TABLE planconsumo
    ADD CONSTRAINT pc_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE pc_largaestadia
    ADD CONSTRAINT pc_le_habitacion_fk FOREIGN KEY ( numerohabitacion )
        REFERENCES habitacion ( numerohabitacion )
    NOT DEFERRABLE;

ALTER TABLE pc_largaestadia
    ADD CONSTRAINT pc_le_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva )
    NOT DEFERRABLE;

ALTER TABLE planconsumo
    ADD CONSTRAINT pc_pc_id_fk FOREIGN KEY ( idplanconsumo )
        REFERENCES planconsumo_id ( idplanconsumo )
    NOT DEFERRABLE;

ALTER TABLE pc_promoparticular
    ADD CONSTRAINT pc_pp_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva )
    NOT DEFERRABLE;

ALTER TABLE pc_tiempocompartido
    ADD CONSTRAINT pc_tc_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva )
    NOT DEFERRABLE;

ALTER TABLE pc_tiempocompartido
    ADD CONSTRAINT pc_tc_s_bar_fk FOREIGN KEY ( idbar )
        REFERENCES s_bar ( idbar )
    NOT DEFERRABLE;

ALTER TABLE pc_tiempocompartido
    ADD CONSTRAINT pc_tc_s_restaurante_fk FOREIGN KEY ( idrestaurante )
        REFERENCES s_restaurante ( idrestaurante )
    NOT DEFERRABLE;

ALTER TABLE pc_todoincluido
    ADD CONSTRAINT pc_ti_producto_fk FOREIGN KEY ( idproducto )
        REFERENCES producto ( idproducto )
    NOT DEFERRABLE;

ALTER TABLE pc_todoincluido
    ADD CONSTRAINT pc_ti_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva )
    NOT DEFERRABLE;

ALTER TABLE pc_todoincluido
    ADD CONSTRAINT pc_ti_s_restaurante_fk FOREIGN KEY ( idrestaurante )
        REFERENCES s_restaurante ( idrestaurante )
    NOT DEFERRABLE;

ALTER TABLE producto
    ADD CONSTRAINT producto_producto_id_fk FOREIGN KEY ( idproducto )
        REFERENCES producto_id ( idproducto )
    NOT DEFERRABLE;

ALTER TABLE producto
    ADD CONSTRAINT producto_s_bar_fk FOREIGN KEY ( idbar )
        REFERENCES s_bar ( idbar )
    NOT DEFERRABLE;

ALTER TABLE producto
    ADD CONSTRAINT producto_s_restaurante_fk FOREIGN KEY ( idrestaurante )
        REFERENCES s_restaurante ( idrestaurante )
    NOT DEFERRABLE;

ALTER TABLE producto
    ADD CONSTRAINT producto_s_supermercado_fk FOREIGN KEY ( idsupermercado )
        REFERENCES s_supermercado ( idsupermercado )
    NOT DEFERRABLE;

ALTER TABLE producto
    ADD CONSTRAINT producto_s_tienda_fk FOREIGN KEY ( idtienda )
        REFERENCES s_tienda ( idtienda )
    NOT DEFERRABLE;

ALTER TABLE recepcionista
    ADD CONSTRAINT recepcio_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE recepcionista
    ADD CONSTRAINT recepcion_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE recepcionista
    ADD CONSTRAINT recepcionista_admindata_fk FOREIGN KEY ( idrecepcionista )
        REFERENCES administradordatos ( numerodocumento )
    NOT DEFERRABLE;

ALTER TABLE recepcionista_id
    ADD CONSTRAINT recepcionista_id_admindata_fk FOREIGN KEY ( idrecepcion )
        REFERENCES administradordatos ( numerodocumento )
    NOT DEFERRABLE;

ALTER TABLE recepcionista
    ADD CONSTRAINT recepcionista_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva )
    NOT DEFERRABLE;

ALTER TABLE reserva
    ADD CONSTRAINT reserva_pc_fk FOREIGN KEY ( idplanconsumo )
        REFERENCES planconsumo ( idplanconsumo )
    NOT DEFERRABLE;

ALTER TABLE s_bar
    ADD CONSTRAINT s_bar_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_bar
    ADD CONSTRAINT s_bar_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_bar
    ADD CONSTRAINT s_bar_s_bar_id_fk FOREIGN KEY ( idbar )
        REFERENCES s_bar_id ( idbar )
    NOT DEFERRABLE;

ALTER TABLE s_gym
    ADD CONSTRAINT s_gym_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_gym
    ADD CONSTRAINT s_gym_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_gym
    ADD CONSTRAINT s_gym_s_gym_id_fk FOREIGN KEY ( idgym )
        REFERENCES s_gym_id ( idgym )
    NOT DEFERRABLE;

ALTER TABLE s_lavanderia
    ADD CONSTRAINT s_lavan_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_lavanderia
    ADD CONSTRAINT s_lavan_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_lavanderia
    ADD CONSTRAINT s_lavan_s_lavan_id_fk FOREIGN KEY ( idlavanderia )
        REFERENCES s_lavanderia_id ( idlavanderia )
    NOT DEFERRABLE;

ALTER TABLE s_piscina
    ADD CONSTRAINT s_piscina_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_piscina
    ADD CONSTRAINT s_piscina_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_piscina
    ADD CONSTRAINT s_piscina_s_id_piscina_fk FOREIGN KEY ( idpiscina )
        REFERENCES s_piscina_id ( idpiscina )
    NOT DEFERRABLE;

ALTER TABLE s_prestamoutencilios
    ADD CONSTRAINT s_pu_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_prestamoutencilios
    ADD CONSTRAINT s_pu_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_prestamoutencilios
    ADD CONSTRAINT s_pu_s_pu_id_fk FOREIGN KEY ( idprestamoutencilios )
        REFERENCES s_prestamoutencilios_id ( idprestamoutencilios )
    NOT DEFERRABLE;

ALTER TABLE s_restaurante
    ADD CONSTRAINT s_rest_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_restaurante
    ADD CONSTRAINT s_rest_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_restaurante
    ADD CONSTRAINT s_rest_s_rest_id_fk FOREIGN KEY ( idrestaurante )
        REFERENCES s_restaurante_id ( idrestaurante )
    NOT DEFERRABLE;

ALTER TABLE s_salon
    ADD CONSTRAINT s_salon_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_salon
    ADD CONSTRAINT s_salon_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_salon
    ADD CONSTRAINT s_salon_s_salon_id_fk FOREIGN KEY ( idsalon )
        REFERENCES s_salon_id ( idsalon )
    NOT DEFERRABLE;

ALTER TABLE s_spa
    ADD CONSTRAINT s_spa_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_spa
    ADD CONSTRAINT s_spa_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_spa
    ADD CONSTRAINT s_spa_s_spa_id_fk FOREIGN KEY ( idspa )
        REFERENCES s_spa_id ( idspa )
    NOT DEFERRABLE;

ALTER TABLE s_supermercado
    ADD CONSTRAINT s_super_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_supermercado
    ADD CONSTRAINT s_super_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_supermercado
    ADD CONSTRAINT s_super_s_super_id_fk FOREIGN KEY ( idsupermercado )
        REFERENCES s_supermercado_id ( idsupermercado )
    NOT DEFERRABLE;

ALTER TABLE s_tienda
    ADD CONSTRAINT s_tienda_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_tienda
    ADD CONSTRAINT s_tienda_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_tienda
    ADD CONSTRAINT s_tienda_s_tienda_id_fk FOREIGN KEY ( idtienda )
        REFERENCES s_tienda_id ( idtienda )
    NOT DEFERRABLE;

ALTER TABLE s_internet
    ADD CONSTRAINT s_wifi_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE s_internet
    ADD CONSTRAINT s_wifi_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE s_internet
    ADD CONSTRAINT s_wifi_s_wifi_id_fk FOREIGN KEY ( idinternet )
        REFERENCES s_internet_id ( idinternet )
    NOT DEFERRABLE;

ALTER TABLE servicio
    ADD CONSTRAINT servicio_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente )
    NOT DEFERRABLE;

ALTER TABLE servicio
    ADD CONSTRAINT servicio_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

ALTER TABLE usuario
    ADD CONSTRAINT usuario_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel )
    NOT DEFERRABLE;

COMMIT;