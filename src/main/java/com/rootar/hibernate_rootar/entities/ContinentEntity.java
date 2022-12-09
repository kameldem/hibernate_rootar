package com.rootar.hibernate_rootar.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name = "continent.getAll", query ="Select c FROM ContinentEntity  c order by c.idContinent")
@Table(name = "CONTINENT", schema = "dbo", catalog = "ROOTAR")
public class ContinentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CONTINENT", nullable = false)
    private int idContinent;
    @Basic
    @Column(name = "NOM_CONTINENT_FR", nullable = false, length = 50)
    private String nomContinentFr;
    @Basic
    @Column(name = "NOM_CONTINENT_ANG", nullable = false, length = 25)
    private String nomContinentAng;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_PAYS")
    private List<PaysEntity> pays;

    public List<PaysEntity> getPays() {
        return pays;
    }

    public void setPays(List<PaysEntity> pays) {
        this.pays = pays;
    }

    public int getIdContinent() {
        return idContinent;
    }

    public void setIdContinent(int idContinent) {
        this.idContinent = idContinent;
    }

    public String getNomContinentFr() {
        return nomContinentFr;
    }

    public void setNomContinentFr(String nomContinentFr) {
        this.nomContinentFr = nomContinentFr;
    }

    public String getNomContinentAng() {
        return nomContinentAng;
    }

    public void setNomContinentAng(String nomContinentAng) {
        this.nomContinentAng = nomContinentAng;
    }

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
