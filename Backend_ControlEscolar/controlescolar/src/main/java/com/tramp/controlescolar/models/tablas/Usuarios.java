package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_usuario")
    private Integer idUsuario;

    @Column(name = "nid_persona", nullable = false)
    private Integer idPersona;


    @Column(name = "cusuario", unique = true, length = 12, nullable = false)
    private String usuario;

    //Corregir en la base de datos
    @Column(name = "ccontrasenia", length = 100, nullable = false)
    private String contrasenia;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean habilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date fechaAlta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date fechaBaja;

    // Constructor vacío requerido por JPA
    public Usuarios() {}

    public Usuarios(Integer IntIdUsuario, Integer IntIdPersona, String StrUsuario, String StrContrasenia, Boolean BoolHabilitado, Date DateFechaAlta, Date DateFechaBaja) {
        this.idUsuario = IntIdUsuario;
        this.idPersona = IntIdPersona;
        this.usuario = StrUsuario;
        this.contrasenia = StrContrasenia;
        this.habilitado = BoolHabilitado;
        this.fechaAlta = DateFechaAlta;   
        this.fechaBaja = DateFechaBaja;
    }

    // Getters y Setters
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer IntIdUsuario) { this.idUsuario = IntIdUsuario; }

    public Integer getIdPersona() { return idPersona; }
    public void setIdPersona(Integer IntIdPersona) { this.idPersona = IntIdPersona; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String StrUsuario) { this.usuario = StrUsuario; }

    public String getContrasenia() { return contrasenia; }
    public void setContrasenia(String StrContrasenia) { this.contrasenia= StrContrasenia; }

    public Boolean getHabilitado() { return habilitado; }
    public void setHabilitado(Boolean BoolHabilitado) { this.habilitado = BoolHabilitado; }

    public Date getFechaAlta() { return fechaAlta; }
    public void setFechaAlta(Date DateFechaAlta) { this.fechaAlta = DateFechaAlta; }

    public Date getFechaBaja() { return fechaBaja; }
    public void setFechaBaja(Date DateFechaBaja) { this.fechaBaja = DateFechaBaja; }
}
