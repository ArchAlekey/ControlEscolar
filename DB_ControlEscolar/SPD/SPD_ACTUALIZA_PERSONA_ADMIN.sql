DELIMITER $$
CREATE PROCEDURE SPD_ACTUALIZA_PERSONA_ADMIN(
    IN IntIdPersona INT,  
    IN StrNombre VARCHAR(50),
    IN StrApellidos VARCHAR(50),
    IN BitSexo BIT,
    IN IntEdad INT,
    IN DateFechaNacimiento DATE,
    IN StrCURP VARCHAR(18),
    IN StrRFC VARCHAR(13),
    IN StrNumeroCelular VARCHAR(10),

    /* IN IntIdCategoria int, */
    IN IntIdCarrera int,
    IN StrContrasenia VARCHAR(16)
)
BEGIN
    UPDATE tbl_personas
    SET 
        nid_persona = IntIdPersona,
        cnombre = StrNombre, 
        capellidos = StrApellidos, 
        bsexo = BitSexo, 
        nedad = IntEdad,
        dfecha_nacimiento = DateFechaNacimiento, 
        cCURP = StrCURP, 
        cRFC = StrRFC, 
        cnumero_celular = StrNumeroCelular, 
        bhabilitado = 1, 
        dfecha_alta = NOW()

    WHERE (nid_persona = IntIdPersona);


    UPDATE tbl_academicos_admin  
    SET 
        nid_persona = IntIdPersona,
        nid_categoria =  3,
        nid_carrera = IntIdCarrera, 
        cnumero_cuenta = CONCAT('30', SUBSTRING(StrCURP, 1, 10)),
        ccorreo_institucional =  CONCAT(CONCAT('30', SUBSTRING(StrCURP, 1, 10)), '@controlescolar.com'), 
        bhabilitado = 1, 
        dfecha_alta = NOW()

    WHERE (nid_persona = IntIdPersona);

    UPDATE tbl_usuarios
    SET 
        nid_persona = IntIdPersona, 
        cusuario = CONCAT('30', SUBSTRING(StrCURP, 1, 10)),
        ccontrasenia = SHA2(StrContrasenia, 256),
        bhabilitado = 1,
        dfecha_alta = NOW()
        
    WHERE (nid_persona = IntIdPersona);
END
DELIMITER ;


CALL SPD_ACTUALIZA_PERSONA_ADMIN(296, 'Angel', 'Gonzalez', 1, 25, '1999-05-01', 'JUAP980101HDFRZZ00', 'JUAP980101HDF', '5545124875', 1, '123');