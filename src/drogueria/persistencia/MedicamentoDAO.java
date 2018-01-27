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

/**
 *
 * @author hernan
 */
public class MedicamentoDAO {
    
public List<Medicamento> conseguirMedicamentoDisponibleLote(Lote lote)
{
    List<Medicamento> listaMedicamentos = null;
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("DrogueriaPU");
        EntityManager gestor = fact.createEntityManager();
        EntityTransaction transaccion = gestor.getTransaction();

        transaccion.begin();
        String consulta="SELECT m FROM Medicamento m WHERE m.lote.idLote = :idLote "
                + "and m.estadoProducto= :estado";
        Query consult = gestor.createQuery(consulta);
        consult.setParameter("idLote", lote.getIdLote());
        consult.setParameter("estado", "DISPONIBLE");
        listaMedicamentos = (List<Medicamento>) consult.getResultList();
        transaccion.commit();
        return listaMedicamentos;
} 

public  boolean  borrarPorMedicamento(Medicamento medicamento)throws Exception{
        boolean resultadoConsulta=false;
            
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("DrogueriaPU");
        EntityManager gestor = fact.createEntityManager();
        EntityTransaction transaccion = gestor.getTransaction();
 
        transaccion.begin();
        String consulta="delete from Medicamento med WHERE med.idMedicamento = :idMed";
        Query consult = gestor.createQuery(consulta);
        consult.setParameter("idMed", medicamento.getIdMedicamento());
        int datoModificados= consult.executeUpdate();
        
        if(datoModificados>0)
            resultadoConsulta=true;
       transaccion.commit();
            
        return resultadoConsulta;
    }    
}
