use `bnowsdq3ly9belvfnnac`;

DELIMITER $$

CREATE PROCEDURE SPD_CONSULTA_USUARIO
(
    IN StrUsuario VARCHAR(12),
    IN StrContrasenia VARCHAR(16),
    OUT IntValidación INT
)
BEGIN
    -- Hashear la contraseña ingresada
    SET @StrContrasenia = SHA2(StrContrasenia, 256);

    -- Validar si el usuario y la contraseña coinciden
    SELECT * 
    FROM tbl_usuarios
    WHERE cusuario = CONVERT(StrUsuario USING utf8mb4)
    AND ccontrasenia = @StrContrasenia COLLATE utf8mb4_unicode_ci;

    -- Si el SELECT no devuelve resultados, el usuario o la contraseña no son correctos
   IF (ROW_COUNT() = 0) THEN
        SET IntValidación  = 0; -- Resultado Incorrecto
    ELSE
        SET IntValidación = 1; -- Resultado Correcto
    END IF;

END $$

DELIMITER ;
