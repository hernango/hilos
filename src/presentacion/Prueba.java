/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import drogueria.persistencia.Cliente;
import drogueria.persistencia.LaboratorioDescMedVenta;
import drogueria.persistencia.Lote;
import drogueria.persistencia.Usuario;
import modulofactura.FacturaServiceImp;
import modulofactura.IFacturaService;
import modulofactura.LoteFactura;
import modulofactura.ServicioSalud;
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
    loteF3.setLote(new Lote("7023"));
    LaboratorioDescMedVenta descLab1=new LaboratorioDescMedVenta(9, 20);
    LaboratorioDescMedVenta descLab3=new LaboratorioDescMedVenta(9, 20);
    //lista de servicio
    
    try{
    //factura.agregarEnLote(loteF1);
    //factura.agregarEnLote(loteF2);
    factura.agregarEnLote(descLab1);
    factura.agregarEnLote(descLab1);
    factura.agregarServicioSalud(new ServicioSalud(2000));
    factura.agregarServicioSalud(new ServicioSalud(4000));
    factura.eliminarServicioSalud(new ServicioSalud(2000));
    /* activar solo cuando se quiere mandar a base de dato */
    //factura.procesarVenta();
//     FacturaVentaDAO dao=new FacturaVentaDAO();
//        LaboratorioDescMedVenta descLabventa=new LaboratorioDescMedVenta(9, 20);
//      System.out.println(dao.conseguirMedicamentoDisponibleLote(descLabventa).size());
    }
    catch(Exception error){
    //System.out.println("Error:" +error.getMessage());
    error.printStackTrace();
    }
    
   VisualizarFactura.imprimir(factura);
}

}