package com.tramp.controlescolar.models.catalogos;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cat_periodos")
public class Periodos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_periodo")
    private Integer nid_periodo;
    // Se cambio name: ccperiodo - cperiodo
    @Column(name = "cperiodo", nullable = false)
    private String ccperiodo;

    @Column(name = "canio", nullable = false)
    private String canio;

    @Column(name = "bhabilitado")
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    // Constructor vacío requerido por JPA
    public Periodos() {}

    public Periodos(Integer IntIdPeriodo, String StrPeriodo, String StrAnio, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja) {
        this.nid_periodo = IntIdPeriodo;
        this.ccperiodo = StrPeriodo;
        this.canio = StrAnio;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    // Getters y Setters
    public Integer getIdPeriodo() { return nid_periodo; }
    public void setIdPeriodo(Integer IntIdPeriodo) { this.nid_periodo = IntIdPeriodo; }

    public String getPeriodo() { return ccperiodo; }
    public void setPeriodo(String StrPeriodo) { this.ccperiodo = StrPeriodo; }

    public String getAnio() { return canio; }
    public void setAnio(String StrAnio) { this.canio = StrAnio; }

    public Boolean getHabilitado() { return bhabilitado; }
    public void setHabilitado(Boolean BoolHabilitado) { this.bhabilitado = BoolHabilitado; }

    public Date getFechaAlta() { return dfecha_alta; }
    public void setFechaAlta(Date DateFechaAlta) { this.dfecha_alta = DateFechaAlta; }

    public Date getFechaBaja() { return dfecha_baja; }
    public void setFechaBaja(Date DateFechaBaja) { this.dfecha_baja = DateFechaBaja; } 
}

