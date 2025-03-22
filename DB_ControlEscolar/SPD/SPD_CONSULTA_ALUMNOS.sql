SELECT
    CONCAT(tp.cnombre, ' ', tp.capellidos) as Nombre,
    ccat.ccategoria as Categoria,
    taal.cnumero_cuenta as Numero_Cuenta,
    taal.ccorreo_institucional as Correo_Institucional,
    ccar.ccarrera as Carrera
from tbl_personas as tp
inner join tbl_academicos_alumnos as taal on tp.nid_persona = taal.nid_persona
INNER join cat_carreras as ccar on taal.nid_carrera = ccar.nid_carrera
inner join cat_categorias as ccat on taal.nid_categoria = ccat.nid_categoria
where tp.cnombre LIKE '%%';

SELECT
    CONCAT(tp.cnombre, ' ', tp.capellidos) as Nombre,
    ccat.ccategoria as Categoria,
    taal.cnumero_cuenta as Numero_Cuenta,
    taal.ccorreo_institucional as Correo_Institucional,
    ccar.ccarrera as Carrera
from tbl_personas as tp
inner join tbl_academicos_profesores as taal on tp.nid_persona = taal.nid_persona
INNER join cat_carreras as ccar on taal.nid_carrera = ccar.nid_carrera
inner join cat_categorias as ccat on taal.nid_categoria = ccat.nid_categoria
where tp.cnombre LIKE '%%';