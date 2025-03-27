package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_usuario")
    private Integer nid_usuario;

    @Column(name = "nid_persona", nullable = false)
    private Integer nid_persona;


    @Column(name = "cusuario", unique = true, length = 12, nullable = false)
    private String cusuario;

    //Corregir en la base de datos
    @Column(name = "ccontrasenia", length = 100, nullable = false)
    private String contrasenia;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    // Constructor vacío requerido por JPA
    public Usuarios() {}

    public Usuarios(Integer IntIdUsuario, Integer IntIdPersona, String StrUsuario, String StrContrasenia, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja) {
        this.nid_usuario = IntIdUsuario;
        this.nid_persona = IntIdPersona;
        this.cusuario = StrUsuario;
        this.contrasenia = StrContrasenia;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    // Getters y Setters
    public Integer getIdUsuario() { return nid_usuario; }
    public void setIdUsuario(Integer IntIdUsuario) { this.nid_usuario = IntIdUsuario; }

    public Integer getIdPersona() { return nid_persona; }
    public void setIdPersona(Integer IntIdPersona) { this.nid_persona = IntIdPersona; }

    public String getUsuario() { return cusuario; }
    public void setUsuario(String StrUsuario) { this.cusuario = StrUsuario; }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String StrContrasenia) { this.contrasenia = StrContrasenia; }

    public Boolean getHabilitado() { return bhabilitado; }
    public void setHabilitado(Boolean BoolHabilitado) { this.bhabilitado = BoolHabilitado; }

    public Date getFechaAlta() { return dfecha_alta; }
    public void setFechaAlta(Date DateFechaAlta) { this.dfecha_alta = DateFechaAlta; }

    public Date getFechaBaja() { return dfecha_baja; }
    public void setFechaBaja(Date DateFechaBaja) { this.dfecha_baja = DateFechaBaja; }
}
