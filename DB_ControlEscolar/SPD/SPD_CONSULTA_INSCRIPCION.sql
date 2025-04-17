
DELIMITER $$

CREATE PROCEDURE SPD_CONSULTA_INSCRIPCION
(
    IN IntIdUsuario INT
)
BEGIN

        SELECT
            cma.cnombre_materia,
            cma.cclave_materia,
            cca.ccarrera,
            cgr.cgrupo,
            CONCAT(tp.cnombre, ' ', tp.capellidos) as profesor,
            tap.ccorreo_institucional,
            cho.chorario
        from tbl_insc_alumnos as tia
        inner join tbl_horario_materias as thm on tia.nid_horario_materia = thm.nid_horario_materia
        INNER JOIN cat_carreras as cca on thm.nid_carrera = cca.nid_carrera
        INNER JOIN cat_periodos as cpe ON thm.nid_periodo = cpe.nid_periodo
        inner join cat_semestres as cse on thm.nid_semestre = cse.nid_semestre
        inner join cat_grupos as cgr on thm.nid_grupo = cgr.nid_grupo
        INNER JOIN tbl_academicos_profesores as tap on thm.nid_academico_profesor = tap.nid_academico_profesor
        inner join tbl_personas as tp on tap.nid_persona = tp.nid_persona
        INNER JOIN cat_horarios as cho on thm.nid_horario = cho.nid_horario
        inner join cat_materias as cma on thm.nid_materia = cma.nid_materia
        where tia.nid_usuario = IntIdUsuario;

END

DELIMITER ;