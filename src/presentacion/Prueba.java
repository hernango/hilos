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
import drogueria.persistencia.FacturaVenta;
import drogueria.persistencia.FacturaVentaDAO;
import drogueria.persistencia.LaboratorioDescMed;
import drogueria.persistencia.LaboratorioDescMedDAO;
import drogueria.persistencia.LaboratorioDescMedVenta;
import drogueria.persistencia.LaboratorioDescMedVentaDAO;
import drogueria.persistencia.Lote;
import drogueria.persistencia.LoteDAO;
import drogueria.persistencia.Usuario;
import drogueria.persistencia.UsuarioDAO;
import drogueria.utilidades.Formateador;
import java.util.Date;
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

    Usuario usuario=new Usuario();
    usuario.setIdUsuario(1);
   
    FacturaVentaDAO dao=new FacturaVentaDAO();
    try{
       String fechaI="2016-09-20";
       String fechaF="2018-01-20";
        Date fechaFinal= Formateador.formatoFechaDate(fechaI);
        Date fechaInicial= Formateador.formatoFechaDate(fechaF);
       List<FacturaVenta> lista= dao.conseguirFacturaCajeroPeriodo(usuario, fechaInicial, fechaFinal);
    }
    catch(Exception error){error.printStackTrace();}
}
}