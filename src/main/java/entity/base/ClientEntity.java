package entity.base;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "client")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ClientEntity extends BaseEntity {

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "surname")
    @NonNull
    private String surname;

    @Column(name = "email")
    @NonNull
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "clients_to_packets",
            joinColumns = @JoinColumn(name = "client_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "packet_id", referencedColumnName = "id"))
    private List<PacketEntity> packetWithClients = new ArrayList<>();

}
