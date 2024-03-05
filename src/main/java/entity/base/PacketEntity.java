package entity.base;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "packet")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class PacketEntity extends BaseEntity  {


    @Column(name = "nume_agentie")
    @NonNull
    private String numeAgentie;

    @Column(name = "city")
    @NonNull
    private String city;

    @Column(name = "transport")
    @NonNull
    private String transport;



    @ManyToMany(mappedBy = "packets", fetch = FetchType.LAZY)
    private List<ClientEntity> clientsForPackets = new ArrayList<>();

    }
