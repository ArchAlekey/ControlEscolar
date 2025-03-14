package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_insc_alumnos")
public class inscripcionAlumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_insc_alumno")
    private Integer nidInscripcionAlumno;

    @Column(name = "nid_horario_materia", nullable = false)
    private Integer nidHorarioMateria;

    @Column(name = "nid_usuario", nullable = false)
    private Integer nidUsuario;

    //Corregir en la base de datos
    @Column(name = "ncalificacion", precision = 2, scale = 2, nullable = false)
    private BigDecimal calificacion;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean habilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date fechaAlta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date fechaBaja;

}
