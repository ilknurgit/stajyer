package tr.com.turksat.stajyer.magazatakip.domain;

public class UrunTipi {
    private String uruntipi;
    private Integer id = -1;

    public UrunTipi() {
    }

    public String getUruntipi() {
        return uruntipi;
    }
    public void setUruntipi(String uruntipi) {
        this.uruntipi = uruntipi;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {
        this.id = id;
    }


}