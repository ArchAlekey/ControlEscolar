package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tbl_insc_alumnos")

public class InscripcionAlumnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_insc_alumno")
    private Integer nid_insc_alumno;

    @Column(name = "nid_horario_materia", nullable = false)
    private Integer nid_horario_materia;

    @Column(name = "nid_usuario", nullable = false)
    private Integer nid_usuario;

    //Corregir en la base de datos
    @Column(name = "ncalificacion", precision = 2, scale = 2, nullable = false)
    private BigDecimal ncalificacion;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    // Constructor vacío requerido por JPA
    public InscripcionAlumnos() {}

    public InscripcionAlumnos(Integer IntIdInscripcionAlumno, Integer IntIdHorarioMateria, Integer IntIdUsuario, BigDecimal BigCalificacion, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja) {
        this.nid_insc_alumno = IntIdInscripcionAlumno;
        this.nid_horario_materia = IntIdHorarioMateria;
        this.nid_usuario = IntIdUsuario;
        this.ncalificacion = BigCalificacion;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    // Getters y Setters
    public Integer getIdInscripcionAlumno() { return nid_insc_alumno; }
    public void setIdInscripcionAlumno(Integer IntIdInscripcionAlumno) { this.nid_insc_alumno = IntIdInscripcionAlumno; }

    public Integer getIdHorarioMateria() { return nid_horario_materia; }
    public void setIdHorarioMateria(Integer IntIdHorarioMateria) { this.nid_horario_materia = IntIdHorarioMateria; }

    public Integer getIdUsuario() { return nid_usuario; }
    public void setIdUsuario(Integer IntIdUsuario) { this.nid_usuario = IntIdUsuario; }

    public BigDecimal getCalificacion() { return ncalificacion; }
    public void setCalificacion(BigDecimal BigCalificacion) { this.ncalificacion = BigCalificacion; }

    public Boolean getHabilitado() { return bhabilitado; }
    public void setHabilitado(Boolean BoolHabilitado) { this.bhabilitado = BoolHabilitado; }

    public Date getFechaAlta() { return dfecha_alta; }
    public void setFechaAlta(Date DateFechaAlta) { this.dfecha_alta = DateFechaAlta; }

    public Date getFechaBaja() { return dfecha_baja; }
    public void setFechaBaja(Date DateFechaBaja) { this.dfecha_baja = DateFechaBaja; }
}
