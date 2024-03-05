package entity.service.impl;

import entity.base.PacketEntity;
import entity.service.base.BaseService;

import java.util.List;
import java.util.Optional;

public class PacketServiceImpl extends BaseService implements PacketService {
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
