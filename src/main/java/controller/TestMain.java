package controller;

import entity.base.ClientEntity;
import entity.base.PacketEntity;
import entity.service.impl.ClientService;
import entity.service.impl.ClientServiceImpl;
import entity.service.impl.PacketService;
import entity.service.impl.PacketServiceImpl;

import java.util.Locale;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {


        ClientService clientService = new ClientServiceImpl();
        PacketService packetService = new PacketServiceImpl();

        Scanner scanner = new Scanner(System.in);
        boolean continueCreating = true;

        while (continueCreating) {
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

            client.getPacketWithClients().add(packet);
            packet.getClientsForPackets().add(client);

            System.out.println("Doriti sa creati un alt client sau un alt pachet (da/nu)?" );
            String continueChoice = scanner.nextLine().toLowerCase();
            continueCreating = continueChoice.equals("da");

        }
        scanner.close();
    }
}
