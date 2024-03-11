package dao.Iimpl;

import dao.base.BaseDAO;
import entity.base.PacketEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacketDAOImpl extends BaseDAO implements PacketDAO {

    public PacketDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public PacketEntity save (PacketEntity packet){
        EntityTransaction transaction = null;
        try {
            // check transaction is Null
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            entityManager.persist(packet);  // in contextul hibernate, persist = save/update element in table

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }

        return packet;
    }

    @Override
    public void deleteById (Integer id){
        EntityTransaction transaction = null;
        try {
            // check transaction is Null
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            Optional<PacketEntity> found = Optional.ofNullable(entityManager.find(PacketEntity.class, id));
            if (found.isPresent()) {
                entityManager.remove(found.get());
            }
            // commit command
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }


    @Override
    public Optional<PacketEntity> searchById (Integer id){
        EntityTransaction transaction = null;
        Optional<PacketEntity> found = Optional.empty();
        try {
            // check transaction is Null
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            found = Optional.ofNullable(entityManager.find(PacketEntity.class, id));

            // commit command
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return found;
    }

    @Override
    public List<PacketEntity> findAll () {
        EntityTransaction transaction = null;
        List<PacketEntity> resultList = new ArrayList<>();

        try {
            // check transaction is Null
            transaction = entityManager.getTransaction();

            if (!transaction.isActive()) {
                transaction.begin();
            }

            // sql command
            resultList = entityManager.createQuery("FROM packet", PacketEntity.class).getResultList();
            // commit command
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return resultList;
    }
}

