/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import drogueria.persistencia.Cliente;
import drogueria.persistencia.ClienteDAO;
import drogueria.persistencia.ConfiguracionSistema;
import drogueria.persistencia.ConfiguracionSistemaDAO;
import drogueria.persistencia.LaboratorioDescMed;
import drogueria.persistencia.LaboratorioDescMedDAO;
import drogueria.persistencia.LaboratorioDescMedVenta;
import drogueria.persistencia.LaboratorioDescMedVentaDAO;
import drogueria.persistencia.Lote;
import drogueria.persistencia.LoteDAO;
import drogueria.persistencia.Usuario;
import drogueria.persistencia.UsuarioDAO;
import drogueria.utilidades.Formateador;
import java.util.List;
import modulofactura.FacturaServiceImp;
import modulofactura.IFacturaService;
import modulofactura.GeneralesServiciosMedicamentos;


/**
 *
 * @author hernan
 */
public class Prueba {

public static void main(String a[]){
   prueba2();
}   

public static void prueba2(){
//    IFacturaService factura=new FacturaServiceImp();
//    factura.agregarCliente(new Cliente(1));
//    factura.agregarUsuario(new Usuario(1));
//    LaboratorioDescMedVenta descLab1=new LaboratorioDescMedVenta(9, 20);
//    LaboratorioDescMedVenta descLab3=new LaboratorioDescMedVenta(9, 20);
//    //lista de servicio
//    
  try{
//    //factura.agregarEnLote(loteF1);
    //factura.agregarEnLote(loteF2);
//    factura.agregarEnLote(descLab1);
//    factura.agregarEnLote(descLab1);
//    factura.agregarServicioSalud(new ServicioSalud(2000));
//    factura.agregarServicioSalud(new ServicioSalud(4000));
//    factura.eliminarServicioSalud(new ServicioSalud(2000));
    /* activar solo cuando se quiere mandar a base de dato */
    //factura.procesarVenta();
//     FacturaVentaDAO dao=new FacturaVentaDAO();
//        LaboratorioDescMedVenta descLabventa=new LaboratorioDescMedVenta(9, 20);
//      System.out.println(dao.conseguirMedicamentoDisponibleLote(descLabventa).size());
    
//  LaboratorioDescMedVentaDAO dao=new LaboratorioDescMedVentaDAO();
//        List<LaboratorioDescMedVenta> lista= dao.sacarTodoComparacion("saniper");  
LaboratorioDescMed labDesdMed= new LaboratorioDescMed();
labDesdMed.setCodigoBarras("00003");
    LaboratorioDescMedDAO dao=new LaboratorioDescMedDAO();
     
 List <Lote> lista= dao.consultaLotePorCodigoBarras(labDesdMed);
 System.out.println(lista.size());
 for (Lote lote: lista){
 System.out.println(Formateador.formatoFecha(lote.getFechaVigencia()) +"**" +lote.getIdLote() );
  System.out.println(lote.getMedicamentoList().size());
 }
}
    catch(Exception error){
    //System.out.println("Error:" +error.getMessage());
    error.printStackTrace();
    }
    
 //  VisualizarFactura.imprimir(factura);

}
}