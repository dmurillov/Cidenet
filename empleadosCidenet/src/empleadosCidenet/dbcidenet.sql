CREATE DATABASE dbCidenet;

CREATE TABLE Empleados 
(
Apellido varchar(20) NOT NULL,
SegundoApellido varchar(20) NOT NULL,
Nombre varchar(20) NOT NULL,
OtroNombre varchar(50),
Pais varchar(20) NOT NULL,
TipoId varchar(45) NOT NULL,
ID varchar(20) NOT NULL,
Correo varchar(300) NOT NULL,
FechaI date NOT NULL,
Area varchar(30) NOT NULL,
Estado varchar(10) NOT NULL,
FechaR date NOT NULL,
FechaE date,
PRIMARY KEY (ID)
);
