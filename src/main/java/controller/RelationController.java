package controller;

import entity.base.ClientEntity;
import entity.base.PacketEntity;
import entity.service.impl.ClientService;
import entity.service.impl.ClientServiceImpl;
import entity.service.impl.PacketService;
import entity.service.impl.PacketServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RelationController {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti numele:");
        String name = scanner.nextLine();

        System.out.println("Introduceti prenumele:");
        String surname = scanner.nextLine();

        System.out.println("Introduceti adresa de email:");
        String email = scanner.nextLine();

        System.out.println("Alegeti un pachet de vacanta");

        List<PacketEntity> vacationPackages = new ArrayList<>();
        vacationPackages.add(new PacketEntity("Dertour","Italia","avion"));
        vacationPackages.add(new PacketEntity("CristianTour","Bulgaria","autocar"));
        vacationPackages.add(new PacketEntity("KarpatenTurism","Elvetia","tren"));

        for (int i = 0; i < vacationPackages.size(); i++) {
            System.out.println((i + 1) + "." + vacationPackages.get(i));
        }

        int choice = scanner.nextInt();
        scanner.nextLine();


         scanner.close();
    }

    static class VacationPackage {
        private String description;
        private String transport;
        private String city;
        private String agency;

        public VacationPackage(String description, String transport, String city, String agency) {
            this.description = description;
            this.transport = transport;
            this.city = city;
            this.agency = agency;


        }
        public String getDescription() {
            return description + " - " + transport + " - " + city + " - " + agency;

        }
    }
}
