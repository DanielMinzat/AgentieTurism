package dao.Iimpl;

import entity.base.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface ClientDAO {

    ClientEntity save(ClientEntity client);

    void deleteById(Integer id);


    Optional<ClientEntity> searchById(Integer id);

    List<ClientEntity> findAll();
}
