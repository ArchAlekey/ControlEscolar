DELIMITER $$

CREATE PROCEDURE SPD_INSERTA_PERSONA_SISTEMAS
(
    IN StrNombre VARCHAR(50),
    IN StrApellidos VARCHAR(50),
    IN BitSexo BIT,
    IN IntEdad INT,
    IN DateFechaNacimiento DATE,
    IN StrCURP VARCHAR(18),
    IN StrRFC VARCHAR(13),
    IN StrNumeroCelular VARCHAR(10),

    IN IntIdCategoria int,
    IN IntIdCarrera int,
    IN StrContraseña VARCHAR(16)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Registro fallido' AS mensaje;
    END;

    SET StrRFC = IFNULL(NULLIF(TRIM(StrRFC), ''), 'SINRFC');

    START TRANSACTION;

    -- Insertar en tbl_personas
    INSERT INTO tbl_personas (cnombre, capellidos, bsexo, nedad, dfecha_nacimiento, cCURP, cRFC, cnumero_celular, bhabilitado, dfecha_alta)
    VALUES (StrNombre, StrApellidos, BitSexo, IntEdad, DateFechaNacimiento, StrCURP, StrRFC, StrNumeroCelular, 1, NOW());

    -- Obtener el último ID insertado
    SET @nid_persona = LAST_INSERT_ID();

    -- Generar el número de cuenta
    SET @NumCuenta = CONCAT('10', SUBSTRING(StrCURP, 1, 10));

    -- Insertar en tbl_academicos_alumnos o tbl_academicos_profesores o tbl_academicos_administradores
            IF IntIdCategoria = 1 THEN
                -- Categoría 1: Alumno
                INSERT INTO tbl_academicos_alumnos(nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, bhabilitado, dfecha_alta)
                VALUES (@nid_persona, 1, IntIdCarrera, @NumCuenta, CONCAT(@NumCuenta, '@controlescolar.com'), 1, NOW());
            ELSEIF IntIdCategoria = 2 THEN
                -- Categoría 2: Profesor
                INSERT INTO tbl_academicos_profesores(nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, bhabilitado, dfecha_alta)
                VALUES (@nid_persona, 2, IntIdCarrera, @NumCuenta, CONCAT(@NumCuenta, '@controlescolar.com'), 1, NOW());
            ELSEIF IntIdCategoria = 3 THEN
                -- Categoría 3: Administrador
                INSERT INTO tbl_academicos_admin(nid_persona, nid_categoria, nid_carrera, cnumero_cuenta, ccorreo_institucional, bhabilitado, dfecha_alta)
                VALUES (@nid_persona, 3, IntIdCarrera, @NumCuenta, CONCAT(@NumCuenta, '@controlescolar.com'), 1, NOW());
            END IF;

    -- Insertar en tbl_usuarios
    INSERT INTO tbl_usuarios(nid_persona, cusuario, ccontraseña, bhabilitado, dfecha_alta)
    VALUES (@nid_persona, @NumCuenta, SHA2(StrContraseña, 256), 1, NOW());

    COMMIT;

    SELECT 'Registro exitoso' AS mensaje;
END $$

DELIMITER ;
