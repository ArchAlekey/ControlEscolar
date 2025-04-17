
DELIMITER $$

CREATE Procedure SPD_CONSULTA_CALIFICACIONES
(
    IN IntIdUsuario INT
)
BEGIN

    SELECT
        cama.cnombre_materia as Materia,
        cama.cclave_materia as Clave,
        tia.ncalificación as Calificacion,
        cape.cperiodo as Periodo,
        cagr.cgrupo as Grupo
    FROM tbl_insc_alumnos as tia
    inner join tbl_horario_materias as thm on tia.nid_horario_materia = thm.nid_horario_materia
    inner join tbl_academicos_profesores as tapr on thm.nid_academico_profesor = tapr.nid_academico_profesor
    inner join tbl_personas as tp on tapr.nid_persona = tp.nid_persona
    inner join cat_materias as cama on thm.nid_materia = cama.nid_materia
    inner join cat_periodos as cape on thm.nid_periodo = cape.nid_periodo
    inner join cat_grupos as cagr on thm.nid_grupo = cagr.nid_grupo
    where tia.nid_usuario = IntIdUsuario;

END

DELIMITER ;