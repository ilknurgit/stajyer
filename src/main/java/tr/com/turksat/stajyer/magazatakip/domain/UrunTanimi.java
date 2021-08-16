package tr.com.turksat.stajyer.magazatakip.domain;


import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

// domain->entity  bilgilerimizin tutulduğu katman

public class UrunTanimi implements Serializable {

    @Column(name = "id",columnDefinition = "serial")
    private int id;

    //urun_tipi_id daha tam eklenmedi
    @Column(name = "urun_tipi_id", length = 4)
    private int urunTipiId;

    @Column(name = "marka", length = 50)
    private String urunMarka;

    @Column(name = "model", length = 50)
    private String urunModel;

    @Column(name = "renk", length = 50)
    private String urunRenk;

    @Column(name = "boyut", length = 50)
    private String urunBoyut;

    @Column(name = "agirlik", length = 50)
    private String urunAgirlik;



    public UrunTanimi() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUrunMarka() {
        return urunMarka;
    }
    public void setUrunMarka(String urunMarka) {
        this.urunMarka = urunMarka;
    }

    public String getUrunModel() {
        return urunModel;
    }
    public void setUrunModel(String urunModel) {
        this.urunModel = urunModel;
    }

    public String getUrunRenk() {
        return urunRenk;
    }
    public void setUrunRenk(String urunRenk) {
        this.urunRenk = urunRenk;
    }

    public String getUrunBoyut() {
        return urunBoyut;
    }
    public void setUrunBoyut(String urunBoyut) {
        this.urunBoyut = urunBoyut;
    }

    public String getUrunAgirlik() {
        return urunAgirlik;
    }
    public void setUrunAgirlik(String urunAgirlik) {
        this.urunAgirlik = urunAgirlik;
    }
}