package com.tramp.controlescolar.models.tablas;

import java.util.*;

public class personas {
    private Integer nid_persona;
    private String cnombre;
    private String capellidos;
    private Boolean bsexo;
    private Integer nedad;
    private Date dfecha_nacimiento;
    private String cCURP;
    private String cRFC;
    private String cnumero_celular;
    private Boolean bhabilitado;
    private Date dfecha_alta;
    private Date dfecha_baja;

    public personas(Integer IntIdPersona,
                    String StrNombre,
                    String StrApellidos,
                    Boolean BoolSexo,
                    Integer IntEdad,
                    Date  DateFechaNacimiento,
                    String StrCURP,
                    String StrRFC, 
                    String StrNumeroCelular,
                    boolean BoolHabilitado, 
                    Date DateFechaAlta, 
                    Date DateFechaBaja){
        this.nid_persona = IntIdPersona;
        this.cnombre = StrNombre;
        this.capellidos = StrApellidos;
        this.bsexo = BoolSexo;
        this.nedad = IntEdad;
        this.dfecha_nacimiento = DateFechaNacimiento;
        this.cCURP = StrCURP;
        this.cRFC = StrRFC;
        this.cnumero_celular = StrNumeroCelular;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    public Integer getIdPersona(){return nid_persona;}
    public void setIdPersona(Integer IntIdPersona){this.nid_persona = IntIdPersona;}

    public String getNombre(){return cnombre;}
    public void setNombre(String StrNombre){this.cnombre = StrNombre;}

    public String getApellidos(){return capellidos;}
    public void setApellidos(String StrApellidos){this.capellidos = StrApellidos;}

    public Boolean getSexo(){return bsexo;}
    public void setSexo(Boolean BoolSexo){this.bsexo = BoolSexo;}

    public Integer getEdad(){return nedad;}
    public void setEdad(Integer IntEdad){this.nedad = IntEdad;}

    public Date getFechaNacimiento(){return dfecha_nacimiento;}
    public void setFechaNacimiento(Date DateFechaNacimiento){this.dfecha_nacimiento = DateFechaNacimiento;}

    public String getCURP(){return cCURP;}
    public void setCURP(String StrCURP){this.cCURP = StrCURP;}

    public String getRFC(){return cRFC;}
    public void setRFC(String StrRFC){this.cRFC = StrRFC;}

    public String getNumeroCelular(){return cnumero_celular;}
    public void setNumeroCelular(String StrNumeroCelular){this.cnumero_celular = StrNumeroCelular;}

    public boolean getHabilitado(){return bhabilitado;}
    public void setHabilitado(boolean BoolHabilitado){this.bhabilitado = BoolHabilitado;}

    public Date getFechaAlta(){return dfecha_alta;}
    public void setFechaAlta(Date DateFechaAlta){this.dfecha_alta = DateFechaAlta;}

    public Date getFechaBaja(){return dfecha_baja;}
    public void setFechaBaja(Date DateFechaBaja){this.dfecha_baja = DateFechaBaja;}
}
