package com.tramp.controlescolar.models.catalogos;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cat_horarios")
public class Horarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_horario")
    private Integer nid_horario;

    @Column(name = "chorario", nullable = false)
    private String chorario;

    @Column(name = "bhabilitado")
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    // Constructor vacío requerido por JPA
     public Horarios() {}

    public Horarios(Integer IntIdHorario, String StrHorario, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja) {
        this.nid_horario = IntIdHorario;
        this.chorario = StrHorario;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    // Getters y Setters
    public Integer getIdHorario() { return nid_horario; }
    public void setIdHorario(Integer IntIdHorario) { this.nid_horario = IntIdHorario; }

    public String getHorario() { return chorario; }
    public void setHorario(String StrHorario) { this.chorario = StrHorario; }

    public Boolean getHabilitado() { return bhabilitado; }
    public void setHabilitado(Boolean BoolHabilitado) { this.bhabilitado = BoolHabilitado; }

    public Date getFechaAlta() { return dfecha_alta; }
    public void setFechaAlta(Date DateFechaAlta) { this.dfecha_alta = DateFechaAlta; }

    public Date getFechaBaja() { return dfecha_baja; }
    public void setFechaBaja(Date DateFechaBaja) { this.dfecha_baja = DateFechaBaja; } 
}

