/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Perez
 */
@Entity
@Table(name = "DOC_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocVenta.findAll", query = "SELECT d FROM DocVenta d")
    , @NamedQuery(name = "DocVenta.findByNcodDoc", query = "SELECT d FROM DocVenta d WHERE d.ncodDoc = :ncodDoc")
    , @NamedQuery(name = "DocVenta.findByNumDoc", query = "SELECT d FROM DocVenta d WHERE d.numDoc = :numDoc")
    , @NamedQuery(name = "DocVenta.findByTipDoc", query = "SELECT d FROM DocVenta d WHERE d.tipDoc = :tipDoc")
    , @NamedQuery(name = "DocVenta.findByFchingDoc", query = "SELECT d FROM DocVenta d WHERE d.fchingDoc = :fchingDoc")
    , @NamedQuery(name = "DocVenta.findByMontDoc", query = "SELECT d FROM DocVenta d WHERE d.montDoc = :montDoc")
    , @NamedQuery(name = "DocVenta.findByDondoc", query = "SELECT d FROM DocVenta d WHERE d.dondoc = :dondoc")
    , @NamedQuery(name = "DocVenta.findByObsDoc", query = "SELECT d FROM DocVenta d WHERE d.obsDoc = :obsDoc")})
public class DocVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NCOD_DOC")
    private Integer ncodDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "NUM_DOC")
    private String numDoc;
    @Size(max = 10)
    @Column(name = "TIP_DOC")
    private String tipDoc;
    @Column(name = "FCHING_DOC")
    @Temporal(TemporalType.DATE)
    private Date fchingDoc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONT_DOC")
    private BigDecimal montDoc;
    @Column(name = "DONDOC")
    private BigDecimal dondoc;
    @Size(max = 50)
    @Column(name = "OBS_DOC")
    private String obsDoc;
    @JoinColumn(name = "CODPAC", referencedColumnName = "CODPAC")
    @ManyToOne
    private Paciente codpac;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docVenta")
    private List<Detventa> detventaList;

    public DocVenta() {
    }

    public DocVenta(Integer ncodDoc) {
        this.ncodDoc = ncodDoc;
    }

    public DocVenta(Integer ncodDoc, String numDoc) {
        this.ncodDoc = ncodDoc;
        this.numDoc = numDoc;
    }

    public Integer getNcodDoc() {
        return ncodDoc;
    }

    public void setNcodDoc(Integer ncodDoc) {
        this.ncodDoc = ncodDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public Date getFchingDoc() {
        return fchingDoc;
    }

    public void setFchingDoc(Date fchingDoc) {
        this.fchingDoc = fchingDoc;
    }

    public BigDecimal getMontDoc() {
        return montDoc;
    }

    public void setMontDoc(BigDecimal montDoc) {
        this.montDoc = montDoc;
    }

    public BigDecimal getDondoc() {
        return dondoc;
    }

    public void setDondoc(BigDecimal dondoc) {
        this.dondoc = dondoc;
    }

    public String getObsDoc() {
        return obsDoc;
    }

    public void setObsDoc(String obsDoc) {
        this.obsDoc = obsDoc;
    }

    public Paciente getCodpac() {
        return codpac;
    }

    public void setCodpac(Paciente codpac) {
        this.codpac = codpac;
    }

    @XmlTransient
    public List<Detventa> getDetventaList() {
        return detventaList;
    }

    public void setDetventaList(List<Detventa> detventaList) {
        this.detventaList = detventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ncodDoc != null ? ncodDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocVenta)) {
            return false;
        }
        DocVenta other = (DocVenta) object;
        if ((this.ncodDoc == null && other.ncodDoc != null) || (this.ncodDoc != null && !this.ncodDoc.equals(other.ncodDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.DocVenta[ ncodDoc=" + ncodDoc + " ]";
    }
    
}
