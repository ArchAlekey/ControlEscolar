INSERT INTO tbl_horario_materias(nid_carrera, nid_periodo, nid_semestre, nid_grupo, nid_academico_profesor, nid_horario, nid_materia, bhabilitado, dfecha_alta)
VALUES
(1, 1, 1, 1, 1, 1, 1, 1, NOW()),
(1, 1, 1, 1, 2, 2, 2, 1, NOW()),
(1, 1, 1, 1, 3, 3, 3, 1, NOW()),
(1, 1, 1, 1, 4, 4, 4, 1, NOW());

INSERT INTO tbl_horario_materias(nid_carrera, nid_periodo, nid_semestre, nid_grupo, nid_academico_profesor, nid_horario, nid_materia, bhabilitado, dfecha_alta)
VALUES
(1, 1, 1, 2, 5, 4, 3, 1, NOW()),
(1, 1, 1, 2, 6, 5, 4, 1, NOW()),
(1, 1, 1, 2, 7, 6, 2, 1, NOW()),
(1, 1, 1, 2, 8, 7, 1, 1, NOW());

INSERT INTO tbl_horario_materias(nid_carrera, nid_periodo, nid_semestre, nid_grupo, nid_academico_profesor, nid_horario, nid_materia, bhabilitado, dfecha_alta)
VALUES
(1, 1, 1, 3, 9, 4, 1, 1, NOW()),
(1, 1, 1, 3, 10, 5, 2, 1, NOW()),
(1, 1, 1, 3, 11, 6, 3, 1, NOW()),
(1, 1, 1, 3, 12, 7, 4, 1, NOW());

INSERT INTO tbl_horario_materias(nid_carrera, nid_periodo, nid_semestre, nid_grupo, nid_academico_profesor, nid_horario, nid_materia, bhabilitado, dfecha_alta)
VALUES
(1, 1, 1, 4, 1, 1, 1, 1, NOW()),
(1, 1, 1, 4, 4, 2, 2, 1, NOW()),
(1, 1, 1, 4, 8, 3, 3, 1, NOW()),
(1, 1, 1, 4, 12, 4, 4, 1, NOW());


SELECT
    thm.nid_horario_materia,
    cma.cnombre_materia,
    cma.cclave_materia,
    cca.ccarrera,
    cpe.cperiodo,
    /* cse.nsemestre, */
    cgr.cgrupo,
    CONCAT(tp.cnombre, ' ', tp.capellidos) as profesor,
    tap.cnumero_cuenta,
    tap.ccorreo_institucional,
    cho.chorario
from tbl_horario_materias as thm
INNER JOIN cat_carreras as cca on thm.nid_carrera = cca.nid_carrera
INNER JOIN cat_periodos as cpe ON thm.nid_periodo = cpe.nid_periodo
inner join cat_semestres as cse on thm.nid_semestre = cse.nid_semestre
inner join cat_grupos as cgr on thm.nid_grupo = cgr.nid_grupo
INNER JOIN tbl_academicos_profesores as tap on thm.nid_academico_profesor = tap.nid_academico_profesor
inner join tbl_personas as tp on tap.nid_persona = tp.nid_persona
INNER JOIN cat_horarios as cho on thm.nid_horario = cho.nid_horario
inner join cat_materias as cma on thm.nid_materia = cma.nid_materia;


