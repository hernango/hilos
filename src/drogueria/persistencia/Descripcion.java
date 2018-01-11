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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hernan
 */
@Entity
@Table(name = "descripcion")
@NamedQueries({
    @NamedQuery(name = "Descripcion.findAll", query = "SELECT d FROM Descripcion d"),
    @NamedQuery(name = "Descripcion.findByIdDesc", query = "SELECT d FROM Descripcion d WHERE d.idDesc = :idDesc"),
    @NamedQuery(name = "Descripcion.findByNombreComercial", query = "SELECT d FROM Descripcion d WHERE d.nombreComercial = :nombreComercial"),
    @NamedQuery(name = "Descripcion.findByNombreCorto", query = "SELECT d FROM Descripcion d WHERE d.nombreCorto = :nombreCorto"),
    @NamedQuery(name = "Descripcion.findByDescripcionLarga", query = "SELECT d FROM Descripcion d WHERE d.descripcionLarga = :descripcionLarga")})
public class Descripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_desc")
    private Integer idDesc;
    @Basic(optional = false)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    @Basic(optional = false)
    @Column(name = "nombre_corto")
    private String nombreCorto;
    @Column(name = "descripcion_larga")
    private String descripcionLarga;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descripcion", fetch = FetchType.LAZY)
    private List<LaboratorioDescMed> laboratorioDescMedList;

    public Descripcion() {
    }

    public Descripcion(Integer idDesc) {
        this.idDesc = idDesc;
    }

    public Descripcion(Integer idDesc, String nombreComercial, String nombreCorto) {
        this.idDesc = idDesc;
        this.nombreComercial = nombreComercial;
        this.nombreCorto = nombreCorto;
    }

    public Integer getIdDesc() {
        return idDesc;
    }

    public void setIdDesc(Integer idDesc) {
        this.idDesc = idDesc;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        hash += (idDesc != null ? idDesc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descripcion)) {
            return false;
        }
        Descripcion other = (Descripcion) object;
        if ((this.idDesc == null && other.idDesc != null) || (this.idDesc != null && !this.idDesc.equals(other.idDesc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drogueria.persistencia.Descripcion[ idDesc=" + idDesc + " ]";
    }
    
}
