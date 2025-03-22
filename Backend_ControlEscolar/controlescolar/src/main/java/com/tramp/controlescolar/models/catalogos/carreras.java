package com.tramp.controlescolar.models.catalogos;

import lombok.*;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cat_carreras")
public class carreras {
/*     private int nid_carrera;
    private String ccarrera;
    private boolean bhabilitado;
    private Date dfecha_alta;
    private Date dfecha_baja; */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_carrera")
    private int nid_carrera;

    @Column(name = "ccarrera", nullable = false)
    private String ccarrera;

    @Column(name = "bhabilitado")
    private boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;
    

    public carreras(){};
    
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
