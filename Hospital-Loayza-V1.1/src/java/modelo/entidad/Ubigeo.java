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
@Table(name = "UBIGEO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubigeo.findAll", query = "SELECT u FROM Ubigeo u")
    , @NamedQuery(name = "Ubigeo.findByUbigeo", query = "SELECT u FROM Ubigeo u WHERE u.ubigeo = :ubigeo")
    , @NamedQuery(name = "Ubigeo.findByDpto", query = "SELECT u FROM Ubigeo u WHERE u.dpto = :dpto")
    , @NamedQuery(name = "Ubigeo.findByProv", query = "SELECT u FROM Ubigeo u WHERE u.prov = :prov")
    , @NamedQuery(name = "Ubigeo.findByDist", query = "SELECT u FROM Ubigeo u WHERE u.dist = :dist")})
public class Ubigeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "UBIGEO")
    private String ubigeo;
    @Size(max = 60)
    @Column(name = "DPTO")
    private String dpto;
    @Size(max = 60)
    @Column(name = "PROV")
    private String prov;
    @Size(max = 60)
    @Column(name = "DIST")
    private String dist;
    @OneToMany(mappedBy = "ubigeo")
    private List<Proveedor> proveedorList;
    @OneToMany(mappedBy = "ubigeo")
    private List<Paciente> pacienteList;
    @OneToMany(mappedBy = "ubigeo")
    private List<Usuario> usuarioList;

    public Ubigeo() {
    }

    public Ubigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    @XmlTransient
    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ubigeo != null ? ubigeo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubigeo)) {
            return false;
        }
        Ubigeo other = (Ubigeo) object;
        if ((this.ubigeo == null && other.ubigeo != null) || (this.ubigeo != null && !this.ubigeo.equals(other.ubigeo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Ubigeo[ ubigeo=" + ubigeo + " ]";
    }
    
}
