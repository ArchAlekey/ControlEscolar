package com.tramp.controlescolar.dto;

import java.util.Date;

public class PersonaUsuarioRequest {

    private String cnombre;
    private String capellidos;
    private Boolean bsexo;
    private Integer nedad;
    private Date dfecha_nacimiento;
    private String cCURP;
    private String cRFC;
    private String cnumero_celular;

    private Integer nid_carrera;

    private String contrasenia;

    public String getCnombre() {
        return cnombre;
    }

    public void setCnombre(String cnombre) {
        this.cnombre = cnombre;
    }

    public String getCapellidos() {
        return capellidos;
    }

    public void setCapellidos(String capellidos) {
        this.capellidos = capellidos;
    }

    public Boolean getBsexo() {
        return bsexo;
    }

    public void setBsexo(Boolean bsexo) {
        this.bsexo = bsexo;
    }

    public Integer getNedad() {
        return nedad;
    }

    public void setNedad(Integer nedad) {
        this.nedad = nedad;
    }

    public Date getDfecha_nacimiento() {
        return dfecha_nacimiento;
    }

    public void setDfecha_nacimiento(Date dfecha_nacimiento) {
        this.dfecha_nacimiento = dfecha_nacimiento;
    }

    public String getcCURP() {
        return cCURP;
    }

    public void setcCURP(String cCURP) {
        this.cCURP = cCURP;
    }

    public String getcRFC() {
        return cRFC;
    }

    public void setcRFC(String cRFC) {
        this.cRFC = cRFC;
    }

    public String getCnumero_celular() {
        return cnumero_celular;
    }

    public void setCnumero_celular(String cnumero_celular) {
        this.cnumero_celular = cnumero_celular;
    }

    public Integer getNid_carrera() {
        return nid_carrera;
    }

    public void setNid_carrera(Integer nid_carrera) {
        this.nid_carrera = nid_carrera;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}
