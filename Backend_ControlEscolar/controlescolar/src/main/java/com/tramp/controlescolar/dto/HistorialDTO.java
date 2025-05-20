package com.tramp.controlescolar.dto;

public class HistorialDTO {
    private Integer nid_insc_alumno;
    private Integer nid_horario_materia;
    private String cnombre_materia;
    private String cclave_materia;
    private Float ncalificación;
    private Integer nsemestre;
    private String cperiodo;
    private String canio;

        // Constructor vacío
    public HistorialDTO() {
    }

    // Constructor con todos los campos
    public HistorialDTO(Integer nid_insc_alumno, Integer nid_horario_materia, String cnombre_materia,
                        String cclave_materia, Float ncalificación, Integer nsemestre,
                        String cperiodo, String canio) {
        this.nid_insc_alumno = nid_insc_alumno;
        this.nid_horario_materia = nid_horario_materia;
        this.cnombre_materia = cnombre_materia;
        this.cclave_materia = cclave_materia;
        this.ncalificación = ncalificación;
        this.nsemestre = nsemestre;
        this.cperiodo = cperiodo;
        this.canio = canio;
    }

    // Getters y Setters
    public Integer getNid_insc_alumno() {
        return nid_insc_alumno;
    }

    public void setNid_insc_alumno(Integer nid_insc_alumno) {
        this.nid_insc_alumno = nid_insc_alumno;
    }

    public Integer getNid_horario_materia() {
        return nid_horario_materia;
    }

    public void setNid_horario_materia(Integer nid_horario_materia) {
        this.nid_horario_materia = nid_horario_materia;
    }

    public String getCnombre_materia() {
        return cnombre_materia;
    }

    public void setCnombre_materia(String cnombre_materia) {
        this.cnombre_materia = cnombre_materia;
    }

    public String getCclave_materia() {
        return cclave_materia;
    }

    public void setCclave_materia(String cclave_materia) {
        this.cclave_materia = cclave_materia;
    }

    public Float getNcalificación() {
        return ncalificación;
    }

    public void setNcalificación(Float ncalificación) {
        this.ncalificación = ncalificación;
    }

    public Integer getNsemestre() {
        return nsemestre;
    }

    public void setNsemestre(Integer nsemestre) {
        this.nsemestre = nsemestre;
    }

    public String getCperiodo() {
        return cperiodo;
    }

    public void setCperiodo(String cperiodo) {
        this.cperiodo = cperiodo;
    }

    public String getCanio() {
        return canio;
    }

    public void setCanio(String canio) {
        this.canio = canio;
    }
}
