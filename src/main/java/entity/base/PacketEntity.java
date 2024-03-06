package entity.base;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "packet")
@Getter
@Setter
public class PacketEntity   {


    @Column(name = "nume_agentie")
    @NonNull
    private String numeAgentie;

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

    }
