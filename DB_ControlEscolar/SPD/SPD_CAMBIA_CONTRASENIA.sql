DELIMITER $$

CREATE PROCEDURE SPD_CAMBIA_CONTRASENIA
(
    IN IntIdUsuario INT,
    IN StrContrasenia VARCHAR(16)
)
begin

    set @StrContrasenia = SHA2(StrContrasenia, 256);

    UPDATE tbl_usuarios
    SET ccontrasenia = @StrContrasenia, bstatus_contrasenia = 1
    where nid_usuario = IntIdUsuario;

end;

DELIMITER ;
