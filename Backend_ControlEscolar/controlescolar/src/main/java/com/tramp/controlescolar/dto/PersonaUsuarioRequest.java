package com.tramp.controlescolar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonaUsuarioRequest {

    private Integer nid_persona;
    private String cnombre;
    private String capellidos;
    private Boolean bsexo;
    private Integer nedad;
    private Date dfecha_nacimiento;
    private String cCURP;
    private String cRFC;
    private String cnumero_celular;

    private Integer nid_carrera;

    private String ccorreo_institucional;
    private String ccorreo_personal;

    public Integer getNid_persona() {
        return nid_persona;
    }

    public void setNid_persona(Integer nid_persona) {
        this.nid_persona = nid_persona;
    }

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

    public String getCcorreo_institucional() {
        return ccorreo_institucional;
    }
    public void setCcorreo_institucional(String ccorreo_institucional) {
        this.ccorreo_institucional = ccorreo_institucional;
    }

    public String getCcorreo_personal() {
        return ccorreo_personal;
    }
    public void setCcorreo_personal(String ccorreo_personal) {
        this.ccorreo_personal = ccorreo_personal;
    }
    
}
