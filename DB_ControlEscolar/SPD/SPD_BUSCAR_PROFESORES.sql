DELIMITER $$

CREATE PROCEDURE SPD_BUSCAR_PROFESORES(
    IN textoBusqueda VARCHAR(255)
)
BEGIN
SELECT 
        ap.nid_academico_profesor,
        p.cnombre,
        p.capellidos,
        ap.cnumero_cuenta,
        ap.bhabilitado
    FROM 
        tbl_academicos_profesores ap
    JOIN 
        tbl_personas p ON ap.nid_persona = p.nid_persona
    WHERE 
        p.cnombre LIKE CONCAT('%', textoBusqueda, '%')
        OR p.capellidos LIKE CONCAT('%', textoBusqueda, '%')
        OR ap.cnumero_cuenta LIKE CONCAT('%', textoBusqueda, '%');
END$$

DELIMITER ;
