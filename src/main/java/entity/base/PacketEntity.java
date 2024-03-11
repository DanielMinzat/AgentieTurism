package entity.base;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "packet")
@Getter
@Setter
public class PacketEntity   {

    public enum Agency {
        Dertour,
        TransAlpina,
        Atlasib
    }

    @Column(name = "nume_agentie")
    @NonNull
    private String numeAgentie; // sa limitez la agentii facute de mine prestabilite (enum)

    @Column(name = "city")
    @NonNull
    private String city;

    @Column(name = "transport")
    @NonNull
    private String transport;

    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "packet_id")
    private Integer packetId;


    @ManyToMany(mappedBy = "packetWithClients", fetch = FetchType.LAZY)
    private List<ClientEntity> clientsForPackets = new ArrayList<>();

    public static void showAgencyOptions() {
        for (Agency agency : Agency.values()) {
            System.out.println(agency.name());
        }
    }


    @Override
    public String toString() {
        return "Pachete din baza de date :" + " "
                +  numeAgentie + " "
                +  city  + " "
                +  transport  + " " +
                " cu numar de identificare: " + packetId + "\n" ;

    }
}
