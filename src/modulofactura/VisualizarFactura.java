/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import java.util.Map;

/**
 *
 * @author hernan
 */
public class VisualizarFactura {
 
public static void imprimir(IFacturaService facturaService){

 FacturadorVenta facturaVenta= facturaService.getFact();
 
Map<String,FacturaListaLotes> listaDescripciones=facturaVenta.getMapaListaLotes();

for(String descripcion:listaDescripciones.keySet())
{
   FacturaListaLotes factura= listaDescripciones.get(descripcion);
   
    System.out.print(descripcion);
    System.out.print(" " +factura.getLabDescMedVenta().getLaboratorioDescMed().getDescripcion().getNombreComercial());
    System.out.print("     " +factura.getCantidadTotal());
    System.out.println("     " +factura.cantidadSubtotal());
}
System.out.println("Total:" + facturaVenta.getTotalVenta());
}    
}
