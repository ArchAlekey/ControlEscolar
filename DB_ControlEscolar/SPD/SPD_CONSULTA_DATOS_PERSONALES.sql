
DELIMITER $$

CREATE Procedure SPD_CONSULTA_DATOS_PERSONALES
(
    in IntIdPersona INT
)
BEGIN

    SELECT
        CONCAT(cnombre, ' ', capellidos) as Nombre,
        bsexo,
        nedad,
        dfecha_nacimiento,
        `cCURP`,
        `cRFC`,
        cnumero_celular,
        dfecha_alta
    FROM tbl_personas
    WHERE nid_persona = IntIdPersona;

END

DELIMITER ;