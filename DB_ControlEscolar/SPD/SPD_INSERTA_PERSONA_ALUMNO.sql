
DELIMITER $$

CREATE PROCEDURE SPD_INSERTA_PERSONA_ALUMNO
(
    IN StrNombre VARCHAR(50),
    IN StrApellidos VARCHAR(50),
    IN BitSexo BIT,
    IN IntEdad INT,
    IN DateFechaNacimiento DATE,
    IN StrCURP VARCHAR(18),
    IN StrRFC VARCHAR(13),
    IN StrNumeroCelular VARCHAR(10),

    /* IN IntIdCategoria int, */
    IN IntIdCarrera int,
    IN StrContrasenia VARCHAR(16)
)
BEGIN
    INSERT INTO tbl_personas(cnombre, capellidos, bsexo, nedad, dfecha_nacimiento, `cCURP`, `cRFC`, cnumero_celular, bhabilitado, dfecha_alta)
    VALUES
    (StrNombre, StrApellidos, BitSexo, IntEdad, DateFechaNacimiento, StrCURP, StrRFC, StrNumeroCelular, 1, NOW());

    SET @nid_persona = LAST_INSERT_ID();

    SET @NumCuenta = CONCAT('10', SUBSTRING(StrCURP, 1, 10));

    INSERT INTO tbl_academicos_alumnos(nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, bhabilitado, dfecha_alta)
    VALUES
    (@nid_persona , 1, IntIdCarrera, @NumCuenta , CONCAT(@NumCuenta , '@controlescolar.com'), 1, NOW());

    INSERT INTO tbl_usuarios(nid_persona, cusuario, ccontrasenia, bhabilitado, dfecha_alta)
    VALUES
    (@nid_persona , @NumCuenta , SHA2(StrContrasenia, 256), 1, NOW());
END $$

DELIMITER ;

