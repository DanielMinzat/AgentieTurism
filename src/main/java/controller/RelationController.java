package controller;

import entity.base.ClientEntity;
import entity.base.PacketEntity;
import entity.service.impl.ClientService;
import entity.service.impl.ClientServiceImpl;
import entity.service.impl.PacketService;
import entity.service.impl.PacketServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RelationController {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure() // incarca configuratia din resources -> bibernate.cfg.xml
                .addAnnotatedClass(ClientEntity.class) // va adauga clasele de entitate ca standarde pentru comenzile sql
                .addAnnotatedClass(PacketEntity.class)
                .buildSessionFactory(); // porneste sesiunea, echivalentul lui getConnection din JDBC

        ClientServiceImpl clientService = new ClientServiceImpl(sessionFactory.createEntityManager());
        PacketServiceImpl packetService = new PacketServiceImpl(sessionFactory.createEntityManager());


        Scanner scanner = new Scanner(System.in);

        ClientEntity client = buildClientAndSaveToDatabase(scanner, clientService);

        System.out.println("client salvat: " + " " + client.getName() + " " + client.getSurname() + " " + client.getEmail());
        System.out.println(clientService.searchById(1));

        System.out.println();

        PacketEntity packet = buildPacketAndSaveToDatabase(scanner, packetService);

        client.setClientId(1);
        packet.setPacketId(1);

        packet.getClientsForPackets().add(client);
        client.getPacketWithClients().add(packet);

        clientService.save(client);
        packetService.save(packet);

        System.out.println("pachet salvat: " + " " + packet.getNumeAgentie() + " " + packet.getCity() + " " + packet.getTransport());


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
