package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_horario_materias")
public class horarioMaterias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_horario_materia")
    private Integer nidHorarioMateria;

    @Column(name = "nid_periodo", nullable = false)
    private Integer nidPeriodo;

    @Column(name = "nid_semestre", nullable = false)
    private Integer nidSemestre;

    @Column(name = "nid_grupo", nullable = false)
    private Integer nidGrupo;

    @Column(name = "nid_academico_profesor", nullable = false)
    private Integer nidAcademicoProfesor;

    @Column(name = "nid_materia", nullable = false)
    private Integer nidMateria;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean habilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date fechaAlta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date fechaBaja;
}
