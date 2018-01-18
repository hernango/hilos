/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import drogueria.persistencia.Cliente;
import drogueria.persistencia.FacturaVenta;
import drogueria.persistencia.FacturaVentaDAO;
import drogueria.persistencia.LaboratorioDescMedVenta;
import drogueria.persistencia.LaboratorioDescMedVentaDAO;
import drogueria.persistencia.Medicamento;
import drogueria.persistencia.MedicamentoDAO;
import drogueria.persistencia.Usuario;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 *
 * @author hernan
 */
public class FacturaServiceImp implements IFacturaService{
    
  private FacturaVenta factura=new FacturaVenta();
  private FacturadorVenta fact=new FacturadorVenta();

  @Override
    public FacturadorVenta getFact() {
        return fact;
    }

  
    public FacturaServiceImp() {
     factura.setMedicamentoList(new ArrayList<Medicamento>());
    }

    @Override
    public Cliente getCliente() {
    return this.factura.getCliente();
    }

    @Override
    public Usuario getUsuario() {
    return this.factura.getUsuario();
    }

    
    
    
    @Override
    public Date getFecha() {
    return this.factura.getFechaFactura();
    }

    @Override
    public Date getHora() {
    return this.factura.getHora();
    }
    
    
    
  
  
  
  @Override
  public void agregarUsuario(Usuario usuario){
  factura.setUsuario(usuario);
  }
  
  @Override
  public void agregarCliente(Cliente cliente){
   factura.setCliente(cliente);
  }
  private void generarFechaHora(){
  factura.setFechaFactura(new Date());
  factura.setHora(new Time(System.currentTimeMillis()));
  }
  
  @Override
 public void agregarEnLote(LaboratorioDescMedVenta loteFactura)throws Exception{
 fact.agregarMedicamento(loteFactura);
 }

  @Override
 public void eliminarEnLote(LoteFactura loteFactura)throws Exception{
 //fact.eliminarMedLote(loteFactura);
 }
  @Override
 public void procesarVenta()throws Exception{
 cargarMedicamentosTodosLote(this.fact, this.factura);
 generarFechaHora();
        FacturaVentaDAO dao=new FacturaVentaDAO();
        dao.registrarFacturaVenta(factura);
 }

    @Override
    public long totalVenta() {
     return this.fact.getTotalVenta();
    }

    @Override
    public void setPago(long pago) {
      this.fact.setPago(pago);
    }

    @Override
    public long devolusion() {
      return this.fact.devolusion();
    }

    @Override
    public boolean agregarServicioSalud(ServicioSalud servicioSalud) {
      boolean resultado=false;
      
      resultado=fact.agregarServicioSalud(servicioSalud);
      return resultado;
    }

    @Override
    public boolean eliminarServicioSalud(ServicioSalud servicioSalud) {
     boolean resultado=false;
     
     resultado=fact.eliminarServicioSalud(servicioSalud);
     
    return resultado;
            
        }

 
private  void cargarMedicamentosTodosLote(FacturadorVenta facturaVenta, FacturaVenta venta)
throws Exception{
    
Map<String,FacturaListaLotes> listaDescripciones=facturaVenta.getMapaListaLotes();

for(String descripcion:listaDescripciones.keySet())
{
   FacturaListaLotes facturaListaLotes= listaDescripciones.get(descripcion);
  
       cargarMedicamentos(venta, facturaListaLotes);
    }
}



private  void cargarMedicamentos(FacturaVenta venta, FacturaListaLotes facturaListalotes )throws Exception{
    
     LaboratorioDescMedVentaDAO medDAO=new LaboratorioDescMedVentaDAO();
 List<Medicamento> listaMedicamentos=medDAO.conseguirMedicamentoDisponibleLote(facturaListalotes.getLabDescMedVenta());
 System.out.println("longitud:" +listaMedicamentos.size());
    for (int i=1; i<=facturaListalotes.getCantidadTotal(); i++){
        Medicamento med=listaMedicamentos.get(i-1);
                venta.getMedicamentoList().add(med);
    }
// 
  
}
}