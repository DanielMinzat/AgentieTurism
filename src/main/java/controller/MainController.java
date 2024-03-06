package controller;

import entity.base.ClientEntity;
import entity.base.PacketEntity;
import entity.service.impl.ClientService;
import entity.service.impl.ClientServiceImpl;
import entity.service.impl.PacketService;
import entity.service.impl.PacketServiceImpl;

public class MainController {
    public static void main(String[] args) {
        ClientService clientService = new ClientServiceImpl();
        PacketService packetService = new PacketServiceImpl();

        clientService.save(new ClientEntity("paul","paul","hauhau@gmail.com"));

        System.out.println(clientService.findAll());
        System.out.println(clientService.searchById(1));
    }
}
