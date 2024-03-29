package entity.base;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity(name = "client")
@Data

public class ClientEntity  {

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "surname")
    @NonNull
    private String surname;

    @Column(name = "email")
    @NonNull
    private String email;

    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "clients_to_packets",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "packet_id"))
    private List<PacketEntity> packetWithClients = new ArrayList<>();


}
