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
public class UsuarioDAO {
  
 public Usuario buscarUsuarioPorId(Usuario usuario) throws Exception
 {      
     Usuario usuarioAux=new Usuario();
     EntityManagerFactory fact=Persistence.createEntityManagerFactory
        ("DrogueriaPU");
     EntityManager gestor=fact.createEntityManager();
     EntityTransaction transaccion=gestor.getTransaction();
        
     transaccion.begin();
        
     String consulta="select user  from  Usuario user where user.idUsuario= :id";
     Query consult= gestor.createQuery(consulta);
     consult.setParameter("id", usuario.getIdUsuario());
   try {
   usuarioAux=(Usuario)consult.getSingleResult();
          
   }
   catch(NoResultException error){
   throw new Exception("Usuario no se encuentra");
   } 
   transaccion.commit();
   gestor.close();
   return usuarioAux;
    
    }
}
