
DELIMITER $$

CREATE PROCEDURE SPD_INSERTA_PERSONA_ADMIN
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
    IN StrCorreoPersonal VARCHAR(50)
    /* IN StrContrasenia VARCHAR(16) */
)
BEGIN
    INSERT INTO tbl_personas(cnombre, capellidos, bsexo, nedad, dfecha_nacimiento, `cCURP`, `cRFC`, cnumero_celular, bhabilitado, dfecha_alta)
    VALUES
    (StrNombre, StrApellidos, BitSexo, IntEdad, DateFechaNacimiento, StrCURP, StrRFC, StrNumeroCelular, 1, NOW());

    SET @nid_persona = LAST_INSERT_ID();

    SET @NumCuenta = CONCAT('30', SUBSTRING(StrCURP, 1, 10));

    INSERT INTO tbl_academicos_admin(nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, ccorreo_personal, bhabilitado, dfecha_alta)
    VALUES
    (@nid_persona , 3, IntIdCarrera, @NumCuenta , CONCAT(@NumCuenta , '@controlescolar.com'), StrCorreoPersonal, 1, NOW());

    INSERT INTO tbl_usuarios(nid_persona, cusuario, ccontrasenia, bstatus_contrasenia, bhabilitado, dfecha_alta)
    VALUES
    (@nid_persona , @NumCuenta , SHA2(@NumCuenta, 256), 0, 1, NOW());
END $$

DELIMITER ;
