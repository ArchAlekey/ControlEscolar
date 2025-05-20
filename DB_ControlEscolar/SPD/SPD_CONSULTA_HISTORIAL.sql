DELIMITER $$

CREATE PROCEDURE SPD_CONSULTA_HISTORIAL
(
    IN IntIdUsuario INT
)
BEGIN
    SELECT
    tia.nid_insc_alumno,
    thm.nid_horario_materia,
    cama.cnombre_materia,
    cama.cclave_materia,
    tia.ncalificación,
    casem.nsemestre,
    cape.cperiodo,
    cape.canio
    from tbl_insc_alumnos as tia
    inner join tbl_horario_materias as thm on tia.nid_horario_materia = thm.nid_horario_materia
    inner join cat_materias as cama on thm.nid_materia = cama.nid_materia
    inner join cat_periodos as cape on thm.nid_periodo = cape.nid_periodo
    inner join cat_semestres as casem on thm.nid_semestre = casem.nid_semestre
    WHERE nid_usuario = IntIdUsuario;

END $$

DELIMITER ;