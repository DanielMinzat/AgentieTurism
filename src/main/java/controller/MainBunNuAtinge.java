package controller;

import entity.base.ClientEntity;
import entity.base.PacketEntity;
import entity.service.impl.ClientService;
import entity.service.impl.ClientServiceImpl;
import entity.service.impl.PacketService;
import entity.service.impl.PacketServiceImpl;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MainBunNuAtinge {
    public static void main(String[] args) {
        ClientService clientService = new ClientServiceImpl();
        PacketService packetService = new PacketServiceImpl();

        Scanner scanner = new Scanner(System.in);
        boolean continueCreating = true;

        while (continueCreating) {
            ClientEntity client = createClientFromInput(scanner);

            System.out.println("Introduceti numele orasului/tarii unde doriti sa mergeti:");
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

            clientService.save(client);
            packetService.save(packet);

            System.out.println("Clientul " + client.getName() + " " + client.getSurname() + " este legat de pachetul cu transportul " + transportName + " către " + cityName + " oferit de agenția " + agencyName);

            System.out.println("Doriti sa adaugati un alt pachet (da/nu) ? ");
            String addAnotherPachetChoice = scanner.nextLine().toLowerCase();
            if (addAnotherPachetChoice.equals("da")) {
                System.out.println("Introduceti numele orasului/tarii pentru noul pachet:");
                String newCityName = scanner.nextLine();

                System.out.println("Introduceti varianta de transport pentru noul pachet (avion/tren/autocar):");
                String newTransportName = scanner.nextLine();

                System.out.println("Introduceti numele agentiei pentru noul pachet:");
                String newAgencyName = scanner.nextLine();

                PacketEntity newPacket = new PacketEntity();
                newPacket.setCity(newCityName);
                newPacket.setTransport(newTransportName);
                newPacket.setNumeAgentie(newAgencyName);

                packetService.save(newPacket);

                client.getPacketWithClients().add(newPacket);
                newPacket.getClientsForPackets().add(client);

                clientService.save(client);
                packetService.save(newPacket);
            }

            System.out.println("Doriti sa adaugati un alt client (da/nu)?");
            String addAnotherClientChoice = scanner.nextLine().toLowerCase();
            if (!addAnotherClientChoice.equals("da")) {
                continueCreating = false;
            }
        }

        // Afiseaza lista de pachete existente
        List<PacketEntity> packets = packetService.findAll();
        System.out.println("Lista de pachete existente:");
        for (PacketEntity packet : packets) {
            System.out.println(packet);
        }

        // Afiseaza lista de clienti disponibili
        List<ClientEntity> clients = clientService.findAll();
        System.out.println("Lista de clienti disponibili:");
        for (ClientEntity client : clients) {
            System.out.println(client);
        }

        // Solicitați utilizatorului ID-ul clientului și ID-ul noului pachet și actualizați asocierea client-pachet
        System.out.println("Introduceti ID-ul clientului pentru care doriti sa schimbati pachetul:");
        int clientId = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti ID-ul noului pachet:");
        int newPacketId = Integer.parseInt(scanner.nextLine());

        Optional<ClientEntity> optionalClient = clientService.searchById(clientId);
        Optional<PacketEntity> optionalNewPacket = packetService.searchById(newPacketId);

        if (optionalClient.isPresent() && optionalNewPacket.isPresent()) {
            ClientEntity clientToUpdate = optionalClient.get();
            PacketEntity newPacket = optionalNewPacket.get();

            clientToUpdate.getPacketWithClients().clear();
            clientToUpdate.getPacketWithClients().add(newPacket);
            newPacket.getClientsForPackets().clear();
            for (PacketEntity oldPacket : clientToUpdate.getPacketWithClients()) {
                oldPacket.getClientsForPackets().remove(clientToUpdate);
            }

            // Asociați clientul cu noul pachet
            clientToUpdate.getPacketWithClients().clear();
            clientToUpdate.getPacketWithClients().add(newPacket);
            newPacket.getClientsForPackets().add(clientToUpdate);

            // Salvarea actualizărilor
            clientService.save(clientToUpdate);
            packetService.save(newPacket);

            System.out.println("Asocierea pachetului a fost actualizată cu succes pentru clientul cu ID-ul " + clientId);
        } else {
            System.out.println("Clientul sau pachetul cu ID-urile specificate nu există.");
        }

        scanner.close();
    }

    public static ClientEntity createClientFromInput(Scanner scanner) {
        while (true) {
            try {
                ClientEntity client = new ClientEntity();

                System.out.println("Introduceti numele:");
                String name = scanner.nextLine();

                System.out.println("Introduceti prenumele:");
                String surname = scanner.nextLine();

                System.out.println("Introduceti adresa de email:");
                String email = scanner.nextLine();

                // Validare adresa de email
                if (!isValidEmail(email)) {
                    throw new IllegalArgumentException("Adresa de email introdusă nu este validă.");
                }

                client.setName(name);
                client.setSurname(surname);
                client.setEmail(email);

                return client;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); //
                System.out.println("Vă rugăm să reintroduceți datele.");
            }
        }
    }

    private static boolean isValidEmail(String email) {
        return true;
    }
}
