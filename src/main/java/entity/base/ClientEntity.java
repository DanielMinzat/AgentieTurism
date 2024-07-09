package entity.base;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


@Entity(name = "client")
@Getter
@Setter


public class ClientEntity  {

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "surname")
    @NonNull
    private String surname;

    @Column(name = "email")
    @NonNull
    private String email;   // cum sa fac validare pe email
    // daca el este invalid throw exception "Invalid email"

    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "clients_to_packets",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "packet_id"))
    private List<PacketEntity> packetWithClients = new ArrayList<>();

    @Override
    public String toString() {
        return "Clienti din baza de date :" + " "
               +  name + " "
                +  surname  + " "
               +  email  + " " +
                " cu numar de identificare: " + clientId + "\n" ;

    }

    public void setEmail(String email) {
        if (isValidEmail(email)) {
            this.email = email;
        }else {
            throw new IllegalArgumentException("Adresă de e-mail invalidă. Reintroduceti datele.");
        }
    }

    protected boolean isValidEmail(String email) {
        // Expresie regulata pentru validarea adresei de e-mail
        String emailRegex =  "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
