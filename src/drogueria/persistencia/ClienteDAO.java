/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drogueria.persistencia;

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
public class ClienteDAO {
    
public Cliente buscarCliente(Cliente cliente) throws Exception{
        
     Cliente clienteAux=new Cliente();
     EntityManagerFactory fact=Persistence.createEntityManagerFactory
        ("DrogueriaPU");
     EntityManager gestor=fact.createEntityManager();
     EntityTransaction transaccion=gestor.getTransaction();
        
     transaccion.begin(); 
        
     String consulta="select c  from  Cliente c where c.idCliente= :id";
     Query consult= gestor.createQuery(consulta);
     consult.setParameter("id", cliente.getIdCliente());
   try {
   clienteAux=(Cliente)consult.getSingleResult();
          
   }
   catch(NoResultException error){
   throw new Exception("Usuario no se encuentra");
   } 
   transaccion.commit();
   gestor.close();
   return clienteAux;
    
    }   
  
// buscar cliente por cedula
public Cliente buscarClientePorCedula(Cliente cliente) throws Exception{
        
     Cliente clienteAux=new Cliente();
     EntityManagerFactory fact=Persistence.createEntityManagerFactory
        ("DrogueriaPU");
     EntityManager gestor=fact.createEntityManager();
     EntityTransaction transaccion=gestor.getTransaction();
        
     transaccion.begin(); 
        
     String consulta="select c  from  Cliente c where c.cedula= :cedula";
     Query consult= gestor.createQuery(consulta);
     consult.setParameter("cedula", cliente.getCedula());
   try {
   clienteAux=(Cliente)consult.getSingleResult();
          
   }
   catch(NoResultException error){
   throw new Exception("Usuario no se encuentra");
   } 
   transaccion.commit();
   gestor.close();
   return clienteAux;
    
    }   
//insertar un cliente

public void registrarCliente(Cliente cliente) throws Exception{
        
     Cliente clienteAux=new Cliente();
     EntityManagerFactory fact=Persistence.createEntityManagerFactory
        ("DrogueriaPU");
     EntityManager gestor=fact.createEntityManager();
     gestor.persist(cliente);
     EntityTransaction transaccion=gestor.getTransaction();
        
     transaccion.begin(); 
        
     
   transaccion.commit();
   gestor.close();
   
    
    }   
}
