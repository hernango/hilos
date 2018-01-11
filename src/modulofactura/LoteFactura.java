/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import drogueria.persistencia.Lote;

/**
 *
 * @author hernan
 */
public class LoteFactura {
    private Lote lote;
    private int cantidad=0;
    private int cantidadMedLote=0;

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadMedLote() {
        return cantidadMedLote;
    }

    public void setCantidadMedLote(int cantidadMedLote) {
        this.cantidadMedLote = cantidadMedLote;
    }
    
    
    
    public void aumentarCantidad(){
    this.cantidad++;}
    
    public void disminuirCantidad()
    {
    this.cantidad--;
    }
    
    public boolean posibleAgregarALote(){
    
    boolean posible=((this.getCantidad()+ 1) <= this.cantidadMedLote);
    return posible;
    }
    
}
