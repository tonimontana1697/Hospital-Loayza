/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Perez
 */
@Entity
@Table(name = "PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByCodprov", query = "SELECT p FROM Proveedor p WHERE p.codprov = :codprov")
    , @NamedQuery(name = "Proveedor.findByNomprov", query = "SELECT p FROM Proveedor p WHERE p.nomprov = :nomprov")
    , @NamedQuery(name = "Proveedor.findByRucprov", query = "SELECT p FROM Proveedor p WHERE p.rucprov = :rucprov")
    , @NamedQuery(name = "Proveedor.findByDirprov", query = "SELECT p FROM Proveedor p WHERE p.dirprov = :dirprov")
    , @NamedQuery(name = "Proveedor.findByTipprov", query = "SELECT p FROM Proveedor p WHERE p.tipprov = :tipprov")
    , @NamedQuery(name = "Proveedor.findByTelfprov", query = "SELECT p FROM Proveedor p WHERE p.telfprov = :telfprov")
    , @NamedQuery(name = "Proveedor.findByComprov", query = "SELECT p FROM Proveedor p WHERE p.comprov = :comprov")
    , @NamedQuery(name = "Proveedor.findByAbrprov", query = "SELECT p FROM Proveedor p WHERE p.abrprov = :abrprov")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPROV")
    private Integer codprov;
    @Size(max = 80)
    @Column(name = "NOMPROV")
    private String nomprov;
    @Size(max = 11)
    @Column(name = "RUCPROV")
    private String rucprov;
    @Size(max = 100)
    @Column(name = "DIRPROV")
    private String dirprov;
    @Size(max = 18)
    @Column(name = "TIPPROV")
    private String tipprov;
    @Size(max = 50)
    @Column(name = "TELFPROV")
    private String telfprov;
    @Size(max = 80)
    @Column(name = "COMPROV")
    private String comprov;
    @Size(max = 8)
    @Column(name = "ABRPROV")
    private String abrprov;
    @OneToMany(mappedBy = "codprov")
    private List<Medicina> medicinaList;
    @JoinColumn(name = "UBIGEO", referencedColumnName = "UBIGEO")
    @ManyToOne
    private Ubigeo ubigeo;

    public Proveedor() {
    }

    public Proveedor(Integer codprov) {
        this.codprov = codprov;
    }

    public Integer getCodprov() {
        return codprov;
    }

    public void setCodprov(Integer codprov) {
        this.codprov = codprov;
    }

    public String getNomprov() {
        return nomprov;
    }

    public void setNomprov(String nomprov) {
        this.nomprov = nomprov;
    }

    public String getRucprov() {
        return rucprov;
    }

    public void setRucprov(String rucprov) {
        this.rucprov = rucprov;
    }

    public String getDirprov() {
        return dirprov;
    }

    public void setDirprov(String dirprov) {
        this.dirprov = dirprov;
    }

    public String getTipprov() {
        return tipprov;
    }

    public void setTipprov(String tipprov) {
        this.tipprov = tipprov;
    }

    public String getTelfprov() {
        return telfprov;
    }

    public void setTelfprov(String telfprov) {
        this.telfprov = telfprov;
    }

    public String getComprov() {
        return comprov;
    }

    public void setComprov(String comprov) {
        this.comprov = comprov;
    }

    public String getAbrprov() {
        return abrprov;
    }

    public void setAbrprov(String abrprov) {
        this.abrprov = abrprov;
    }

    @XmlTransient
    public List<Medicina> getMedicinaList() {
        return medicinaList;
    }

    public void setMedicinaList(List<Medicina> medicinaList) {
        this.medicinaList = medicinaList;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprov != null ? codprov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.codprov == null && other.codprov != null) || (this.codprov != null && !this.codprov.equals(other.codprov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Proveedor[ codprov=" + codprov + " ]";
    }
    
}
