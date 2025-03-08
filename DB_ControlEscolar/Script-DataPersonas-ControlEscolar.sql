
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

