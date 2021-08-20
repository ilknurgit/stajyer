package tr.com.turksat.stajyer.magazatakip.domain;

import javax.persistence.Column;
import java.io.Serializable;

/*
 * @author iuysal
 * @since  20.08.2021
 */
public class Musteri implements Serializable {
    @Column(name = "id",columnDefinition = "serial")
    private int id;
    @Column(name = "musteri_adi", length = 50)
    private String musteriAdi;
    @Column(name = "musteri_soyad", length = 50)
    private String musteriSoyad;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public String getMusteriSoyad() {
        return musteriSoyad;
    }

    public void setMusteriSoyad(String musteriSoyad) {
        this.musteriSoyad = musteriSoyad;
    }
}
