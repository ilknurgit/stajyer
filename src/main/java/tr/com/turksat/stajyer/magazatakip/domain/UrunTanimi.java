package tr.com.turksat.stajyer.magazatakip.domain;


import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

// domain->entity  bilgilerimizin tutulduğu katman

public class UrunTanimi implements Serializable {

    @Column(name = "id",columnDefinition = "serial")
    private int id;


    @ManyToOne

    private UrunTipi urunTipi;

    @Column(name = "marka", length = 50)
    private String urunMarkasi;

    @Column(name = "model", length = 50)
    private String urunModeli;



    public UrunTanimi() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUrunTanimi() {
        return urunTanimi;
    }
    public void setUrunTanimi(String urunTanimi) {
        this.urunTanimi = urunTanimi;
    }

    public String getUrunMarkasi() {
        return urunMarkasi;
    }
    public void setUrunMarkasi(String urunMarkasi) {
        this.urunMarkasi = urunMarkasi;
    }

    public String getUrunModeli() {
        return urunModeli;
    }
    public void setUrunModeli(String urunModeli) {
        this.urunModeli = urunModeli;
    }


}