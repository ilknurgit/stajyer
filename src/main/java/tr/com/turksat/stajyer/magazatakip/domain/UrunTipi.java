package tr.com.turksat.stajyer.magazatakip.domain;


// domain->entity  bilgilerimizin tutulduğu
public class UrunTipi {
    private String urunTipi;
    private Integer id = -1;

    public UrunTipi() {
    }

    public String getUrunTipi() {
        return urunTipi;
    }

    public void setUrunTipi(String urunTipi) {
        this.urunTipi = urunTipi;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {
        this.id = id;
    }





}