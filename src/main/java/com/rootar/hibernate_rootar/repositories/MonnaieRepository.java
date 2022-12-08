package com.rootar.hibernate_rootar.repositories;

import com.rootar.hibernate_rootar.entities.MonnaieEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

public class MonnaieRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("fr.hc.rootar").createEntityManager();

    public List<MonnaieEntity> getAll() {
        return entityManager.createNamedQuery("monnaie.getAll", MonnaieEntity.class).getResultList();
    }
    public MonnaieEntity getById(int id) {
        MonnaieEntity monnaie = entityManager.find(MonnaieEntity.class, id);
        return monnaie;
    }
    @Transactional
    public boolean update(MonnaieEntity monnaie) {

        MonnaieEntity updatingMonnaie = getById(monnaie.getIdMonnaie());
        if (updatingMonnaie == null) return false;
        entityManager.getTransaction().begin();
        entityManager.merge(monnaie);
        entityManager.getTransaction().commit();
        return true;
    }
    @Transactional
    public void create(MonnaieEntity monnaie) {
        entityManager.getTransaction().begin();
        entityManager.persist(monnaie);
        entityManager.getTransaction().commit();
    }
    @Transactional
    public boolean delete(MonnaieEntity monnaie) {
        MonnaieEntity deletingMonnaie = getById(monnaie.getIdMonnaie());
        if (deletingMonnaie == null)
            return false;
        entityManager.getTransaction().begin();
        entityManager.remove(deletingMonnaie);
        entityManager.getTransaction().commit();
        return true;
    }
}
