DELIMITER $$

CREATE PROCEDURE SPD_CONSULTA_GRUPOS_ASIGNADOS
(
    IN IntIdAcademicoProfesor INT
)
BEGIN

    SELECT
        DISTINCT
            /* thm.nid_horario_materia, */
            cagr.nid_grupo,
            cagr.cgrupo,
            cama.nid_materia,
            cama.cnombre_materia,
            cama.cclave_materia,
            cape.cperiodo,
            caho.chorario
    FROM tbl_horario_materias as thm
    inner join cat_periodos as                  cape on thm.nid_periodo = cape.nid_periodo
    inner join cat_grupos as                    cagr on thm.nid_grupo = cagr.nid_grupo
    inner join tbl_academicos_profesores as     tapr on thm.nid_academico_profesor = tapr.nid_academico_profesor
    inner join cat_horarios as                  caho on thm.nid_horario = caho.nid_horario
    inner join cat_materias as                  cama on thm.nid_materia = cama.nid_materia 
    where thm.nid_academico_profesor = IntIdAcademicoProfesor;

END $$

DELIMITER ;