/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

import drogueria.persistencia.ConsultaMedDAO;
import drogueria.persistencia.LaboratorioDescMedVenta;
import drogueria.persistencia.LaboratorioDescMedVentaDAO;
import drogueria.persistencia.Lote;
import drogueria.persistencia.LoteDAO;
import drogueria.persistencia.Medicamento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hernan
 */
public class FacturaListaLotes {
    
 //private List<Medicamento> listaMedicamentos=new ArrayList<Medicamento>();
 private LaboratorioDescMedVenta labDescMedVenta;
 private int cantidadTotal;

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

 
       
    public LaboratorioDescMedVenta getLabDescMedVenta() {
        return labDescMedVenta;
    }

    public void setLabDescMedVenta(LaboratorioDescMedVenta labDescMedVenta) {
        
        this.labDescMedVenta = labDescMedVenta;
    }


    
 public boolean agregarMedicamento(DescripcionLaboratorio descLab) throws Exception{
      boolean fueAgregado=false;
       if((this.cantidadTotal +1)<=descLab.getCantidad())  {
       fueAgregado=true;
        this.cantidadTotal++;
       }
        else
           throw new Exception("no se puede agregar, cantidad insuficiente");
    return fueAgregado;    
 }
 
public boolean eliminarMedicamento(DescripcionLaboratorio descLab) throws Exception{
      boolean fueEliminado=false;
       
         if(this.cantidadTotal-1>=0){
           fueEliminado=true;
           this.cantidadTotal--;
         }
           else throw new Exception("no se puede eliminar, no hay medicamentos");
      return fueEliminado;    
 }




 public void cargarLaboratorioDescMedVenta(LaboratorioDescMedVenta descLabVenta)throws Exception{
 
       LaboratorioDescMedVentaDAO daoLabDescVenta =new LaboratorioDescMedVentaDAO();
       this.labDescMedVenta=daoLabDescVenta.conseguirLabDescVentaPorLabDesc(descLabVenta);
   
 }
       


public float cantidadSubtotal(){
 
    return this.cantidadTotal  * this.labDescMedVenta.getPrecio();
}

}   
    

