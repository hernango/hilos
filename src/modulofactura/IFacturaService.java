/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import drogueria.persistencia.Cliente;
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
    
    public void agregarEnLote(LoteFactura loteFactura)throws Exception;
    
    public void eliminarEnLote(LoteFactura loteFactura)throws Exception;
    
    public boolean agregarServicioSalud(ServicioSalud servicioSalud);
    
    public boolean eliminarServicioSalud(ServicioSalud servicioSalud);
    
    public void procesarVenta()throws Exception;
    
    public FacturadorVenta getFact();
    
    public long totalVenta();
    
    public void setPago(long pago);
    
    public long devolusion();
    
    
}
