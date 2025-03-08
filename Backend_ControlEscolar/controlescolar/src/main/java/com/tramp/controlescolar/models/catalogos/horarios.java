package com.tramp.controlescolar.models.catalogos;

import java.util.*;

public class horarios {
    private Integer nid_horario;    
    private String  chorario;
    private Boolean bhabilitado;
    private Date dfecha_alta;
    private Date dfecha_baja;

    public horarios(Integer IntIdHorario, String StrHorario, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja){
        this.nid_horario = IntIdHorario;
        this.chorario = StrHorario;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    public Integer getIdHorario(){return nid_horario;}
    public void setIdHorario(Integer IntIdHorario){this.nid_horario = IntIdHorario;}

    public String getHorario(){return chorario;}
    public void setHorario(String StrHorario){this.chorario = StrHorario;}

    public Boolean getHabilitado(){return bhabilitado;}
    public void setHabilitado(Boolean BoolHabilitado){this.bhabilitado = BoolHabilitado;}

    public Date getFechaAlta(){return dfecha_alta;}
    public void setFechaAlta(Date DateFechaAlta){this.dfecha_alta = DateFechaAlta;}

    public Date getFechaBaja(){return dfecha_baja;}
    public void setFechaBaja(Date DateFechaBaja){this.dfecha_baja = DateFechaBaja;} 
}   
