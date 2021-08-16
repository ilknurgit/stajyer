package tr.com.turksat.stajyer.magazatakip.domain;


import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

// domain->entity  bilgilerimizin tutulduğu katman

public class UrunTipi implements Serializable {

    @Column(name = "type", length = 50)
    private String urunTipi;

    @Column(name = "id",columnDefinition = "serial")
    private int id;

    public UrunTipi() {
    }



    public String getUrunTipi() {
        return urunTipi;
    }
    public void setUrunTipi(String urunTipi) {
        this.urunTipi = urunTipi;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}