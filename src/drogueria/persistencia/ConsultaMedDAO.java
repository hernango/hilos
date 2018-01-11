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
public class ConsultaMedDAO {

//    public Lote buscarLote(Lote lote) {
//
//        Lote LoteEncontrado = null;
//        EntityManagerFactory factoria = Persistence.createEntityManagerFactory("DrogueriaPU");
//        EntityManager gestor = factoria.createEntityManager();
//        EntityTransaction trans = gestor.getTransaction();
//        trans.begin();
//       
//        Query consulta = gestor.createNamedQuery("ConsultaMed.findByIdLote");
//        consulta.setParameter("idLote", lote.getIdLote()); 
//        
//  
//  
//    }
//    
public DescripcionLaboratorio consultaCantidadesPorLote(Lote lote) throws Exception {
        DescripcionLaboratorio descripcionLab = null;
EntityManagerFactory fact=Persistence.createEntityManagerFactory
        ("DrogueriaPU");
 EntityManager gestor=fact.createEntityManager();
        EntityTransaction transaccion=gestor.getTransaction();
        
        transaccion.begin();
   String consulta="select NEW modulofactura.DescripcionLaboratorio"
           + "(c.idDesc,c.idLab, c.idLote, COUNT (c.idMedicamento)) from " 
           +" ConsultaMed c where c.idLote= :idLote group by c.idLote, c.idLab";
            
   Query consult= gestor.createQuery(consulta);
   consult.setParameter("idLote",lote.getIdLote());
   descripcionLab=(DescripcionLaboratorio)consult.getSingleResult();
          
   
   transaccion.commit();
    return descripcionLab;
      
    }

}
