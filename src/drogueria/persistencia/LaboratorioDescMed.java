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
@Table(name = "laboratorio_desc_med")
@NamedQueries({
    @NamedQuery(name = "LaboratorioDescMed.findAll", query = "SELECT l FROM LaboratorioDescMed l"),
    @NamedQuery(name = "LaboratorioDescMed.findByIdLab", query = "SELECT l FROM LaboratorioDescMed l WHERE l.laboratorioDescMedPK.idLab = :idLab"),
    @NamedQuery(name = "LaboratorioDescMed.findByIdDesc", query = "SELECT l FROM LaboratorioDescMed l WHERE l.laboratorioDescMedPK.idDesc = :idDesc"),
    @NamedQuery(name = "LaboratorioDescMed.findByInvima", query = "SELECT l FROM LaboratorioDescMed l WHERE l.invima = :invima")})
public class LaboratorioDescMed implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LaboratorioDescMedPK laboratorioDescMedPK;
    @Column(name = "invima")
    private String invima;
    @Basic(optional = true)
    @Column(name = "codigo_barras")
    private String codigoBarras;
    @JoinColumn(name = "id_lab", referencedColumnName = "id_lab", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Laboratorio laboratorio;
    @JoinColumn(name = "id_desc", referencedColumnName = "id_desc", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Descripcion descripcion;

    public LaboratorioDescMed() {
    }

    public LaboratorioDescMed(LaboratorioDescMedPK laboratorioDescMedPK) {
        this.laboratorioDescMedPK = laboratorioDescMedPK;
    }

    public LaboratorioDescMed(int idLab, int idDesc) {
        this.laboratorioDescMedPK = new LaboratorioDescMedPK(idLab, idDesc);
    }

    public LaboratorioDescMedPK getLaboratorioDescMedPK() {
        return laboratorioDescMedPK;
    }

    public void setLaboratorioDescMedPK(LaboratorioDescMedPK laboratorioDescMedPK) {
        this.laboratorioDescMedPK = laboratorioDescMedPK;
    }

    public String getInvima() {
        return invima;
    }

    public void setInvima(String invima) {
        this.invima = invima;
    }

   public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(Descripcion descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (laboratorioDescMedPK != null ? laboratorioDescMedPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaboratorioDescMed)) {
            return false;
        }
        LaboratorioDescMed other = (LaboratorioDescMed) object;
        if ((this.laboratorioDescMedPK == null && other.laboratorioDescMedPK != null) || (this.laboratorioDescMedPK != null && !this.laboratorioDescMedPK.equals(other.laboratorioDescMedPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drogueria.persistencia.LaboratorioDescMed[ laboratorioDescMedPK=" + laboratorioDescMedPK + " ]";
    }
    
}
