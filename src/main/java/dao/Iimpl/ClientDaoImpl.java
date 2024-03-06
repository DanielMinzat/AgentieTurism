package dao.Iimpl;

import dao.base.BaseDAO;
import entity.base.ClientEntity;
import entity.service.base.BaseService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class ClientDaoImpl extends BaseService implements ClientDAO {

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
