package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.Musteri;
import tr.com.turksat.stajyer.magazatakip.domain.Urun;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * @author iuysal
 * @since  20.08.2021
 */
public class MusteriDao {
    PreparedStatement ps = null;
    Connection con = null;
    Integer id = -1;
    int i = 0;
    String errorMessage;

    public List<Musteri> getMusteriler() {
        try {

            con = Database.getInstance().getConnection();
            ps = con.prepareStatement(
                    "select * from stajyer.musteri");
            ResultSet rs = ps.executeQuery();
            List<Musteri> urunList = new ArrayList<>();
            while (rs.next()) {
                Musteri musteri = new Musteri();

                Integer id = rs.getInt("id");
                String musteri_adi = rs.getString("musteri_adi");
                String musteri_soyad = rs.getString("musteri_soyad");



                musteri.setId(Integer.valueOf(id != null ? id.toString() : "null"));
                musteri.setMusteriAdi(musteri_adi);
                musteri.setMusteriSoyad(musteri_soyad);
                urunList.add(musteri);

            }
            return urunList;

        } catch (Exception exception) {
            System.out.println("Bir hata meydana geldi:" + exception);
            return null;
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception sqlException) {
                System.out.println("Bir hata meydana geldi:" + sqlException);
            }
        }
    }
    public String musteriEkle(Musteri musteri) {
        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("INSERT INTO stajyer.musteri(name,surname) VALUES(?, ?)");
            ps.setString(1, musteri.getMusteriAdi());
            ps.setString(2, musteri.getMusteriSoyad());

            i = ps.executeUpdate();

        } catch (Exception exception) {
            System.out.println(exception);
            setErrorMessage(exception.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception sqlException) {
                System.out.println(sqlException);
            }
        }
        if (i > 0) {
            return "basarili?faces-redirect=true";
        } else {
            return "basarisiz?faces-redirect=true";
        }
    }
    public Musteri findMusteri(Integer musteriId) {


        Musteri musteri = new Musteri();
        try {

            con = Database.getInstance().getConnection();///Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.(properties-file config den alıyor)
            ps = con.prepareStatement(
                    "select * from stajyer.musteri"); //urun_tipi tablosundaki herşeyi çek diyoruz.
            ResultSet rs = ps.executeQuery(); //SQL Sorgusundan dönecek sonuç rs sonuç kümesi içinde tutulacak.
            List<Musteri> urunList = new ArrayList<>();//AdiAlani sınıfı tipinde liste tanımladık çünkü SQL Sorgusundan dönecek sonuç içindeki Adi Alani kısmına bu tiple ulaşacaz.
            while (rs.next())//Kayıt olduğu sürece her işlem sonunda 1 satır atla.
            {
                musteri = new Musteri();

                Integer id = rs.getInt("id");
                String musteri_adi = rs.getString("musteri_adi");
                String musteri_soyad = rs.getString("musteri_soyad");


                musteri.setId(Integer.valueOf(id != null ? id.toString() : "null"));
                musteri.setMusteriAdi(musteri_adi);
                musteri.setMusteriSoyad(musteri_soyad);
                urunList.add(musteri);
            }
            for (int i = 0; i < urunList.size(); i++) {
                if (urunList.get(i).getId() == musteriId) {
                    musteri = urunList.get(i);
                }
            }
        } catch (Exception exception) {
            System.out.println("Bir hata meydana geldi:" + exception);
            return null;
        } finally { //try'a da düşse catch'e de bu bloktaki kod çalıştırılacak.
            try {
                if (con != null) { //Connection nesnesi belki yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    con.close();
                }
                if (ps != null) { //PreparedStatement nesnesi yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    ps.close();
                }
//                urunTanimi.setUrunTipi(urunTipi);
            } catch (Exception sqlException) {
                System.out.println("Bir hata meydana geldi:" + sqlException);
            }
        }
//        urunTanimi.setUrunTipi(urunTipi);
        return musteri;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
