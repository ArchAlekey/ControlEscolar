
DELIMITER $$

CREATE Procedure SPD_INSERTA_INSCRIPCION
(
    IN IntIdUSuario INT,
    IN IntIdGrupo INT
)
BEGIN

    Insert into tbl_insc_alumnos(nid_horario_materia, nid_usuario, bhabilitado, dfecha_alta)
        SELECT
            nid_horario_materia, IntIdUSuario, 1, now()
        FROM tbl_horario_materias
        where nid_grupo = IntIdGrupo;

END

DELIMITER;