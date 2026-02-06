CREATE TABLE clientes(
    codigo INT,
    dni VARCHAR(9),
    apellidos VARCHAR(35),
    nombre VARCHAR(15),
    direccion VARCHAR(40),
    codigo_postal VARCHAR(5),
    localidad VARCHAR(20),
    telefono VARCHAR(9),
    movil VARCHAR(9),
    fax VARCHAR(9),
    email VARCHAR(20),
    total FLOAT
);

CREATE TABLE proveedores(
    codigo INT,
    dni VARCHAR(9),
    apellidos VARCHAR(35),
    nombre VARCHAR(15),
    direccion VARCHAR(40),
    codigo_postal VARCHAR(5),
    localidad VARCHAR(20),
    telefono VARCHAR(9),
    movil VARCHAR(9),
    fax VARCHAR(9),
    email VARCHAR(20),
    total FLOAT
);

CREATE TABLE articulos(
    codigo INT,
    descripcion VARCHAR(25),
    stock FLOAT,
    stock_minimo FLOAT,
    stock_maximo FLOAT,
    precio_venta FLOAT,
    precio_compra FLOAT
);

-- =====================================
-- 10 INSERTS FOR CLIENTES (ID: 10001-10010) - FIXED EMAILS ≤20 chars
-- =====================================
INSERT INTO clientes VALUES (10001, '12345678A', 'García López', 'Juan', 'Calle Mayor 123', '28001', 'Madrid', '915123456', '699123456', '915123457', 'juan.garcia@email.com', 1250.50);
INSERT INTO clientes VALUES (10002, '87654321B', 'Martínez Pérez', 'María', 'Avenida Principal 45', '28002', 'Madrid', '914567890', '699456789', '914567891', 'maria@email.com', 890.75);
INSERT INTO clientes VALUES (10003, '11223344C', 'Rodríguez Gómez', 'Carlos', 'Plaza España 12', '28003', 'Madrid', '917890123', '699789012', NULL, 'carlos@email.com', 2345.00);
INSERT INTO clientes VALUES (10004, '55667788D', 'Fernández Ruiz', 'Ana', 'Calle Gran Vía 67', '28004', 'Madrid', '913456789', '699111222', '913456790', 'ana@email.com', 1678.25);
INSERT INTO clientes VALUES (10005, '99887766E', 'López Sánchez', 'Pedro', 'Paseo Castellana 89', '28005', 'Madrid', '912345678', '699333444', NULL, 'pedro@email.com', 2100.99);
INSERT INTO clientes VALUES (10006, '44332211F', 'González Díaz', 'Laura', 'Calle Alcalá 234', '28006', 'Madrid', '911234567', '699555666', '911234568', 'laura@email.com', 1456.80);
INSERT INTO clientes VALUES (10007, '66778899G', 'Hernández Torres', 'Miguel', 'Avenida América 56', '28007', 'Madrid', '910987654', '699777888', NULL, 'miguel@email.com', 1890.30);
INSERT INTO clientes VALUES (10008, '33445566H', 'Pérez Morales', 'Sofía', 'Calle Serrano 78', '28008', 'Madrid', '919876543', '699999000', '919876544', 'sofia@email.com', 2789.45);
INSERT INTO clientes VALUES (10009, '88990011I', 'Romero Castillo', 'David', 'Plaza Mayor 34', '28009', 'Madrid', '918765432', '699222333', NULL, 'david@email.com', 1567.90);
INSERT INTO clientes VALUES (10010, '22110033J', 'Vázquez Ortega', 'Elena', 'Calle Fuencarral 90', '28010', 'Madrid', '916543210', '699444555', '916543211', 'elena@email.com', 1987.60);

