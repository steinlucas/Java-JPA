
package br.edu.ifsc.database;

import br.edu.ifsc.database.util.EntityManagerUtil;
import br.edu.ifsc.database.entity.Aluno;
import java.util.List;
import javax.persistence.EntityManager;

public class AlunoDAO {

    private EntityManager entityManager;
    private static AlunoDAO instance;

    public static AlunoDAO getInstance() {
        if (instance == null) {
            instance = new AlunoDAO();
        }
        return instance;
    }

    public AlunoDAO() {
        entityManager = EntityManagerUtil.getInstance().getEntityManager();
    }

    public void save(Aluno aluno) {
        entityManager.getTransaction().begin();
        entityManager.persist(aluno);
        entityManager.getTransaction().commit();
    }

    public Aluno getAluno(long id) throws Exception {
        Aluno aluno = entityManager.find(Aluno.class, id);
        if (aluno != null) {
            return aluno;
        }
        throw new Exception(String.format("Aluno %s não encontrado", id));
    }

    public List<Aluno> getAll() {
        List<Aluno> resp = entityManager.createQuery("SELECT * FROM cliente").getResultList();

        return resp;
    }

    public void remove(Aluno aluno) {
        entityManager.getTransaction().begin();
        entityManager.remove(aluno);
        entityManager.getTransaction().commit();
    }
}
