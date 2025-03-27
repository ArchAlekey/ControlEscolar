package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_horario_materias")
public class HorarioMaterias {
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

    // Constructor vacío requerido por JPA
    public HorarioMaterias() {}

    public HorarioMaterias(Integer IntIdHorarioMateria, Integer IntIdPeriodo, Integer IntIdSemestre, Integer IntIdGrupo, Integer IntIdAcademicoProfesor, Integer IntIdMateria, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja) {
        this.nid_horario_materia = IntIdHorarioMateria;
        this.nid_periodo = IntIdPeriodo;
        this.nid_semestre = IntIdSemestre;
        this.nid_grupo = IntIdGrupo;
        this.nid_academico_profesor = IntIdAcademicoProfesor;
        this.nid_materia = IntIdMateria;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    // Getters y Setters
    public Integer getIdHorarioMateria() { return nid_horario_materia; }
    public void setIdHorarioMateria(Integer IntIdHorarioMateria) { this.nid_horario_materia = IntIdHorarioMateria; }

    public Integer getIdPeriodo() { return nid_periodo; }
    public void setIdPeriodo(Integer IntIdPeriodo) { this.nid_periodo = IntIdPeriodo; }

    public Integer getIdSemestre() { return nid_semestre; }
    public void setIdSemestre(Integer IntIdSemestre) { this.nid_semestre = IntIdSemestre; }

    public Integer getIdGrupo() { return nid_grupo; }
    public void setIdGrupo(Integer IntIdGrupo) { this.nid_grupo = IntIdGrupo; }

    public Integer getIdAcademicoProfesor() { return nid_academico_profesor; }
    public void setIdAcademicoProfesor(Integer IntIdAcademicoProfesor) { this.nid_academico_profesor = IntIdAcademicoProfesor; }

    public Integer getIdMateria() { return nid_materia; }
    public void setIdMateria(Integer IntIdMateria) { this.nid_materia = IntIdMateria; }

    public Boolean getHabilitado() { return bhabilitado; }
    public void setHabilitado(Boolean BoolHabilitado) { this.bhabilitado = BoolHabilitado; }

    public Date getFechaAlta() { return dfecha_alta; }
    public void setFechaAlta(Date DateFechaAlta) { this.dfecha_alta = DateFechaAlta; }

    public Date getFechaBaja() { return dfecha_baja; }
    public void setFechaBaja(Date DateFechaBaja) { this.dfecha_baja = DateFechaBaja; }
}
