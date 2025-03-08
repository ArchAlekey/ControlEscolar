package com.tramp.controlescolar.models.catalogos;

import java.util.*;

public class grupos {
    private Integer nid_grupo;
    private String cgrupo;
    private Boolean bhabilitado;
    private Date dfecha_alta;
    private Date dfecha_baja;

    public grupos(Integer IntIdGrupo, String StrGrupo, Boolean BoolParImpar, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja){
        this.nid_grupo = IntIdGrupo;
        this.cgrupo = StrGrupo;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    public Integer getIdGrupo(){return nid_grupo;}
    public void setIdGrupo(Integer IntIdGrupo){this.nid_grupo = IntIdGrupo;}

    public String getGrupo(){return cgrupo;}
    public void setGrupo(String StrGrupo){this.cgrupo = StrGrupo;}

    public Boolean getHabilitado(){return bhabilitado;}
    public void setHabilitado(Boolean BoolHabilitado){this.bhabilitado = BoolHabilitado;}

    public Date getFechaAlta(){return dfecha_alta;}
    public void setFechaAlta(Date DateFechaAlta){this.dfecha_alta = DateFechaAlta;}

    public Date getFechaBaja(){return dfecha_baja;}
    public void setFechaBaja(Date DateFechaBaja){this.dfecha_baja = DateFechaBaja;}
}