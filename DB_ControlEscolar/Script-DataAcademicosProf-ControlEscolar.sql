
Insert into tbl_academicos_profesores(nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, bhabilitado, dfecha_alta)
VALUES
(1, 2, 1, '200790315', '200790315@controlescolar.com', 1, NOW()),
(2, 2, 1, '200860722', '200860722@controlescolar.com', 1, NOW()),
(3, 2, 1, '200740110', '200740110@controlescolar.com', 1, NOW()),
(4, 2, 1, '200830918', '200830918@controlescolar.com', 1, NOW()),
(5, 2, 1, '200890527', '200890527@controlescolar.com', 1, NOW()),
(6, 2, 1, '200820814', '200820814@controlescolar.com', 1, NOW()),
(7, 2, 1, '200761105', '200761105@controlescolar.com', 1, NOW()),
(8, 2, 1, '200850430', '200850430@controlescolar.com', 1, NOW()),
(9, 2, 1, '200870621', '200870621@controlescolar.com', 1, NOW()),
(10, 2, 1, '200901202', '200901202@controlescolar.com', 1, NOW()),
(11, 2, 1, '200780713', '200780713@controlescolar.com', 1, NOW()),
(12, 2, 1, '200840919', '200840919@controlescolar.com', 1, NOW());


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