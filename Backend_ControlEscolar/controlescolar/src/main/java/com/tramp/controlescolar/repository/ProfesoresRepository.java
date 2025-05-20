package com.tramp.controlescolar.repository;

import com.tramp.controlescolar.models.tablas.AcademicosProfesores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProfesoresRepository extends JpaRepository<AcademicosProfesores, Integer> {
        //Procedimiento SPD_CONSULTA_GRUPOS_ASIGNADOS
        @Procedure(procedureName = "SPD_CONSULTA_GRUPOS_ASIGNADOS")
        List<Object[]> consultaGruposAsignados(
                @Param("IntIdAcademicoProfesor") Integer nid_academico_profesor
        );

        //Procedimiento SPD_INSERTA_CALIFICACION
        @Procedure(procedureName = "SPD_INSERTA_CALIFICACION")
        void insertaCalificaciones(@Param("IntIdMateria") Integer nid_horario_materia, @Param("IntIdUsuario") Integer nid_usuario, @Param("FloatCalificacion") Float ncalificacion);

        //Procedimiento SPD_ELIMINA_CALIFICACION
        @Procedure(procedureName = "SPD_ELIMINA_CALIFICACION")
        void eliminaCalificacion(@Param("IntIdMateria") Integer nid_horario_materia, @Param("IntIdUsuario") Integer nid_usuario);
        
        //Procedimiento SPD_CONSULTA_ALUMNOS_INSCRITOS
        @Procedure(procedureName = "SPD_CONSULTA_ALUMNOS_INSCRITOS")
        List<Object[]> consultaAlumnosIns(@Param("IntIdGrupo") Integer nid_grupo, @Param("IntIdMateria") Integer nid_materia);

        @Query(value = "Select nid_academico_profesor from tbl_academicos_profesores where nid_persona = :nid_persona", nativeQuery = true)
        List<Object[]> consultaIdAcademico(@Param("nid_persona") Integer nid_persona);

        @Query("SELECT p.nid_persona, ap.nid_academico_profesor, p.cnombre, p.capellidos, ap.cnumero_cuenta, ap.bhabilitado " +
                "FROM AcademicosProfesores ap " +
                "JOIN Personas p ON ap.nid_persona = p.nid_persona")
        List<Object[]> obtenerAcademicosProfesoresConPersonas();

        @Modifying
        @Query("UPDATE AcademicosProfesores a SET a.bhabilitado = :habilitado WHERE a.nid_academico_profesor = :idProfesor")
        void actualizarEstadoHabilitado(@Param("idProfesor") Integer idProfesor, @Param("habilitado") boolean habilitado);

        //Procedimiento SPD_BUSCAR_PROFESORES
        @Procedure(procedureName = "SPD_BUSCAR_PROFESORES")
        List<Object[]> buscarProfesores(
                @Param("textoBusqueda") String textoBusqueda
        );
}
