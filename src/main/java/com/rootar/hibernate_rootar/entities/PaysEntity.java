package com.rootar.hibernate_rootar.entities;

import jakarta.persistence.*;

@Entity
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

    public void setContinent(ContinentEntity continent) {
        this.continent = continent;
    }

    public ContinentEntity getContinent() {
        return continent;
    }

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public String getCodePays() {
        return codePays;
    }

    public void setCodePays(String codePays) {
        this.codePays = codePays;
    }

    public String getNomPaysFr() {
        return nomPaysFr;
    }

    public void setNomPaysFr(String nomPaysFr) {
        this.nomPaysFr = nomPaysFr;
    }

    public String getNomPaysAng() {
        return nomPaysAng;
    }

    public void setNomPaysAng(String nomPaysAng) {
        this.nomPaysAng = nomPaysAng;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getNombreHabitant() {
        return nombreHabitant;
    }

    public void setNombreHabitant(int nombreHabitant) {
        this.nombreHabitant = nombreHabitant;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getFeteNationale() {
        return feteNationale;
    }

    public void setFeteNationale(String feteNationale) {
        this.feteNationale = feteNationale;
    }

    public String getIndicatifTelephonique() {
        return indicatifTelephonique;
    }

    public void setIndicatifTelephonique(String indicatifTelephonique) {
        this.indicatifTelephonique = indicatifTelephonique;
    }

   /* public int getIdContinent() {
        return idContinent;
    }

    public void setIdContinent(int idContinent) {
        this.idContinent = idContinent;
    }*/

    public int getIdMonnaie() {
        return idMonnaie;
    }

    public void setIdMonnaie(int idMonnaie) {
        this.idMonnaie = idMonnaie;
    }

    public Integer getIdVisas() {
        return idVisas;
    }

    public void setIdVisas(Integer idVisas) {
        this.idVisas = idVisas;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        PaysEntity that = (PaysEntity) object;

        if (idPays != that.idPays) return false;
        if (nombreHabitant != that.nombreHabitant) return false;
        if (superficie != that.superficie) return false;
      //  if (idContinent != that.idContinent) return false;
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
      //  result = 31 * result + idContinent;
        result = 31 * result + idMonnaie;
        result = 31 * result + (idVisas != null ? idVisas.hashCode() : 0);
        result = 31 * result + idVille;
        return result;
    }


}
