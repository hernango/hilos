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
public class ServicioSalud {
    
private String descripcionServicio="SERVICIO SALUD";
private int valor;

public ServicioSalud(){}

    public ServicioSalud(int valor) {
        this.valor = valor;
    }


    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


}
