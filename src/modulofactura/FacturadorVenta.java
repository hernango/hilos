/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import drogueria.persistencia.ConsultaMedDAO;
import drogueria.persistencia.LaboratorioDescMedVenta;
import drogueria.persistencia.Lote;
import drogueria.persistencia.LoteDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.NoResultException;

/**
 *
 * @author hernan lista de medicamentos listaItemVentas<String,ItemVenta>
 * key:string -->hace referencia al codigo de barras del producto.
 *
 */
public class FacturadorVenta {

    private long totalVenta;
    private long pago;
    private long subTotal;
    private long iva;
    private double porcentajeIva;
    
    Map<String, ItemVenta> listaItemVentas = new HashMap<String, ItemVenta>();
    List<GeneralesServiciosMedicamentos> listaGeneralServiciosMedicamentos;

    public Map<String, ItemVenta> getListaItemVentas() {
        return listaItemVentas;
    }

    public void setListaItemVentas(Map<String, ItemVenta> listaItemVentas) {
        this.listaItemVentas = listaItemVentas;
    }

    public List<GeneralesServiciosMedicamentos> getListaGeneralServiciosMedicamentos() {
        return listaGeneralServiciosMedicamentos;
    }

    public void setListaGeneralServiciosMedicamentos(List<GeneralesServiciosMedicamentos> listaGeneralServiciosMedicamentos) {
        this.listaGeneralServiciosMedicamentos = listaGeneralServiciosMedicamentos;
    }

    public double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

       
    
    public long getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(long totalVenta) {
        this.totalVenta = totalVenta;
    }

    public long getPago() {
        return pago;
    }

    public void setPago(long pago) {
        
        this.pago = pago;
    }

    public long getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(long subTotal) {
        this.subTotal = subTotal;
    }

    public long getIva() {
        return iva;
    }

    public void setIva(long iva) {
        this.iva = iva;
    }

    
    public boolean agregarMedicamento(ItemVenta item) {

        boolean fueAgregado = false;

        ItemVenta itemVentaEncontrado = listaItemVentas.get(item.getLabDescVenta().getLaboratorioDescMed().getCodigoBarras());
        if (itemVentaEncontrado != null) {
            int sumaTotal = itemVentaEncontrado.getCantidad() + item.getCantidad();

            if (sumaTotal <= item.getStock()) {
                //actualizar datos del itemVentaEncontrado
                itemVentaEncontrado.setStock(item.getStock());
                itemVentaEncontrado.setCantidad(sumaTotal);
                totalVenta +=item.calcularValorDescuento();
                fueAgregado = true;
            }
        } else if (item.getCantidad() <= item.getStock()) {
              System.out.println("primera vez");
              ItemVenta itemVentaAux=new ItemVenta();
              itemVentaAux.setLabDescVenta(item.getLabDescVenta());
              itemVentaAux.setCantidad(item.getCantidad());
              itemVentaAux.setStock(item.getStock());
            listaItemVentas.put(item.getLabDescVenta().getLaboratorioDescMed().getCodigoBarras(), itemVentaAux);
            totalVenta += item.calcularValorDescuento();
            calcularValores();
            fueAgregado = true;
        }
        return fueAgregado;
    }
    
    public boolean eliminarMedicamento(ItemVenta item){
    boolean efectuado=false;
    
    listaItemVentas.remove(item.getLabDescVenta().getLaboratorioDescMed().getCodigoBarras());
    totalVenta -=item.calcularValorDescuento();
    calcularValores();
    efectuado=true;
    
    return efectuado;
    }

    public Long devolusion() {
        return (this.pago - this.totalVenta);
    }

    public boolean agregarGeneralesServicioMedicamentos(GeneralesServiciosMedicamentos generalServicioMedicamento) {

        boolean realizado = false;
        if (this.listaGeneralServiciosMedicamentos == null) {
            this.listaGeneralServiciosMedicamentos = new ArrayList<GeneralesServiciosMedicamentos>();
        }
        listaGeneralServiciosMedicamentos.add(generalServicioMedicamento);
        this.totalVenta += generalServicioMedicamento.getValor();
        calcularValores();

        realizado = true;

        return realizado;

    }
    
    public boolean eliminarGeneralesServicioMedicamentos(GeneralesServiciosMedicamentos generalServicioMedicamento)
    {
    boolean realizado=false;
    if(listaGeneralServiciosMedicamentos!=null && listaGeneralServiciosMedicamentos.size()>0)
    {
      realizado=listaGeneralServiciosMedicamentos.remove(generalServicioMedicamento);
      this.totalVenta -= generalServicioMedicamento.getValor();
      calcularValores();
    }
     return realizado;
    }

//    
    
    public void calcularValores(){
    this.iva=(long)Math.round(this.totalVenta * this.porcentajeIva);
    System.out.println("iva:"+ this.porcentajeIva);
    this.subTotal=this.totalVenta-this.iva;
    }
}
