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
    private Integer nid_horario_materia;

    @Column(name = "nid_periodo", nullable = false)
    private Integer nid_periodo;

    @Column(name = "nid_semestre", nullable = false)
    private Integer nid_semestre;

    @Column(name = "nid_grupo", nullable = false)
    private Integer nid_grupo;

    @Column(name = "nid_academico_profesor", nullable = false)
    private Integer nid_academico_profesor;

    @Column(name = "nid_materia", nullable = false)
    private Integer nid_materia;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;
}
