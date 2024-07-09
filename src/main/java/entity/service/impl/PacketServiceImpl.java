package entity.service.impl;

import dao.Iimpl.PacketDAO;
import dao.Iimpl.PacketDAOImpl;
import entity.base.PacketEntity;
import entity.service.base.BaseService;
import java.util.List;
import java.util.Optional;

public class PacketServiceImpl extends BaseService implements PacketService {

    private PacketDAO packetDAO;

    public PacketServiceImpl() {
        this.packetDAO = new PacketDAOImpl(sessionFactory.createEntityManager());
    }

    @Override
    public PacketEntity save(PacketEntity packet) {
        return packetDAO.save(packet);
    }

    @Override
    public void deleteById(Integer id) {
        this.packetDAO.deleteById(id);
    }

    @Override
    public Optional<PacketEntity> searchById(Integer id) {
        return this.packetDAO.searchById(id);
    }

    @Override
    public List<PacketEntity> findAll() {
        return this.packetDAO.findAll();
    }
}