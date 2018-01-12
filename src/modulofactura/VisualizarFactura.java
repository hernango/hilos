/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import java.util.List;
import java.util.Map;

/**
 *
 * @author hernan
 */
public class VisualizarFactura {
 
public static void imprimir(IFacturaService facturaService){

 FacturadorVenta facturaVenta= facturaService.getFact();
 
Map<String,FacturaListaLotes> listaDescripciones=facturaVenta.getMapaListaLotes();
// medicamento por lote
for(String descripcion:listaDescripciones.keySet())
{
   FacturaListaLotes factura= listaDescripciones.get(descripcion);
   
    System.out.print(descripcion);
    System.out.print(" " +factura.getLabDescMedVenta().getLaboratorioDescMed().getDescripcion().getNombreComercial());
    System.out.print("     " +factura.getCantidadTotal());
    System.out.println("     " +factura.cantidadSubtotal());
}
// servicios
List<ServicioSalud> listaServicio=facturaVenta.getListaServicios();
int cantServicio=0;


if(listaServicio!=null){
for(ServicioSalud servicio:listaServicio){
    System.out.print("S" + ++cantServicio);
    System.out.print("     " +servicio.getDescripcionServicio());
    System.out.println("     " +servicio.getValor());
}
}
// total
System.out.println("Total:" + facturaVenta.getTotalVenta());
}    
}