-- =====================================
-- 10 INSERTS FOR PROVEEDORES (ID: 20001-20010) - FIXED EMAILS ≤20 chars
-- =====================================
INSERT INTO proveedores VALUES (20001, '11111111A', 'Industrias ABC SL', 'Comercial', 'Polígono Industrial 1', '28901', 'Getafe', '912345678', '699123456', '912345679', 'info@abc.com', 45000.00);
INSERT INTO proveedores VALUES (20002, '22222222B', 'Materiales XYZ SA', 'Ventas', 'Calle Factoria 45', '28902', 'Leganés', '913456789', '699234567', '913456790', 'ventas@xyz.com', 32000.75);
INSERT INTO proveedores VALUES (20003, '33333333C', 'Electrónica DEF SL', 'Logística', 'Avenida Industrial 12', '28903', 'Alcorcón', '914567890', '699345678', NULL, 'log@def.com', 27890.50);
INSERT INTO proveedores VALUES (20004, '44444444D', 'Herramientas GHI SA', 'Compras', 'Polígono Norte 67', '28904', 'Fuenlabrada', '915678901', '699456789', '915678902', 'compra@ghi.com', 38500.25);
INSERT INTO proveedores VALUES (20005, '55555555E', 'Papeleria JKL SL', 'Administración', 'Calle Comercio 23', '28905', 'Móstoles', '916789012', '699567890', NULL, 'admin@jkl.com', 15600.80);
INSERT INTO proveedores VALUES (20006, '66666666F', 'Muebles MNO SA', 'Export', 'Avenida Empresas 89', '28906', 'Parla', '917890123', '699678901', '917890124', 'export@mno.com', 42000.90);
INSERT INTO proveedores VALUES (20007, '77777777G', 'Químicos PQR SL', 'Técnico', 'Polígono Sur 34', '28907', 'Pinto', '918901234', '699789012', NULL, 'tec@pqr.com', 29876.35);
INSERT INTO proveedores VALUES (20008, '88888888H', 'Textiles STU SA', 'Finanzas', 'Calle Textil 56', '28908', 'Griñón', '919012345', '699890123', '919012346', 'fin@stu.com', 24500.00);
INSERT INTO proveedores VALUES (20009, '99999999I', 'Plásticos VWX SL', 'Producción', 'Zona Industrial 78', '28909', 'Valdemoro', '910123456', '699901234', NULL, 'prod@vwx.com', 36789.75);
INSERT INTO proveedores VALUES (20010, '00000000J', 'Madera YZA SA', 'Calidad', 'Camino Madera 12', '28910', 'Aranjuez', '911234567', '699012345', '911234568', 'cal@yza.com', 18900.20);

-- =====================================
-- 10 INSERTS FOR ARTICULOS (ID: 30001-30010)
-- =====================================
INSERT INTO articulos VALUES (30001, 'Portatil Dell XPS13', 25, 5, 50, 1299.99, 950.00);
INSERT INTO articulos VALUES (30002, 'Teclado Mecánico RGB', 150, 20, 200, 89.50, 65.00);
INSERT INTO articulos VALUES (30003, 'Ratón Logitech MX', 80, 10, 100, 79.90, 58.00);
INSERT INTO articulos VALUES (30004, 'Monitor 27" 4K', 12, 2, 20, 399.00, 285.00);
INSERT INTO articulos VALUES (30005, 'SSD 1TB NVMe', 45, 8, 60, 129.00, 95.00);
INSERT INTO articulos VALUES (30006, 'Cable HDMI 2m', 300, 50, 500, 9.99, 6.50);
INSERT INTO articulos VALUES (30007, 'Webcam HD 1080p', 35, 5, 50, 69.90, 52.00);
INSERT INTO articulos VALUES (30008, 'Altavoz Bluetooth', 60, 10, 80, 49.50, 36.00);
INSERT INTO articulos VALUES (30009, 'Batería Externa 20k', 22, 3, 30, 39.99, 28.00);
INSERT INTO articulos VALUES (30010, 'Fundas Laptop 15"', 120, 15, 150, 19.90, 14.00


