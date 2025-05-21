package com.tramp.controlescolar.repository;

import com.tramp.controlescolar.models.tablas.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AlumnosRepository extends JpaRepository<Personas, Integer>{


    @Query("SELECT p.nid_persona, aa.nid_academico_alumno, p.cnombre, p.capellidos, aa.cnumero_cuenta, aa.bhabilitado " +
    "FROM AcademicosAlumnos aa " +
    "JOIN Personas p ON aa.nid_persona = p.nid_persona")
    List<Object[]> findAcademicosAlumnosWithPersonas();

    @Modifying
    @Query("UPDATE AcademicosAlumnos a SET a.bhabilitado = :habilitado WHERE a.nid_academico_alumno = :idAlumno")
    void actualizarEstadoHabilitado(@Param("idAlumno") Integer idAlumno, @Param("habilitado") boolean habilitado);

    //Procedimiento SPD_INSERTA_INSCRIPCION
    @Procedure(procedureName = "SPD_INSERTA_INSCRIPCION")
        void insertarInscripcion(@Param("IntIdUSuario") Integer nid_usuario, @Param("IntIdGrupo") Integer nid_grupo);

    //Procedimiento SPD_CONSULTA_INSCRIPCION 
    @Procedure(procedureName = "SPD_CONSULTA_INSCRIPCION")
        List<Object[]> consultarInscripcion(@Param("IntIdUsuario") Integer nid_usuario);
     
     //Procedimiento SPD_BUSCAR_ALUMNOS
     @Procedure(procedureName = "SPD_BUSCAR_ALUMNOS")
     List<Object[]> buscarAlumnos(@Param("textoBusqueda") String textoBusqueda);
     
     //Procedimiento SPD_INSERTA_INSCRIPCION 
/*      @Procedure(procedureName = "SPD_CONSULTA_INSCRIPCION")
     List<Object[]> consultarInscripcion(
        @Param("IntIdUsuario") Integer nid_usuario
     ); */

    @Procedure(procedureName = "SPD_CONSULTA_HISTORIAL")
    List<Object[]> consultaHistorial(@Param("IntIdUsuario") Integer nid_usuario);
}
