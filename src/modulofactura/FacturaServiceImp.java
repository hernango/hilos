/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import drogueria.persistencia.Cliente;
import drogueria.persistencia.FacturaVenta;
import drogueria.persistencia.FacturaVentaDAO;
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
 public void agregarEnLote(LoteFactura loteFactura)throws Exception{
 fact.agregarALote(loteFactura);
 }

  @Override
 public void eliminarEnLote(LoteFactura loteFactura)throws Exception{
 fact.eliminarMedLote(loteFactura);
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
 
 
 
private  void cargarMedicamentosTodosLote(FacturadorVenta facturaVenta, FacturaVenta venta)
throws Exception{
    
Map<String,FacturaListaLotes> listaDescripciones=facturaVenta.getMapaListaLotes();

for(String descripcion:listaDescripciones.keySet())
{
   FacturaListaLotes factura= listaDescripciones.get(descripcion);
  Map<String,LoteFactura>listaLotes= factura.getMapaLotesFactura();
    for(String lote:listaLotes.keySet()){
        cargarMedicamentoSegunLote(venta, listaLotes.get(lote));
    }
}

}

private  void cargarMedicamentoSegunLote(FacturaVenta venta, LoteFactura lote)throws Exception{
    
     MedicamentoDAO medDAO=new MedicamentoDAO();
    List<Medicamento> listaMedicamentos=medDAO.conseguirMedicamentoDisponibleLote(lote.getLote());
    System.out.println("longitud:" +listaMedicamentos.size());
    for (int i=1; i<=lote.getCantidad(); i++){
        Medicamento med=listaMedicamentos.get(i-1);
                venta.getMedicamentoList().add(med);
    }
 
  
}
}