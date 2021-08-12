package tr.com.turksat.stajyer.magazatakip.domain;


import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrunTipi that = (UrunTipi) o;
        return  Objects.equals(getId(), that.getId()) &&
                Objects.equals(getUrunTipi(),that.getUrunTipi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getUrunTipi());
    }
}