package com.tramp.controlescolar.models.catalogos;

import java.util.Date;
public class carreras {
    private int nid_carrera;
    private String ccarrera;
    private boolean bhabilitado;
    private Date dfecha_alta;
    private Date dfecha_baja;
    
    public carreras(int IntId_carrera, String StrCarrera, boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja)
    {
        this.nid_carrera = IntId_carrera;
        this.ccarrera = StrCarrera;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    //Getters y Setters
    public Integer getIdCarrera(){return nid_carrera;}
    public void setIdCarrera(Integer nid_carrera){this.nid_carrera = nid_carrera;}

    public String getCarrera(){return ccarrera;}
    public void setCarrera(String ccarrera){this.ccarrera = ccarrera;}

    public boolean getHabilitado(){return bhabilitado;}
    public void setHabilitado(boolean bhabilitado){this.bhabilitado = bhabilitado;}

    public Date getFechaAlta(){return dfecha_alta;}
    public void setFechaAlta(Date dfecha_alta){this.dfecha_alta = dfecha_alta;}

    public Date getFechaBaja(){return dfecha_baja;}
    public void setFechaBaja(Date dfecha_baja){this.dfecha_baja = dfecha_baja;}
}
