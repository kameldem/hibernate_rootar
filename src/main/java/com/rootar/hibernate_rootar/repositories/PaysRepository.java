package com.rootar.hibernate_rootar.repositories;

import com.rootar.hibernate_rootar.dto.PaysDto;
import com.rootar.hibernate_rootar.entities.MonnaieEntity;
import com.rootar.hibernate_rootar.entities.PaysEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

public class PaysRepository {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("fr.hc.rootar").createEntityManager();


    public List<PaysDto> getAll() {
        return entityManager.createNamedQuery("pays.getAll", PaysDto.class).getResultList();
    }

    public PaysEntity getById(int id) {
        PaysEntity pays = entityManager.find(PaysEntity.class, id);
        return pays;
    }
    @Transactional
    public boolean update(PaysEntity pays) {

        PaysEntity updatingPays = getById(pays.getIdPays());
        if (updatingPays == null) return false;
        entityManager.getTransaction().begin();
        entityManager.merge(pays);
        entityManager.getTransaction().commit();
        return true;
    }
    @Transactional
    public void create(PaysEntity pays) {
        entityManager.getTransaction().begin();
        entityManager.persist(pays);
        entityManager.getTransaction().commit();
    }
    @Transactional
    public boolean delete(PaysEntity pays) {
        PaysEntity deletingPays = getById(pays.getIdMonnaie());
        if (deletingPays == null)
            return false;
        entityManager.getTransaction().begin();
        entityManager.remove(deletingPays);
        entityManager.getTransaction().commit();
        return true;
    }
}
