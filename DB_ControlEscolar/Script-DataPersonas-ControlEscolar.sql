
show TABLES;
-- Insert para personas
INSERT INTO tbl_personas(cnombre, capellidos, bsexo, nedad, dfecha_nacimiento, `cCURP`, `cRFC`, cnumero_celular, bhabilitado, dfecha_alta)
VALUES  ('Alejandro', 'Hernández Rodríguez', 1, 24, '20010219', 'HERA010219HDFRDLA0', 'HERA010219', '5622068728', 1, NOW())
        ('Mariana', 'López García', 2, 22, '2002-07-15', 'LOGM020715MDFPRLA2', 'LOGM020715', '5512345678', 1, NOW()),
        ('Carlos', 'Martínez Gómez', 1, 27, '1997-05-30', 'MAGC970530HDFRRN07', 'MAGC970530', '5539876543', 1, NOW()),
        ('Fernanda', 'Ruiz Torres', 2, 21, '2003-09-10', 'RUTF030910MDFPRL08', 'RUTF030910', '5587654321', 1, NOW()),
        ('Javier', 'Pérez Domínguez', 1, 23, '2001-12-05', 'PEDJ011205HDFRNL04', 'PEDJ011205', '5611122233', 1, NOW());

-- Inerta para academicos alumnos
INSERT INTO tbl_academicos_alumnos(nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, bhabilitado, dfecha_alta)
VALUES  (1, 1, 1, '100010219', '100010219@controlescolar.com', 1, NOW()),
        (2, 1, 2, '100020715', '100020715@controlescolar.com', 1, NOW());

-- Inerta para academicos profesores
INSERT INTO tbl_academicos_profesores(nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, bhabilitado, dfecha_alta)
VALUES  (3, 2, 1, '200970530', '200970530@controlescolar.com', 1, NOW()),
        (4, 2, 2, '200030910', '200030910@controlescolar.com', 1, NOW());

-- Inserta para academicos administrador

INSERT INTO tbl_academicos_admin(nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, bhabilitado, dfecha_alta)
VALUES  (5, 3, 1, '300011205', '300011205@controlescolar.com', 1, NOW());

SELECT tp.cnombre, tp.`cCURP`, cc.ccategoria,taa.cnumero_cuenta, taa.ccorreo_institucional FROM tbl_personas as tp
INNER JOIN tbl_academicos_alumnos as taa on tp.nid_persona = taa.nid_persona
INNER JOIN cat_categorias as cc on taa.nid_categoria = cc.nid_categoria

UNION ALL

SELECT tp.cnombre, tp.`cCURP`, cc.ccategoria,tap.cnumero_cuenta, tap.ccorreo_institucional from tbl_personas as tp
INNER JOIN tbl_academicos_profesores as tap on tp.nid_persona = tap.nid_persona
INNER JOIN cat_categorias as cc on tap.nid_categoria = cc.nid_categoria

UNION ALL

SELECT tp.cnombre, tp.`cCURP`, cc.ccategoria,taad.cnumero_cuenta, taad.ccorreo_institucional FROM tbl_personas as tp
INNER JOIN tbl_academicos_admin as taad on tp.nid_persona = taad.nid_persona
INNER JOIN cat_categorias as cc on taad.nid_categoria = cc.nid_categoria;

INSERT INTO tbl_usuarios(nid_persona, cusuario, ccontraseña, bhabilitado, dfecha_alta)
VALUES  (1, '100010219', '123', 1, NOW()),
        (2, '100020715', '123', 1, NOW()),
        (3, '200970530', '123', 1, NOW()),
        (4, '200030910', '123', 1, NOW()),
        (5, '300011205', '123', 1, NOW());

SELECT 
    tp.cnombre, 
    tp.`cCURP`, 
    cc.ccategoria,
    taa.cnumero_cuenta, 
    taa.ccorreo_institucional, 
    tu.cusuario as Usuario, 
    tu.ccontraseña as Contraseña FROM tbl_personas as tp
INNER JOIN tbl_academicos_alumnos as taa on tp.nid_persona = taa.nid_persona
INNER JOIN tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
INNER JOIN cat_categorias as cc on taa.nid_categoria = cc.nid_categoria

UNION ALL

SELECT 
    tp.cnombre, 
    tp.`cCURP`, 
    cc.ccategoria,
    tap.cnumero_cuenta, 
    tap.ccorreo_institucional ,
    tu.cusuario as Usuario,
    tu.ccontraseña as Contraseña
from tbl_personas as tp
INNER JOIN tbl_academicos_profesores as tap on tp.nid_persona = tap.nid_persona
INNER JOIN tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
INNER JOIN cat_categorias as cc on tap.nid_categoria = cc.nid_categoria

UNION ALL

SELECT 
    tp.cnombre, 
    tp.`cCURP`, 
    cc.ccategoria,
    taad.cnumero_cuenta, 
    taad.ccorreo_institucional ,
    tu.cusuario as Usuario,
    tu.ccontraseña as Contraseña
