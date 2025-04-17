DELIMITER $$

CREATE PROCEDURE SPD_ACTUALIZA_DATOS_PERSONAL
(
    IN IntIdPersona INT,
    IN StrNombre VARCHAR(50),
    IN StrApellidos VARCHAR(50),
    IN BitSexo BIT,
    IN IntEdad INT,
    IN DateFechaNacimiento DATE,
    IN StrCURP VARCHAR(18),
    IN StrRFC VARCHAR(13),
    IN StrNumeroCelular VARCHAR(10)
)
BEGIN

    UPDATE tbl_personas
    SET
        cnombre = IF(StrNombre IS NULL OR StrNombre = '', cnombre, StrNombre),
        capellidos = IF(StrApellidos IS NULL OR StrApellidos = '', capellidos, StrApellidos),
        bsexo = IF(BitSexo IS NULL, bsexo, BitSexo), /* Importante, este campo debe indicarse que es un parametro nulo */
        nedad = IF(IntEdad IS NULL, nedad, IntEdad), /* Importante, este campo debe indicarse que es un parametro nulo */
        dfecha_nacimiento = IF(DateFechaNacimiento IS NULL, dfecha_nacimiento, DateFechaNacimiento), /* Importante, este campo debe indicarse que es un parametro nulo */
        cCURP = IF(StrCURP IS NULL OR StrCURP = '', cCURP, StrCURP),
        cRFC = IF(StrRFC IS NULL OR StrRFC = '', cRFC, StrRFC),
        cnumero_celular = IF(StrNumeroCelular IS NULL OR StrNumeroCelular = '', cnumero_celular, StrNumeroCelular)
    WHERE nid_persona = IntIdPersona;

END$$

DELIMITER ;

