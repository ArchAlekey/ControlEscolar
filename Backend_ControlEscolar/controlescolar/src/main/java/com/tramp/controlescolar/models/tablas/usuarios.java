package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "tbl_usuarios")
public class usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_usuario")
    private Integer nidUsuario;

    @Column(name = "nid_persona", nullable = false)
    private Integer nidPersona;


    @Column(name = "cusuario", unique = true, length = 9, nullable = false)
    private String usuario;

    //Corregir en la base de datos
    @Column(name = "contrasenia", length = 50, nullable = false)
    private String contrasenia;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean habilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date fechaAlta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date fechaBaja;
}
