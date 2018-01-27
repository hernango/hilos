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
public class LaboratorioDescMedDAO {

    public List<Lote> consultaLotePorCodigoBarras(LaboratorioDescMed labDescMed) throws Exception {

        List<Lote> listaLote = null;

        EntityManagerFactory fact = Persistence.createEntityManagerFactory("DrogueriaPU");
        EntityManager gestor = fact.createEntityManager();
        EntityTransaction transaccion = gestor.getTransaction();
        Lote lote;

        transaccion.begin();
        String consulta = "select lote from Lote lote join lote.laboratorioDescMedVenta labDescventa "
                + " join labDescventa.laboratorioDescMed labDescMed where "
                + "labDescMed.codigoBarras= :codigoBarras order by lote.fechaVigencia asc";

        Query consult = gestor.createQuery(consulta);
        consult.setParameter("codigoBarras", labDescMed.getCodigoBarras());
        listaLote = (List<Lote>) consult.getResultList();

        transaccion.commit();
        return listaLote;

    }
}
