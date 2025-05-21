DELIMITER $$

CREATE PROCEDURE SPD_ASIGNAR_PROFESOR_MATERIA (
    IN p_nid_carrera INT,
    IN p_nid_periodo INT,
    IN p_nid_semestre INT,
    IN p_nid_grupo INT,
    IN p_nid_academico_profesor INT,
    IN p_nid_horario INT,
    IN p_nid_materia INT,
    OUT p_codigo_resultado INT
)
BEGIN
    DECLARE v_existente INT DEFAULT 0;

    -- Buscar si ya existe la asignación activa
    SELECT COUNT(*) INTO v_existente
    FROM tbl_horario_materias
    WHERE nid_carrera = p_nid_carrera
      AND nid_periodo = p_nid_periodo
      AND nid_semestre = p_nid_semestre
      AND nid_grupo = p_nid_grupo
      AND nid_horario = p_nid_horario
      AND nid_materia = p_nid_materia
      AND bhabilitado = 1;

    IF v_existente = 0 THEN
        -- INSERTAR nueva asignación
        INSERT INTO tbl_horario_materias (
            nid_carrera,
            nid_periodo,
            nid_semestre,
            nid_grupo,
            nid_academico_profesor,
            nid_horario,
            nid_materia,
            bhabilitado,
            dfecha_alta,
            dfecha_baja
        ) VALUES (
            p_nid_carrera,
            p_nid_periodo,
            p_nid_semestre,
            p_nid_grupo,
            p_nid_academico_profesor,
            p_nid_horario,
            p_nid_materia,
            1,
            CURDATE(),
            NULL
        );
        SET p_codigo_resultado = 1; -- Nuevo insertado
    ELSE
        -- ACTUALIZAR la asignación existente
        UPDATE tbl_horario_materias
        SET nid_academico_profesor = p_nid_academico_profesor,
            dfecha_alta = CURDATE(),
            dfecha_baja = NULL,
            bhabilitado = 1
        WHERE nid_carrera = p_nid_carrera
          AND nid_periodo = p_nid_periodo
          AND nid_semestre = p_nid_semestre
          AND nid_grupo = p_nid_grupo
          AND nid_horario = p_nid_horario
          AND nid_materia = p_nid_materia
          AND bhabilitado = 1;

        IF ROW_COUNT() > 0 THEN
            SET p_codigo_resultado = 2; -- Actualización exitosa
        ELSE
            SET p_codigo_resultado = 0; -- Error: no se pudo actualizar
        END IF;
    END IF;
END $$

DELIMITER ;
