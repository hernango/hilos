/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import drogueria.persistencia.LaboratorioDescMedVenta;

/**
 *
 * @author hernan
 */
public class ItemVenta {

private int stock;
private LaboratorioDescMedVenta labDescVenta;
private int cantidad;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LaboratorioDescMedVenta getLabDescVenta() {
        return labDescVenta;
    }

    public void setLabDescVenta(LaboratorioDescMedVenta labDescVenta) {
        this.labDescVenta = labDescVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public int calcularValorDescuento() {
        int valor=labDescVenta.getPrecio() * this.getCantidad();
        if (labDescVenta.getNeto() == 0) {
           valor= (int)Math.round(valor *0.75);
        }
        
        return valor;
    }

}
