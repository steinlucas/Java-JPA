
package br.edu.ifsc.database;

import br.edu.ifsc.database.util.EntityManagerUtil;
import java.util.List;
import javax.persistence.EntityManager;

public class ClienteDAO {

    private EntityManager entityManager;
    private static ClienteDAO instance;

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    public ClienteDAO() {
        entityManager = EntityManagerUtil.getInstance().getEntityManager();
    }

    public void save(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    public Cliente getCliente(long idCliente) throws Exception {
    	Cliente cliente = entityManager.find(Cliente.class, idCliente);
        if (cliente != null) {
            return cliente;
        }
        throw new Exception(String.format("Cliente %s não encontrado", idCliente));
    }

    public List<Cliente> getAll() {
        List<Cliente> resp = entityManager.createQuery("SELECT * FROM cliente").getResultList();

        return resp;
    }

    public void remove(Cliente cliente) {
        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();
    }
}
