package tr.com.turksat.stajyer.magazatakip.domain;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

/**.
 * Created by iuysal on 05.08.2021
 */
public class Kullanici implements Serializable {
    @Column(name = "id",columnDefinition = "serial")
    private int id;
    @Column(name = "kullanici_adi", length = 50)
    private String kullaniciAdi;
    @Column(name = "sifre", length = 50)
    private String sifre;

    public Kullanici() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kullanici that = (Kullanici) o;
        return  Objects.equals(getId(), that.getId()) &&
                Objects.equals(getKullaniciAdi(),that.getKullaniciAdi())
                &&
                Objects.equals(getSifre(),that.getSifre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getKullaniciAdi(),getSifre());
    }
}
