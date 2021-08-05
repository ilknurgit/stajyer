package tr.com.turksat.stajyer.magazatakip.domain;

public class Kullanici
{
    private String kullaniciAdi;
    private String sifre;
    private String adsoyad;
    private String telefon;
    private String eposta;
    private String adres;

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
    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {this.telefon = telefon;}
    public String getEposta() {
        return eposta;
    }
    public void setEposta(String eposta) {
        this.eposta = eposta;
    }
    public String getAdres() {
        return adres;
    }
    public void setAdres(String adres) {
        this.adres = adres;
    }
}
