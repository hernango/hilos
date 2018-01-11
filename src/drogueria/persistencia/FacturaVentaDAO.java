/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drogueria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author hernan
 */
public class FacturaVentaDAO {
    
public void registrarFacturaVenta(FacturaVenta venta){
EntityManagerFactory fact=Persistence.createEntityManagerFactory("DrogueriaPU");
  EntityManager gestor=fact.createEntityManager();
  EntityTransaction trans=gestor.getTransaction();
  trans.begin();
  gestor.persist(venta);
  System.out.println(venta.getMedicamentoList().size());
 for(Medicamento med:venta.getMedicamentoList())
  {
  med.setEstadoProducto("VENDIDO");
  gestor.merge(med);
  }
  
  
  trans.commit();
}    
    
}
