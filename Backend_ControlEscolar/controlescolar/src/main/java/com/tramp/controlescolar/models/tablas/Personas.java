package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_personas")
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_persona")
    private Integer nid_persona;

    @Column(name = "cnombre", nullable = false)
    private String cnombre;

    @Column(name = "capellidos", nullable = false)
    private String capellidos;

    @Column(name = "bsexo", nullable = false)
    private Boolean bsexo;

    @Column(name = "nedad", nullable = false)
    private Integer nedad;

    @Temporal(TemporalType.DATE)
    @Column(name = "dfecha_nacimiento")
    private Date dfecha_nacimiento;

    @Column(name = "cCURP", unique = true, length = 18, nullable = false)
    private String cCURP;

    @Column(name = "cRFC", unique = true, length = 13, nullable = false)
    private String cRFC;

    @Column(name = "cnumero_celular", length = 15)
    private String cnumero_celular;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    public Integer getNid_persona() {
        return nid_persona;
    }

    public String getCnombre() {
        return cnombre;
    }

    public String getCapellidos() {
        return capellidos;
    }

    public Boolean getBsexo() {
        return bsexo;
    }

    public Integer getNedad() {
        return nedad;
    }

    public Date getDfecha_nacimiento() {
        return dfecha_nacimiento;
    }

    public String getcCURP() {
        return cCURP;
    }

    public String getcRFC() {
        return cRFC;
    }

    public String getCnumero_celular() {
        return cnumero_celular;
    }

    public Boolean getBhabilitado() {
        return bhabilitado;
    }

    public Date getDfecha_alta() {
        return dfecha_alta;
    }

    public Date getDfecha_baja() {
        return dfecha_baja;
    }

    public void setNid_persona(Integer nid_persona) {
        this.nid_persona = nid_persona;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public void setCapellidos(String capellidos) {
        this.capellidos = capellidos;
    }

    public void setBsexo(Boolean bsexo) {
        this.bsexo = bsexo;
    }

    public void setNedad(Integer nedad) {
        this.nedad = nedad;
    }

    public void setDfecha_nacimiento(Date dfecha_nacimiento) {
        this.dfecha_nacimiento = dfecha_nacimiento;
    }

    public void setcCURP(String cCURP) {
        this.cCURP = cCURP;
    }

    public void setcRFC(String cRFC) {
        this.cRFC = cRFC;
    }

    public void setCnumero_celular(String cnumero_celular) {
        this.cnumero_celular = cnumero_celular;
    }

    public void setBhabilitado(Boolean bhabilitado) {
        this.bhabilitado = bhabilitado;
    }

    public void setDfecha_alta(Date dfecha_alta) {
        this.dfecha_alta = dfecha_alta;
    }

    public void setDfecha_baja(Date dfecha_baja) {
        this.dfecha_baja = dfecha_baja;
    }
}
