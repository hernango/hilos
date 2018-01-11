/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drogueria.persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author hernan
 */
@Entity
@Table(name = "consulta_med")
@NamedQueries({
    @NamedQuery(name = "ConsultaMed.findAll", query = "SELECT c FROM ConsultaMed c"),
    @NamedQuery(name = "ConsultaMed.findByIdLote", query = "SELECT c FROM ConsultaMed c WHERE c.idLote = :idLote"),
    @NamedQuery(name = "ConsultaMed.findByIdMedicamento", query = "SELECT c FROM ConsultaMed c WHERE c.idMedicamento = :idMedicamento"),
    @NamedQuery(name = "ConsultaMed.findByFechaVigencia", query = "SELECT c FROM ConsultaMed c WHERE c.fechaVigencia = :fechaVigencia"),
    @NamedQuery(name = "ConsultaMed.findByIdLab", query = "SELECT c FROM ConsultaMed c WHERE c.idLab = :idLab"),
    @NamedQuery(name = "ConsultaMed.findByIdDesc", query = "SELECT c FROM ConsultaMed c WHERE c.idDesc = :idDesc"),
    @NamedQuery(name = "ConsultaMed.findByPrecio", query = "SELECT c FROM ConsultaMed c WHERE c.precio = :precio"),
    @NamedQuery(name = "ConsultaMed.findByPresentacion", query = "SELECT c FROM ConsultaMed c WHERE c.presentacion = :presentacion"),
    @NamedQuery(name = "ConsultaMed.findByNombreComercial", query = "SELECT c FROM ConsultaMed c WHERE c.nombreComercial = :nombreComercial")})

public class ConsultaMed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id_lote")
    private String idLote;
    @Basic(optional = false)
    @Column(name = "id_medicamento")
    @Id
    private int idMedicamento;
    @Basic(optional = false)
    @Column(name = "fecha_vigencia")
    @Temporal(TemporalType.DATE)
    private Date fechaVigencia;
    @Basic(optional = false)
    @Column(name = "id_lab")
    private int idLab;
    @Basic(optional = false)
    @Column(name = "id_desc")
    private int idDesc;
    @Basic(optional = false)
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @Column(name = "presentacion")
    private String presentacion;
    @Basic(optional = false)
    @Column(name = "nombre_comercial")
    private String nombreComercial;

    public ConsultaMed() {
    }

    public String getIdLote() {
        return idLote;
    }

    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public Date getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
    
}
