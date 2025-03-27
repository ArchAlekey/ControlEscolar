package com.tramp.controlescolar.models.catalogos;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cat_semestres")
public class Semestres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_semestre")
    private Integer nid_semestre;

    @Column(name = "nsemestre", nullable = false)
    private Integer nsemestre;

    @Column(name = "bpar_impar", nullable = false)
    private boolean bpar_impar;

    @Column(name = "bhabilitado", nullable = false)
    private boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    // Constructor vacío requerido por JPA
    public Semestres() {}

    public Semestres(Integer IntIdSemestre, Integer IntSemestre, boolean BoolParImpar, boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja) {
        this.nid_semestre = IntIdSemestre;
        this.nsemestre = IntSemestre;
        this.bpar_impar = BoolParImpar;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    // Getters y Setters
    public Integer getIdSemestre() { return nid_semestre; }
    public void setIdSemestre(Integer IntIdSemestre) { this.nid_semestre = IntIdSemestre; }

    public Integer getSemestre() { return nsemestre; }
    public void setSemestre(Integer IntSemestre) { this.nsemestre = IntSemestre; }

    public boolean getParImpar() { return bpar_impar; }
    public void setParImpar(boolean BoolParImpar) { this.bpar_impar = BoolParImpar; }

    public boolean getHabilitado() { return bhabilitado; }
    public void setHabilitado(boolean BoolHabilitado) { this.bhabilitado = BoolHabilitado; }

    public Date getFechaAlta() { return dfecha_alta; }
    public void setFechaAlta(Date DateFechaAlta) { this.dfecha_alta = DateFechaAlta; }

    public Date getFechaBaja() { return dfecha_baja; }
    public void setFechaBaja(Date DateFechaBaja) { this.dfecha_baja = DateFechaBaja; }
}
