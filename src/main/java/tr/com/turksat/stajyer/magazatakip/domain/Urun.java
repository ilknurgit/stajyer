package tr.com.turksat.stajyer.magazatakip.domain;


import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class Urun {

    @Column(name = "id",columnDefinition = "serial")
    private int id;

//    @Column(name = "urun_tanimi_id",columnDefinition = "serial")
//    private int urun_tanimi_id;

    @ManyToOne
    @JoinColumn(name = "employee_id" , referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "employee_id_fk"))

    private Kullanici kullanici;

    @Column(name = "urun_fiyat",columnDefinition = "float")
    private String urunFiyat;

    @Column(name = "urun_adedi",columnDefinition = "serial")
    private String urunAdedi;

    @ManyToOne
    @JoinColumn(name = "urun_tanimi_id" , referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "urun_tanimi_id_fk"))

    private UrunTanimi urunTanimi;

//    public int id(){
//        return id;
//    }
//
//    public int urun_tanimi_id(){
//        return urun_tanimi_id;
//    }
//
//    public int employee_id(){
//        return employee_id;
//    }
//
//    public String urun_fiyat(){
//        return urun_fiyat;
//    }
//
//    public String urun_adedi(){
//        return urun_adedi;
//    }

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
                Objects.equals(getKullanici(), that.getKullanici()) &&
                Objects.equals(getUrunFiyat(), that.getUrunFiyat()) &&
                Objects.equals(getUrunAdedi(), that.getUrunAdedi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getUrunTanimi(),getKullanici(),getUrunFiyat(),getUrunAdedi());
    }
}