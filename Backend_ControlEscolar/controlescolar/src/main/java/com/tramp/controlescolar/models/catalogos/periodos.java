package com.tramp.controlescolar.models.catalogos;

import java.util.*;

public class periodos {
    private Integer nid_periodo;
    private String ccperiodo;
    private String canio;
    private Boolean bhabilitado;
    private Date dfecha_alta;
    private Date dfecha_baja;

    public periodos(Integer IntIdPeriodo, String StrPeriodo, String StrAnio, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja){
        this.nid_periodo = IntIdPeriodo;
        this.ccperiodo = StrPeriodo;
        this.canio = StrAnio;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    public Integer getIdPeriodo(){return nid_periodo;}
    public void setIdPeriodo(Integer IntIdPeriodo){this.nid_periodo = IntIdPeriodo;}

    public String getPeriodo(){return ccperiodo;}
    public void setPeriodo(String StrPeriodo){this.ccperiodo = StrPeriodo;}

    public String getAnio(){return canio;}
    public void setAnio(String StrAnio){this.canio = StrAnio;}

    public Boolean getHabilitado(){return bhabilitado;}
    public void setHabilitado(Boolean BoolHabilitado){this.bhabilitado = BoolHabilitado;}

    public Date getFechaAlta(){return dfecha_alta;}
    public void setFechaAlta(Date DateFechaAlta){this.dfecha_alta = DateFechaAlta;}

    public Date getFechaBaja(){return dfecha_baja;}
    public void setFechaBaja(Date DateFechaBaja){this.dfecha_baja = DateFechaBaja;} 
}
