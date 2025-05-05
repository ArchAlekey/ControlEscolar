
DELIMITER $$

CREATE Procedure SPD_CONSULTA_DATOS_PERSONALES
(
    in IntIdPersona INT
)
BEGIN

    SELECT
        nid_persona,
        cnombre,
        capellidos,
        bsexo,
        nedad,
        dfecha_nacimiento,
        `cCURP`,
        `cRFC`,
        cnumero_celular,
        ccorreo_institucional,
        ccorreo_personal
    FROM(
        SELECT
            tp.nid_persona,
            tp.cnombre,
            tp.capellidos,
            tp.bsexo,
            tp.nedad,
            tp.dfecha_nacimiento,
            tp.`cCURP`,
            tp.`cRFC`,
            tp.cnumero_celular,
            taad.ccorreo_institucional,
            taad.ccorreo_personal
        FROM tbl_personas as tp
        inner join tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
        inner join tbl_academicos_admin as taad on tp.nid_persona = taad.nid_persona
        inner join cat_categorias as caca on taad.nid_categoria = caca.nid_categoria

        UNION ALL

        SELECT 
            tp.nid_persona,
            tp.cnombre,
            tp.capellidos,
            tp.bsexo,
            tp.nedad,
            tp.dfecha_nacimiento,
            tp.`cCURP`,
            tp.`cRFC`,
            tp.cnumero_celular,
            taal.ccorreo_institucional,
            taal.ccorreo_personal
        FROM tbl_personas as tp
        inner join tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
        inner join tbl_academicos_alumnos as taal on tp.nid_persona = taal.nid_persona
        inner join cat_categorias as caca on taal.nid_categoria = caca.nid_categoria

        UNION ALL

        SELECT 
            tp.nid_persona,
            tp.cnombre,
            tp.capellidos,
            tp.bsexo,
            tp.nedad,
            tp.dfecha_nacimiento,
            tp.`cCURP`,
            tp.`cRFC`,
            tp.cnumero_celular,
            tapr.ccorreo_institucional,
            tapr.ccorreo_personal
        FROM tbl_personas as tp
        inner join tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
        inner join tbl_academicos_profesores as tapr on tp.nid_persona = tapr.nid_persona
        inner join cat_categorias as caca on tapr.nid_categoria = caca.nid_categoria

        UNION ALL

        SELECT 
            tp.nid_persona,
            tp.cnombre,
            tp.capellidos,
            tp.bsexo,
            tp.nedad,
            tp.dfecha_nacimiento,
            tp.`cCURP`,
            tp.`cRFC`,
            tp.cnumero_celular,
            tasu.ccorreo_institucional,
            tasu.ccorreo_personal
        FROM tbl_personas as tp
        inner join tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
        inner join tbl_academicos_super_us as tasu on tp.nid_persona = tasu.nid_persona
        inner join cat_categorias as caca on tasu.nid_categoria = caca.nid_categoria
    ) as DatosPersonales
    WHERE nid_persona = IntIdPersona;

END $$

DELIMITER ;