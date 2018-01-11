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
@Table(name = "roll")
@NamedQueries({
    @NamedQuery(name = "Roll.findAll", query = "SELECT r FROM Roll r"),
    @NamedQuery(name = "Roll.findByIdRoll", query = "SELECT r FROM Roll r WHERE r.idRoll = :idRoll"),
    @NamedQuery(name = "Roll.findByTipoRoll", query = "SELECT r FROM Roll r WHERE r.tipoRoll = :tipoRoll")})
public class Roll implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_roll")
    private Integer idRoll;
    @Basic(optional = false)
    @Column(name = "tipo_roll")
    private String tipoRoll;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roll", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Roll() {
    }

    public Roll(Integer idRoll) {
        this.idRoll = idRoll;
    }

    public Roll(Integer idRoll, String tipoRoll) {
        this.idRoll = idRoll;
        this.tipoRoll = tipoRoll;
    }

    public Integer getIdRoll() {
        return idRoll;
    }

    public void setIdRoll(Integer idRoll) {
        this.idRoll = idRoll;
    }

    public String getTipoRoll() {
        return tipoRoll;
    }

    public void setTipoRoll(String tipoRoll) {
        this.tipoRoll = tipoRoll;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoll != null ? idRoll.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roll)) {
            return false;
        }
        Roll other = (Roll) object;
        if ((this.idRoll == null && other.idRoll != null) || (this.idRoll != null && !this.idRoll.equals(other.idRoll))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drogueria.persistencia.Roll[ idRoll=" + idRoll + " ]";
    }
    
}
