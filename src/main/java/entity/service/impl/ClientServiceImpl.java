package entity.service.impl;

import entity.base.ClientEntity;
import entity.service.base.BaseService;

import java.util.List;
import java.util.Optional;

public class ClientServiceImpl extends BaseService implements ClientService {
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
