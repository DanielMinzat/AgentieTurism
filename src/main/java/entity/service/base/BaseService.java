package entity.service.base;

import entity.base.ClientEntity;
import entity.base.PacketEntity;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public abstract class BaseService {
    protected final SessionFactory sessionFactory = new Configuration()
            .configure() // incarca configuratia din resources -> bibernate.cfg.xml
            .addAnnotatedClass(ClientEntity.class) // va adauga clasele de entitate ca standarde pentru comenzile sql
            .addAnnotatedClass(PacketEntity.class)
            .buildSessionFactory(); // porneste sesiunea, echivalentul lui getConnection din JDBC

}
