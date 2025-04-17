
DELIMITER $$

CREATE PROCEDURE SPD_INSERTA_CALIFICACION
(
    IN IntIdMateria INT,
    IN IntIdUsuario INT,
    IN FloatCalificacion FLOAT
)
BEGIN

    UPDATE tbl_insc_alumnos
    set ncalificación = FloatCalificacion
    WHERE nid_horario_materia = IntIdMateria
    AND nid_usuario  = IntIdUsuario;

END

DELIMITER ;