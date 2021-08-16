package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;

import javax.faces.context.FacesContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * @author iuysal
 * @since  6.08.2021
 */
//dao Veritabanı ile ilgili tüm işlerin yapıldığı classlar
public class UrunTipiDao {

    PreparedStatement ps = null;//SQL sorgumuzu tutacak ve çalıştıracak nesne.
    Connection con = null;//Veri tabanına bağlantı yapmamızı sağlayacak nesne.

    Integer id = -1;
    int i = 0;
    String errorMessage;

    //ürün tiplerini listemeye yarayan veritabanından ürünleri çeken dao methodu
    public List<UrunTipi> getUrunTipleri() {
        try {

            con = Database.getInstance().getConnection();///Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.(properties-file config den alıyor)
            ps = con.prepareStatement(
                    "select * from stajyer.urun_tipi "); //urun_tipi tablosundaki herşeyi çek diyoruz.
            ResultSet rs = ps.executeQuery(); //SQL Sorgusundan dönecek sonuç rs sonuç kümesi içinde tutulacak.
            List<UrunTipi> uruntipiList = new ArrayList<>();//AdiAlani sınıfı tipinde liste tanımladık çünkü SQL Sorgusundan dönecek sonuç içindeki Adi Alani kısmına bu tiple ulaşacaz.
            while (rs.next())//Kayıt olduğu sürece her işlem sonunda 1 satır atla.
            {
                UrunTipi urunTipi = new UrunTipi();//SQL Sorgusundan sütunları çekip bu değişkenin içinde type veya id kısmına atıyacağız.

                Integer id = rs.getInt("id");//ResultSet içinden o anki indisdeki "id" anahtar kelimesine karşı gelen değer alınıyor.
                String name = rs.getString("type");//ResultSet içinden o anki indisdeki "type" anahtar kelimesine karşı gelen değer alınıyor.
                urunTipi.setId(Integer.valueOf(id != null ? id.toString() : "null"));
                urunTipi.setUrunTipi(name);
                uruntipiList.add(urunTipi);//Her bir dönen sonucu listeye ekliyoruz.

            }
            return uruntipiList;//Listeyi return ediyoruz.

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
            } catch (Exception sqlException) {
                System.out.println("Bir hata meydana geldi:" + sqlException);
            }
        }
    }

    //veritabanına ürüNtiplerini eklememizi yarayan dao methodu
    public String urunTipiEkle(UrunTipi urunTipi)//Sayfadan girilen verileri veri tabanına gönderem metot.
    {
        try {
            con = Database.getInstance().getConnection();///Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.(properties-file config den alıyor)
            ps = con.prepareStatement("INSERT INTO stajyer.urun_tipi(type) VALUES(?)");
            //ps nesnesine SQL komutunu bildiriyoruz.İsterseniz parametre olarak SQL kodu yerine üstteki sql de verebilirsiniz.
            // --id alanını eklemedik çünkü zaten otomatik set olacak.
            ps.setString(1, urunTipi.getUrunTipi());//ps nesnesine gelen alanı koyduk.
            i = ps.executeUpdate();//executeUpdate verilen sorguyu çalıştırır ve integer değer döndürür.
            //exequteUdate eğer 0'dan büyük değer döndürürse kayıt başarılı olmuş demektir.
        } catch (Exception exception)//Hata olduğunda konsola verilecek.
        {
            System.out.println(exception);
            setErrorMessage(exception.toString());
        } finally //Ne olursa olsun her koşulda çalışacak kısım
        {
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
        if (i > 0) //Sorgu başarılı olarak çalışınca i 0'dan büyük oluyor ve bizi başarılı sayfasına yönlediriyor.
        {
            return "basarili?faces-redirect=true";
        } else //Sorgu başarısız ise başarısız sayfasına gidiyoruz.
        {
            return "basarisiz?faces-redirect=true";
        }
    }

    //ürünTiplerini silmemeize yarayan dao methodu
    public boolean urunTipiSil(UrunTipi silinecekUrunTipi) {
        FacesContext fc = FacesContext.getCurrentInstance();
        this.id = Integer.valueOf(silinecekUrunTipi.getId());
        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("DELETE FROM stajyer.urun_tipi WHERE id=?");
            ps.setInt(1, silinecekUrunTipi.getId());
            i = ps.executeUpdate();
        } catch (Exception exception) {
            System.out.print(exception);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException exception) {
                System.out.println("Bir Hata Meydana Geldi!\nHata:" + exception);
            }
        }
        if (i > 0)
            return true;
        else
            return false;
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

//    public UrunTipi findUrunTipi(Long id) {
//        try {
//
//            con = Database.getInstance().getConnection();///Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.(properties-file config den alıyor)
//            ps = con.prepareStatement(
//                    "select id from stajyer.urun_tipi where id :=id"); //urun_tipi tablosundaki herşeyi çek diyoruz.
//            ResultSet rs = ps.executeQuery();
//
//        }
//
//    }
