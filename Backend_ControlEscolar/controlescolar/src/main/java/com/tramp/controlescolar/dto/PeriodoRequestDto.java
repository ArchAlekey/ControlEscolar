package com.tramp.controlescolar.dto;

public class PeriodoRequestDto {

        private String cperiodo;
        private String canio;
        private Boolean bhabilitado;

        // Getters y setters
        public String getCperiodo() { return cperiodo; }
        public void setCperiodo(String cperiodo) { this.cperiodo = cperiodo; }

        public String getCanio() { return canio; }
        public void setCanio(String canio) { this.canio = canio; }

        public Boolean getBhabilitado() { return bhabilitado; }
        public void setBhabilitado(Boolean bhabilitado) { this.bhabilitado = bhabilitado; }

}
