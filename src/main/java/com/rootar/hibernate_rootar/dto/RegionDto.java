package com.rootar.hibernate_rootar.dto;

import com.rootar.hibernate_rootar.entities.ContinentEntity;
import com.rootar.hibernate_rootar.entities.PaysEntity;
import com.rootar.hibernate_rootar.entities.RegionEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class RegionDto {
    private int id;
    private String nom;
    private Pays pays;

    public RegionDto(RegionEntity regionEntity){
        id = regionEntity.getIdRegion();
        nom = regionEntity.getNomRegion();
        pays = new RegionDto.Pays(regionEntity.getPays());
    }

    public static List<RegionDto> toRegionDtoList(List<RegionEntity> regionEntities) {

        List<RegionDto> regionDtoList = new ArrayList<>();
        for (RegionEntity regionEntity : regionEntities) {
            regionDtoList.add(new RegionDto(regionEntity));
        }

        return regionDtoList;
    }
    @Getter
    @Setter
    class Pays{
        private int id;
        private String nom;

        public Pays(PaysEntity paysEntity) {
            id = paysEntity.getIdPays();
            nom = paysEntity.getNomPaysFr();
        }
    }

}

