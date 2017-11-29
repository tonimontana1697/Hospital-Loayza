/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidad;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Perez
 */
@Entity
@Table(name = "PACIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paciente.findAll", query = "SELECT p FROM Paciente p")
    , @NamedQuery(name = "Paciente.findByCodpac", query = "SELECT p FROM Paciente p WHERE p.codpac = :codpac")
    , @NamedQuery(name = "Paciente.findByNompac", query = "SELECT p FROM Paciente p WHERE p.nompac = :nompac")
    , @NamedQuery(name = "Paciente.findByApepac", query = "SELECT p FROM Paciente p WHERE p.apepac = :apepac")
    , @NamedQuery(name = "Paciente.findBySexpac", query = "SELECT p FROM Paciente p WHERE p.sexpac = :sexpac")
    , @NamedQuery(name = "Paciente.findByDnipac", query = "SELECT p FROM Paciente p WHERE p.dnipac = :dnipac")
    , @NamedQuery(name = "Paciente.findByFnpac", query = "SELECT p FROM Paciente p WHERE p.fnpac = :fnpac")
    , @NamedQuery(name = "Paciente.findByDirpac", query = "SELECT p FROM Paciente p WHERE p.dirpac = :dirpac")
    , @NamedQuery(name = "Paciente.findByTelfpac", query = "SELECT p FROM Paciente p WHERE p.telfpac = :telfpac")
    , @NamedQuery(name = "Paciente.findByEmailpac", query = "SELECT p FROM Paciente p WHERE p.emailpac = :emailpac")
    , @NamedQuery(name = "Paciente.findByHcpac", query = "SELECT p FROM Paciente p WHERE p.hcpac = :hcpac")
    , @NamedQuery(name = "Paciente.findByEstpac", query = "SELECT p FROM Paciente p WHERE p.estpac = :estpac")})
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODPAC")
    private Integer codpac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOMPAC")
    private String nompac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "APEPAC")
    private String apepac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEXPAC")
    private Character sexpac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DNIPAC")
    private String dnipac;
    @Column(name = "FNPAC")
    @Temporal(TemporalType.DATE)
    private Date fnpac;
    @Size(max = 50)
    @Column(name = "DIRPAC")
    private String dirpac;
    @Size(max = 30)
    @Column(name = "TELFPAC")
    private String telfpac;
    @Size(max = 30)
    @Column(length = 30)
    @Email(message = "Corregir el correo ingresado")
    private String emailpac;
    @Size(max = 11)
    @Column(name = "HCPAC")
    private String hcpac;
    @Size(max = 20)
    @Column(name = "ESTPAC")
    private String estpac;
    @OneToMany(mappedBy = "codpac")
    private List<DocVenta> docVentaList;
    @JoinColumn(name = "UBIGEO", referencedColumnName = "UBIGEO")
    @ManyToOne
    private Ubigeo ubigeo;

    public Paciente() {
    }

    public Paciente(Integer codpac) {
        this.codpac = codpac;
    }

    public Paciente(Integer codpac, String nompac, String apepac, Character sexpac, String dnipac) {
        this.codpac = codpac;
        this.nompac = nompac;
        this.apepac = apepac;
        this.sexpac = sexpac;
        this.dnipac = dnipac;
    }

    public Integer getCodpac() {
        return codpac;
    }

    public void setCodpac(Integer codpac) {
        this.codpac = codpac;
    }

    public String getNompac() {
        return nompac;
    }

    public void setNompac(String nompac) {
        this.nompac = nompac;
    }

    public String getApepac() {
        return apepac;
    }

    public void setApepac(String apepac) {
        this.apepac = apepac;
    }

    public Character getSexpac() {
        return sexpac;
    }

    public void setSexpac(Character sexpac) {
        this.sexpac = sexpac;
    }

    public String getDnipac() {
        return dnipac;
    }

    public void setDnipac(String dnipac) {
        this.dnipac = dnipac;
    }

    public Date getFnpac() {
        return fnpac;
    }

    public void setFnpac(Date fnpac) {
        this.fnpac = fnpac;
    }

    public String getDirpac() {
        return dirpac;
    }

    public void setDirpac(String dirpac) {
        this.dirpac = dirpac;
    }

    public String getTelfpac() {
        return telfpac;
    }

    public void setTelfpac(String telfpac) {
        this.telfpac = telfpac;
    }

    public String getEmailpac() {
        return emailpac;
    }

    public void setEmailpac(String emailpac) {
        this.emailpac = emailpac;
    }

    public String getHcpac() {
        return hcpac;
    }

    public void setHcpac(String hcpac) {
        this.hcpac = hcpac;
    }

    public String getEstpac() {
        return estpac;
    }

    public void setEstpac(String estpac) {
        this.estpac = estpac;
    }

    @XmlTransient
    public List<DocVenta> getDocVentaList() {
        return docVentaList;
    }

    public void setDocVentaList(List<DocVenta> docVentaList) {
        this.docVentaList = docVentaList;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getPaciente(){
        switch (String.valueOf(this.sexpac)){
            case "M": return "Masculino";
            case "F": return "Femenino";
            default: return "No Definido";
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codpac != null ? codpac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.codpac == null && other.codpac != null) || (this.codpac != null && !this.codpac.equals(other.codpac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Paciente[ codpac=" + codpac + " ]";
    }
    
}
