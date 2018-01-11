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
import javax.persistence.Query;

/**
 *
 * @author hernan
 */
public class LoteDAO {

    public Lote consultarPorIdLote(Lote lote) throws Exception{

        Lote loteEncontrado = null;
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("DrogueriaPU");
        EntityManager gestor = fact.createEntityManager();
        EntityTransaction transaccion = gestor.getTransaction();

        transaccion.begin();
        String consulta="SELECT l FROM Lote l WHERE l.idLote = :idLote";
        Query consult = gestor.createQuery(consulta);
        consult.setParameter("idLote", lote.getIdLote());
        loteEncontrado = (Lote) consult.getSingleResult();
        transaccion.commit();
        return loteEncontrado;
    }
    

}
