/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drogueria.persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author hernan
 */
@Entity
@Table(name = "lote")
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l"),
    @NamedQuery(name = "Lote.findByIdLote", query = "SELECT l FROM Lote l WHERE l.idLote = :idLote"),
    @NamedQuery(name = "Lote.findByFechaCreacion", query = "SELECT l FROM Lote l WHERE l.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Lote.findByFechaVigencia", query = "SELECT l FROM Lote l WHERE l.fechaVigencia = :fechaVigencia")})
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_lote")
    private String idLote;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "fecha_vigencia")
    @Temporal(TemporalType.DATE)
    private Date fechaVigencia;
    
    @JoinColumns ({
    @JoinColumn(name = "id_desc", referencedColumnName = "id_desc", insertable = false, updatable = false),
    @JoinColumn(name = "id_lab", referencedColumnName = "id_lab", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LaboratorioDescMedVenta laboratorioDescMedVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lote", fetch = FetchType.LAZY)
    private List<Medicamento> medicamentoList;

    public Lote() {
    }

    public Lote(String idLote) {
        this.idLote = idLote;
    }

    public Lote(String idLote, Date fechaVigencia) {
        this.idLote = idLote;
        this.fechaVigencia = fechaVigencia;
    }

    public String getIdLote() {
        return idLote;
    }

    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public LaboratorioDescMedVenta getLaboratorioDescMedVenta() {
        return laboratorioDescMedVenta;
    }

    public void setLaboratorioDescMedVenta(LaboratorioDescMedVenta laboratorioDescMedVenta) {
        this.laboratorioDescMedVenta = laboratorioDescMedVenta;
    }

    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLote != null ? idLote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.idLote == null && other.idLote != null) || (this.idLote != null && !this.idLote.equals(other.idLote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drogueria.persistencia.Lote[ idLote=" + idLote + " ]";
    }
    
}
