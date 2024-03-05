package dao.Iimpl;

import entity.base.PacketEntity;

import java.util.List;
import java.util.Optional;

public interface PacketDAO {
    PacketEntity save(PacketEntity packet);

    void deleteById(Integer id);


    Optional<PacketEntity> searchById(Integer id);

    List<PacketEntity> findAll();
}
