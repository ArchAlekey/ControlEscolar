package com.tramp.controlescolar.models.catalogos;

import java.util.*;

import jakarta.persistence.*;

@Entity
//Se modifico de tbl_materias a cat_materias
@Table(name = "cat_materias")
public class Materias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_materia")
    private Integer nid_materia;

    @Column(name = "nid_carrera")
    private Integer nid_carrera;

    @Column(name = "nid_semestre")
    private Integer nid_semestre;

    @Column(name = "cnombre_materia")
    private String cnombre_materia;

    @Column(name = "cclave_materia")
    private String cclave_materia;

    @Column(name = "bhabilitado")
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    // 👇 Constructor vacío obligatorio para JPA
    public Materias() {}

    public Materias( Integer IntIdMateria, Integer IntIdCarrera, Integer IntIdSemestre, String StrNombreMateria, String StrClaveMateria, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja){
        this.nid_materia = IntIdMateria;
        this.nid_carrera = IntIdCarrera;
        this.nid_semestre = IntIdSemestre;
        this.cnombre_materia = StrNombreMateria;
        this.cclave_materia = StrClaveMateria;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }
    public Integer getIdMateria(){return nid_materia;}
    public void setIdMateria(Integer IntIdMateria){this.nid_materia = IntIdMateria;}
    
    public Integer getIdCarrera(){return nid_carrera;}
    public void setIdCarrera(Integer IntIdCarrera){this.nid_carrera = IntIdCarrera;}

    public Integer getIdSemestre(){return nid_semestre;}
    public void setIdSemestre(Integer IntIdSemestre){this.nid_semestre = IntIdSemestre;}

    public String getNombreMateria(){return cnombre_materia;}
    public void setNombreMateria(String StrNombreMateria){this.cnombre_materia = StrNombreMateria;}

    public String getClaveMateria(){return cclave_materia;}
    public void setClaveMateria(String StrClaveMateria){this.cclave_materia = StrClaveMateria;}

    public Boolean getHabilitado(){return bhabilitado;}
    public void setHabilitado(Boolean BoolHabilitado){this.bhabilitado = BoolHabilitado;}

    public Date getFechaAlta(){return dfecha_alta;}
    public void setFechaAlta(Date DateFechaAlta){this.dfecha_alta = DateFechaAlta;}

    public Date getFechaBaja(){return dfecha_baja;}
    public void setFechaBaja(Date DateFechaBaja){this.dfecha_baja = DateFechaBaja;}
}
