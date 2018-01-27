/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drogueria.persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author hernan
 */
@Entity
@Table(name = "configuracion_sistema")
@NamedQueries({
    @NamedQuery(name = "ConfiguracionSistema.findAll", query = "SELECT c FROM ConfiguracionSistema c"),
    @NamedQuery(name = "ConfiguracionSistema.findById", query = "SELECT c FROM ConfiguracionSistema c WHERE c.id = :id"),
    @NamedQuery(name = "ConfiguracionSistema.findByNombreEstabecimiento", query = "SELECT c FROM ConfiguracionSistema c WHERE c.nombreEstabecimiento = :nombreEstabecimiento"),
    @NamedQuery(name = "ConfiguracionSistema.findByDirecion", query = "SELECT c FROM ConfiguracionSistema c WHERE c.direcion = :direcion"),
    @NamedQuery(name = "ConfiguracionSistema.findByTelefono", query = "SELECT c FROM ConfiguracionSistema c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "ConfiguracionSistema.findByNotificacionMesVencer", query = "SELECT c FROM ConfiguracionSistema c WHERE c.notificacionMesVencer = :notificacionMesVencer"),
    @NamedQuery(name = "ConfiguracionSistema.findByPorcientoIva", query = "SELECT c FROM ConfiguracionSistema c WHERE c.porcientoIva = :porcientoIva"),
    @NamedQuery(name = "ConfiguracionSistema.findByResolusionDIAN", query = "SELECT c FROM ConfiguracionSistema c WHERE c.resolusionDIAN = :resolusionDIAN")})
public class ConfiguracionSistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre_estabecimiento")
    private String nombreEstabecimiento;
    @Basic(optional = false)
    @Column(name = "direcion")
    private String direcion;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "notificacion_mes_vencer")
    private int notificacionMesVencer;
    @Basic(optional = false)
    @Column(name = "porciento_iva")
    private int porcientoIva;
    @Basic(optional = false)
    @Column(name = "resolusionDIAN")
    private String resolusionDIAN;

    public ConfiguracionSistema() {
    }

    public ConfiguracionSistema(Integer id) {
        this.id = id;
    }

    public ConfiguracionSistema(Integer id, String nombreEstabecimiento, String direcion, int telefono, int notificacionMesVencer, int porcientoIva, String resolusionDIAN) {
        this.id = id;
        this.nombreEstabecimiento = nombreEstabecimiento;
        this.direcion = direcion;
        this.telefono = telefono;
        this.notificacionMesVencer = notificacionMesVencer;
        this.porcientoIva = porcientoIva;
        this.resolusionDIAN = resolusionDIAN;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEstabecimiento() {
        return nombreEstabecimiento;
    }

    public void setNombreEstabecimiento(String nombreEstabecimiento) {
        this.nombreEstabecimiento = nombreEstabecimiento;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getNotificacionMesVencer() {
        return notificacionMesVencer;
    }

    public void setNotificacionMesVencer(int notificacionMesVencer) {
        this.notificacionMesVencer = notificacionMesVencer;
    }

    public int getPorcientoIva() {
        return porcientoIva;
    }

    public void setPorcientoIva(int porcientoIva) {
        this.porcientoIva = porcientoIva;
    }

    public String getResolusionDIAN() {
        return resolusionDIAN;
    }

    public void setResolusionDIAN(String resolusionDIAN) {
        this.resolusionDIAN = resolusionDIAN;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfiguracionSistema)) {
            return false;
        }
        ConfiguracionSistema other = (ConfiguracionSistema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drogueria.persistencia.ConfiguracionSistema[ id=" + id + " ]";
    }
    
}
