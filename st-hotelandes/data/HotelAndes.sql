
DROP TABLE a_equipoadicional CASCADE CONSTRAINTS;

DROP TABLE a_serviciosspa CASCADE CONSTRAINTS;

DROP TABLE admindata_id CASCADE CONSTRAINTS;

DROP TABLE administradordatos CASCADE CONSTRAINTS;

DROP TABLE cliente CASCADE CONSTRAINTS;

DROP TABLE cliente_id CASCADE CONSTRAINTS;

DROP TABLE convencion CASCADE CONSTRAINTS;

DROP TABLE cuenta CASCADE CONSTRAINTS;

DROP TABLE empleado CASCADE CONSTRAINTS;

DROP TABLE empleado_id CASCADE CONSTRAINTS;

DROP TABLE gerente CASCADE CONSTRAINTS;

DROP TABLE gerente_id CASCADE CONSTRAINTS;

DROP TABLE habitacion CASCADE CONSTRAINTS;

DROP TABLE hotel CASCADE CONSTRAINTS;

DROP TABLE organizadoreventos CASCADE CONSTRAINTS;

DROP TABLE organizadoreventos_id CASCADE CONSTRAINTS;

DROP TABLE pc_largaestadia CASCADE CONSTRAINTS;

DROP TABLE pc_promoparticular CASCADE CONSTRAINTS;

DROP TABLE pc_tiempocompartido CASCADE CONSTRAINTS;

DROP TABLE pc_todoincluido CASCADE CONSTRAINTS;

DROP TABLE planconsumo CASCADE CONSTRAINTS;

DROP TABLE planconsumo_id CASCADE CONSTRAINTS;

DROP TABLE producto CASCADE CONSTRAINTS;

DROP TABLE producto_id CASCADE CONSTRAINTS;

DROP TABLE recepcionista CASCADE CONSTRAINTS;

DROP TABLE recepcionista_id CASCADE CONSTRAINTS;

DROP TABLE reserva CASCADE CONSTRAINTS;

DROP TABLE s_bar CASCADE CONSTRAINTS;

DROP TABLE s_bar_id CASCADE CONSTRAINTS;

DROP TABLE s_gym CASCADE CONSTRAINTS;

DROP TABLE s_gym_id CASCADE CONSTRAINTS;

DROP TABLE s_internet CASCADE CONSTRAINTS;

DROP TABLE s_internet_id CASCADE CONSTRAINTS;

DROP TABLE s_lavanderia CASCADE CONSTRAINTS;

DROP TABLE s_lavanderia_id CASCADE CONSTRAINTS;

DROP TABLE s_piscina CASCADE CONSTRAINTS;

DROP TABLE s_piscina_id CASCADE CONSTRAINTS;

DROP TABLE s_prestamoutencilios CASCADE CONSTRAINTS;

DROP TABLE s_prestamoutencilios_id CASCADE CONSTRAINTS;

DROP TABLE s_restaurante CASCADE CONSTRAINTS;

DROP TABLE s_restaurante_id CASCADE CONSTRAINTS;

DROP TABLE s_salon CASCADE CONSTRAINTS;

DROP TABLE s_salon_id CASCADE CONSTRAINTS;

DROP TABLE s_spa CASCADE CONSTRAINTS;

DROP TABLE s_spa_id CASCADE CONSTRAINTS;

DROP TABLE s_supermercado CASCADE CONSTRAINTS;

DROP TABLE s_supermercado_id CASCADE CONSTRAINTS;

DROP TABLE s_tienda CASCADE CONSTRAINTS;

DROP TABLE s_tienda_id CASCADE CONSTRAINTS;

DROP TABLE servicio CASCADE CONSTRAINTS;

DROP TABLE servicioxcliente CASCADE CONSTRAINTS;

DROP TABLE tipo CASCADE CONSTRAINTS;

DROP TABLE usuario CASCADE CONSTRAINTS;

DROP SEQUENCE proyecto_sequence;



CREATE SEQUENCE proyecto_sequence;

CREATE TABLE a_equipoadicional (
    tipoequipo VARCHAR2(255 BYTE) NOT NULL,
    costo      NUMBER NOT NULL,
    idgym      NUMBER NOT NULL
);

ALTER TABLE a_equipoadicional ADD CONSTRAINT a_equipoadicional_pk PRIMARY KEY ( tipoequipo );

