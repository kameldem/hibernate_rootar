package com.rootar.hibernate_rootar.entities;

import jakarta.persistence.*;

@Entity
@NamedQuery(name = "monnaie.getAll", query ="Select m FROM MonnaieEntity  m order by m.idMonnaie")
@Table(name = "MONNAIE", schema = "dbo", catalog = "ROOTAR")
public class MonnaieEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MONNAIE")
    private int idMonnaie;
    @Basic
    @Column(name = "LIBELLE_MONNAIE")
    private String libelleMonnaie;

    public int getIdMonnaie() {
        return idMonnaie;
    }

    public void setIdMonnaie(int idMonnaie) {
        this.idMonnaie = idMonnaie;
    }

    public String getLibelleMonnaie() {
        return libelleMonnaie;
    }

    public void setLibelleMonnaie(String libelleMonnaie) {
        this.libelleMonnaie = libelleMonnaie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonnaieEntity that = (MonnaieEntity) o;

        if (idMonnaie != that.idMonnaie) return false;
        if (libelleMonnaie != null ? !libelleMonnaie.equals(that.libelleMonnaie) : that.libelleMonnaie != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMonnaie;
        result = 31 * result + (libelleMonnaie != null ? libelleMonnaie.hashCode() : 0);
        return result;
    }
}
