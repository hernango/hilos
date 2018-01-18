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
   List<ServicioSalud>listaServicios;
   
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

    public List<ServicioSalud> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<ServicioSalud> listaServicios) {
        this.listaServicios = listaServicios;
    }
   
   
 public void agregarMedicamento(LaboratorioDescMedVenta labDescVenta)
 throws Exception{
     
 ConsultaMedDAO consultaMedDAO= new ConsultaMedDAO();
       try{
       DescripcionLaboratorio descLab=consultaMedDAO.consultaCantidadesPorDescLab(labDescVenta);
       
       if(descLab!=null){
       
       String codigoDescLab=String.valueOf(descLab.getIdDescripcion()) 
               +"/" +String.valueOf(descLab.getIdLaboratorio());
       FacturaListaLotes controladorListaLotes=mapaListaLotes.get(codigoDescLab);
      // crea si es necesario por primera vez un lote 
       if(controladorListaLotes==null){
          controladorListaLotes=new FacturaListaLotes();
          controladorListaLotes.cargarLaboratorioDescMedVenta(labDescVenta);
          mapaListaLotes.put(codigoDescLab, controladorListaLotes);
          }
        if(controladorListaLotes.agregarMedicamento(descLab)){
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
  
 public void eliminarMedicamento(LaboratorioDescMedVenta labDescVenta) throws Exception
  {
   try{   
   String codigoDescLab=String.valueOf(labDescVenta.getLaboratorioDescMed().getDescripcion().getIdDesc()) 
               +"/" +String.valueOf(labDescVenta.getLaboratorioDescMed().getLaboratorio().getIdLab());
   FacturaListaLotes controladorListaLotes=mapaListaLotes.get(codigoDescLab);  
   
   if(controladorListaLotes!=null){
        
    if(controladorListaLotes.eliminarMedicamento(labDescVenta)){
         this.totalVenta -=controladorListaLotes.getLabDescMedVenta().getPrecio();
         if (controladorListaLotes.getCantidadTotal()==0){
           mapaListaLotes.remove(codigoDescLab);
         }
        }  
    
        }
   else throw new Exception("No existe medicamento a eliminar");
   }
   catch(NoResultException error){
   throw new Exception("no existe lote a eliminar");}
   }
 
 public Long devolusion(){
 return (this.pago-this.totalVenta);
 }
 
 public boolean agregarServicioSalud(ServicioSalud servicioSalud){
 
     boolean realizado=false;
     if(this.listaServicios==null){
     this.listaServicios=new ArrayList<ServicioSalud>();
     System.out.println("aqui");
     }
     listaServicios.add(servicioSalud);
     this.totalVenta +=servicioSalud.getValor();
     
     realizado=true;
       
     return realizado;        
    
 }
 
 public boolean eliminarServicioSalud(ServicioSalud servicioSalud){
  boolean realizado=false;
     if(listaServicios!=null){
     
        realizado= listaServicios.remove(servicioSalud);
        if(realizado){ this.totalVenta -=servicioSalud.getValor();}
     }
     
     
     
       
     return realizado;
 }
}