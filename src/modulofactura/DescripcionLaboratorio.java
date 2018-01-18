package modulofactura;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hernan
 */
public class DescripcionLaboratorio {

    private int idDescripcion;
    private int idLaboratorio;
    private long cantidad;
    private String idLote;
    
   public DescripcionLaboratorio(int idDescripcion, int idLaboratorio,String idLote, long cant) {

   this.idDescripcion=idDescripcion;
   this.idLaboratorio=idLaboratorio;
   this.idLote=idLote;
   this.cantidad=cant;
    }

   public DescripcionLaboratorio(int idDescripcion, int idLaboratorio, long cant) {

   this.idDescripcion=idDescripcion;
   this.idLaboratorio=idLaboratorio;
   this.cantidad=cant;
    }
    public int getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(int idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdLote() {
        return idLote;
    }

    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }

 
    
    
}
