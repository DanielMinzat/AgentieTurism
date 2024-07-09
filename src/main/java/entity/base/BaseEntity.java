package entity.base;

import jakarta.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
}


