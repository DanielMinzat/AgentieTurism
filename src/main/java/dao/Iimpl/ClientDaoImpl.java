package dao.Iimpl;

import dao.base.BaseDAO;
import entity.base.ClientEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class ClientDaoImpl extends BaseDAO implements ClientDAO {
    public ClientDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public ClientEntity save(ClientEntity client) {
        EntityTransaction transaction = null;
        try {
            // check transaction is Null
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            entityManager.persist(client);  // in contextul hibernate, persist = save/update element in table

            // commit command
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }

        return client;
    }

    @Override
    public void deleteById(Integer id) {
        EntityTransaction transaction = null;
        try {
            // check transaction is Null
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            Optional<ClientEntity> found = Optional.ofNullable(entityManager.find(ClientEntity.class, id));
            if (found.isPresent()) {
                entityManager.remove(found.get());
            }
            // commit command
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    @Override
    public Optional<ClientEntity> searchById(Integer id) {
        EntityTransaction transaction = null;
        Optional<ClientEntity> found = Optional.empty();
        try {
            // check transaction is Null
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            found = Optional.ofNullable(entityManager.find(ClientEntity.class, id));

            // commit command
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return found;
    }

    @Override
    public List<ClientEntity> findAll() {
        EntityTransaction transaction = null;
        List<ClientEntity> resultList = new ArrayList<>();

        try {
            // check transaction is Null
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            resultList = entityManager.createQuery("FROM client", ClientEntity.class).getResultList(); // atentie mare ca era From actors
            // commit command
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return resultList;
    }
}