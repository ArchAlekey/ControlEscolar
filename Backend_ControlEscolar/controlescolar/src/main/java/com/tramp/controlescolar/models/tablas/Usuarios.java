package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "tbl_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
