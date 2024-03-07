package controller;

import entity.base.ClientEntity;
import entity.base.PacketEntity;
import entity.service.impl.ClientService;
import entity.service.impl.ClientServiceImpl;
import entity.service.impl.PacketService;
import entity.service.impl.PacketServiceImpl;

import java.util.List;

public class RelationController {
    public static void main(String[] args) {
        // inirializam serviciile
        ClientService clientService = new ClientServiceImpl();
        PacketService packetService = new PacketServiceImpl();


        // cream entitati nerelationate
        ClientEntity client = new ClientEntity();
        PacketEntity packet = new PacketEntity();

        client.setName("b");
        client.setSurname("b");
        client.setEmail("b");

        // salvam
        clientService.save(client);



        // salvam
        packetService.save(packet);

        // stabilim relatiile many to many
        packet.getClientsForPackets().add(client);
        client.getPacketWithClients().add(packet);

        // printuri
        List<PacketEntity> packetEntities = packetService.findAll();
        List<ClientEntity> clientEntities = clientService.findAll();

        for (PacketEntity itPacket : packetEntities) {
            System.out.println("Packet: " + itPacket.getTransport() + " " + itPacket.getCity() + " " + itPacket.getNumeAgentie());
            System.out.println("Client: ");
            for (ClientEntity itClient : clientEntities) {
                System.out.println("-> " + itClient.getName() + " " + itClient.getSurname() + " " + itClient.getEmail());
            }
            System.out.println("-------------------------------------");
        }

        for (ClientEntity itClient : clientEntities) {
            System.out.println("Client: " + itClient.getName() + " " + itClient.getSurname() + " " + itClient.getEmail());
            System.out.println("Packet: ");
            for (PacketEntity itPacket : packetEntities) {
                System.out.println("-> " + itPacket.getTransport() + " " + itPacket.getCity() + " " + itPacket.getNumeAgentie());
            }
            System.out.println("-------------------------------------");
        }
    }

    }

