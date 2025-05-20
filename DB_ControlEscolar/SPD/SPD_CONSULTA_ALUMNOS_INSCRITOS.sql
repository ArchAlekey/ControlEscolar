
DELIMITER $$

CREATE PROCEDURE SPD_CONSULTA_ALUMNOS_INSCRITOS
(
    IN IntIdGrupo INT,
    IN IntIdMateria INT
)
BEGIN

    Select
        DISTINCT 
            tu.nid_usuario,
            thm.nid_horario_materia,
            thm.nid_grupo,
            thm.nid_materia,
            CONCAT(tp.cnombre, ' ', tp.capellidos) as Nombre,
            taal.cnumero_cuenta as 'Numero de cuenta',
            tia.ncalificación,
            taal.ccorreo_institucional as 'Correo Institucional',
            taal.ccorreo_personal as 'Correo Personal'
    FROM tbl_insc_alumnos as tia 
    inner join tbl_horario_materias as thm on tia.nid_horario_materia = thm.nid_horario_materia
    inner join tbl_usuarios as tu on tia.nid_usuario = tu.nid_usuario
    inner join tbl_personas as tp on tu.nid_persona = tp.nid_persona
    inner join tbl_academicos_alumnos as taal on tp.nid_persona = taal.nid_persona
    where thm.nid_grupo = IntIdGrupo
    and thm.nid_materia = IntIdMateria;

END $$

DELIMITER ;
