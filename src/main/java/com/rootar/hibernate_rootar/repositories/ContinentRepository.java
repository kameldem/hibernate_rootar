package com.rootar.hibernate_rootar.repositories;

import com.rootar.hibernate_rootar.dto.ContinentDto;
import com.rootar.hibernate_rootar.entities.ContinentEntity;
import com.rootar.hibernate_rootar.entities.MonnaieEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

public class ContinentRepository {

    private EntityManager entityManager = Persistence.createEntityManagerFactory("fr.hc.rootar").createEntityManager();

    public List<ContinentDto> getAll() {
        return ContinentDto.toContinentDtoList(entityManager.createNamedQuery("continent.getAll", ContinentEntity.class).getResultList());
    }
    public ContinentEntity getById(int id) {
        ContinentEntity continent = entityManager.find(ContinentEntity.class, id);
        return continent;
    }

    @Transactional
    public boolean update(ContinentEntity continent) {

        ContinentEntity updatingContinent = getById(continent.getIdContinent());
        if (updatingContinent == null) return false;
        entityManager.getTransaction().begin();
        entityManager.merge(continent);
        entityManager.getTransaction().commit();
        return true;
    }

    @Transactional
    public void insert(ContinentEntity continent) {
        entityManager.getTransaction().begin();
        entityManager.persist(continent);
        entityManager.getTransaction().commit();
    }

    @Transactional
    public boolean delete(ContinentEntity continent) {
        ContinentEntity deletingContinent = getById(continent.getIdContinent());
        if (deletingContinent == null)
            return false;
        entityManager.getTransaction().begin();
        entityManager.remove(deletingContinent);
        entityManager.getTransaction().commit();
        return true;
    }
}


