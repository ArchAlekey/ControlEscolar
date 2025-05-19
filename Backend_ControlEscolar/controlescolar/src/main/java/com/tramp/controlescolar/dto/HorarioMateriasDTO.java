package com.tramp.controlescolar.dto;

public class HorarioMateriasDTO {
    private Integer nid_horario_materia;
    private String cnombre_materia;
    private String cclave_materia;
    private String ccarrera;
    private String cperiodo;
    private Integer nsemestre;
    private String cgrupo;
    private String profesor;
    private String cnumero_cuenta;
    private String ccorreo_institucional;
    private String chorario;

    public HorarioMateriasDTO(
    Integer nid_horario_materia,
    String cnombre_materia,
    String cclave_materia,
    String ccarrera,
    String cperiodo,
    Integer nsemestre,
    String cgrupo,
    String profesor,
    String cnumero_cuenta,
    String ccorreo_institucional,
    String chorario
) {
    this.nid_horario_materia = nid_horario_materia;
    this.cnombre_materia = cnombre_materia;
    this.cclave_materia = cclave_materia;
    this.ccarrera = ccarrera;
    this.cperiodo = cperiodo;
    this.nsemestre = nsemestre;
    this.cgrupo = cgrupo;
    this.profesor = profesor;
    this.cnumero_cuenta = cnumero_cuenta;
    this.ccorreo_institucional = ccorreo_institucional;
    this.chorario = chorario;
}

    // Getters
    public Integer getNid_horario_materia() {
        return nid_horario_materia;
    }

    public String getCnombre_materia() {
        return cnombre_materia;
    }

    public String getCclave_materia() {
        return cclave_materia;
    }

    public String getCcarrera() {
        return ccarrera;
    }

    public String getCperiodo() {
        return cperiodo;
    }

    public Integer getNsemestre() {
        return nsemestre;
    }

    public String getCgrupo() {
        return cgrupo;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getCnumero_cuenta() {
        return cnumero_cuenta;
    }

    public String getCcorreo_institucional() {
        return ccorreo_institucional;
    }

    public String getChorario() {
        return chorario;
    }

    // Setters
    public void setNid_horario_materia(Integer nid_horario_materia) {
        this.nid_horario_materia = nid_horario_materia;
    }

    public void setCnombre_materia(String cnombre_materia) {
        this.cnombre_materia = cnombre_materia;
    }

    public void setCclave_materia(String cclave_materia) {
        this.cclave_materia = cclave_materia;
    }

    public void setCcarrera(String ccarrera) {
        this.ccarrera = ccarrera;
    }

    public void setCperiodo(String cperiodo) {
        this.cperiodo = cperiodo;
    }

    public void setNsemestre(Integer nsemestre) {
        this.nsemestre = nsemestre;
    }

    public void setCgrupo(String cgrupo) {
        this.cgrupo = cgrupo;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setCnumero_cuenta(String cnumero_cuenta) {
        this.cnumero_cuenta = cnumero_cuenta;
    }

    public void setCcorreo_institucional(String ccorreo_institucional) {
        this.ccorreo_institucional = ccorreo_institucional;
    }

    public void setChorario(String chorario) {
        this.chorario = chorario;
    }
}