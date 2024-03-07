package controller;

import entity.base.ClientEntity;
import entity.base.PacketEntity;
import entity.service.impl.ClientService;
import entity.service.impl.ClientServiceImpl;
import entity.service.impl.PacketService;
import entity.service.impl.PacketServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



        ClientService clientService = new ClientServiceImpl();
        PacketService packetService = new PacketServiceImpl();

        Scanner scanner = new Scanner(System.in);

        ClientEntity client = buildClientAndSaveToDatabase(scanner, (ClientServiceImpl) clientService);

        System.out.println("client salvat: " + " " + client.getName() + " " + client.getSurname() + " " + client.getEmail());

        PacketEntity packet = buildPacketAndSaveToDatabase(scanner, (PacketServiceImpl) packetService);

        packet.getClientsForPackets().add(client);
        client.getPacketWithClients().add(packet);

        clientService.save(client);
        packetService.save(packet);

        System.out.println("pachet salvat: " + " " + packet.getNumeAgentie() + " " + packet.getCity() + " " + packet.getTransport());

        System.out.println();clientService.findAll();
        scanner.close();

    }

    private static PacketEntity buildPacketAndSaveToDatabase(Scanner scanner, PacketServiceImpl packetService) {
        System.out.println("Alegeti un pachet de vacanta");

        System.out.println("Introduceti numele orasului unde doriti sa mergeti:");
        String cityName = scanner.nextLine();

        System.out.println("Introduceti varianta de transport(avion/tren/autocar):");
        String transportName = scanner.nextLine();

        System.out.println("Introduceti numele agentiei pe care doriti sa o alegeti:");
        String agencyName = scanner.nextLine();

        PacketEntity packet = new PacketEntity();
        packet.setCity(cityName);
        packet.setTransport(transportName);
        packet.setNumeAgentie(agencyName);


        packetService.save(packet);
        return packet;
    }

    private static ClientEntity buildClientAndSaveToDatabase(Scanner scanner, ClientServiceImpl clientService) {
        System.out.println("Introduceti numele:");
        String name = scanner.nextLine();

        System.out.println("Introduceti prenumele:");
        String surname = scanner.nextLine();

        System.out.println("Introduceti adresa de email:");
        String email = scanner.nextLine();

        ClientEntity client = new ClientEntity();
        client.setName(name);
        client.setSurname(surname);
        client.setEmail(email);

        clientService.save(client);
        return client;

    }

    private static String getDescription (PacketEntity packetEntity) {
        return packetEntity.getCity()+ " " + packetEntity.getTransport() + " " + packetEntity.getNumeAgentie();
    }
}
