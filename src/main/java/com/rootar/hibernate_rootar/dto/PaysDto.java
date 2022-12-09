package com.rootar.hibernate_rootar.dto;

import com.rootar.hibernate_rootar.entities.ContinentEntity;
import com.rootar.hibernate_rootar.entities.PaysEntity;
import com.rootar.hibernate_rootar.entities.RegionEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.List;

@Data
public class PaysDto {
    private int id;
    private String nom;
    private Continent continent;

    private List<Region> region;

    public PaysDto(PaysEntity paysEntity){
        id = paysEntity.getIdPays();
        nom = paysEntity.getNomPaysFr();
        continent = new Continent(paysEntity.getContinent());
        region = fromRegionDtoList(paysEntity.getRegions());
    }

    private List<Region> fromRegionDtoList(List<RegionEntity> regionEntities) {
        List<Region> regionList = new ArrayList<Region>();
        for (RegionEntity regionEntity : regionEntities){
            regionList.add(new Region(regionEntity));
        }
        return regionList;
    }

    public static List<PaysDto> toPaysDtoList(List<PaysEntity> paysEntities) {

        List<PaysDto> paysDtoList = new ArrayList<>();
        for (PaysEntity paysEntity : paysEntities) {
            paysDtoList.add(new PaysDto(paysEntity));
        }

        return paysDtoList;
    }
    @Getter
    @Setter
    class Continent{
        private int id;
        private String nom;

        public Continent(ContinentEntity continentEntity) {
            id = continentEntity.getIdContinent();
            nom = continentEntity.getNomContinentFr();
        }
    }

    @Getter
    @Setter
    class Region{
        private int idRegion;
        private String nomRegion;

        public Region(RegionEntity regionEntity) {
            idRegion = regionEntity.getIdRegion();
            nomRegion = regionEntity.getNomRegion();
        }
    }
}

