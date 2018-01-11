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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "factura_venta")
@NamedQueries({
    @NamedQuery(name = "FacturaVenta.findAll", query = "SELECT f FROM FacturaVenta f"),
    @NamedQuery(name = "FacturaVenta.findByIdFacturaVenta", query = "SELECT f FROM FacturaVenta f WHERE f.idFacturaVenta = :idFacturaVenta"),
    @NamedQuery(name = "FacturaVenta.findByIva", query = "SELECT f FROM FacturaVenta f WHERE f.iva = :iva"),
    @NamedQuery(name = "FacturaVenta.findByTotal", query = "SELECT f FROM FacturaVenta f WHERE f.total = :total"),
    @NamedQuery(name = "FacturaVenta.findByFechaFactura", query = "SELECT f FROM FacturaVenta f WHERE f.fechaFactura = :fechaFactura"),
    @NamedQuery(name = "FacturaVenta.findByHora", query = "SELECT f FROM FacturaVenta f WHERE f.hora = :hora")})
public class FacturaVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura_venta")
    private Integer idFacturaVenta;
    @Column(name = "iva")
    private Integer iva;
    @Basic(optional = false)
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @Column(name = "fecha_factura")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    
//    @OneToMany (cascade =CascadeType.ALL, mappedBy ="factura", fetch = FetchType.LAZY)
//    private List<ItemVenta> listaItemVenta;
 @JoinTable(name = "item_venta", joinColumns = {
       @JoinColumn(name = "id_factura_venta", referencedColumnName = "id_factura_venta" )} , inverseJoinColumns = {
       @JoinColumn(name = "id_medicamento", referencedColumnName = "id_medicamento") })   
 @OneToMany(fetch=FetchType.LAZY)
  private List<Medicamento> medicamentoList;
 
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "id_cajero", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;

    public FacturaVenta() {
    }

    public FacturaVenta(Integer idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public FacturaVenta(Integer idFacturaVenta, int total, Date fechaFactura, Date hora) {
        this.idFacturaVenta = idFacturaVenta;
        this.total = total;
        this.fechaFactura = fechaFactura;
        this.hora = hora;
    }

    public Integer getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(Integer idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

//    public List<ItemVenta> getListaItemVenta() {
//        return listaItemVenta;
//    }
//
//    public void setListaItemVenta(List<ItemVenta> listaItemVenta) {
//        this.listaItemVenta = listaItemVenta;
//    }

    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void setMedicamentoList(List<Medicamento> medicamentoList) {
        this.medicamentoList = medicamentoList;
    }

   

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaVenta != null ? idFacturaVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaVenta)) {
            return false;
        }
        FacturaVenta other = (FacturaVenta) object;
        if ((this.idFacturaVenta == null && other.idFacturaVenta != null) || (this.idFacturaVenta != null && !this.idFacturaVenta.equals(other.idFacturaVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "drogueria.persistencia.FacturaVenta[ idFacturaVenta=" + idFacturaVenta + " ]";
    }
    
}
