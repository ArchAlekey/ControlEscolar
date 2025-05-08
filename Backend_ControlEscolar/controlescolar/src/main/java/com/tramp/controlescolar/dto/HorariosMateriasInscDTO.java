package com.tramp.controlescolar.dto;

public class HorariosMateriasInscDTO {
    private Integer nid_grupo;
    private String cgrupo;    

    public HorariosMateriasInscDTO(Integer IntIdGrupo, String StrGrupo){
        this.nid_grupo = IntIdGrupo;
        this.cgrupo = StrGrupo;
    }

    public Integer getIdGrupo() { return nid_grupo; }
    public void setIdGrupo(Integer IntIdGrupo) { this.nid_grupo = IntIdGrupo; }

    public String getStrGrupo() { return cgrupo; }
    public void setStrGrupo(String StrGrupo) { this.cgrupo = StrGrupo; }
}