CREATE TABLE a_serviciosspa (
    idspa    NUMBER NOT NULL,
    nombre   VARCHAR2(255 BYTE) NOT NULL,
    duracion DATE NOT NULL,
    costo    NUMBER NOT NULL
);

ALTER TABLE a_serviciosspa ADD CONSTRAINT a_serviciosspa_pk PRIMARY KEY ( idspa );

CREATE TABLE admindata_id (
    id     NUMBER NOT NULL,
    nombre VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE admindata_id ADD CONSTRAINT admindata_id_pk PRIMARY KEY ( id );

CREATE TABLE administradordatos (
    numerodocumento NUMBER NOT NULL,
    tipodocumento   VARCHAR2(255 BYTE) NOT NULL,
    correo          VARCHAR2(255 BYTE) NOT NULL,
    pw              VARCHAR2(255 BYTE) NOT NULL,
    idusuario       NUMBER NOT NULL,
    idhotel         NUMBER NOT NULL
);

ALTER TABLE administradordatos ADD CONSTRAINT administradordatos_pk PRIMARY KEY ( numerodocumento );

CREATE TABLE cliente (
    numerodocumentocliente NUMBER NOT NULL,
    tipodocumento          VARCHAR2(255 BYTE) NOT NULL,
    correocliente          VARCHAR2(255 BYTE) NOT NULL,
    pwcliente              VARCHAR2(255 BYTE) NOT NULL,
    idhotel                NUMBER NOT NULL,
    idhabitacion           NUMBER,
    idconvencion           NUMBER
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( numerodocumentocliente );

CREATE TABLE cliente_id (
    numerodocumento NUMBER NOT NULL,
    nombrecliente   VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE cliente_id ADD CONSTRAINT cliente_id_pk PRIMARY KEY ( numerodocumento );

CREATE TABLE convencion (
    idconvencion  NUMBER NOT NULL,
    checkin       DATE NOT NULL,
    checkout      DATE NOT NULL,
    cantpersonas  NUMBER NOT NULL,
    idplanconsumo NUMBER NOT NULL
);

ALTER TABLE convencion ADD CONSTRAINT convencion_pk PRIMARY KEY ( idconvencion );

CREATE TABLE cuenta (
    idcuenta   NUMBER NOT NULL,
    costototal NUMBER NOT NULL
);

ALTER TABLE cuenta ADD CONSTRAINT cuenta_pk PRIMARY KEY ( idcuenta );

CREATE TABLE empleado (
    idempleado       NUMBER NOT NULL,
    tipodocumento    VARCHAR2(255 BYTE) NOT NULL,
    correoempleado   VARCHAR2(255 BYTE) NOT NULL,
    pwempleado       VARCHAR2(255 BYTE) NOT NULL,
    numerohabitacion NUMBER,
    idcliente        NUMBER,
    idhotel          NUMBER NOT NULL
);

ALTER TABLE empleado ADD CONSTRAINT empleado_pk PRIMARY KEY ( idempleado );

CREATE TABLE empleado_id (
    idempleado     NUMBER NOT NULL,
    nombreempleado VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE empleado_id ADD CONSTRAINT empleado_id_pk PRIMARY KEY ( idempleado );

CREATE TABLE gerente (
    idgerente     NUMBER NOT NULL,
    tipodocumento VARCHAR2(255 BYTE) NOT NULL,
    correogerente VARCHAR2(255 BYTE) NOT NULL,
    pwgerente     VARCHAR2(255 BYTE) NOT NULL,
    idhotel       NUMBER NOT NULL
);

ALTER TABLE gerente ADD CONSTRAINT gerente_pk PRIMARY KEY ( idgerente );

CREATE TABLE gerente_id (
    idgerente     NUMBER NOT NULL,
    nombregerente VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE gerente_id ADD CONSTRAINT gerente_id_pk PRIMARY KEY ( idgerente );

CREATE TABLE habitacion (
    numerohabitacion NUMBER NOT NULL,
    costohabitacion  NUMBER NOT NULL,
    idtipo           NUMBER NOT NULL,
    idcuenta         NUMBER NOT NULL,
    idreserva        NUMBER,
    idhotel          NUMBER NOT NULL,
    ocupaciontotal   NUMBER NOT NULL
);

ALTER TABLE habitacion ADD CONSTRAINT habitacion_pk PRIMARY KEY ( numerohabitacion );

CREATE TABLE hotel (
    idhotel     NUMBER NOT NULL,
    nombrehotel VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE hotel ADD CONSTRAINT hotel_pk PRIMARY KEY ( idhotel );

CREATE TABLE organizadoreventos (
    idoe          NUMBER NOT NULL,
    tipodocumento VARCHAR2(255 BYTE) NOT NULL,
    correooe      VARCHAR2(255 BYTE) NOT NULL,
    pwoe          VARCHAR2(255 BYTE) NOT NULL,
    idhotel       NUMBER NOT NULL,
    idconvencion  NUMBER,
    idcuenta      NUMBER,
    idreserva     NUMBER
);

ALTER TABLE organizadoreventos ADD CONSTRAINT organizadoreventos_pk PRIMARY KEY ( idoe );

CREATE TABLE organizadoreventos_id (
    idoe     NUMBER NOT NULL,
    nombreoe VARCHAR2(255 BYTE)
);

ALTER TABLE organizadoreventos_id ADD CONSTRAINT organizadoreventos_id_pk PRIMARY KEY ( idoe );

CREATE TABLE pc_largaestadia (
    idlargaestadia       NUMBER NOT NULL,
    idreserva            NUMBER,
    descuentoalojamiento NUMBER NOT NULL,
    numerohabitacion     NUMBER
);

ALTER TABLE pc_largaestadia ADD CONSTRAINT pc_largaestadia_pk PRIMARY KEY ( idlargaestadia );

CREATE TABLE pc_promoparticular (
    idpromopar       INTEGER NOT NULL,
    idreserva        NUMBER,
    descuentoreserva NUMBER NOT NULL
);

ALTER TABLE pc_promoparticular ADD CONSTRAINT pc_promoparticular_pk PRIMARY KEY ( idpromopar );

CREATE TABLE pc_tiempocompartido (
    idtiempocompartido   NUMBER NOT NULL,
    idreserva            NUMBER,
    descuentobar         NUMBER NOT NULL,
    descuentorestaurante NUMBER NOT NULL,
    idbar                NUMBER NOT NULL,
    idrestaurante        NUMBER NOT NULL
);

ALTER TABLE pc_tiempocompartido ADD CONSTRAINT pc_tiempocompartido_pk PRIMARY KEY ( idtiempocompartido );

CREATE TABLE pc_todoincluido (
    idproducto    NUMBER NOT NULL,
    idreserva     NUMBER,
    idrestaurante NUMBER NOT NULL
);

ALTER TABLE pc_todoincluido ADD CONSTRAINT pc_todoincluido_pk PRIMARY KEY ( idproducto );

CREATE TABLE planconsumo (
    idplanconsumo NUMBER NOT NULL,
    idhotel       NUMBER NOT NULL
);

ALTER TABLE planconsumo ADD CONSTRAINT planconsumo_pk PRIMARY KEY ( idplanconsumo );

CREATE TABLE planconsumo_id (
    idplanconsumo     NUMBER NOT NULL,
    nombreplanconsumo VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE planconsumo_id ADD CONSTRAINT planconsumo_id_pk PRIMARY KEY ( idplanconsumo );

CREATE TABLE producto (
    idproducto     NUMBER NOT NULL,
    precioproducto NUMBER NOT NULL,
    idrestaurante  NUMBER,
    idbar          NUMBER,
    idsupermercado NUMBER,
    idtienda       NUMBER
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( idproducto );

CREATE TABLE producto_id (
    idproducto     NUMBER NOT NULL,
    nombreproducto VARCHAR2(255 BYTE)
);

ALTER TABLE producto_id ADD CONSTRAINT producto_id_pk PRIMARY KEY ( idproducto );

CREATE TABLE recepcionista (
    idrecepcionista     NUMBER NOT NULL,
    tipodocumento       VARCHAR2(255 BYTE) NOT NULL,
    correorecepcionista VARCHAR2(255 BYTE) NOT NULL,
    pwrecepcionista     VARCHAR2(255 BYTE) NOT NULL,
    idreserva           NUMBER,
    idcliente           NUMBER,
    idhotel             NUMBER NOT NULL
);

ALTER TABLE recepcionista ADD CONSTRAINT recepcionista_pk PRIMARY KEY ( idrecepcionista );

CREATE TABLE recepcionista_id (
    idrecepcion         NUMBER NOT NULL,
    nombrerecepcionista VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE recepcionista_id ADD CONSTRAINT recepcionista_id_pk PRIMARY KEY ( idrecepcion );

CREATE TABLE reserva (
    idreserva     NUMBER NOT NULL,
    cantpersonas  NUMBER NOT NULL,
    checkin       DATE NOT NULL,
    checkout      DATE NOT NULL,
    idplanconsumo NUMBER,
    activo        NUMBER NOT NULL
);

ALTER TABLE reserva ADD CONSTRAINT reserva_pk PRIMARY KEY ( idreserva );

CREATE TABLE s_bar (
    idbar         NUMBER NOT NULL,
    estilobar     VARCHAR2(255 BYTE) NOT NULL,
    capacidad     NUMBER NOT NULL,
    pagocuenta    CHAR(1) NOT NULL,
    costoservicio NUMBER NOT NULL,
    idhotel       NUMBER NOT NULL
);

ALTER TABLE s_bar ADD CONSTRAINT s_bar_pk PRIMARY KEY ( idbar );

CREATE TABLE s_bar_id (
    idbar     NUMBER NOT NULL,
    nombrebar VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_bar_id ADD CONSTRAINT s_bar_id_pk PRIMARY KEY ( idbar );

CREATE TABLE s_gym (
    idgym         NUMBER NOT NULL,
    cantmaquinas  NUMBER NOT NULL,
    capacidad     NUMBER NOT NULL,
    pagocuenta    CHAR(1) NOT NULL,
    costoservicio NUMBER NOT NULL,
    idhotel       NUMBER NOT NULL
);

ALTER TABLE s_gym ADD CONSTRAINT s_gym_pk PRIMARY KEY ( idgym );

CREATE TABLE s_gym_id (
    idgym     NUMBER NOT NULL,
    nombregym VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_gym_id ADD CONSTRAINT s_gym_id_pk PRIMARY KEY ( idgym );

CREATE TABLE s_internet (
    idinternet    NUMBER NOT NULL,
    capacidad     NUMBER NOT NULL,
    pagocuenta    CHAR(1) NOT NULL,
    costoservicio NUMBER NOT NULL,
    idhotel       NUMBER NOT NULL
);

ALTER TABLE s_internet ADD CONSTRAINT s_internet_pk PRIMARY KEY ( idinternet );

CREATE TABLE s_internet_id (
    idinternet     NUMBER NOT NULL,
    nombreinternet VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_internet_id ADD CONSTRAINT s_internet_id_pk PRIMARY KEY ( idinternet );

CREATE TABLE s_lavanderia (
    idlavanderia   NUMBER NOT NULL,
    tipolavanderia VARCHAR2(255 BYTE) NOT NULL,
    cantprendas    NUMBER NOT NULL,
    pagocuenta     CHAR(1) NOT NULL,
    costoservicio  NUMBER NOT NULL,
    idhotel        NUMBER NOT NULL
);

ALTER TABLE s_lavanderia ADD CONSTRAINT s_lavanderia_pk PRIMARY KEY ( idlavanderia );

CREATE TABLE s_lavanderia_id (
    idlavanderia     NUMBER NOT NULL,
    nombrelavanderia VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_lavanderia_id ADD CONSTRAINT s_lavanderia_id_pk PRIMARY KEY ( idlavanderia );

CREATE TABLE s_piscina (
    idpiscina      NUMBER NOT NULL,
    profundidad    NUMBER NOT NULL,
    horarioinicial DATE NOT NULL,
    horariofinal   DATE NOT NULL,
    capacidad      NUMBER NOT NULL,
    pagocuenta     CHAR(1) NOT NULL,
    costoservicio  NUMBER NOT NULL,
    idhotel        NUMBER NOT NULL
);

ALTER TABLE s_piscina ADD CONSTRAINT s_piscina_pk PRIMARY KEY ( idpiscina );

CREATE TABLE s_piscina_id (
    idpiscina     NUMBER NOT NULL,
    nombrepiscina VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_piscina_id ADD CONSTRAINT s_id_piscina_pk PRIMARY KEY ( idpiscina );

CREATE TABLE s_prestamoutencilios (
    idprestamoutencilios NUMBER NOT NULL,
    tipoutencilios       VARCHAR2(255 BYTE) NOT NULL,
    cantutencilios       NUMBER NOT NULL,
    pagocuenta           CHAR(1) NOT NULL,
    costoservicio        NUMBER NOT NULL,
    idhotel              NUMBER NOT NULL
);

ALTER TABLE s_prestamoutencilios ADD CONSTRAINT s_prestamoutencilios_pk PRIMARY KEY ( idprestamoutencilios );

CREATE TABLE s_prestamoutencilios_id (
    idprestamoutencilios     NUMBER NOT NULL,
    nombreprestamoutencilios VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_prestamoutencilios_id ADD CONSTRAINT s_prestamoutencilios_id_pk PRIMARY KEY ( idprestamoutencilios );

CREATE TABLE s_restaurante (
    idrestaurante     NUMBER NOT NULL,
    estilorestaurante VARCHAR2(255 BYTE) NOT NULL,
    capacidad         NUMBER NOT NULL,
    pagocuenta        CHAR(1) NOT NULL,
    costoservicio     NUMBER NOT NULL,
    idhotel           NUMBER NOT NULL
);

ALTER TABLE s_restaurante ADD CONSTRAINT s_restaurante_pk PRIMARY KEY ( idrestaurante );

CREATE TABLE s_restaurante_id (
    idrestaurante     NUMBER NOT NULL,
    nombrerestaurante VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_restaurante_id ADD CONSTRAINT s_restaurante_id_pk PRIMARY KEY ( idrestaurante );

CREATE TABLE s_salon (
    idsalon        NUMBER NOT NULL,
    reserva        DATE,
    tiposalon      VARCHAR2(255 BYTE) NOT NULL,
    tiempolimpieza VARCHAR2(255 BYTE) NOT NULL,
    capacidad      NUMBER NOT NULL,
    pagocuenta     CHAR(1) NOT NULL,
    costoservicio  NUMBER NOT NULL,
    idcliente      NUMBER,
    idhotel        NUMBER NOT NULL
);

ALTER TABLE s_salon ADD CONSTRAINT s_salon_pk PRIMARY KEY ( idsalon );

CREATE TABLE s_salon_id (
    idsalon     NUMBER NOT NULL,
    nombresalon VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_salon_id ADD CONSTRAINT s_salon_id_pk PRIMARY KEY ( idsalon );

CREATE TABLE s_spa (
    idspa         NUMBER NOT NULL,
    reserva       DATE NOT NULL,
    pagocuenta    CHAR(1) NOT NULL,
    costoservicio NUMBER NOT NULL,
    idcliente     NUMBER,
    idhotel       NUMBER NOT NULL
);

ALTER TABLE s_spa ADD CONSTRAINT s_spa_pk PRIMARY KEY ( idspa );

CREATE TABLE s_spa_id (
    idspa     NUMBER NOT NULL,
    nombrespa VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_spa_id ADD CONSTRAINT s_spa_id_pk PRIMARY KEY ( idspa );

CREATE TABLE s_supermercado (
    idsupermercado NUMBER NOT NULL,
    pagocuenta     CHAR(1) NOT NULL,
    costoservicio  NUMBER NOT NULL,
    idhotel        NUMBER NOT NULL
);

ALTER TABLE s_supermercado ADD CONSTRAINT s_supermercado_pk PRIMARY KEY ( idsupermercado );

CREATE TABLE s_supermercado_id (
    idsupermercado     NUMBER NOT NULL,
    nombresupermercado VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_supermercado_id ADD CONSTRAINT s_supermercado_id_pk PRIMARY KEY ( idsupermercado );

CREATE TABLE s_tienda (
    idtienda      NUMBER NOT NULL,
    pagocuenta    CHAR(1) NOT NULL,
    costoservicio NUMBER NOT NULL,
    idhotel       NUMBER NOT NULL
);

ALTER TABLE s_tienda ADD CONSTRAINT s_tienda_pk PRIMARY KEY ( idtienda );

CREATE TABLE s_tienda_id (
    idtienda     NUMBER NOT NULL,
    nombretienda VARCHAR2(255 BYTE) NOT NULL
);

ALTER TABLE s_tienda_id ADD CONSTRAINT s_tienda_id_pk PRIMARY KEY ( idtienda );

CREATE TABLE servicio (
    idservicio     NUMBER NOT NULL,
    nombreservicio VARCHAR2(255 BYTE) NOT NULL,
    idhotel        NUMBER NOT NULL,
    idcliente      NUMBER
);

ALTER TABLE servicio ADD CONSTRAINT servicio_pk PRIMARY KEY ( idservicio );

CREATE TABLE servicioxcliente (
    historial    NUMBER NOT NULL,
    fecha        DATE NOT NULL,
    idcliente    NUMBER NOT NULL,
    idservicio   NUMBER NOT NULL,
    idespecifico NUMBER NOT NULL,
    cantvisitas  NUMBER NOT NULL,
    costo        NUMBER NOT NULL,
    consumo      NUMBER NOT NULL
);

ALTER TABLE servicioxcliente ADD CONSTRAINT servicioxcliente_pk PRIMARY KEY ( historial );

CREATE TABLE tipo (
    idtipo     NUMBER NOT NULL,
    nombretipo VARCHAR2(255 BYTE) NOT NULL,
    dotacion   VARCHAR2(255 BYTE) NOT NULL,
    capacidad  NUMBER NOT NULL
);

ALTER TABLE tipo ADD CONSTRAINT tipo_pk PRIMARY KEY ( idtipo );

CREATE TABLE usuario (
    idusuario  NUMBER NOT NULL,
    rolusuario VARCHAR2(255 BYTE) NOT NULL,
    idhotel    NUMBER NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( idusuario );

ALTER TABLE a_equipoadicional
    ADD CONSTRAINT a_equipoadicional_s_gym_fk FOREIGN KEY ( idgym )
        REFERENCES s_gym ( idgym );

ALTER TABLE a_serviciosspa
    ADD CONSTRAINT a_serviciosspa_s_spa_fk FOREIGN KEY ( idspa )
        REFERENCES s_spa ( idspa );

ALTER TABLE administradordatos
    ADD CONSTRAINT admindata_admindata_id_fk FOREIGN KEY ( numerodocumento )
        REFERENCES admindata_id ( id );

ALTER TABLE cliente
    ADD CONSTRAINT cliente_admindata_fk FOREIGN KEY ( numerodocumentocliente )
        REFERENCES administradordatos ( numerodocumento );

ALTER TABLE cliente
    ADD CONSTRAINT cliente_habitacion_fk FOREIGN KEY ( idhabitacion )
        REFERENCES habitacion ( numerohabitacion );

ALTER TABLE cliente
    ADD CONSTRAINT cliente_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE cliente_id
    ADD CONSTRAINT cliente_id_admindata_fk FOREIGN KEY ( numerodocumento )
        REFERENCES administradordatos ( numerodocumento );

ALTER TABLE convencion
    ADD CONSTRAINT convencion_pc_fk FOREIGN KEY ( idplanconsumo )
        REFERENCES planconsumo ( idplanconsumo );

ALTER TABLE empleado
    ADD CONSTRAINT empleado_admindata_fk FOREIGN KEY ( idempleado )
        REFERENCES administradordatos ( numerodocumento );

ALTER TABLE empleado
    ADD CONSTRAINT empleado_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente );

ALTER TABLE empleado
    ADD CONSTRAINT empleado_habitacion_fk FOREIGN KEY ( numerohabitacion )
        REFERENCES habitacion ( numerohabitacion );

ALTER TABLE empleado
    ADD CONSTRAINT empleado_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE empleado_id
    ADD CONSTRAINT empleado_id_admindata_fk FOREIGN KEY ( idempleado )
        REFERENCES administradordatos ( numerodocumento );

ALTER TABLE gerente
    ADD CONSTRAINT gerente_administradordatos_fk FOREIGN KEY ( idgerente )
        REFERENCES administradordatos ( numerodocumento );

ALTER TABLE gerente
    ADD CONSTRAINT gerente_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE gerente_id
    ADD CONSTRAINT gerente_id_admindata_fk FOREIGN KEY ( idgerente )
        REFERENCES administradordatos ( numerodocumento );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_cuenta_fk FOREIGN KEY ( idcuenta )
        REFERENCES cuenta ( idcuenta );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_tipo_fk FOREIGN KEY ( idtipo )
        REFERENCES tipo ( idtipo );

ALTER TABLE organizadoreventos
    ADD CONSTRAINT oe_admindata_fk FOREIGN KEY ( idoe )
        REFERENCES administradordatos ( numerodocumento );

ALTER TABLE organizadoreventos
    ADD CONSTRAINT oe_convencion_fk FOREIGN KEY ( idconvencion )
        REFERENCES convencion ( idconvencion );

ALTER TABLE organizadoreventos_id
    ADD CONSTRAINT oe_id_admindata_fk FOREIGN KEY ( idoe )
        REFERENCES administradordatos ( numerodocumento );

ALTER TABLE organizadoreventos
    ADD CONSTRAINT organizadoreventos_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE planconsumo
    ADD CONSTRAINT pc_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE pc_largaestadia
    ADD CONSTRAINT pc_le_habitacion_fk FOREIGN KEY ( numerohabitacion )
        REFERENCES habitacion ( numerohabitacion );

ALTER TABLE pc_largaestadia
    ADD CONSTRAINT pc_le_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva );

ALTER TABLE planconsumo
    ADD CONSTRAINT pc_pc_id_fk FOREIGN KEY ( idplanconsumo )
        REFERENCES planconsumo_id ( idplanconsumo );

ALTER TABLE pc_promoparticular
    ADD CONSTRAINT pc_pp_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva );

ALTER TABLE pc_tiempocompartido
    ADD CONSTRAINT pc_tc_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva );

ALTER TABLE pc_tiempocompartido
    ADD CONSTRAINT pc_tc_s_bar_fk FOREIGN KEY ( idbar )
        REFERENCES s_bar ( idbar );

ALTER TABLE pc_tiempocompartido
    ADD CONSTRAINT pc_tc_s_restaurante_fk FOREIGN KEY ( idrestaurante )
        REFERENCES s_restaurante ( idrestaurante );

ALTER TABLE pc_todoincluido
    ADD CONSTRAINT pc_ti_producto_fk FOREIGN KEY ( idproducto )
        REFERENCES producto ( idproducto );

ALTER TABLE pc_todoincluido
    ADD CONSTRAINT pc_ti_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva );

ALTER TABLE pc_todoincluido
    ADD CONSTRAINT pc_ti_s_restaurante_fk FOREIGN KEY ( idrestaurante )
        REFERENCES s_restaurante ( idrestaurante );

ALTER TABLE producto
    ADD CONSTRAINT producto_producto_id_fk FOREIGN KEY ( idproducto )
        REFERENCES producto_id ( idproducto );

ALTER TABLE producto
    ADD CONSTRAINT producto_s_bar_fk FOREIGN KEY ( idbar )
        REFERENCES s_bar ( idbar );

ALTER TABLE producto
    ADD CONSTRAINT producto_s_restaurante_fk FOREIGN KEY ( idrestaurante )
        REFERENCES s_restaurante ( idrestaurante );

ALTER TABLE producto
    ADD CONSTRAINT producto_s_supermercado_fk FOREIGN KEY ( idsupermercado )
        REFERENCES s_supermercado ( idsupermercado );

ALTER TABLE producto
    ADD CONSTRAINT producto_s_tienda_fk FOREIGN KEY ( idtienda )
        REFERENCES s_tienda ( idtienda );

ALTER TABLE recepcionista
    ADD CONSTRAINT recepcio_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE recepcionista
    ADD CONSTRAINT recepcion_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente );

ALTER TABLE recepcionista
    ADD CONSTRAINT recepcionista_admindata_fk FOREIGN KEY ( idrecepcionista )
        REFERENCES administradordatos ( numerodocumento );

ALTER TABLE recepcionista_id
    ADD CONSTRAINT recepcionista_id_admindata_fk FOREIGN KEY ( idrecepcion )
        REFERENCES administradordatos ( numerodocumento );

ALTER TABLE recepcionista
    ADD CONSTRAINT recepcionista_reserva_fk FOREIGN KEY ( idreserva )
        REFERENCES reserva ( idreserva );

ALTER TABLE reserva
    ADD CONSTRAINT reserva_pc_fk FOREIGN KEY ( idplanconsumo )
        REFERENCES planconsumo ( idplanconsumo );

ALTER TABLE s_bar
    ADD CONSTRAINT s_bar_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_bar
    ADD CONSTRAINT s_bar_s_bar_id_fk FOREIGN KEY ( idbar )
        REFERENCES s_bar_id ( idbar );

ALTER TABLE s_gym
    ADD CONSTRAINT s_gym_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_gym
    ADD CONSTRAINT s_gym_s_gym_id_fk FOREIGN KEY ( idgym )
        REFERENCES s_gym_id ( idgym );

ALTER TABLE s_lavanderia
    ADD CONSTRAINT s_lavan_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_lavanderia
    ADD CONSTRAINT s_lavan_s_lavan_id_fk FOREIGN KEY ( idlavanderia )
        REFERENCES s_lavanderia_id ( idlavanderia );

ALTER TABLE s_piscina
    ADD CONSTRAINT s_piscina_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_piscina
    ADD CONSTRAINT s_piscina_s_id_piscina_fk FOREIGN KEY ( idpiscina )
        REFERENCES s_piscina_id ( idpiscina );

ALTER TABLE s_prestamoutencilios
    ADD CONSTRAINT s_pu_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_prestamoutencilios
    ADD CONSTRAINT s_pu_s_pu_id_fk FOREIGN KEY ( idprestamoutencilios )
        REFERENCES s_prestamoutencilios_id ( idprestamoutencilios );

ALTER TABLE s_restaurante
    ADD CONSTRAINT s_rest_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_restaurante
    ADD CONSTRAINT s_rest_s_rest_id_fk FOREIGN KEY ( idrestaurante )
        REFERENCES s_restaurante_id ( idrestaurante );

ALTER TABLE s_salon
    ADD CONSTRAINT s_salon_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente );

ALTER TABLE s_salon
    ADD CONSTRAINT s_salon_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_salon
    ADD CONSTRAINT s_salon_s_salon_id_fk FOREIGN KEY ( idsalon )
        REFERENCES s_salon_id ( idsalon );

ALTER TABLE s_spa
    ADD CONSTRAINT s_spa_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente );

ALTER TABLE s_spa
    ADD CONSTRAINT s_spa_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_spa
    ADD CONSTRAINT s_spa_s_spa_id_fk FOREIGN KEY ( idspa )
        REFERENCES s_spa_id ( idspa );

ALTER TABLE s_supermercado
    ADD CONSTRAINT s_super_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_supermercado
    ADD CONSTRAINT s_super_s_super_id_fk FOREIGN KEY ( idsupermercado )
        REFERENCES s_supermercado_id ( idsupermercado );

ALTER TABLE s_tienda
    ADD CONSTRAINT s_tienda_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_tienda
    ADD CONSTRAINT s_tienda_s_tienda_id_fk FOREIGN KEY ( idtienda )
        REFERENCES s_tienda_id ( idtienda );

ALTER TABLE s_internet
    ADD CONSTRAINT s_wifi_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE s_internet
    ADD CONSTRAINT s_wifi_s_wifi_id_fk FOREIGN KEY ( idinternet )
        REFERENCES s_internet_id ( idinternet );

ALTER TABLE servicio
    ADD CONSTRAINT servicio_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente );

ALTER TABLE servicio
    ADD CONSTRAINT servicio_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_cliente_fk FOREIGN KEY ( idcliente )
        REFERENCES cliente ( numerodocumentocliente );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_bar_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_bar ( idbar );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_gym_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_gym ( idgym );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_internet_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_internet ( idinternet );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_lavanderia_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_lavanderia ( idlavanderia );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_piscina_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_piscina ( idpiscina );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_pu_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_prestamoutencilios ( idprestamoutencilios );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_restaurante_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_restaurante ( idrestaurante );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_salon_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_salon ( idsalon );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_spa_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_spa ( idspa );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_supermercado_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_supermercado ( idsupermercado );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_s_tienda_fk FOREIGN KEY ( idespecifico )
        REFERENCES s_tienda ( idtienda );

ALTER TABLE servicioxcliente
    ADD CONSTRAINT sxc_servicio_fk FOREIGN KEY ( idservicio )
        REFERENCES servicio ( idservicio );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_hotel_fk FOREIGN KEY ( idhotel )
        REFERENCES hotel ( idhotel );




COMMIT;