/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drogueria.persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author hernan
 */
@Embeddable
public class LaboratorioDescMedVentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_lab")
    private int idLab;
    @Basic(optional = false)
    @Column(name = "id_desc")
    private int idDesc;

    public LaboratorioDescMedVentaPK() {
    }

    public LaboratorioDescMedVentaPK(int idLab, int idDesc) {
        this.idLab = idLab;
        this.idDesc = idDesc;
    }

    public int getIdLab() {
        return idLab;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }

    public int getIdDesc() {
        return idDesc;
    }

    public void setIdDesc(int idDesc) {
        this.idDesc = idDesc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLab;
        hash += (int) idDesc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaboratorioDescMedVentaPK)) {
            return false;
        }
        LaboratorioDescMedVentaPK other = (LaboratorioDescMedVentaPK) object;
        if (this.idLab != other.idLab) {
            return false;
        }
        if (this.idDesc != other.idDesc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drogueria.persistencia.LaboratorioDescMedVentaPK[ idLab=" + idLab + ", idDesc=" + idDesc + " ]";
    }
    
}
