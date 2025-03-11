package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "academicos_alumnos")
public class academicosAlumnos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_academico_alumno")
    private Integer nid_academico_alumno;

    @Column(name = "nid_persona", nullable = false)
    private Integer nid_persona;

    @Column(name = "nid_categoria", nullable = false)
    private Integer nid_categoria;

    @Column(name = "nid_carrera", nullable = false)
    private Integer nid_carrera;

    @Column(name = "cnumero_cuenta", unique = true, nullable = false, length = 20)
    private String cnumero_cuenta;

    @Column(name = "ccorreo_institucional", unique = true, nullable = false, length = 100)
    private String ccorreo_institucional;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    // Constructor vacío requerido por JPA
    public academicosAlumnos() {}

    public academicosAlumnos(Integer IntIdAcademicoAlumno, Integer IntIdPersona, Integer IntIdCategoria, Integer IntIdCarrera, String StrNumeroCuenta, String StrCorreoInstitucional, boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja) {
        this.nid_academico_alumno = IntIdAcademicoAlumno;
        this.nid_persona = IntIdPersona;
        this.nid_categoria = IntIdCategoria;
        this.nid_carrera = IntIdCarrera;
        this.cnumero_cuenta = StrNumeroCuenta;
        this.ccorreo_institucional = StrCorreoInstitucional;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    // Getters y Setters
    public Integer getIdAcademicoAlumno() { return nid_academico_alumno; }
    public void setIdAcademicoAlumno(Integer IntIdAcademicoAlumno) { this.nid_academico_alumno = IntIdAcademicoAlumno; }

    public Integer getIdPersona() { return nid_persona; }
    public void setIdPersona(Integer IntIdPersona) { this.nid_persona = IntIdPersona; }

    public Integer getIdCategoria() { return nid_categoria; }
    public void setIdCategoria(Integer IntIdCategoria) { this.nid_categoria = IntIdCategoria; }

    public Integer getIdCarrera() { return nid_carrera; }
    public void setIdCarrera(Integer IntIdCarrera) { this.nid_carrera = IntIdCarrera; }

    public String getNumeroCuenta() { return cnumero_cuenta; }
    public void setNumeroCuenta(String StrNumeroCuenta) { this.cnumero_cuenta = StrNumeroCuenta; }

    public String getCorreoInstitucional() { return ccorreo_institucional; }
    public void setCorreoInstitucional(String StrCorreoInstitucional) { this.ccorreo_institucional = StrCorreoInstitucional; }

    public Boolean getHabilitado() { return bhabilitado; }
    public void setHabilitado(Boolean BoolHabilitado) { this.bhabilitado = BoolHabilitado; }

    public Date getFechaAlta() { return dfecha_alta; }
    public void setFechaAlta(Date DateFechaAlta) { this.dfecha_alta = DateFechaAlta; }

    public Date getFechaBaja() { return dfecha_baja; }
    public void setFechaBaja(Date DateFechaBaja) { this.dfecha_baja = DateFechaBaja; }
}
