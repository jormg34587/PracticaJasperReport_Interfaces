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