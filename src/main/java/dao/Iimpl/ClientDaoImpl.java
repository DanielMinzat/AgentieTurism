package dao.Iimpl;

import dao.base.BaseDAO;
import entity.base.ClientEntity;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ClientDaoImpl extends BaseDAO implements ClientDAO {

    protected ClientDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public ClientEntity save(ClientEntity client) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Optional<ClientEntity> searchById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<ClientEntity> findAll() {
        return null;
    }
}
