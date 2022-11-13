/**
 * Author:  Anderson Londoño
 * Created: 9 nov. 2022
 */

CREATE DATABASE softwareSeguro_RH;
USE softwareSeguro_RH;

CREATE TABLE parentesco (
id int primary key auto_increment,
nombre varchar(40) not null,
descripcion varchar(40)
);

CREATE TABLE estado (
id int primary key auto_increment,
nombre varchar(40) not null
);

CREATE TABLE nivel (
id int primary key auto_increment,
nombre varchar(40) not null
);


CREATE TABLE universidad (
id int primary key auto_increment,
nombre varchar(40) not null,
descripcion varchar(40),
ciudad varchar(40),
fecha_creacion datetime,
fecha_actualizacion datetime
);

CREATE TABLE tipo_identificacion (
id int primary key auto_increment,
nombre varchar(40) not null,
descripcion varchar(40)
);

CREATE TABLE estado_civil (
id int primary key auto_increment,
nombre varchar(40) not null,
descripcion varchar(40)
);

CREATE TABLE grupo_familiar (
id int primary key auto_increment,
nombres varchar(40) not null,
apellidos varchar(40) not null,
direccion varchar(40),
parentesco int,
fecha_creacion datetime,
fecha_actualizacion datetime,
constraint fk_parentesco foreign key(parentesco) references parentesco(id)
);

CREATE TABLE funcionarios (
numero_identificacion int primary key,
tipo_identificacion int,
nombres varchar(40) not null,
apellidos varchar(40) not null,
estado_civil int,
sexo varchar(40),
direccion varchar(40),
telefono varchar(40),
fecha_nacimiento date,
fecha_creacion datetime,
fecha_actualizacion datetime,
constraint fk_tipo_identificacion foreign key(tipo_identificacion) references tipo_identificacion(id),
constraint fk_estado_civil foreign key(estado_civil) references estado_civil(id)
);

CREATE TABLE formacion_academica (
id int primary key auto_increment,
fecha_inicio date,
fecha_final date,
estado int,
nivel int,
fecha_creacion datetime,
fecha_actualizacion datetime,
universidad int,
funcionario int,
constraint fk_estado foreign key(estado) references estado(id),
constraint fk_nivel foreign key(nivel) references nivel(id),
constraint fk_universidad foreign key(universidad) references universidad(id),
constraint fk_funcionario foreign key(funcionario) references funcionarios(numero_identificacion)
);

insert into tipo_identificacion (nombre, descripcion) values ('CC','Cedula de Ciudadania');
insert into tipo_identificacion (nombre, descripcion) values ('RC','Registro Civil');
insert into tipo_identificacion (nombre, descripcion) values ('CE','Cedula Extranjeria');
insert into tipo_identificacion (nombre, descripcion) values ('TI','Tarjeta de Identidad');

insert into estado_civil (nombre, descripcion) values ('Soltero/a','Esta libre');
insert into estado_civil (nombre, descripcion) values ('Union Libre','Ya lo van atrapando');
insert into estado_civil (nombre, descripcion) values ('Casado/a','Lo atraparon');
insert into estado_civil (nombre, descripcion) values ('Viudo/a','Volvio al ruedo');

insert into funcionarios (numero_identificacion,tipo_identificacion,nombres, apellidos, estado_civil,sexo,direccion,telefono,fecha_creacion,fecha_actualizacion) 
values (101719,1,'Anderson','Londoño Valencia',2,'Masculino','Cr 66BB ', '311622',localtime(),localtime());