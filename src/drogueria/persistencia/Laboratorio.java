/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drogueria.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hernan
 */
@Entity
@Table(name = "laboratorio")
@NamedQueries({
    @NamedQuery(name = "Laboratorio.findAll", query = "SELECT l FROM Laboratorio l"),
    @NamedQuery(name = "Laboratorio.findByIdLab", query = "SELECT l FROM Laboratorio l WHERE l.idLab = :idLab"),
    @NamedQuery(name = "Laboratorio.findByNombre", query = "SELECT l FROM Laboratorio l WHERE l.nombre = :nombre")})
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lab")
    private Integer idLab;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laboratorio", fetch = FetchType.LAZY)
    private List<LaboratorioDescMed> laboratorioDescMedList;

    public Laboratorio() {
    }

    public Laboratorio(Integer idLab) {
        this.idLab = idLab;
    }

    public Laboratorio(Integer idLab, String nombre) {
        this.idLab = idLab;
        this.nombre = nombre;
    }

    public Integer getIdLab() {
        return idLab;
    }

    public void setIdLab(Integer idLab) {
        this.idLab = idLab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<LaboratorioDescMed> getLaboratorioDescMedList() {
        return laboratorioDescMedList;
    }

    public void setLaboratorioDescMedList(List<LaboratorioDescMed> laboratorioDescMedList) {
        this.laboratorioDescMedList = laboratorioDescMedList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLab != null ? idLab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laboratorio)) {
            return false;
        }
        Laboratorio other = (Laboratorio) object;
        if ((this.idLab == null && other.idLab != null) || (this.idLab != null && !this.idLab.equals(other.idLab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drogueria.persistencia.Laboratorio[ idLab=" + idLab + " ]";
    }
    
}
