package dao.Iimpl;

import dao.base.BaseDAO;
import entity.base.PacketEntity;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class PacketDAOImpl extends BaseDAO implements PacketDAO {
    protected PacketDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public PacketEntity save(PacketEntity packet) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Optional<PacketEntity> searchById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<PacketEntity> findAll() {
        return null;
    }
}
