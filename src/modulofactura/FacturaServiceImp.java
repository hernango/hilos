/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import drogueria.persistencia.Cliente;
import drogueria.persistencia.ClienteDAO;
import drogueria.persistencia.ConfiguracionSistema;
import drogueria.persistencia.ConfiguracionSistemaDAO;
import drogueria.persistencia.FacturaVenta;
import drogueria.persistencia.FacturaVentaDAO;
import drogueria.persistencia.LaboratorioDescMedVentaDAO;
import drogueria.persistencia.Medicamento;
import drogueria.persistencia.Usuario;
import drogueria.persistencia.UsuarioDAO;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hernan
 */
public class FacturaServiceImp implements IFacturaService {

    private FacturaVenta factura = new FacturaVenta();
    private FacturadorVenta fact = new FacturadorVenta();
    ConfiguracionSistema configuracionSistema;

    
    public FacturaServiceImp() throws Exception{
        factura.setMedicamentoList(new ArrayList<Medicamento>());
        cargarDatosPorDefecto();
        cargarCajeroPorDefecto();
    }
    
    
    @Override
    public FacturadorVenta getFact() {
        return fact;
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
    public void agregarUsuario(Usuario usuario) {
        factura.setUsuario(usuario);
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        factura.setCliente(cliente);
    }

    private void generarFechaHora() {
        factura.setFechaFactura(new Date());
        factura.setHora(new Time(System.currentTimeMillis()));
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
    public void agregarMedicamentos(ItemVenta item) throws Exception {
        if (!fact.agregarMedicamento(item)) {
            throw new Exception("Cantidad insuficiente");
        }
    }

    @Override
    public void eliminarMedicamentos(ItemVenta item) throws Exception {
        if (!fact.eliminarMedicamento(item)) {
            throw new Exception("No se puede eliminar medicamento");
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long subTotal() {
        return this.fact.getSubTotal();
    }

    @Override
    public long totalIva() {
        return this.fact.getIva();
    }

    @Override
    public void agregarServiciosGeneralesMedicamentos(GeneralesServiciosMedicamentos generalServiciosMedicamentos) throws Exception {
        if (!fact.agregarGeneralesServicioMedicamentos(generalServiciosMedicamentos)) {
            throw new Exception("No se puede agregar");
        }
    }

    @Override
    public void eliminarServiciosGeneralesMedicamentos(GeneralesServiciosMedicamentos generalServiciosMedicamentos) throws Exception {

        if (!fact.eliminarGeneralesServicioMedicamentos(generalServiciosMedicamentos)) {
            throw new Exception("No se puede eliminar");
        }
    }
    
        /* carga de valores por defecto cliente cajero, clente y configuracion sistema
    
    */ 
    public void cargarDatosPorDefecto()throws Exception{
    
       
        Cliente cliente=new Cliente(1);
        ConfiguracionSistema configuracion=new ConfiguracionSistema(1);
        
        
        ClienteDAO daoCliente=new ClienteDAO();
        ConfiguracionSistemaDAO daoConfiguracion= new ConfiguracionSistemaDAO();
        
        try{
        
       
        cliente=daoCliente.buscarCliente(cliente);
        configuracionSistema=daoConfiguracion.buscarConfiguracionSistemaPorId(configuracion);
        double pIva=((float)configuracionSistema.getPorcientoIva())/100;
        fact.setPorcentajeIva(pIva);
        agregarCliente(cliente);
        cargarCajeroPorDefecto();
        }
       catch(Exception error){throw new Exception("No se pueden cargar datos configuracion");}
        
        
    } 
    public void cargarCajeroPorDefecto() throws Exception{
     Usuario usuario=new Usuario(1);
     UsuarioDAO daoUsuario=new UsuarioDAO();
     usuario=daoUsuario.buscarUsuarioPorId(usuario);
     agregarUsuario(usuario);
    }

    @Override
   public void limpiarFacturacion() throws Exception{
    this.factura = new FacturaVenta();
    this.fact = new FacturadorVenta();
    cargarDatosPorDefecto();

   }
    
    @Override
    public void procesarVenta() throws Exception {
        cargarMedicamentosTodos(this.fact, this.factura);
        generarFechaHora();
        factura.setTotal((int)fact.getTotalVenta());
        factura.setIva((int)fact.getIva());
        FacturaVentaDAO dao = new FacturaVentaDAO();
        dao.registrarFacturaVenta(factura);
    }

    private void cargarMedicamentosTodos(FacturadorVenta facturaVenta, FacturaVenta venta)
            throws Exception {

Map<String,ItemVenta> listaItemVenta=facturaVenta.getListaItemVentas();

for(String descripcion:listaItemVenta.keySet())
{
   ItemVenta itemVenta= listaItemVenta.get(descripcion);
  
       cargarMedicamentos(venta, itemVenta);
    }
    }

    private void cargarMedicamentos(FacturaVenta venta, ItemVenta itemVenta) throws Exception {

        LaboratorioDescMedVentaDAO medDAO = new LaboratorioDescMedVentaDAO();
        List<Medicamento> listaMedicamentos = medDAO.conseguirMedicamentoDisponibleLote(itemVenta.getLabDescVenta());
        System.out.println("longitud:" + listaMedicamentos.size());
        for (int i = 1; i <= itemVenta.getCantidad(); i++) {
            Medicamento med = listaMedicamentos.get(i - 1);
            venta.getMedicamentoList().add(med);
        }
// 

    }
}
