package com.rootar.hibernate_rootar.repositories;

import com.rootar.hibernate_rootar.entities.MonnaieEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

public class MonnaieRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("fr.hc.rootar").createEntityManager();

    public List<MonnaieEntity> getAll() {
        return entityManager.createNamedQuery("monnaie.getAll", MonnaieEntity.class).getResultList();
    }
}
