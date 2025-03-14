package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tbl_academicos_profesores")
public class academicosProfesores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_academico_profesor")
    private Integer nidAcademicoProfesor;

    @Column(name = "nid_persona", nullable = false)
    private Integer nidPersona;

    @Column(name = "nid_categoria", nullable = false)
    private Integer niCategoria;

    @Column(name = "nid_carrera", nullable = false)
    private Integer nidCarrera;

    @Column(name = "cnumero_cuenta", unique = true, length = 9, nullable = false)
    private String numeroCuenta;

    @Column(name = "ccorreo_institucional", unique = true, length = 50, nullable = false)
    private String correoInstitucional;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean habilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date fechaAlta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date fechaBaja;
}
