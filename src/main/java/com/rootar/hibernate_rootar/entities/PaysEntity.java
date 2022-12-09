package com.rootar.hibernate_rootar.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NamedQuery(name = "pays.getAll", query ="Select p FROM PaysEntity  p order by p.idPays")
@Table(name = "PAYS", schema = "dbo", catalog = "ROOTAR")
public class PaysEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PAYS")
    private int idPays;
    @Basic
    @Column(name = "CODE_PAYS")
    private String codePays;
    @Basic
    @Column(name = "NOM_PAYS_FR")
    private String nomPaysFr;
    @Basic
    @Column(name = "NOM_PAYS_ANG")
    private String nomPaysAng;
    @Basic
    @Column(name = "NATIONALITE")
    private String nationalite;
    @Basic
    @Column(name = "NOMBRE_HABITANT")
    private int nombreHabitant;
    @Basic
    @Column(name = "SUPERFICIE")
    private int superficie;
    @Basic
    @Column(name = "DEVISE")
    private String devise;
    @Basic
    @Column(name = "FETE_NATIONALE")
    private String feteNationale;
    @Basic
    @Column(name = "INDICATIF_TELEPHONIQUE")
    private String indicatifTelephonique;
    /*@Basic
    @Column(name = "ID_CONTINENT")
    private int idContinent;*/
    @Basic
    @Column(name = "ID_MONNAIE")
    private int idMonnaie;
    @Basic
    @Column(name = "ID_VISAS")
    private Integer idVisas;
    @Basic
    @Column(name = "ID_VILLE")
    private int idVille;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_CONTINENT")
    private ContinentEntity continent;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_REGION")
    private List<RegionEntity> regions;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        PaysEntity that = (PaysEntity) object;

        if (idPays != that.idPays) return false;
        if (nombreHabitant != that.nombreHabitant) return false;
        if (superficie != that.superficie) return false;
        //if (idContinent != that.idContinent) return false;
        if (idMonnaie != that.idMonnaie) return false;
        if (idVille != that.idVille) return false;
        if (codePays != null ? !codePays.equals(that.codePays) : that.codePays != null) return false;
        if (nomPaysFr != null ? !nomPaysFr.equals(that.nomPaysFr) : that.nomPaysFr != null) return false;
        if (nomPaysAng != null ? !nomPaysAng.equals(that.nomPaysAng) : that.nomPaysAng != null) return false;
        if (nationalite != null ? !nationalite.equals(that.nationalite) : that.nationalite != null) return false;
        if (devise != null ? !devise.equals(that.devise) : that.devise != null) return false;
        if (feteNationale != null ? !feteNationale.equals(that.feteNationale) : that.feteNationale != null)
            return false;
        if (indicatifTelephonique != null ? !indicatifTelephonique.equals(that.indicatifTelephonique) : that.indicatifTelephonique != null)
            return false;
        if (idVisas != null ? !idVisas.equals(that.idVisas) : that.idVisas != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPays;
        result = 31 * result + (codePays != null ? codePays.hashCode() : 0);
        result = 31 * result + (nomPaysFr != null ? nomPaysFr.hashCode() : 0);
        result = 31 * result + (nomPaysAng != null ? nomPaysAng.hashCode() : 0);
        result = 31 * result + (nationalite != null ? nationalite.hashCode() : 0);
        result = 31 * result + nombreHabitant;
        result = 31 * result + superficie;
        result = 31 * result + (devise != null ? devise.hashCode() : 0);
        result = 31 * result + (feteNationale != null ? feteNationale.hashCode() : 0);
        result = 31 * result + (indicatifTelephonique != null ? indicatifTelephonique.hashCode() : 0);
       // result = 31 * result + idContinent;
        result = 31 * result + idMonnaie;
        result = 31 * result + (idVisas != null ? idVisas.hashCode() : 0);
        result = 31 * result + idVille;
        return result;
    }


}
