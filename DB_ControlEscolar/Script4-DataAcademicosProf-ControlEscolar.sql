-- Active: 1741838627681@@127.0.0.1@3306@db_onepiece
use bnowsdq3ly9belvfnnac;

-- Academicos profesores de MAC
INSERT INTO tbl_academicos_profesores (nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, bhabilitado, dfecha_alta)
VALUES
(1, 2, 1, '20GOPC79031', '20GOPC79031@controlescolar.com', 1, NOW()),
(2, 2, 1, '20LORM86072', '20LORM86072@controlescolar.com', 1, NOW()),
(3, 2, 1, '20MATJ74011', '20MATJ74011@controlescolar.com', 1, NOW()),
(4, 2, 1, '20RUCF83091', '20RUCF83091@controlescolar.com', 1, NOW()),
(5, 2, 1, '20HESA89052', '20HESA89052@controlescolar.com', 1, NOW()),
(6, 2, 1, '20DIHS82081', '20DIHS82081@controlescolar.com', 1, NOW()),
(7, 2, 1, '20PEGI76110', '20PEGI76110@controlescolar.com', 1, NOW()),
(8, 2, 1, '20GAMA85043', '20GAMA85043@controlescolar.com', 1, NOW()),
(9, 2, 1, '20NAFJ87062', '20NAFJ87062@controlescolar.com', 1, NOW()),
(10, 2, 1, '20ORVP90120', '20ORVP90120@controlescolar.com', 1, NOW()),
(11, 2, 1, '20ROLM78071', '20ROLM78071@controlescolar.com', 1, NOW()),
(12, 2, 1, '20HETV84091', '20HETV84091@controlescolar.com', 1, NOW());

-- Academicos profesores de Filosofía
INSERT INTO tbl_academicos_profesores (nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, bhabilitado, dfecha_alta)
VALUES
(13, 2, 2, '20ALCM74021', '20ALCM74021@controlescolar.com', 1, NOW()),
(14, 2, 2, '20CAMB85062', '20CAMB85062@controlescolar.com', 1, NOW()),
(15, 2, 2, '20GOEF79091', '20GOEF79091@controlescolar.com', 1, NOW()),
(16, 2, 2, '20PEMA82033', '20PEMA82033@controlescolar.com', 1, NOW()),
(17, 2, 2, '20MARS76110', '20MARS76110@controlescolar.com', 1, NOW()),
(18, 2, 2, '20HEOL84081', '20HEOL84081@controlescolar.com', 1, NOW()),
(19, 2, 2, '20DOVR77012', '20DOVR77012@controlescolar.com', 1, NOW()),
(20, 2, 2, '20ORZC86101', '20ORZC86101@controlescolar.com', 1, NOW()),
(21, 2, 2, '20SAHA75051', '20SAHA75051@controlescolar.com', 1, NOW()),
(22, 2, 2, '20VETG87120', '20VETG87120@controlescolar.com', 1, NOW()),
(23, 2, 2, '20NASU80071', '20NASU80071@controlescolar.com', 1, NOW()),
(24, 2, 2, '20FUMP83041', '20FUMP83041@controlescolar.com', 1, NOW());



SELECT
    CONCAT(tp.cnombre, ' ', tp.capellidos) as nombre,
    ccat.ccategoria,
    tap.cnumero_cuenta,
    tap.ccorreo_institucional,
    ccar.ccarrera
FROM tbl_personas as tp
inner join tbl_academicos_profesores as tap on tp.nid_persona = tap.nid_persona
inner join cat_categorias as ccat on tap.nid_categoria = ccat.nid_categoria
inner join cat_carreras as ccar on tap.nid_carrera = ccar.nid_carrera;

