package tr.com.turksat.stajyer.magazatakip.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class UrunTanimi implements Serializable {



    @Column(name = "id",columnDefinition = "serial")
    private int id;

    @Column(name = "marka", length = 50)
    private String marka;

    @Column(name = "model", length = 50)
    private String urunModel;

    @Column(name = "renk", length = 50)
    private String urunRenk;

    @Column(name = "uretim_tarihi", columnDefinition = "date")
    private Date urunDate;

    @Column(name = "boyutlar", length = 50)
    private String urunBoyutlar;

    @Column(name = "agirlik", length = 50)
    private String urunAgirlik;


    private UrunTipi urunTipi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//
//    public String getUrunTanimiId() {
//        return urunTanimiId;
//    }
//
//    public void setUrunTanimiId(String urunTanimiId) {
//        this.urunTanimiId = urunTanimiId;
//    }

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

    public Date getUrunDate() {
        return urunDate;
    }

    public void setUrunDate(Date urunDate) {
        this.urunDate = urunDate;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getUrunBoyutlar() {
        return urunBoyutlar;
    }

    public void setUrunBoyutlar(String urunBoyutlar) {
        this.urunBoyutlar = urunBoyutlar;
    }

    public String getUrunAgirlik() {
        return urunAgirlik;
    }

    public void setUrunAgirlik(String urunAgirlik) {
        this.urunAgirlik = urunAgirlik;
    }

    public UrunTipi getUrunTipi() {
        return urunTipi;
    }

    public void setUrunTipi(UrunTipi urunTipi) {
        this.urunTipi = urunTipi;
    }


}
