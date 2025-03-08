package com.tramp.controlescolar.models.catalogos;

import java.util.Date;

public class semestres {
    private Integer nid_semestre;
    private Integer nsemestre;
    private boolean bpar_impar;
    private boolean bhabilitado;
    private Date dfecha_alta;
    private Date dfecha_baja;

    public semestres(Integer IntIdSemestre, Integer IntSemestre, boolean BoolParImpar, boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja)
    {
        this.nid_semestre = IntIdSemestre;
        this.nsemestre = IntSemestre;
        this.bpar_impar = BoolParImpar;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    public Integer getIdSemestre(){return nid_semestre;}
    public void setIdSemestre(Integer IntIdSemestre){this.nid_semestre = IntIdSemestre;}

    public Integer getSemestre(){return nsemestre;}
    public void setSemestre(Integer IntSemestre){this.nsemestre = IntSemestre;}

    public boolean getParImpar(){return bpar_impar;}
    public void setParImpar(boolean BoolParImpar){this.bpar_impar = BoolParImpar;}

    public boolean getHabilitado(){return bhabilitado;}
    public void setHabilitado(boolean BoolHabilitado){this.bhabilitado = BoolHabilitado;}

    public Date getFechaAlta(){return dfecha_alta;}
    public void setFechaAlta(Date DateFechaAlta){this.dfecha_alta = DateFechaAlta;}

    public Date getFechaBaja(){return dfecha_baja;}
    public void setFechaBaja(Date DateFechaBaja){this.dfecha_baja = DateFechaBaja;}

}
