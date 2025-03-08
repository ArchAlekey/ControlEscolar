package com.tramp.controlescolar.models.catalogos;

import java.util.Date;
public class carreras {
    private int nid_carrera;
    private String ccarrera;
    private boolean bhabilitado;
    private Date dfecha_alta;
    private Date dfecha_baja;
    
    public carreras(int IntIdCarrera, String StrCarrera, boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja)
    {
        this.nid_carrera = IntIdCarrera;
        this.ccarrera = StrCarrera;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    //Getters y Setters
    public Integer getIdCarrera(){return nid_carrera;}
    public void setIdCarrera(Integer IntIdCarrera){this.nid_carrera = IntIdCarrera;}

    public String getCarrera(){return ccarrera;}
    public void setCarrera(String StrCarrera){this.ccarrera = StrCarrera;}

    public boolean getHabilitado(){return bhabilitado;}
    public void setHabilitado(boolean BoolHabilitado){this.bhabilitado = BoolHabilitado;}

    public Date getFechaAlta(){return dfecha_alta;}
    public void setFechaAlta(Date DateFechaAlta){this.dfecha_alta = DateFechaAlta;}

    public Date getFechaBaja(){return dfecha_baja;}
    public void setFechaBaja(Date DateFechaBaja){this.dfecha_baja = DateFechaBaja;}
}
