INSERT INTO usuario(id, nombre, num_tarjeta, pin, saldo) VALUES (1, 'Miguel', '112719483CV', '2234', 13);
INSERT INTO usuario(id, nombre, num_tarjeta, pin, saldo) VALUES (2, 'Javier', '112339483CV', '8234', 40);
INSERT INTO usuario(id, nombre, num_tarjeta, pin, saldo) VALUES (3, 'Manolo', '112319283CV', '9234', 20);
INSERT INTO usuario(id, nombre, num_tarjeta, pin, saldo) VALUES (4, 'Jacinto', '112319443CV', '2534', 5);
INSERT INTO usuario(id, nombre, num_tarjeta, pin, saldo) VALUES (5, 'Estuardo', '112519483CV', '1234', 89);
INSERT INTO usuario(id, nombre, num_tarjeta, pin, saldo) VALUES (6, 'Luis', '412319483CV', '4234', 21);
INSERT INTO usuario(id, nombre, num_tarjeta, pin, saldo) VALUES (7, 'Gonzalo', '112319483CV', '2734', 33);

ALTER SEQUENCE usuario_seq RESTART WITH 57;

INSERT INTO estacion(id, numero, nombre, coordenadas, capacidad) VALUES (1, '1241A', 'Estacion 1', '-1.23124, -4.2124115', 15);
INSERT INTO estacion(id, numero, nombre, coordenadas, capacidad) VALUES (2, '4241A', 'Estacion 2', '1.23124, -4.2124115', 15);
INSERT INTO estacion(id, numero, nombre, coordenadas, capacidad) VALUES (3, '3241A', 'Estacion 3', '-5.23124, 6.1124115', 15);
INSERT INTO estacion(id, numero, nombre, coordenadas, capacidad) VALUES (4, '2241A', 'Estacion 4', '-1.23124, 9.2124115', 15);

ALTER SEQUENCE estacion_seq RESTART WITH 54;

INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (1, 'La mejor 1', 'Estandar', 'Nueva', 1);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (2, 'La mejor 2', 'Estandar', 'Nueva', 1);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (3, 'La mejor 3', 'Estandar', 'Nueva', 1);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (4, 'La mejor 4', 'Estandar', 'Nueva', 1);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (5, 'La mejor 5', 'Estandar', 'Nueva', 1);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (6, 'La mejor 6', 'Estandar', 'Nueva', 1);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (7, 'La mejor 7', 'Estandar', 'Nueva', 1);

INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (8, 'La mejor 8', 'Estandar', 'Nueva', 2);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (9, 'La mejor 9', 'Estandar', 'Nueva', 2);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (10, 'La mejor 10', 'Estandar', 'Nueva', 2);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (11, 'La mejor 11', 'Estandar', 'Nueva', 2);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (12, 'La mejor 12', 'Estandar', 'Nueva', 2);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (13, 'La mejor 13', 'Estandar', 'Nueva', 2);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (14, 'La mejor 14', 'Estandar', 'Nueva', 2);

INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (15, 'La mejor 15', 'Estandar', 'Nueva', 3);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (16, 'La mejor 16', 'Estandar', 'Nueva', 3);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (17, 'La mejor 17', 'Estandar', 'Nueva', 3);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (18, 'La mejor 18', 'Estandar', 'Nueva', 3);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (19, 'La mejor 19', 'Estandar', 'Nueva', 3);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (20, 'La mejor 20', 'Estandar', 'Nueva', 3);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (21, 'La mejor 21', 'Estandar', 'Nueva', 3);

INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (22, 'La mejor 22', 'Estandar', 'Nueva', 4);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (23, 'La mejor 23', 'Estandar', 'Nueva', 4);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (24, 'La mejor 24', 'Estandar', 'Nueva', 4);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (25, 'La mejor 25', 'Estandar', 'Nueva', 4);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (26, 'La mejor 26', 'Estandar', 'Nueva', 4);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (27, 'La mejor 27', 'Estandar', 'Nueva', 4);
INSERT INTO bicicleta(id, marca, modelo, estado, estacion_id) VALUES (28, 'La mejor 28', 'Estandar', 'Nueva', 4);

ALTER SEQUENCE bicicleta_seq RESTART WITH 78;


