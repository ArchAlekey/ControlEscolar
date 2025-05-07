DELIMITER $$

CREATE PROCEDURE SPD_CONS_USUARIO
(
    IN StrUsuario VARCHAR(12),
    IN StrContrasenia VARCHAR(16)
)
BEGIN
    -- Hashear la contraseña ingresada
    SET @StrContrasenia = SHA2(StrContrasenia, 256);

    -- Validar si el usuario y la contraseña coinciden
    SELECT
        nid_persona,
        nid_usuario,
        cusuario,
        -- ccontrasenia,
        nid_categoria
    FROM(
        SELECT
            tp.nid_persona,
            tu.nid_usuario,
            tu.cusuario,
            tu.ccontrasenia,
            caca.nid_categoria
        FROM tbl_personas as tp
        inner join tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
        inner join tbl_academicos_admin as taad on tp.nid_persona = taad.nid_persona
        inner join cat_categorias as caca on taad.nid_categoria = caca.nid_categoria

        UNION ALL

        SELECT
            tp.nid_persona, 
            tu.nid_usuario,
            tu.cusuario,
            tu.ccontrasenia,
            caca.nid_categoria
        FROM tbl_personas as tp
        inner join tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
        inner join tbl_academicos_alumnos as taal on tp.nid_persona = taal.nid_persona
        inner join cat_categorias as caca on taal.nid_categoria = caca.nid_categoria

        UNION ALL

        SELECT
            tp.nid_persona, 
            tu.nid_usuario,
            tu.cusuario,
            tu.ccontrasenia,
            caca.nid_categoria
        FROM tbl_personas as tp
        inner join tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
        inner join tbl_academicos_profesores as tapr on tp.nid_persona = tapr.nid_persona
        inner join cat_categorias as caca on tapr.nid_categoria = caca.nid_categoria

        UNION ALL

        SELECT
            tp.nid_persona, 
            tu.nid_usuario,
            tu.cusuario,
            tu.ccontrasenia,
            caca.nid_categoria
        FROM tbl_personas as tp
        inner join tbl_usuarios as tu on tp.nid_persona = tu.nid_persona
        inner join tbl_academicos_super_us as tasu on tp.nid_persona = tasu.nid_persona
        inner join cat_categorias as caca on tasu.nid_categoria = caca.nid_categoria
    ) as login
    WHERE cusuario = CONVERT(StrUsuario USING utf8mb4)
    and ccontrasenia = @StrContrasenia COLLATE utf8mb4_unicode_ci;
 

END $$

DELIMITER ;



/* SELECT
    cusuario,
    ccontrasenia
FROM tbl_usuarios
WHERE cusuario = CONVERT(StrUsuario USING utf8mb4)
AND ccontrasenia = @StrContrasenia COLLATE utf8mb4_unicode_ci; */