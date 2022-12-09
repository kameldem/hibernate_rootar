package com.rootar.hibernate_rootar.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NamedQuery(name = "region.getAll", query ="Select r FROM RegionEntity  r order by r.idRegion")
@Table(name = "REGION", schema = "dbo", catalog = "ROOTAR")
public class RegionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_REGION")
    private int idRegion;
    @Basic
    @Column(name = "NOM_REGION")
    private String nomRegion;

    @Basic
    @Column(name = "ID_TYPE_CLIMAT")
    private int idTypeClimat;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_PAYS")
    private PaysEntity pays;


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        RegionEntity that = (RegionEntity) object;

        if (idRegion != that.idRegion) return false;

        if (idTypeClimat != that.idTypeClimat) return false;
        if (nomRegion != null ? !nomRegion.equals(that.nomRegion) : that.nomRegion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRegion;
        result = 31 * result + (nomRegion != null ? nomRegion.hashCode() : 0);

        result = 31 * result + idTypeClimat;
        return result;
    }
}
