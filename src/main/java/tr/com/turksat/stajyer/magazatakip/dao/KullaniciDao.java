package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**.
 * Created by iuysal on 05.08.2021
 */
public class KullaniciDao {
    Connection con = null;
    PreparedStatement ps = null;
    public boolean  girisYap(Kullanici kullanici){
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = Database.getInstance().getConnection();
            ps = con.prepareStatement(
                    "select kullanici_adi, sifre from stajyer.tb_kullanici where kullanici_adi= ? and sifre= ? ");
            ps.setString(1, kullanici.getKullaniciAdi());
            ps.setString(2, kullanici.getSifre());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {

                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("hatalı giriş");
            return false;
        } finally {
            Database.close(con);
        }
    }

    public List<Kullanici> getKullanicilar() {
        Connection con = null;
        PreparedStatement ps = null;
        List<Kullanici> kullaniciList = new ArrayList<>();
        try {

            con = Database.getInstance().getConnection();
            ps = con.prepareStatement(
                    "select * from stajyer.tb_kullanici ");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) // found
            {
                Kullanici kullanici = new Kullanici();

                Integer id  = rs.getInt("id");
                String name = rs.getString("kullanici_adi");
                String sifre = rs.getString("sifre");
                kullanici.setId(id);
                kullanici.setKullaniciAdi(name);
                kullanici.setSifre(sifre);
                kullaniciList.add(kullanici);

            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş "+ex.getLocalizedMessage());
            return kullaniciList;
        } finally {
            Database.close(con);
        }



        return kullaniciList;
    }

    public Kullanici findKullanici(Integer kullaniciId) {
        Kullanici kullanici = new Kullanici();
        try {

            con = Database.getInstance().getConnection();///Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.(properties-file config den alıyor)
            ps = con.prepareStatement(
                    "select * from stajyer.tb_kullanici "); //urun_tipi tablosundaki herşeyi çek diyoruz.
            ResultSet rs = ps.executeQuery(); //SQL Sorgusundan dönecek sonuç rs sonuç kümesi içinde tutulacak.
            List<Kullanici> kullaniciList = new ArrayList<>();//AdiAlani sınıfı tipinde liste tanımladık çünkü SQL Sorgusundan dönecek sonuç içindeki Adi Alani kısmına bu tiple ulaşacaz.
            while (rs.next())//Kayıt olduğu sürece her işlem sonunda 1 satır atla.
            {
                kullanici = new Kullanici();//SQL Sorgusundan sütunları çekip bu değişkenin içinde type veya id kısmına atıyacağız.

                Integer id  = rs.getInt("id");//ResultSet içinden o anki indisdeki "id" anahtar kelimesine karşı gelen değer alınıyor.
                String name = rs.getString("kullanici_adi");//ResultSet içinden o anki indisdeki "type" anahtar kelimesine karşı gelen değer alınıyor.
                String sifre = rs.getString("sifre");
                kullanici.setId(Integer.valueOf(id != null ? id.toString() : "null"));
                kullanici.setKullaniciAdi(name);
                kullanici.setSifre(sifre);
                kullaniciList.add(kullanici);
            }
            for(int i=0; i<kullaniciList.size(); i++) {
                if (kullaniciList.get(i).getId()==kullaniciId){
                    kullanici = kullaniciList.get(i);
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
        return kullanici;
    }


}
