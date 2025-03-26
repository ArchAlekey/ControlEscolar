package com.tramp.controlescolar.models.tablas;

import jakarta.persistence.*;
import java.util.Date;
import lombok.*;

@Entity
@Table(name = "tbl_personas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nid_persona")
    private Integer nid_persona;

    @Column(name = "cnombre", nullable = false)
    private String cnombre;

    @Column(name = "capellidos", nullable = false)
    private String capellidos;

    @Column(name = "bsexo", nullable = false)
    private Boolean bsexo;

    @Column(name = "nedad", nullable = false)
    private Integer nedad;

    @Temporal(TemporalType.DATE)
    @Column(name = "dfecha_nacimiento")
    private Date dfecha_nacimiento;

    @Column(name = "cCURP", unique = true, length = 18, nullable = false)
    private String cCURP;

    @Column(name = "cRFC", unique = true, length = 13, nullable = false)
    private String cRFC;

    @Column(name = "cnumero_celular", length = 15)
    private String cnumero_celular;

    @Column(name = "bhabilitado", nullable = false)
    private Boolean bhabilitado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_alta")
    private Date dfecha_alta;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dfecha_baja")
    private Date dfecha_baja;

    // Constructor vacío requerido por JPA
/*     public Personas() {}

    public Personas(Integer IntIdPersona,
                    String StrNombre,
                    String StrApellidos,
                    Boolean BoolSexo,
                    Integer IntEdad,
                    Date DateFechaNacimiento,
                    String StrCURP,
                    String StrRFC, 
                    String StrNumeroCelular,
                    Boolean BoolHabilitado, 
                    Date DateFechaAlta, 
                    Date DateFechaBaja) {
        this.nid_persona = IntIdPersona;
        this.cnombre = StrNombre;
        this.capellidos = StrApellidos;
        this.bsexo = BoolSexo;
        this.nedad = IntEdad;
        this.dfecha_nacimiento = DateFechaNacimiento;
        this.cCURP = StrCURP;
        this.cRFC = StrRFC;
        this.cnumero_celular = StrNumeroCelular;
        this.bhabilitado = BoolHabilitado;
        this.dfecha_alta = DateFechaAlta;
        this.dfecha_baja = DateFechaBaja;
    }

    // Getters y Setters
    public Integer getIdPersona() { return nid_persona; }
    public void setIdPersona(Integer IntIdPersona) { this.nid_persona = IntIdPersona; }

    public String getNombre() { return cnombre; }
    public void setNombre(String StrNombre) { this.cnombre = StrNombre; }

    public String getApellidos() { return capellidos; }
    public void setApellidos(String StrApellidos) { this.capellidos = StrApellidos; }

    public Boolean getSexo() { return bsexo; }
    public void setSexo(Boolean BoolSexo) { this.bsexo = BoolSexo; }

    public Integer getEdad() { return nedad; }
    public void setEdad(Integer IntEdad) { this.nedad = IntEdad; }

    public Date getFechaNacimiento() { return dfecha_nacimiento; }
    public void setFechaNacimiento(Date DateFechaNacimiento) { this.dfecha_nacimiento = DateFechaNacimiento; }

    public String getCURP() { return cCURP; }
    public void setCURP(String StrCURP) { this.cCURP = StrCURP; }

    public String getRFC() { return cRFC; }
    public void setRFC(String StrRFC) { this.cRFC = StrRFC; }

    public String getNumeroCelular() { return cnumero_celular; }
    public void setNumeroCelular(String StrNumeroCelular) { this.cnumero_celular = StrNumeroCelular; }

    public Boolean getHabilitado() { return bhabilitado; }
    public void setHabilitado(Boolean BoolHabilitado) { this.bhabilitado = BoolHabilitado; }

    public Date getFechaAlta() { return dfecha_alta; }
    public void setFechaAlta(Date DateFechaAlta) { this.dfecha_alta = DateFechaAlta; }

    public Date getFechaBaja() { return dfecha_baja; }
    public void setFechaBaja(Date DateFechaBaja) { this.dfecha_baja = DateFechaBaja; } */
}
