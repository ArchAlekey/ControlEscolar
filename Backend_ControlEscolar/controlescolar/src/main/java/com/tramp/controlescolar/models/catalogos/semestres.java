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
    public void setIdSemestre(Integer nid_semestre){this.nid_semestre = nid_semestre;}

    public Integer getSemestre(){return nsemestre;}
    public void setSemestre(Integer nsemestre){this.nsemestre = nsemestre;}

    public boolean getParImpar(){return bpar_impar;}
    public void setParImpar(boolean bpar_impar){this.bpar_impar = bpar_impar;}

    public boolean getHabilitado(){return bhabilitado;}
    public void setHabilitado(boolean bhabilitado){this.bhabilitado = bhabilitado;}

    public Date getFechaAlta(){return dfecha_alta;}
    public void setFechaAlta(Date dfecha_alta){this.dfecha_alta = dfecha_alta;}

    public Date getFechaBaja(){return dfecha_baja;}
    public void setFechaBaja(Date dfecha_baja){this.dfecha_baja = dfecha_baja;}

}
