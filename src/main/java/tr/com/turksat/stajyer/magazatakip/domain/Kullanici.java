package tr.com.turksat.stajyer.magazatakip.domain;
/**.
 * Created by iuysal on 05.08.2021
 */
public class Kullanici
{
    private String kullaniciAdi;
    private String sifre;
    private String adsoyad;


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
    public String getAdsoyad() {
        return adsoyad;
    }
    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

}
