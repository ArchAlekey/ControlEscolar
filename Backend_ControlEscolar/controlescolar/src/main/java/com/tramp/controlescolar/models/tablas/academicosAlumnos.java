package com.tramp.controlescolar.models.tablas;

import java.util.Date;

public class academicosAlumnos {
    private Integer nid_academico_alumno;
    private Integer nid_persona;
    private Integer nid_categoria;
    private Integer nid_carrera;
    private String cnumero_cuenta;
    private String ccorreo_institucional;
    private Boolean bhabilitado;
    private Date dfecha_alta;
    private Date dfecha_baja;

    public academicosAlumnos(Integer IntIdAcademicoAlumno, Integer IntIdPersona, Integer IntIdCategoria, Integer IntIdCarrera, String StrNumeroCuenta, String StrCorreoInstitucional, boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja){
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

    public Integer getIdAcademicoAlumno(){return nid_academico_alumno;}
    public void setIdAcademicoAlumno(Integer IntIdAcademicoAlumno){this.nid_academico_alumno = IntIdAcademicoAlumno;}

    public Integer getIdPersona(){return nid_persona;}
    public void setIdPersona(Integer IntIdPersona){this.nid_persona = IntIdPersona;}

    public Integer getIdCategoria(){return nid_categoria;}
    public void setIdCategoria(Integer IntIdCategoria){this.nid_categoria = IntIdCategoria;}

    public Integer getIdCarrera(){return nid_carrera;}
    public void setIdCarrera(Integer IntIdCarrera){this.nid_carrera = IntIdCarrera;}

    public String getNumeroCuenta(){return cnumero_cuenta;}
    public void setNumeroCuenta(String StrNumeroCuenta){this.cnumero_cuenta = StrNumeroCuenta;}

    public String getCorreoInstitucional(){return ccorreo_institucional;}
    public void setCorreoInstitucional(String StrCorreoInstitucional){this.ccorreo_institucional = StrCorreoInstitucional;}

    public boolean getHabilitado(){return bhabilitado;}
    public void setHabilitado(boolean BoolHabilitado){this.bhabilitado = BoolHabilitado;}

    public Date getFechaAlta(){return dfecha_alta;}
    public void setFechaAlta(Date DateFechaAlta){this.dfecha_alta = DateFechaAlta;}

    public Date getFechaBaja(){return dfecha_baja;}
    public void setFechaBaja(Date DateFechaBaja){this.dfecha_baja = DateFechaBaja;}
}
