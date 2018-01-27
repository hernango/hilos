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
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author hernan
 */
public class LaboratorioDescMedVentaDAO {
    
    public LaboratorioDescMedVenta conseguirLabDescVentaPorCodigoBarras(LaboratorioDescMedVenta labDescVenta)
    throws Exception
    {
    LaboratorioDescMedVenta labDescVentaAux=null;
    EntityManagerFactory fact=Persistence.createEntityManagerFactory
        ("DrogueriaPU");
 EntityManager gestor=fact.createEntityManager();
        EntityTransaction transaccion=gestor.getTransaction();
        
        transaccion.begin();
        
   String consulta="select labDescVenta  from  LaboratorioDescMedVenta labDescVenta " 
           + "join labDescVenta.laboratorioDescMed labDescMed "
           + "where labDescMed.codigoBarras= :codigoBarras";
           
      Query consult= gestor.createQuery(consulta);
   consult.setParameter("codigoBarras",labDescVenta.getLaboratorioDescMed().getCodigoBarras());
   //consult.setParameter("idDesc",labDescVenta.getLaboratorioDescMedVentaPK().getIdDesc());
   try {
   labDescVentaAux=(LaboratorioDescMedVenta)consult.getSingleResult();
          
   }
   catch(NoResultException error){
   throw new Exception("No se encuentra medicamento en farmacia");
   } 
   transaccion.commit();
   gestor.close();
    return labDescVentaAux;
    
    }
    
public List<Medicamento> conseguirMedicamentoDisponibleLote(LaboratorioDescMedVenta labDescVenta)
throws Exception{
    List<Medicamento>listaMedicamentos=null;
    
    EntityManagerFactory fact=Persistence.createEntityManagerFactory
        ("DrogueriaPU");
 EntityManager gestor=fact.createEntityManager();
        EntityTransaction transaccion=gestor.getTransaction();
        
        transaccion.begin();
   String consulta="select med  from  Medicamento med " 
           +" join med.lote lote "
//           + "where lote.laboratorioDescMedVenta.laboratorioDescMed.laboratorio.idLab= :idLab "
//           + " and lote.laboratorioDescMedVenta.laboratorioDescMed.descripcion.idDesc= :idDesc ";
           + "where lote.laboratorioDescMedVenta.laboratorioDescMedVentaPK.idLab= :idLab "
           + " and lote.laboratorioDescMedVenta.laboratorioDescMedVentaPK.idDesc= :idDesc "
           + " and med.estadoProducto='DISPONIBLE' order by lote.fechaVigencia ASC";
            
   Query consult= gestor.createQuery(consulta);
   consult.setParameter("idLab",labDescVenta.getLaboratorioDescMedVentaPK().getIdLab());
   consult.setParameter("idDesc",labDescVenta.getLaboratorioDescMedVentaPK().getIdDesc());
   listaMedicamentos=(List<Medicamento>)consult.getResultList();
          
   
   transaccion.commit();
   gestor.close();
    return listaMedicamentos;
}  



public LaboratorioDescMedVenta conseguirLabDescVentaPorLabDesc(LaboratorioDescMedVenta labDescVenta)
throws Exception{
    LaboratorioDescMedVenta labDescVentaAux=null;
    
    EntityManagerFactory fact=Persistence.createEntityManagerFactory
        ("DrogueriaPU");
 EntityManager gestor=fact.createEntityManager();
        EntityTransaction transaccion=gestor.getTransaction();
        
        transaccion.begin();
   String consulta="select labDescVenta  from  LaboratorioDescMedVenta labDescVenta " 
           + "where labDescVenta.laboratorioDescMedVentaPK.idLab= :idLab "
           + " and labDescVenta.laboratorioDescMedVentaPK.idDesc= :idDesc ";
            
   Query consult= gestor.createQuery(consulta);
   System.out.println("Lab:" +labDescVenta.getLaboratorioDescMedVentaPK().getIdLab());
   System.out.println("Lab:" +labDescVenta.getLaboratorioDescMedVentaPK().getIdDesc());
   consult.setParameter("idLab",labDescVenta.getLaboratorioDescMedVentaPK().getIdLab());
   consult.setParameter("idDesc",labDescVenta.getLaboratorioDescMedVentaPK().getIdDesc());
   try {
   labDescVentaAux=(LaboratorioDescMedVenta)consult.getSingleResult();
          
   }
   catch(NoResultException error){
   throw new Exception("No se encuentra medicamento en farmacia");
   } 
   transaccion.commit();
   gestor.close();
    return labDescVentaAux;
    
}
public List<LaboratorioDescMedVenta> sacarTodoComparacion(String cadena){
    
    List<LaboratorioDescMedVenta> lista=null;
        EntityManagerFactory fact=Persistence.createEntityManagerFactory
        ("DrogueriaPU");
 EntityManager gestor=fact.createEntityManager();
        EntityTransaction transaccion=gestor.getTransaction();
        
        transaccion.begin();
               
   String consulta="select labDescVenta  from  LaboratorioDescMedVenta labDescVenta "
           +"join labDescVenta.laboratorioDescMed labDescMed join labDescMed.descripcion des "
           + "where des.nombreComercial like '%"  +cadena +"%' "
           + " or labDescMed.codigoBarras like  '%"  +cadena +"%' ";
   
   
   Query consult= gestor.createQuery(consulta);
   //consult.setParameter("cadena",cadena);
   lista=(List<LaboratorioDescMedVenta>)consult.getResultList();
   System.out.println("datos:" +lista.size());
   
 
           
 return lista;   
}



}