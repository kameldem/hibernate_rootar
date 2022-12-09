package com.rootar.hibernate_rootar.repositories;

import com.rootar.hibernate_rootar.dto.PaysDto;
import com.rootar.hibernate_rootar.dto.RegionDto;
import com.rootar.hibernate_rootar.entities.PaysEntity;
import com.rootar.hibernate_rootar.entities.RegionEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;

import java.util.List;

public class RegionRepository {
    private EntityManager entityManager = Persistence.createEntityManagerFactory("fr.hc.rootar").createEntityManager();


    public List<RegionDto> getAll() {
        return RegionDto.toRegionDtoList(entityManager.createNamedQuery("region.getAll", RegionEntity.class).getResultList());
    }

    public RegionEntity getById(int id) {
        RegionEntity region = entityManager.find(RegionEntity.class, id);
        return region;
    }
    @Transactional
    public boolean update(RegionEntity region) {

        RegionEntity updatingRegion = getById(region.getIdRegion());
        if (updatingRegion == null) return false;
        entityManager.getTransaction().begin();
        entityManager.merge(region);
        entityManager.getTransaction().commit();
        return true;
    }
    @Transactional
    public void create(RegionEntity region) {
        entityManager.getTransaction().begin();
        entityManager.persist(region);
        entityManager.getTransaction().commit();
    }
    @Transactional
    public boolean delete(RegionEntity region) {
        RegionEntity deletingRegion = getById(region.getIdRegion());
        if (deletingRegion == null)
            return false;
        entityManager.getTransaction().begin();
        entityManager.remove(deletingRegion);
        entityManager.getTransaction().commit();
        return true;
    }
}