FROM tbl_personas as tp
INNER JOIN tbl_academicos_admin as taad on tp.nid_persona = taad.nid_persona
INNER JOIN tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
INNER JOIN cat_categorias as cc on taad.nid_categoria = cc.nid_categoria;

-- Inserta personas que son profesores de MAC
INSERT INTO tbl_personas (cnombre, capellidos, bsexo, nedad, dfecha_nacimiento, cCURP, cRFC, cnumero_celular, bhabilitado, dfecha_alta)
VALUES  
('Carlos', 'González Pérez', 1, 45, '1979-03-15', 'GOPC790315HDFTRC01', 'GOPC790315', '5541234567', 1, NOW()),
('María', 'López Ramírez', 0, 38, '1986-07-22', 'LORM860722MDFTRZ02', 'LORM860722', '5532345678', 1, NOW()),
('Javier', 'Martínez Torres', 1, 50, '1974-01-10', 'MATJ740110HDFRNR03', 'MATJ740110', '5523456789', 1, NOW()),
('Fernanda', 'Ruiz Castro', 0, 41, '1983-09-18', 'RUCF830918MDFTRL04', 'RUCF830918', '5512345678', 1, NOW()),
('Alejandro', 'Hernández Soto', 1, 35, '1989-05-27', 'HESA890527HDFRNL05', 'HESA890527', '5567890123', 1, NOW()),
('Sofía', 'Díaz Herrera', 0, 42, '1982-08-14', 'DIHS820814MDFTRL06', 'DIHS820814', '5556789012', 1, NOW()),
('Ricardo', 'Pérez Gómez', 1, 48, '1976-11-05', 'PEGI761105HDFRNL07', 'PEGI761105', '5535678901', 1, NOW()),
('Andrea', 'García Montes', 0, 39, '1985-04-30', 'GAMA850430MDFTRL08', 'GAMA850430', '5598765432', 1, NOW()),
('Juan', 'Navarro Fernández', 1, 37, '1987-06-21', 'NAFJ870621HDFRNR09', 'NAFJ870621', '5520987654', 1, NOW()),
('Paula', 'Ortega Velasco', 0, 34, '1990-12-02', 'ORVP901202MDFTRL10', 'ORVP901202', '5567893456', 1, NOW()),
('Manuel', 'Rojas Luna', 1, 46, '1978-07-13', 'ROLM780713HDFRNR11', 'ROLM780713', '5545678912', 1, NOW()),
('Valeria', 'Hernández Tovar', 0, 40, '1984-09-19', 'HETV840919MDFTRL12', 'HETV840919', '5534567890', 1, NOW());

-- Inserta para Filosofía 
INSERT INTO tbl_personas (cnombre, capellidos, bsexo, nedad, dfecha_nacimiento, cCURP, cRFC, cnumero_celular, bhabilitado, dfecha_alta)
VALUES  
('Miguel', 'Álvarez Cervantes', 1, 50, '1974-02-10', 'ALCM740210HDFTRN01', 'ALCM740210', '5541122233', 1, NOW()),
('Beatriz', 'Campos Morales', 0, 39, '1985-06-22', 'CAMB850622MDFTRC02', 'CAMB850622', '5556677889', 1, NOW()),
('Fernando', 'Gómez Estrada', 1, 45, '1979-09-15', 'GOEF790915HDFTRF03', 'GOEF790915', '5523456788', 1, NOW()),
('Ana', 'Pérez Medina', 0, 42, '1982-03-30', 'PEMA820330MDFTRA04', 'PEMA820330', '5567890125', 1, NOW()),
('Sergio', 'Martínez Rivas', 1, 48, '1976-11-05', 'MARS761105HDFTRS05', 'MARS761105', '5535678902', 1, NOW()),
('Laura', 'Hernández Olvera', 0, 40, '1984-08-14', 'HEOL840814MDFTRL06', 'HEOL840814', '5556789123', 1, NOW()),
('Roberto', 'Domínguez Vega', 1, 47, '1977-01-21', 'DOVR770121HDFTRR07', 'DOVR770121', '5522345679', 1, NOW()),
('Carmen', 'Ortega Zúñiga', 0, 38, '1986-10-12', 'ORZC861012MDFTRC08', 'ORZC861012', '5598765433', 1, NOW()),
('Alfredo', 'Salinas Herrera', 1, 49, '1975-05-18', 'SAHA750518HDFTRA09', 'SAHA750518', '5567898765', 1, NOW()),
('Gloria', 'Velázquez Torres', 0, 37, '1987-12-08', 'VETG871208MDFTRG10', 'VETG871208', '5520986543', 1, NOW()),
('Eduardo', 'Navarro Suárez', 1, 44, '1980-07-11', 'NASU800711HDFTRE11', 'NASU800711', '5545678903', 1, NOW()),
('Patricia', 'Fuentes Moreno', 0, 41, '1983-04-19', 'FUMP830419MDFTRP12', 'FUMP830419', '5534567891', 1, NOW());

