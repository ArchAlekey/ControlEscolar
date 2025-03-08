package com.tramp.controlescolar.models.catalogos;

import java.util.Date;

public class categorias {
    private Integer nid_categoria;
    private String ccategoria;
    private boolean bhabilitado;
    private Date dfecha_alta;
    private Date dfecha_baja;

    // Constructor
    public categorias(Integer nid_categoria, String ccategoria, boolean bhabilitado, Date dfecha_alta, Date dfecha_baja) {
        this.nid_categoria = nid_categoria;
        this.ccategoria = ccategoria;
        this.bhabilitado = bhabilitado;
        this.dfecha_alta = dfecha_alta;
        this.dfecha_baja = dfecha_baja;
    }

    // Getters y setters
    public Integer getNid_categoria() {return nid_categoria;}
    public void setNid_categoria(Integer nid_categoria) {this.nid_categoria = nid_categoria;}

    public String getCcategoria() {return ccategoria;}
    public void setCcategoria(String ccategoria) {this.ccategoria = ccategoria;}

    public boolean isBhabilitado() {return bhabilitado;}
    public void setBhabilitado(boolean bhabilitado) {this.bhabilitado = bhabilitado;}

    public Date getDfecha_alta() {return dfecha_alta;}
    public void setDfecha_alta(Date dfecha_alta) {this.dfecha_alta = dfecha_alta;}

    public Date getDfecha_baja() {return dfecha_baja;}
    public void setDfecha_baja(Date dfecha_baja) {this.dfecha_baja = dfecha_baja;}
}
