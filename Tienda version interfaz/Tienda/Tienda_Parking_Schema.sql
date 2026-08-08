-- Script para crear las tablas de la base de datos Tienda_Parking

-- 1. Tabla para Choferes
CREATE TABLE IF NOT EXISTS chofer (
    cedula VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    licencia VARCHAR(50) NOT NULL
);

-- 2. Tabla para Pasajeros
CREATE TABLE IF NOT EXISTS pasajero (
    cedula VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL
);

-- 3. Tabla para Carros
CREATE TABLE IF NOT EXISTS carro (
    placa VARCHAR(20) PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL
);

-- 4. Tabla para Motores
CREATE TABLE IF NOT EXISTS motor (
    numero_serie VARCHAR(50) PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    cilindraje INT NOT NULL
);

-- 5. Tabla para Viajes (Registro)
CREATE TABLE IF NOT EXISTS viaje (
    id_viaje INT AUTO_INCREMENT PRIMARY KEY,
    placa_carro VARCHAR(20) NOT NULL,
    serie_motor VARCHAR(50) NOT NULL,
    cedula_chofer VARCHAR(20) NOT NULL,
    cedula_pasajero VARCHAR(20) NOT NULL,
    FOREIGN KEY (placa_carro) REFERENCES carro(placa) ON DELETE CASCADE,
    FOREIGN KEY (serie_motor) REFERENCES motor(numero_serie) ON DELETE CASCADE,
    FOREIGN KEY (cedula_chofer) REFERENCES chofer(cedula) ON DELETE CASCADE,
    FOREIGN KEY (cedula_pasajero) REFERENCES pasajero(cedula) ON DELETE CASCADE
);
