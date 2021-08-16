package tr.com.turksat.stajyer.magazatakip.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class UrunTanimi implements Serializable {



    @Column(name = "id",columnDefinition = "serial")
    private int id;

    @Column(name = "marka", length = 50)
    private String marka;

    @Column(name = "model", length = 50)
    private String urunModel;

    @Column(name = "renk", length = 50)
    private String urunRenk;

    @Column(name = "boyutlar", length = 50)
    private String urunBoyutlar;

    @Column(name = "agirlik", length = 50)
    private String urunAgirlik;


    @ManyToOne
    @JoinColumn(name = "urun_tipi_id" , referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "urun_tipi_id_fk"))
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrunTanimi that = (UrunTanimi) o;
        return  Objects.equals(getId(), that.getId()) &&
                Objects.equals(getUrunTipi(),that.getUrunTipi()) &&
                Objects.equals(getMarka(), that.getMarka()) &&
                Objects.equals(getUrunAgirlik(), that.getUrunAgirlik()) &&
                Objects.equals(getUrunBoyutlar(), that.getUrunBoyutlar()) &&
                Objects.equals(getUrunModel(), that.getUrunModel()) &&
                Objects.equals(getUrunRenk(), that.getUrunRenk()) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getUrunTipi(),getMarka(),getUrunAgirlik(),getUrunBoyutlar(),getUrunModel(),getUrunRenk());
    }
}

