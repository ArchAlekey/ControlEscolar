-- Active: 1737221727660@@127.0.0.1@3306@controlescolar
CREATE DATABASE ControlEscolar;

Use ControlEscolar;

-- Aquí comienzan las tablas de tipos catálogo
CREATE TABLE `cat_carreras` (
  `nid_carrera` int AUTO_INCREMENT PRIMARY KEY,
  `ccarrera` varchar(50) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date
);

CREATE TABLE `cat_materias` (
  `nid_materia` int AUTO_INCREMENT PRIMARY KEY,
  `nid_carrera` int NOT NULL,
  `nid_semestre` int NOT NULL,  
  `cnombre_materia` varchar(50) NOT NULL,
  `cclave_materia` varchar(10) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  Foreign Key (nid_carrera) REFERENCES cat_carreras(nid_carrera),
  Foreign Key (nid_semestre) REFERENCES cat_semestres(nid_semestre)
);

CREATE TABLE `cat_semestres` (
  `nid_semestre` int AUTO_INCREMENT PRIMARY KEY,
  `nsemestre` int NOT NULL,
  `bpar_impar` bit NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date
);

CREATE TABLE `cat_profesores` (
  `nid_profesor` int AUTO_INCREMENT PRIMARY KEY,
  `cnombre_profesor` varchar(100) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date
);

CREATE TABLE `cat_grupos` (
  `nid_grupo` int AUTO_INCREMENT PRIMARY KEY,
  `cgrupo` varchar(4) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date
);

CREATE TABLE `cat_periodos` (
  `nid_periodo` int AUTO_INCREMENT PRIMARY KEY,
  `cperiodo` varchar(50) NOT NULL,
  `canio` varchar(4) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date
);

CREATE TABLE `cat_horarios` (
  `nid_horario` int AUTO_INCREMENT PRIMARY KEY,
  `chorario` varchar(20) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date
);

CREATE TABLE `cat_perfiles` (
  `nid_perfil` int AUTO_INCREMENT PRIMARY KEY,
  `cperfil` varchar(25) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date
);

CREATE TABLE `cat_categorias`(
    `nid_categoria` int AUTO_INCREMENT PRIMARY KEY,
    `ccategoria` VARCHAR(25) NOT NULL,
    `bhabilitado` bit NOT NULL,
    `dfecha_alta` date NOT NULL,
    `dfecha_baja` date
);

-- Hasta aca son las tablas de tipo catálogo
-- Aquí comienzas las tablas de registro

CREATE TABLE `tbl_personas` (
  `nid_persona` int AUTO_INCREMENT PRIMARY KEY,
  `cnombre` varchar(50) NOT NULL,
  `capellidos` varchar(50) NOT NULL,
  `bsexo` numeric NOT NULL,
  `nedad` int NOT NULL,
  `dfecha_nacimiento` date NOT NULL,
  `cCURP` varchar(18) NOT NULL,
  `cRFC` varchar(13) NOT NULL,
  `cnumero_celular` varchar(10) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date
);

CREATE TABLE `tbl_academicos` (
  `nid_academico` int AUTO_INCREMENT PRIMARY KEY,
  `nid_persona` int NOT NULL,
  `nid_categoria` int NOT NULL,
  `nid_carrera` int NOT NULL,
  `cnumero_cuenta` varchar(9) UNIQUE NOT NULL,
  `ccorreo_institucional` varchar(50) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  Foreign Key (nid_persona) REFERENCES tbl_personas(`nid_persona`),
  Foreign Key (nid_categoria) REFERENCES cat_categorias(`nid_categoria`),
  Foreign Key (nid_carrera) REFERENCES cat_carreras(`nid_carrera`)
);

CREATE TABLE `tbl_usuarios` (
  `nid_usuario` int AUTO_INCREMENT PRIMARY KEY,
  `nid_academico` int NOT NULL,
  `nid_perfil` int NOT NULL,
  `cusuario` varchar(9) NOT NULL,
  `ccontraseña` varchar(50) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  Foreign Key (nid_academico) REFERENCES tbl_academicos(nid_academico),
  Foreign Key (nid_perfil) REFERENCES cat_perfiles(nid_perfil)
);

CREATE TABLE `tbl_inscripcion` (
  `nid_inscripcion` int AUTO_INCREMENT PRIMARY KEY,
  `nid_academico` int NOT NULL,
  `nid_periodo` int NOT NULL,
  `nid_semestre` int NOT NULL,
  `nid_materia` int NOT NULL,
  `nid_grupo` int NOT NULL,
  `nid_profesor` int NOT NULL,
  `nid_horario` int NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  Foreign Key (nid_academico) REFERENCES tbl_academicos(`nid_academico`),
  Foreign Key (nid_periodo) REFERENCES cat_periodos(`nid_periodo`),
  Foreign Key (nid_semestre) REFERENCES cat_semestres(`nid_semestre`),
  Foreign Key (nid_materia) REFERENCES cat_materias(`nid_materia`),
  Foreign Key (nid_grupo) REFERENCES cat_grupos(`nid_grupo`),
  Foreign Key (nid_profesor) REFERENCES cat_profesores(`nid_profesor`),
  Foreign Key (nid_horario) REFERENCES cat_horarios(`nid_horario`)
);


CREATE TABLE `tbl_calificaciones` (
  `nid_calificación` int AUTO_INCREMENT PRIMARY KEY,
  `nid_inscripcion` int NOT NULL,
  `nid_usuario` int NOT NULL,
  `ncalificación` decimal(2,2) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  Foreign Key (nid_inscripcion) REFERENCES tbl_inscripcion(`nid_inscripcion`),
  Foreign Key (nid_usuario) REFERENCES tbl_usuarios(`nid_usuario`)
);

CREATE TABLE `tbl_historial_acaedmico` (
  `nid_historial_academico` int AUTO_INCREMENT PRIMARY KEY,
  `nid_calificación` int NOT NULL,
  `npromedio` decimal(2,2) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  Foreign Key (nid_calificación) REFERENCES tbl_calificaciones(`nid_calificación`)
);



