package controller;

import entity.base.ClientEntity;
import entity.service.impl.ClientService;
import entity.service.impl.ClientServiceImpl;
import entity.service.impl.PacketService;
import entity.service.impl.PacketServiceImpl;

public class RelationController {
    public static void main(String[] args) {


        ClientService clientService = new ClientServiceImpl();
        PacketService packetService = new PacketServiceImpl();

        ClientEntity client = new ClientEntity("asa","totasa","asasas@gmail.com");
    }
}
