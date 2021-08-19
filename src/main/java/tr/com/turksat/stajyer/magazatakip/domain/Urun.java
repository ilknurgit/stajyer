package tr.com.turksat.stajyer.magazatakip.domain;


import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class Urun implements Serializable {

    @Column(name = "id",columnDefinition = "serial")
    private int id;

    @ManyToOne
    @JoinColumn(name = "employee_id" , referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "employee_id_fk"))

    private Kullanici kullanici;

    @Column(name = "urun_fiyat",length = 50)
    private String urunFiyat;

    @Column(name = "urun_adedi",length = 50)
    private String urunAdedi;

    @ManyToOne
    @JoinColumn(name = "urun_tanimi_id" , referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "urun_tanimi_id_fk"))

    private UrunTanimi urunTanimi;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getUrun_tanimi_id() {
//        return urun_tanimi_id;
//    }

//    public void setUrun_tanimi_id(int urun_tanimi_id) {
//        this.urun_tanimi_id = urun_tanimi_id;
//    }


    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public String getUrunFiyat() {
        return urunFiyat;
    }

    public void setUrunFiyat(String urunFiyat) {
        this.urunFiyat = urunFiyat;
    }

    public String getUrunAdedi() {
        return urunAdedi;
    }

    public void setUrunAdedi(String urunAdedi) {
        this.urunAdedi = urunAdedi;
    }

    public UrunTanimi getUrunTanimi() {
        return urunTanimi;
    }

    public void setUrunTanimi(UrunTanimi urunTanimi) {
        this.urunTanimi = urunTanimi;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urun that = (Urun) o;
        return  Objects.equals(getId(), that.getId()) &&
                Objects.equals(getUrunFiyat(), that.getUrunFiyat()) &&
                Objects.equals(getUrunAdedi(), that.getUrunAdedi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getUrunFiyat(),getUrunAdedi());
    }

    // equals ve hash methodları nedir araştırıp yazar mısınız dökümanada bunlardan kaynaklı hataymış oldu şimdi?
}