-- Inserta para Arquitectura
INSERT INTO tbl_personas (cnombre, capellidos, bsexo, nedad, dfecha_nacimiento, cCURP, cRFC, cnumero_celular, bhabilitado, dfecha_alta)
VALUES  
('Juan', 'Torres Méndez', 1, 52, '1972-03-15', 'TOMJ720315HDFTRN01', 'TOMJ720315', '5543216789', 1, NOW()),
('María', 'López Ramírez', 0, 45, '1979-07-23', 'LORM790723MDFTRC02', 'LORM790723', '5556789234', 1, NOW()),
('Carlos', 'Fernández Herrera', 1, 48, '1976-11-30', 'FEHC761130HDFTRF03', 'FEHC761130', '5523456789', 1, NOW()),
('Sofía', 'García Ortega', 0, 39, '1985-09-10', 'GAOS850910MDFTRS04', 'GAOS850910', '5567890345', 1, NOW()),
('Ricardo', 'Sánchez Rivas', 1, 50, '1974-05-18', 'SARV740518HDFTRR05', 'SARV740518', '5535678923', 1, NOW()),
('Elena', 'Castillo Pérez', 0, 42, '1982-12-22', 'CAPE821222MDFTRE06', 'CAPE821222', '5556789012', 1, NOW()),
('Javier', 'Mendoza Zúñiga', 1, 47, '1977-08-05', 'MEZJ770805HDFTRJ07', 'MEZJ770805', '5522345671', 1, NOW()),
('Gabriela', 'Navarro Ruiz', 0, 38, '1986-04-14', 'NARG860414MDFTRG08', 'NARG860414', '5598765439', 1, NOW()),
('Andrés', 'Hernández Salinas', 1, 49, '1975-01-29', 'HESA750129HDFTRA09', 'HESA750129', '5567898723', 1, NOW()),
('Paula', 'Ortega Velázquez', 0, 37, '1987-06-19', 'ORVP870619MDFTRP10', 'ORVP870619', '5520986548', 1, NOW()),
('David', 'Suárez Moreno', 1, 44, '1980-10-25', 'SUMD801025HDFTRE11', 'SUMD801025', '5545678912', 1, NOW()),
('Rosa', 'Fuentes Torres', 0, 41, '1983-02-08', 'FUTR830208MDFTRR12', 'FUTR830208', '5534567895', 1, NOW());

-- Inserta para medicina
INSERT INTO tbl_personas (cnombre, capellidos, bsexo, nedad, dfecha_nacimiento, cCURP, cRFC, cnumero_celular, bhabilitado, dfecha_alta)
VALUES  
('Alberto', 'Ramírez González', 1, 55, '1969-02-17', 'RAGA690217HDFTLA01', 'RAGA690217', '5541239876', 1, NOW()),
('Marta', 'Sánchez López', 0, 50, '1974-06-12', 'SALO740612MDFTRM02', 'SALO740612', '5557896543', 1, NOW()),
('José', 'Fernández Castro', 1, 48, '1976-09-25', 'FECA760925HDFTRJ03', 'FECA760925', '5523459871', 1, NOW()),
('Luisa', 'Ortiz Velasco', 0, 45, '1979-03-07', 'ORVL790307MDFTRL04', 'ORVL790307', '5567893456', 1, NOW()),
('Roberto', 'Gómez Herrera', 1, 52, '1972-12-19', 'GOHR721219HDFTRR05', 'GOHR721219', '5535672341', 1, NOW()),
('Elisa', 'Navarro Pérez', 0, 40, '1984-08-15', 'NAPE840815MDFTRE06', 'NAPE840815', '5556789078', 1, NOW()),
('Daniel', 'Mendoza Torres', 1, 49, '1975-11-03', 'METD751103HDFTRD07', 'METD751103', '5522398765', 1, NOW()),
('Gabriela', 'Castro Ruiz', 0, 41, '1983-05-20', 'CARU830520MDFTRG08', 'CARU830520', '5598760987', 1, NOW()),
('Alejandro', 'Hernández Salinas', 1, 54, '1970-07-09', 'HESA700709HDFTRA09', 'HESA700709', '5567895632', 1, NOW()),
('Patricia', 'Ortega Velázquez', 0, 42, '1982-01-29', 'ORVP820129MDFTRP10', 'ORVP820129', '5520987456', 1, NOW()),
('Héctor', 'Suárez Moreno', 1, 47, '1977-10-14', 'SUMH771014HDFTRE11', 'SUMH771014', '5545672389', 1, NOW()),
('Rosa', 'Fuentes Domínguez', 0, 44, '1980-04-05', 'FUDO800405MDFTRR12', 'FUDO800405', '5534567123', 1, NOW());
