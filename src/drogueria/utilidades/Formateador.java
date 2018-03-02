/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drogueria.utilidades;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author hernan
 */
public class Formateador {
    
 public static String formatoDecimal(long numero)
 {
 
     DecimalFormat df = new DecimalFormat("$#,###.##"); 
     String s = df.format(numero);

 return s;
 }
 
 public static long formatoDecimal(String numeroFormateado) throws ParseException
 {
 
     DecimalFormat df = new DecimalFormat("$#,###.##"); 
     long numero = df.parse(numeroFormateado).longValue();

 return numero;
 }
   
public static String formatoFecha(Date fecha){

    
    SimpleDateFormat formateo=new SimpleDateFormat("yyyy-MM-dd");
    return formateo.format(fecha);
} 

public static Date formatoFechaDate(String fecha)throws Exception{

    
    SimpleDateFormat formateo=new SimpleDateFormat("yyyy-MM-dd");
    return formateo.parse (fecha);
} 
}
