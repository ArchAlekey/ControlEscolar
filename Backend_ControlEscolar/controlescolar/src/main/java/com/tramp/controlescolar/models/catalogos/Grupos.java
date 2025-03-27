package com.tramp.controlescolar.models.catalogos;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cat_grupos")
public class Grupos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_grupo")
    private Integer nid_grupo;

    @Column(name = "cgrupo", nullable = false)
    private String cgrupo;

    @Column(name = "bhabilitado")
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    // Constructor vacío requerido por JPA
    public Grupos() {}

    public Grupos(Integer IntIdGrupo, String StrGrupo, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja) {
        this.nid_grupo = IntIdGrupo;
        this.cgrupo = StrGrupo;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    } 

    // Getters y Setters
    public Integer getIdGrupo() { return nid_grupo; }
    public void setIdGrupo(Integer IntIdGrupo) { this.nid_grupo = IntIdGrupo; }

    public String getGrupo() { return cgrupo; }
    public void setGrupo(String StrGrupo) { this.cgrupo = StrGrupo; }

    public Boolean getHabilitado() { return bhabilitado; }
    public void setHabilitado(Boolean BoolHabilitado) { this.bhabilitado = BoolHabilitado; }

    public Date getFechaAlta() { return dfecha_alta; }
    public void setFechaAlta(Date DateFechaAlta) { this.dfecha_alta = DateFechaAlta; }

    public Date getFechaBaja() { return dfecha_baja; }
    public void setFechaBaja(Date DateFechaBaja) { this.dfecha_baja = DateFechaBaja; }
}
