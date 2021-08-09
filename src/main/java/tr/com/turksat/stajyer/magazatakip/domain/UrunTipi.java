package tr.com.turksat.stajyer.magazatakip.domain;


// domain->entity  bilgilerimizin tutulduğu
public class UrunTipi {
    private String urunTipi;
    private String id;

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