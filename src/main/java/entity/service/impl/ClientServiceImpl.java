package entity.service.impl;

import dao.Iimpl.ClientDAO;
import dao.Iimpl.ClientDaoImpl;
import entity.base.ClientEntity;
import entity.service.base.BaseService;
import java.util.List;
import java.util.Optional;

public class ClientServiceImpl extends BaseService implements ClientService {

    private ClientDAO clientDAO;

    public ClientServiceImpl() {
        this.clientDAO = new ClientDaoImpl(sessionFactory.createEntityManager());
    }

    @Override
    public ClientEntity save(ClientEntity client) {
        return clientDAO.save(client);
    }

    @Override
    public void deleteById(Integer id) {
        this.clientDAO.deleteById(id);
    }

    @Override
    public Optional<ClientEntity> searchById(Integer id) {
        return this.clientDAO.searchById(id);
    }

    @Override
    public List<ClientEntity> findAll() {
        return this.clientDAO.findAll();
    }
}

