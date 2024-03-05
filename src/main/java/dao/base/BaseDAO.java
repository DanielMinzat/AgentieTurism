package dao.base;

import jakarta.persistence.EntityManager;

public abstract class BaseDAO {
    protected final EntityManager entityManager;

    protected BaseDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
