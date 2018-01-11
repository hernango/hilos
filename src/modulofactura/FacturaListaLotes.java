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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hernan
 */
public class FacturaListaLotes {
    
 private Map<String,LoteFactura> mapaLotesFactura=new HashMap<String, LoteFactura>();
 private LaboratorioDescMedVenta labDescMedVenta;
 private int cantidadTotal;

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

 
    public Map<String, LoteFactura> getMapaLotesFactura() {
        return mapaLotesFactura;
    }

    public void setMapaLotesFactura(Map<String, LoteFactura> mapaLotesFactura) {
        this.mapaLotesFactura = mapaLotesFactura;
    }

    public LaboratorioDescMedVenta getLabDescMedVenta() {
        return labDescMedVenta;
    }

    public void setLabDescMedVenta(LaboratorioDescMedVenta labDescMedVenta) {
        this.labDescMedVenta = labDescMedVenta;
    }
 
 public boolean agregarALote(DescripcionLaboratorio descLab) throws Exception{
      boolean fueAgregado=false;
       LoteFactura loteBuscado=mapaLotesFactura.get(descLab.getIdLote());
       // crea si es necesario por primera vez un lote 
       if(loteBuscado==null){
          loteBuscado=new LoteFactura();
          loteBuscado.setCantidadMedLote((int)descLab.getCantidad());
          loteBuscado.setLote(new Lote(descLab.getIdLote()));
          LoteDAO loteDAO=new LoteDAO();
          Lote loteEncontrado=loteDAO.consultarPorIdLote(loteBuscado.getLote());
          loteBuscado.setLote(loteEncontrado);
          mapaLotesFactura.put(loteEncontrado.getIdLote(),loteBuscado);
          }
       
       if(loteBuscado.posibleAgregarALote())
       {
        loteBuscado.aumentarCantidad();
        fueAgregado=true;
        this.cantidadTotal++;
       }
       else 
       throw new NoMedicamentosDisponibleException();
    return fueAgregado;    
 }
 
public boolean eliminarEnLote(LoteFactura lote) throws Exception{
      boolean fueEliminado=false;
       LoteFactura loteBuscado=mapaLotesFactura.get(lote.getLote().getIdLote());
       // crea si es necesario por primera vez un lote 
       if(loteBuscado!=null){
           if(loteBuscado.getCantidad()-1>=0){
           loteBuscado.disminuirCantidad();
           fueEliminado=true;
           this.cantidadTotal--;
           if(loteBuscado.getCantidad()==0) mapaLotesFactura.
                   remove(lote.getLote().getIdLote());
          }
           else throw new Exception("no se puede eliminar, no existen lotes");
       }    
       else 
       throw new Exception("Lote no existe");
    return fueEliminado;    
 }




 public void cargarLaboratorioDescMedVenta(DescripcionLaboratorio descLab)throws Exception{
 
     Lote lote=new Lote(descLab.getIdLote());
     LoteDAO loteDAO=new LoteDAO();
     lote= loteDAO.consultarPorIdLote(lote);
     this.labDescMedVenta=lote.getLaboratorioDescMedVenta();
   
 }
       


public float cantidadSubtotal(){
 
    return this.cantidadTotal  * this.labDescMedVenta.getPrecio();
}

}   
    

