/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drogueria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modulofactura.DescripcionLaboratorio;

/**
 *
 * @author hernan
 */
public class FacturaVentaDAO {
    
public void registrarFacturaVenta(FacturaVenta venta) throws Exception{
EntityManagerFactory fact=Persistence.createEntityManagerFactory("DrogueriaPU");
  EntityManager gestor=fact.createEntityManager();
  EntityTransaction trans=gestor.getTransaction();
  MedicamentoDAO daoMed=new MedicamentoDAO();
  trans.begin();
  
  System.out.println(venta.getMedicamentoList().size());
 for(Medicamento med:venta.getMedicamentoList())
  {
 
  String consulta="delete from Medicamento med WHERE med.idMedicamento = :idMed";
  Query consult = gestor.createQuery(consulta);
  consult.setParameter("idMed", med.getIdMedicamento());
  int datoModificados= consult.executeUpdate();    
   
  }
  gestor.persist(venta);
  
  trans.commit();
}    


}
