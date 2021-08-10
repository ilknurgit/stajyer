package tr.com.turksat.stajyer.magazatakip.domain;


import javax.persistence.*;
import java.io.Serializable;

// domain->entity  bilgilerimizin tutulduğu katman
public class UrunTipi implements Serializable {

    @Column (name="type",length=50)
    private String urunTipi;


    private String id="" ;

    public UrunTipi() {
    }

    public String getUrunTipi() {
        return urunTipi;
    }

    public void setUrunTipi(String urunTipi) {
        this.urunTipi = urunTipi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}