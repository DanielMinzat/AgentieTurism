//package controller;
//
//import dao.Iimpl.PacketDAO;
//import entity.base.ClientEntity;
//import entity.base.PacketEntity;
//import entity.service.impl.ClientService;
//import entity.service.impl.ClientServiceImpl;
//import entity.service.impl.PacketService;
//import entity.service.impl.PacketServiceImpl;
//import org.hibernate.Hibernate;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import java.util.List;
//import java.util.Locale;
//import java.util.Optional;
//import java.util.Scanner;
//
//public class TestMain {
//    public static void main(String[] args) {
//
//
//        ClientService clientService = new ClientServiceImpl();
//        PacketService packetService = new PacketServiceImpl();
//
//        Scanner scanner = new Scanner(System.in);
//        boolean continueCreating = true;
//
//        while (continueCreating) {
//            System.out.println("Introduceti numele:");
//            String name = scanner.nextLine();
//
//            System.out.println("Introduceti prenumele:");
//            String surname = scanner.nextLine();
//
//            System.out.println("Introduceti adresa de email:");
//            String email = scanner.nextLine();
//
//            ClientEntity client = new ClientEntity();
//            client.setName(name);
//            client.setSurname(surname);
//            client.setEmail(email);
//
//            clientService.save(client);
//
//
//            System.out.println("Introduceti numele orasului unde doriti sa mergeti:");
//            String cityName = scanner.nextLine();
//
//            System.out.println("Introduceti varianta de transport(avion/tren/autocar):");
//            String transportName = scanner.nextLine();
//
//            System.out.println("Introduceti numele agentiei pe care doriti sa o alegeti:");
//            String agencyName = scanner.nextLine();
//
//            PacketEntity packet = new PacketEntity();
//            packet.setCity(cityName);
//            packet.setTransport(transportName);
//            packet.setNumeAgentie(agencyName);
//
//            packetService.save(packet);
//
//            client.getPacketWithClients().add(packet);
//            packet.getClientsForPackets().add(client);
//
//            clientService.save(client);
//            packetService.save(packet);
//
//
//            System.out.println("Clientul " + name + " " + surname + " este legat de pachetul cu transportul " + transportName + " către " + cityName + " oferit de agenția " + agencyName);
//
//
//            System.out.println("Doriti sa adaugati un alt pachet (da/nu) ? ");
//            String addAnotherPachetChoice = scanner.nextLine().toLowerCase();
//            if (addAnotherPachetChoice.equals("da")) {
//
//                System.out.println("Introduceti numele orasului pentru noul pachet:");
//                String newCityName = scanner.nextLine();
//
//                System.out.println("Introduceti varianta de transport pentru noul pachet (avion/tren/autocar):");
//                String newTransportName = scanner.nextLine();
//
//                System.out.println("Introduceti numele agentiei pentru noul pachet:");
//                String newAgencyName = scanner.nextLine();
//
//                PacketEntity newPacket = new PacketEntity();
//                newPacket.setCity(newCityName);
//                newPacket.setTransport(newTransportName);
//                newPacket.setNumeAgentie(newAgencyName);
//
//                packetService.save(newPacket);
//
//                client.getPacketWithClients().add(newPacket);
//                newPacket.getClientsForPackets().add(client);
//
//                clientService.save(client);
//                packetService.save(newPacket);
//            }
//
//            System.out.println("Doriti sa adaugati un alt client (da/nu)?");
//            String addAnotherClientChoice = scanner.nextLine().toLowerCase();
//            if (addAnotherClientChoice.equals("da")) {
//                continue;
//            }
//
//
//
//            continueCreating = false;
//
//        }
//            scanner.close();
//
//        }
//    }
//
//
