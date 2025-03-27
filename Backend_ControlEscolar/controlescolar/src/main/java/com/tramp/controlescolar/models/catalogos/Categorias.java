package com.tramp.controlescolar.models.catalogos;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "cat_categorias")
public class Categorias {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_categoria")
    private Integer nid_categoria;

    @Column(name = "ccategoria", nullable = false)
    private String ccategoria;

    @Column(name = "bhabilitado")
    private boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    public Categorias(){};

    // Constructor
    public Categorias(Integer IntIdCategoria, String StrCategoria, boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja) {
        this.nid_categoria = IntIdCategoria;
        this.ccategoria = StrCategoria;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    // Getters y setters
    public Integer getIdCategoria() {return nid_categoria;}
    public void setIdCategoria(Integer IntIdCategoria) {this.nid_categoria = IntIdCategoria;}

    public String getCategoria() {return ccategoria;}
    public void setCategoria(String StrCategoria){this.ccategoria = StrCategoria;}

    public boolean getHabilitado() {return bhabilitado;}
    public void setHabilitado(Boolean BoolHabilitado) {this.bhabilitado = BoolHabilitado;}

    public Date getFechaAlta() {return dfecha_alta;}
    public void setFechaAlta(Date DateFechaAlta) {this.dfecha_alta = DateFechaAlta;}

    public Date getFechaBaja() {return dfecha_baja;}
    public void setFechaBaja(Date DateFechaBaja) {this.dfecha_baja = DateFechaBaja;}
}
