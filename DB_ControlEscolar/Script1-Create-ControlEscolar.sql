-- Active: 1737221727660@@127.0.0.1@3306@el_milagro
/* DROP DATABASE db_onepiece; */
CREATE DATABASE db_onepiece;
-- Use bnowsdq3ly9belvfnnac;
Use db_onepiece;
-- Aquí comienzan las tablas de tipos catálogo

CREATE TABLE `cat_carreras` (
  `nid_carrera` int AUTO_INCREMENT PRIMARY KEY,
  `ccarrera` varchar(50) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date
);

CREATE TABLE `cat_semestres` (
  `nid_semestre` int AUTO_INCREMENT PRIMARY KEY,
  `nsemestre` int NOT NULL,
  `bpar_impar` bit NOT NULL,
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
  `bsexo` BIT NOT NULL,
  `nedad` int NOT NULL,
  `dfecha_nacimiento` date NOT NULL,
  `cCURP` varchar(18) NOT NULL,
  `cRFC` varchar(13) NOT NULL,
  `cnumero_celular` varchar(10) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date
);

CREATE TABLE `tbl_academicos_alumnos` (
  `nid_academico_alumno` int AUTO_INCREMENT PRIMARY KEY,
  `nid_persona` int NOT NULL,
  `nid_categoria` int NOT NULL,
  `nid_carrera` int NOT NULL,
  `cnumero_cuenta` varchar(12) UNIQUE NOT NULL,
  `ccorreo_institucional` varchar(50) NOT NULL,
  `ccorreo_personal` VARCHAR(50) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  Foreign Key (nid_persona) REFERENCES tbl_personas(`nid_persona`),
  Foreign Key (nid_categoria) REFERENCES cat_categorias(`nid_categoria`),
  Foreign Key (nid_carrera) REFERENCES cat_carreras(`nid_carrera`)
);

CREATE TABLE `tbl_academicos_profesores` (
  `nid_academico_profesor` int AUTO_INCREMENT PRIMARY KEY,
  `nid_persona` int NOT NULL,
  `nid_categoria` int NOT NULL,
  `nid_carrera` int NOT NULL,
  `cnumero_cuenta` varchar(12) UNIQUE NOT NULL,
  `ccorreo_institucional` varchar(50) NOT NULL,
  `ccorreo_personal` VARCHAR(50) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  Foreign Key (nid_persona) REFERENCES tbl_personas(`nid_persona`),
  Foreign Key (nid_categoria) REFERENCES cat_categorias(`nid_categoria`),
  Foreign Key (nid_carrera) REFERENCES cat_carreras(`nid_carrera`)
);

CREATE TABLE `tbl_academicos_admin` (
  `nid_academico_admin` int AUTO_INCREMENT PRIMARY KEY,
  `nid_persona` int NOT NULL,
  `nid_categoria` int NOT NULL,
  `nid_carrera` int NOT NULL,
  `cnumero_cuenta` varchar(12) UNIQUE NOT NULL,
  `ccorreo_institucional` varchar(50) NOT NULL,
  `ccorreo_personal` VARCHAR(50) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  Foreign Key (nid_persona) REFERENCES tbl_personas(`nid_persona`),
  Foreign Key (nid_categoria) REFERENCES cat_categorias(`nid_categoria`),
  Foreign Key (nid_carrera) REFERENCES cat_carreras(`nid_carrera`)
);

CREATE TABLE `tbl_usuarios` (
  `nid_usuario` int AUTO_INCREMENT PRIMARY KEY,
  `nid_persona` int NOT NULL,
  `cusuario` varchar(12) NOT NULL,
  `ccontrasenia` varchar(100) NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  Foreign Key (nid_persona) REFERENCES tbl_personas(nid_persona)
);

CREATE TABLE `tbl_horario_materias` (
  `nid_horario_materia` int AUTO_INCREMENT PRIMARY KEY,
  `nid_carrera` INT not NULL,
  `nid_periodo` int NOT NULL,
  `nid_semestre` int NOT NULL,
  `nid_grupo` int NOT NULL,
  `nid_academico_profesor` int NOT NULL,
  `nid_horario` int NOT NULL,
  `nid_materia` int NOT NULL,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,
  
  Foreign Key (nid_periodo) REFERENCES cat_periodos(`nid_periodo`),
  Foreign Key (nid_semestre) REFERENCES cat_semestres(`nid_semestre`),
  Foreign Key (nid_grupo) REFERENCES cat_grupos(`nid_grupo`),
  Foreign Key (nid_academico_profesor) REFERENCES tbl_academicos_profesores(nid_academico_profesor),
  Foreign Key (nid_horario) REFERENCES cat_horarios(`nid_horario`),
  Foreign Key (nid_materia) REFERENCES cat_materias(`nid_materia`)
);

CREATE TABLE `tbl_insc_alumnos`(
  nid_insc_alumno INT AUTO_INCREMENT PRIMARY KEY,
  nid_horario_materia INT NOT NULL,
  nid_usuario int NOT NULL,
  ncalificación FLOAT NULL DEFAULT 0,
  `bhabilitado` bit NOT NULL,
  `dfecha_alta` date NOT NULL,
  `dfecha_baja` date,

  Foreign Key (nid_horario_materia) REFERENCES tbl_horario_materias(nid_horario_materia),
  Foreign Key (nid_usuario) REFERENCES tbl_usuarios(nid_usuario)
);
