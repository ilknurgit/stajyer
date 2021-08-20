package tr.com.turksat.stajyer.magazatakip.domain;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

/*
 * @author iuysal
 * @since  20.08.2021
 */
public class Satis implements Serializable {
    @Column(name = "id",columnDefinition = "serial")
    private int id;

    @ManyToOne
    @JoinColumn(name = "musteri_id" , referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "musteri_id_fk"))

    private Musteri musteri;

    @ManyToOne
    @JoinColumn(name = "urun_id" , referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "urun_id_fk"))

    private Urun urun;

    @Column(name = "satis_tarihi",length = 50)
    private String satisTarihi;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public String getSatisTarihi() {
        return satisTarihi;
    }

    public void setSatisTarihi(String satisTarihi) {
        this.satisTarihi = satisTarihi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Satis that = (Satis) o;
        return  Objects.equals(getId(), that.getId()) &&
                Objects.equals(getSatisTarihi(), that.getSatisTarihi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getSatisTarihi());
    }
}
