package com.rootar.hibernate_rootar.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.List;

@Entity
@Getter
@Setter
@NamedQuery(name = "continent.getAll", query ="Select c FROM ContinentEntity  c order by c.idContinent")
@Table(name = "CONTINENT", schema = "dbo", catalog = "ROOTAR")
public class ContinentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CONTINENT")
    private int idContinent;
    @Basic
    @Column(name = "NOM_CONTINENT_FR")
    private String nomContinentFr;
    @Basic
    @Column(name = "NOM_CONTINENT_ANG")
    private String nomContinentAng;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_CONTINENT")
    private List<PaysEntity> pays;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinentEntity that = (ContinentEntity) o;

        if (idContinent != that.idContinent) return false;
        if (nomContinentFr != null ? !nomContinentFr.equals(that.nomContinentFr) : that.nomContinentFr != null)
            return false;
        if (nomContinentAng != null ? !nomContinentAng.equals(that.nomContinentAng) : that.nomContinentAng != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idContinent;
        result = 31 * result + (nomContinentFr != null ? nomContinentFr.hashCode() : 0);
        result = 31 * result + (nomContinentAng != null ? nomContinentAng.hashCode() : 0);
        return result;
    }



}
