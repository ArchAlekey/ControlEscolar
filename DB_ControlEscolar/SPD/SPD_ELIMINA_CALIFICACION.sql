DELIMITER $$

CREATE Procedure SPD_ELIMINA_CALIFICACION
(
    IN IntIdMateria INT,
    IN IntIdUsuario INT
)
BEGIN

    UPDATE tbl_insc_alumnos
    set ncalificación = 0
    WHERE nid_horario_materia = IntIdMateria
    AND nid_usuario  = IntIdUsuario;

END $$

DELIMITER ;