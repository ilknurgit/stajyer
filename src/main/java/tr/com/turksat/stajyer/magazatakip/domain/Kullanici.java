package tr.com.turksat.stajyer.magazatakip.domain;

import javax.persistence.Column;

/**.
 * Created by iuysal on 05.08.2021
 */
public class Kullanici
{
    @Column(name = "id",columnDefinition = "serial")
    private int id;
    @Column(name = "kullanici_adi")
    private String kullaniciAdi;
    @Column(name = "sifre")
    private String sifre;

    public Kullanici()
    {
    }
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }
    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
    public String getSifre() {
        return sifre;
    }
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
