
package br.edu.ifsc.database;

import br.edu.ifsc.database.entity.Orcamento;
import br.edu.ifsc.database.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class OrcamentoDAO {

    private EntityManager entityManager;
    private static OrcamentoDAO instance;

    public static OrcamentoDAO getInstance() {
        if (instance == null) {
            instance = new OrcamentoDAO();
        }
        return instance;
    }

    public OrcamentoDAO() {
        entityManager = EntityManagerUtil.getInstance().getEntityManager();
    }

    public void save(Orcamento orcamento) {
        entityManager.getTransaction().begin();
        entityManager.persist(orcamento);
        entityManager.getTransaction().commit();
    }

    public Orcamento getOrcamento(long idOrcamento) throws Exception {
    	Orcamento orcamento = entityManager.find(Orcamento.class, idOrcamento);
        if (orcamento != null) {
            return orcamento;
        }
        throw new Exception(String.format("Orçamento %s não encontrado", idOrcamento));
    }

    public List<Orcamento> getAll() {
        List<Orcamento> resp = entityManager.createQuery("SELECT O FROM Orcamento O").getResultList();

        return resp;
    }

    public void remove(Orcamento orcamento) {
        entityManager.getTransaction().begin();
        entityManager.remove(orcamento);
        entityManager.getTransaction().commit();
    }
}
