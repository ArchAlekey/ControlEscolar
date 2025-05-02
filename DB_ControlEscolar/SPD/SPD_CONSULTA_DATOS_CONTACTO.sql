DELIMITER $$

CREATE PROCEDURE SPD_CONSULTA_DATOS_CONTACTO
(
    in IntIdPersona INT
)
BEGIN

    SELECT 
        nid_persona, ccorreo_institucional, ccorreo_personal
    FROM (
        SELECT nid_persona, ccorreo_institucional, ccorreo_personal FROM
        tbl_academicos_alumnos

        UNION ALL

        SELECT nid_persona, ccorreo_institucional, ccorreo_personal FROM
        tbl_academicos_profesores

        UNION ALL

        SELECT nid_persona, ccorreo_institucional, ccorreo_personal FROM
        tbl_academicos_admin
    ) as contacto
    WHERE nid_persona = IntIdPersona;

END $$

DELIMITER ;