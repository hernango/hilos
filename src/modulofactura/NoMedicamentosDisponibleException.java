/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulofactura;

/**
 *
 * @author hernan
 */
public class NoMedicamentosDisponibleException extends Exception{

    public NoMedicamentosDisponibleException() {
    super("este lote no ha sido registrado en bodega.Registrelo antes de venderlo");
    }
     
    
    
}
