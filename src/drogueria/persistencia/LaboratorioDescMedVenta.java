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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "laboratorio_desc_med_venta")
@NamedQueries({
    @NamedQuery(name = "LaboratorioDescMedVenta.findAll", query = "SELECT l FROM LaboratorioDescMedVenta l"),
    @NamedQuery(name = "LaboratorioDescMedVenta.findByIdLab", query = "SELECT l FROM LaboratorioDescMedVenta l WHERE l.laboratorioDescMedVentaPK.idLab = :idLab"),
    @NamedQuery(name = "LaboratorioDescMedVenta.findByIdDesc", query = "SELECT l FROM LaboratorioDescMedVenta l WHERE l.laboratorioDescMedVentaPK.idDesc = :idDesc"),
    @NamedQuery(name = "LaboratorioDescMedVenta.findByPrecio", query = "SELECT l FROM LaboratorioDescMedVenta l WHERE l.precio = :precio"),
    @NamedQuery(name = "LaboratorioDescMedVenta.findByUnidad", query = "SELECT l FROM LaboratorioDescMedVenta l WHERE l.unidad = :unidad"),
    @NamedQuery(name = "LaboratorioDescMedVenta.findByCantidadAlertaMin", query = "SELECT l FROM LaboratorioDescMedVenta l WHERE l.cantidadAlertaMin = :cantidadAlertaMin"),
    @NamedQuery(name = "LaboratorioDescMedVenta.findByEstado", query = "SELECT l FROM LaboratorioDescMedVenta l WHERE l.estado = :estado")})
public class LaboratorioDescMedVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LaboratorioDescMedVentaPK laboratorioDescMedVentaPK;
    @Basic(optional = false)
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @Column(name = "unidad")
    private String unidad;
    @Basic(optional = false)
    @Column(name = "cantidad_alerta_min")
    private int cantidadAlertaMin;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @JoinColumns ({
    @JoinColumn(name = "id_desc", referencedColumnName = "id_desc", insertable = false, updatable = false),
    @JoinColumn(name = "id_lab", referencedColumnName = "id_lab", insertable = false, updatable = false)
    })
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LaboratorioDescMed laboratorioDescMed;

    public LaboratorioDescMedVenta() {
    }

    public LaboratorioDescMedVenta(LaboratorioDescMedVentaPK laboratorioDescMedVentaPK) {
        this.laboratorioDescMedVentaPK = laboratorioDescMedVentaPK;
    }

    public LaboratorioDescMedVenta(LaboratorioDescMedVentaPK laboratorioDescMedVentaPK, int precio, String unidad, int cantidadAlertaMin, String estado) {
        this.laboratorioDescMedVentaPK = laboratorioDescMedVentaPK;
        this.precio = precio;
        this.unidad = unidad;
        this.cantidadAlertaMin = cantidadAlertaMin;
        this.estado = estado;
    }

    public LaboratorioDescMedVenta(int idLab, int idDesc) {
        this.laboratorioDescMedVentaPK = new LaboratorioDescMedVentaPK(idLab, idDesc);
    }

    public LaboratorioDescMedVentaPK getLaboratorioDescMedVentaPK() {
        return laboratorioDescMedVentaPK;
    }

    public void setLaboratorioDescMedVentaPK(LaboratorioDescMedVentaPK laboratorioDescMedVentaPK) {
        this.laboratorioDescMedVentaPK = laboratorioDescMedVentaPK;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getCantidadAlertaMin() {
        return cantidadAlertaMin;
    }

    public void setCantidadAlertaMin(int cantidadAlertaMin) {
        this.cantidadAlertaMin = cantidadAlertaMin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LaboratorioDescMed getLaboratorioDescMed() {
        return laboratorioDescMed;
    }

    public void setLaboratorioDescMed(LaboratorioDescMed laboratorioDescMed) {
        this.laboratorioDescMed = laboratorioDescMed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (laboratorioDescMedVentaPK != null ? laboratorioDescMedVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaboratorioDescMedVenta)) {
            return false;
        }
        LaboratorioDescMedVenta other = (LaboratorioDescMedVenta) object;
        if ((this.laboratorioDescMedVentaPK == null && other.laboratorioDescMedVentaPK != null) || (this.laboratorioDescMedVentaPK != null && !this.laboratorioDescMedVentaPK.equals(other.laboratorioDescMedVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drogueria.persistencia.LaboratorioDescMedVenta[ laboratorioDescMedVentaPK=" + laboratorioDescMedVentaPK + " ]";
    }
    
}
