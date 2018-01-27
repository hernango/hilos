/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import drogueria.persistencia.Cliente;
import drogueria.persistencia.LaboratorioDescMedVenta;
import drogueria.persistencia.Usuario;
import java.util.Date;

/**
 *
 * @author hernan
 */
public interface IFacturaService {
    
    public void agregarUsuario(Usuario usuario);
    
    public void agregarCliente(Cliente cliente);
    
    public Cliente getCliente();
    
    public Usuario getUsuario();
    
    public Date getFecha();
    
    public Date getHora();
    
    public void agregarMedicamentos(ItemVenta item)throws Exception;
    
    public void eliminarMedicamentos(ItemVenta item)throws Exception;
    
    public void agregarServiciosGeneralesMedicamentos(GeneralesServiciosMedicamentos generalServiciosMedicamentos)throws Exception;
   
    public void  eliminarServiciosGeneralesMedicamentos(GeneralesServiciosMedicamentos generalServiciosMedicamentos)throws Exception; 
   
   public void procesarVenta()throws Exception;
   
   public void limpiarFacturacion() throws Exception;
    
    public FacturadorVenta getFact();
    
    public long totalVenta();
    public long totalIva();
    public long subTotal();
    
    public void setPago(long pago);
    
    public long devolusion();
    
    
}
