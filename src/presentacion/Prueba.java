/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import drogueria.persistencia.Cliente;
import drogueria.persistencia.Lote;
import drogueria.persistencia.Usuario;
import modulofactura.FacturaServiceImp;
import modulofactura.IFacturaService;
import modulofactura.LoteFactura;
import modulofactura.VisualizarFactura;

/**
 *
 * @author hernan
 */
public class Prueba {

public static void main(String a[]){
 prueba2();
}   

public static void prueba2(){
    IFacturaService factura=new FacturaServiceImp();
    factura.agregarCliente(new Cliente(1));
    factura.agregarUsuario(new Usuario(1));
    LoteFactura loteF1=new LoteFactura();
    loteF1.setLote(new Lote("7"));
    LoteFactura loteF2=new LoteFactura();
    loteF2.setLote(new Lote("13"));
    LoteFactura loteF3=new LoteFactura();
    loteF3.setLote(new Lote("8"));
    try{
    factura.agregarEnLote(loteF1);
    factura.agregarEnLote(loteF2);
    factura.agregarEnLote(loteF3);
    /* activar solo cuando se quiere mandar a base de dato */
    //factura.procesarVenta();
    
    }
    catch(Exception error){
    System.out.println("Error:" +error.getMessage());}
    
   VisualizarFactura.imprimir(factura);
}

}