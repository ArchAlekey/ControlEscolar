package com.tramp.controlescolar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InscripcionHorarioMateriaDTO {
    
    private Integer nid_carrera;
    private Integer nid_semestre;
    private Integer nid_materia;
    private Integer nid_grupo;
    private Integer nid_horario;
    private Integer nid_periodo;
    private Integer nid_academico_profesor;


    public Integer getNid_carrera() {
        return nid_carrera;
    }

    public void setNid_carrera(Integer nid_carrera) {
        this.nid_carrera = nid_carrera;
    }

    public Integer getNid_semestre() {
        return nid_semestre;
    }

    public void setNid_semestre(Integer nid_semestre) {
        this.nid_semestre = nid_semestre;
    }

    public Integer getNid_materia() {
        return nid_materia;
    }

    public void setNid_materia(Integer nid_materia) {
        this.nid_materia = nid_materia;
    }

    public Integer getNid_grupo() {
        return nid_grupo;
    }

    public void setNid_grupo(Integer nid_grupo) {
        this.nid_grupo = nid_grupo;
    }

    public Integer getNid_horario() {
        return nid_horario;
    }

    public void setNid_horario(Integer nid_horario) {
        this.nid_horario = nid_horario;
    }

    public Integer getNid_periodo() {
        return nid_periodo;
    }

    public void setNid_periodo(Integer nid_periodo) {
        this.nid_periodo = nid_periodo;
    }

    public Integer getNid_academico_profesor() {
        return nid_academico_profesor;
    }

    public void setNid_academico_profesor(Integer nid_academico_profesor) {
        this.nid_academico_profesor = nid_academico_profesor;
    }

}
