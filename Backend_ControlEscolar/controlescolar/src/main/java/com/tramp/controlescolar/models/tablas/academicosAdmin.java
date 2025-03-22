package com.tramp.controlescolar.models.tablas;

import com.tramp.controlescolar.models.catalogos.categorias;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "tbl_academicos_admin")
public class academicosAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_academico_admin")
    private Integer nid_academico_admin;

    @Column(name = "nid_persona", nullable = false)
    private Integer nid_persona;

    @Column(name = "nid_categoria", nullable = false)
    private Integer nid_categoria;

    @Column(name = "nid_carrera", nullable = false)
    private Integer nid_carrera;

    @Column(name = "cnumero_cuenta", unique = true, length = 9, nullable = false)
    private String cnumero_cuenta;

    @Column(name = "ccorreo_institucional", unique = true, length = 50, nullable = false)
    private String ccorreo_institucional;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;


}
