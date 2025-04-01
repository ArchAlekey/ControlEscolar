package com.tramp.controlescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tramp.controlescolar.models.tablas.Personas;
import java.util.Date;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, Integer> {
    //name genera un error cambiar por procedureName
    //Procedimiento SPD_INSERTA_PERSONA_ADMIN
    @Procedure(procedureName = "SPD_INSERTA_PERSONA_ADMIN")
    void insertaPersonaAdministrador(
            //Personas
            @Param("StrNombre") String cnombre,
            @Param("StrApellidos") String capellidos,
            @Param("BitSexo") Boolean bsexo,
            @Param("IntEdad") Integer nedad,
            @Param("DateFechaNacimiento") Date dfecha_nacimiento,
            @Param("StrCURP") String cCURP,
            @Param("StrRFC") String cRFC,
            @Param("StrNumeroCelular") String cnumero_celular,

            //Carreras
            @Param("IntIdCarrera") Integer nid_carrera,
            //Usuarios
            @Param("StrContrasenia") String contrasenia
    );

    //Procedimiento SPD_INSERTA_PERSONA_PROFESOR
    @Procedure(procedureName = "SPD_INSERTA_PERSONA_PROFESOR")
    void insertaPersonaProfesor(
            //Personas
            @Param("StrNombre") String cnombre,
            @Param("StrApellidos") String capellidos,
            @Param("BitSexo") Boolean bsexo,
            @Param("IntEdad") Integer nedad,
            @Param("DateFechaNacimiento") Date dfecha_nacimiento,
            @Param("StrCURP") String cCURP,
            @Param("StrRFC") String cRFC,
            @Param("StrNumeroCelular") String cnumero_celular,

            //Carreras
            @Param("IntIdCarrera") Integer nid_carrera,
            //Usuarios
            @Param("StrContrasenia") String contrasenia
    );

        //Procedimiento SPD_INSERTA_PERSONA_ALUMNO
        @Procedure(procedureName = "SPD_INSERTA_PERSONA_ALUMNO")
        void insertaPersonaAlumno(
                //Personas
                @Param("StrNombre") String cnombre,
                @Param("StrApellidos") String capellidos,
                @Param("BitSexo") Boolean bsexo,
                @Param("IntEdad") Integer nedad,
                @Param("DateFechaNacimiento") Date dfecha_nacimiento,
                @Param("StrCURP") String cCURP,
                @Param("StrRFC") String cRFC,
                @Param("StrNumeroCelular") String cnumero_celular,
    
                //Carreras
                @Param("IntIdCarrera") Integer nid_carrera,
                //Usuarios
                @Param("StrContrasenia") String contrasenia
        );


}
