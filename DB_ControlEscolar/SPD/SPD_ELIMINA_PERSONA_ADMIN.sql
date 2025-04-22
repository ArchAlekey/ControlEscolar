DELIMITER $$
CREATE PROCEDURE SPD_ELIMINA_PERSONA_ADMIN(
    IN IntIdPersona INT
)
BEGIN
    DELETE FROM tbl_usuarios
    WHERE (nid_persona = IntIdPersona);

    DELETE FROM tbl_academicos_admin  
    WHERE (nid_persona = IntIdPersona);

    DELETE FROM  tbl_personas
    WHERE (nid_persona = IntIdPersona);

END
DELIMITER ;
