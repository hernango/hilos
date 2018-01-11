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
import javax.persistence.NoResultException;

/**
 *
 * @author hernan
 * lista de medicamentos
 * mapaMedicamentos<String,FacturaListaLotes>
 * key:string: esta formado por id_desc/id_lab
 * 
 */
public class FacturadorVenta {
        
   private long totalVenta;
   private long pago;
   Map<String,FacturaListaLotes> mapaListaLotes=new HashMap<String, FacturaListaLotes>();

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

    public Map<String, FacturaListaLotes> getMapaListaLotes() {
        return mapaListaLotes;
    }

    public void setMapaListaLotes(Map<String, FacturaListaLotes> mapaListaLotes) {
        this.mapaListaLotes = mapaListaLotes;
    }
   
   
   public void agregarALote(LoteFactura lote) throws Exception{
    
       ConsultaMedDAO consultaMedDAO= new ConsultaMedDAO();
       try{
       DescripcionLaboratorio descLab=consultaMedDAO.consultaCantidadesPorLote(lote.getLote());
       
       if(descLab!=null){
       
       String codigoDescLab=String.valueOf(descLab.getIdDescripcion()) 
               +"/" +String.valueOf(descLab.getIdLaboratorio());
       FacturaListaLotes controladorListaLotes=mapaListaLotes.get(codigoDescLab);
      // crea si es necesario por primera vez un lote 
       if(controladorListaLotes==null){
          controladorListaLotes=new FacturaListaLotes();
          controladorListaLotes.cargarLaboratorioDescMedVenta(descLab);
          mapaListaLotes.put(codigoDescLab, controladorListaLotes);
          }
        if(controladorListaLotes.agregarALote(descLab)){
         this.totalVenta +=controladorListaLotes.getLabDescMedVenta().getPrecio();
        }
        
       }
              
       else{
       throw new Exception("No se encuentra en bodega medicamento");
       }
       }
       catch (NoResultException error){ 
           throw new Exception("no existen elementos");
       }
       
   }
   
  /* eliminar medicamento de lote solo si es posible
    */
  
 public void eliminarMedLote(LoteFactura lote) throws Exception
  {
   try{   
   LoteDAO loteDAO=new LoteDAO();
   Lote loteEncontrado=loteDAO.consultarPorIdLote(lote.getLote());
   LaboratorioDescMedVenta labDescVenta=loteEncontrado.getLaboratorioDescMedVenta();
   String codigoDescLab=String.valueOf(labDescVenta.getLaboratorioDescMed().getDescripcion().getIdDesc()) 
               +"/" +String.valueOf(labDescVenta.getLaboratorioDescMed().getLaboratorio().getIdLab());
   FacturaListaLotes controladorListaLotes=mapaListaLotes.get(codigoDescLab);  
   
   if(controladorListaLotes!=null){
        
    if(controladorListaLotes.eliminarEnLote(lote)){
         this.totalVenta -=controladorListaLotes.getLabDescMedVenta().getPrecio();
         if (controladorListaLotes.getCantidadTotal()==0){
           mapaListaLotes.remove(codigoDescLab);
         }
        }  
    
        }
   else throw new Exception("No existe lote a eliminar");
   }
   catch(NoResultException error){
   throw new Exception("no existe lote a eliminar");}
   }
 public Long devolusion(){
 return (this.pago-this.totalVenta);
 }
 
 
}