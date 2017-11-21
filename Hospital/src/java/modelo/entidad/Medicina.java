/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Perez
 */
@Entity
@Table(name = "MEDICINA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicina.findAll", query = "SELECT m FROM Medicina m")
    , @NamedQuery(name = "Medicina.findByCodmed", query = "SELECT m FROM Medicina m WHERE m.codmed = :codmed")
    , @NamedQuery(name = "Medicina.findByNomgenmed", query = "SELECT m FROM Medicina m WHERE m.nomgenmed = :nomgenmed")
    , @NamedQuery(name = "Medicina.findByNomcommed", query = "SELECT m FROM Medicina m WHERE m.nomcommed = :nomcommed")
    , @NamedQuery(name = "Medicina.findByCosmed", query = "SELECT m FROM Medicina m WHERE m.cosmed = :cosmed")
    , @NamedQuery(name = "Medicina.findByPrecmed", query = "SELECT m FROM Medicina m WHERE m.precmed = :precmed")
    , @NamedQuery(name = "Medicina.findByPremed", query = "SELECT m FROM Medicina m WHERE m.premed = :premed")
    , @NamedQuery(name = "Medicina.findByCantmed", query = "SELECT m FROM Medicina m WHERE m.cantmed = :cantmed")
    , @NamedQuery(name = "Medicina.findByObsmed", query = "SELECT m FROM Medicina m WHERE m.obsmed = :obsmed")
    , @NamedQuery(name = "Medicina.findByFchmed", query = "SELECT m FROM Medicina m WHERE m.fchmed = :fchmed")
    , @NamedQuery(name = "Medicina.findByLotmed", query = "SELECT m FROM Medicina m WHERE m.lotmed = :lotmed")})
public class Medicina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODMED")
    private Integer codmed;
    @Size(max = 100)
    @Column(name = "NOMGENMED")
    private String nomgenmed;
    @Size(max = 80)
    @Column(name = "NOMCOMMED")
    private String nomcommed;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSMED")
    private BigDecimal cosmed;
    @Column(name = "PRECMED")
    private BigDecimal precmed;
    @Size(max = 40)
    @Column(name = "PREMED")
    private String premed;
    @Column(name = "CANTMED")
    private Integer cantmed;
    @Size(max = 80)
    @Column(name = "OBSMED")
    private String obsmed;
    @Column(name = "FCHMED")
    @Temporal(TemporalType.DATE)
    private Date fchmed;
    @Size(max = 8)
    @Column(name = "LOTMED")
    private String lotmed;
    @JoinColumn(name = "CODPROV", referencedColumnName = "CODPROV")
    @ManyToOne
    private Proveedor codprov;

    public Medicina() {
    }

    public Medicina(Integer codmed) {
        this.codmed = codmed;
    }

    public Integer getCodmed() {
        return codmed;
    }

    public void setCodmed(Integer codmed) {
        this.codmed = codmed;
    }

    public String getNomgenmed() {
        return nomgenmed;
    }

    public void setNomgenmed(String nomgenmed) {
        this.nomgenmed = nomgenmed;
    }

    public String getNomcommed() {
        return nomcommed;
    }

    public void setNomcommed(String nomcommed) {
        this.nomcommed = nomcommed;
    }

    public BigDecimal getCosmed() {
        return cosmed;
    }

    public void setCosmed(BigDecimal cosmed) {
        this.cosmed = cosmed;
    }

    public BigDecimal getPrecmed() {
        return precmed;
    }

    public void setPrecmed(BigDecimal precmed) {
        this.precmed = precmed;
    }

    public String getPremed() {
        return premed;
    }

    public void setPremed(String premed) {
        this.premed = premed;
    }

    public Integer getCantmed() {
        return cantmed;
    }

    public void setCantmed(Integer cantmed) {
        this.cantmed = cantmed;
    }

    public String getObsmed() {
        return obsmed;
    }

    public void setObsmed(String obsmed) {
        this.obsmed = obsmed;
    }

    public Date getFchmed() {
        return fchmed;
    }

    public void setFchmed(Date fchmed) {
        this.fchmed = fchmed;
    }

    public String getLotmed() {
        return lotmed;
    }

    public void setLotmed(String lotmed) {
        this.lotmed = lotmed;
    }

    public Proveedor getCodprov() {
        return codprov;
    }

    public void setCodprov(Proveedor codprov) {
        this.codprov = codprov;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmed != null ? codmed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicina)) {
            return false;
        }
        Medicina other = (Medicina) object;
        if ((this.codmed == null && other.codmed != null) || (this.codmed != null && !this.codmed.equals(other.codmed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Medicina[ codmed=" + codmed + " ]";
    }
    
}
