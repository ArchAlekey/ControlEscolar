DELIMITER $$

CREATE PROCEDURE SPD_CONSULTA_USUARIO
(
    IN StrUsuario VARCHAR(12),
    IN StrContraseña VARCHAR(16)
)
BEGIN
    -- Hashear la contraseña ingresada
    SET @StrContraseña = SHA2(StrContraseña, 256);

    -- Validar si el usuario y la contraseña coinciden
    SELECT * 
    FROM tbl_usuarios
    WHERE cusuario = CONVERT(StrUsuario USING utf8mb4)
    AND ccontraseña = @StrContraseña COLLATE utf8mb4_unicode_ci;

    -- Si el SELECT no devuelve resultados, el usuario o la contraseña no son correctos
    IF (ROW_COUNT() = 0) THEN
        SELECT 0 AS mensaje;
    ELSE
        SELECT 1 AS mensaje;
    END IF;

END $$

DELIMITER ;