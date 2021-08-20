package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.service.UrunTipiService;

import javax.faces.context.FacesContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UrunTanimiDao {


    UrunTipiService urunTipiService =new UrunTipiService();
    PreparedStatement ps=null;//SQL sorgumuzu tutacak ve çalıştıracak nesne.
    Connection con=null;//Veri tabanına bağlantı yapmamızı sağlayacak nesne.

    Integer id=-1;
    int i=0;
    String errorMessage;

    //ürün tanımları listemeye yarayan veritabanından ürün tanımları çeken dao methodu
    public List<UrunTanimi> getUrunTanimlari() {
        try {

            con = Database.getInstance().getConnection();///Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.(properties-file config den alıyor)
            ps = con.prepareStatement(
                    "select * from stajyer.urun_tanimi "); //urun_tipi tablosundaki herşeyi çek diyoruz.
            ResultSet rs = ps.executeQuery(); //SQL Sorgusundan dönecek sonuç rs sonuç kümesi içinde tutulacak.
            List<UrunTanimi> uruntanimiList=new ArrayList<>();//AdiAlani sınıfı tipinde liste tanımladık çünkü SQL Sorgusundan dönecek sonuç içindeki Adi Alani kısmına bu tiple ulaşacaz.
            while(rs.next())//Kayıt olduğu sürece her işlem sonunda 1 satır atla.
            {
                UrunTanimi urunTanimi = new UrunTanimi();//SQL Sorgusundan sütunları çekip bu değişkenin içinde type veya id kısmına atıyacağız.
                //model, marka, renk, uretim_tarihi, boyutlar, agirlik
                Integer id  = rs.getInt("id");//ResultSet içinden o anki indisdeki "id" anahtar kelimesine karşı gelen değer alınıyor.
                String marka = rs.getString("marka");//ResultSet içinden o anki indisdeki "type" anahtar kelimesine karşı gelen değer alınıyor.
                String model = rs.getString("model");
                String renk = rs.getString("renk");
                String boyutlar = rs.getString("boyutlar");
                String agirlik = rs.getString("agirlik");
                Integer urunTipi = rs.getInt("urun_tipi_id");


                urunTanimi.setId(Integer.valueOf(id!=null?id.toString():"null"));
                urunTanimi.setMarka(marka);
                urunTanimi.setUrunModel(model);
                urunTanimi.setUrunRenk(renk);
                urunTanimi.setUrunBoyutlar(boyutlar);
                urunTanimi.setUrunAgirlik(agirlik);
                UrunTipi findUrunTipi =urunTipiService.findUrunTipi(urunTipi);
                urunTanimi.setUrunTipi(findUrunTipi);

                uruntanimiList.add(urunTanimi);//Her bir dönen sonucu listeye ekliyoruz.

            }
            return uruntanimiList;//Listeyi return ediyoruz.

        }
        catch ( Exception exception) {
            System.out.println("Bir hata meydana geldi:"+exception);
            return null;
        }
        finally{ //try'a da düşse catch'e de bu bloktaki kod çalıştırılacak.
            try {
                if(con!=null){ //Connection nesnesi belki yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    con.close();
                }
                if(ps!=null){ //PreparedStatement nesnesi yukarıda null kalmış olabilir. Kontrol etmekte fayda var.
                    ps.close();
                }
            } catch (Exception sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
    }

    //veritabanına ürün tanimlarını eklememize yarayan dao methodu
    public String urunTanimiEkle(UrunTanimi urunTanimi, UrunTipi urunTipi)//Sayfadan girilen verileri veri tabanına gönderem metot.
    {
        try {
            con = Database.getInstance().getConnection();///Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.(properties-file config den alıyor)
            ps=con.prepareStatement("INSERT INTO stajyer.urun_tanimi(model, marka, renk,  boyutlar, agirlik,urun_tipi_id) VALUES(?, ?, ?, ?, ?, ?)");
            //ps nesnesine SQL komutunu bildiriyoruz.İsterseniz parametre olarak SQL kodu yerine üstteki sql de verebilirsiniz.
            // --ürün tanimi id ve ürün tiği id alanlarını eklemedik çünkü zaten otomatik set olacak.
            ps.setString(1, urunTanimi.getUrunModel());
            ps.setString(2, urunTanimi.getMarka());
            ps.setString(3, urunTanimi.getUrunRenk());
            ps.setString(4,  urunTanimi.getUrunBoyutlar());
            ps.setString(5,  urunTanimi.getUrunAgirlik());
            ps.setInt(6, urunTipi.getId());//ps nesnesine gelen alanı koyduk.
            i=ps.executeUpdate();//executeUpdate verilen Usorguyu çalıştırır ve integer değer döndürür.
            //exequteUdate eğer 0'dan büyük değer döndürürse kayıt başarılı olmuş demektir.
        }
        catch(Exception exception)//Hata olduğunda konsola verilecek.
        {
            System.out.println(exception);
            setErrorMessage(exception.toString());
        }
        finally //Ne olursa olsun her koşulda çalışacak kısım
        {
            try {
                if(con!=null){
                    con.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
            catch(Exception sqlException)
            {
                System.out.println(sqlException);
            }
        }
        if(i>0) //Sorgu başarılı olarak çalışınca i 0'dan büyük oluyor ve bizi başarılı sayfasına yönlediriyor.
        {
            return "basarili?faces-redirect=true";
        }
        else //Sorgu başarısız ise başarısız sayfasına gidiyoruz.
        {
            return "basarisiz?faces-redirect=true";
        }
    }
    //ürünTiplerini silmemeize yarayan dao methodu
    public boolean urunTanimiSil(UrunTanimi silinecekUrunTanimi){
        FacesContext fc = FacesContext.getCurrentInstance();
        this.id = Integer.valueOf(silinecekUrunTanimi.getId());
        try {
            con = Database.getInstance().getConnection();
            ps=con.prepareStatement("DELETE FROM stajyer.urun_tanimi WHERE id=?");
            ps.setInt(1, silinecekUrunTanimi.getId());
            i=ps.executeUpdate();
        }
        catch(Exception exception)
        {
            System.out.print(exception);
        }
        finally {
            try {
                if(con!= null){
                    con.close();
                }
                if (ps!=null) {
                    ps.close();
                }
            }
            catch (SQLException exception) {
                System.out.println("Bir Hata Meydana Geldi!\nHata:"+exception);
            }
        }
        if(i>0)
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

    public UrunTanimi findUrunTanimi(Integer urunTanimiId) {
        UrunTanimi urunTanimi = new UrunTanimi();
        try {

            con = Database.getInstance().getConnection();///Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.(properties-file config den alıyor)
            ps = con.prepareStatement(
                    "select * from stajyer.urun_tanimi "); //urun_tipi tablosundaki herşeyi çek diyoruz.
            ResultSet rs = ps.executeQuery(); //SQL Sorgusundan dönecek sonuç rs sonuç kümesi içinde tutulacak.
            List<UrunTanimi> uruntanimiList = new ArrayList<>();//AdiAlani sınıfı tipinde liste tanımladık çünkü SQL Sorgusundan dönecek sonuç içindeki Adi Alani kısmına bu tiple ulaşacaz.
            while (rs.next())//Kayıt olduğu sürece her işlem sonunda 1 satır atla.
            {
                urunTanimi = new UrunTanimi();//SQL Sorgusundan sütunları çekip bu değişkenin içinde type veya id kısmına atıyacağız.

                Integer id  = rs.getInt("id");//ResultSet içinden o anki indisdeki "id" anahtar kelimesine karşı gelen değer alınıyor.
                String marka = rs.getString("marka");//ResultSet içinden o anki indisdeki "type" anahtar kelimesine karşı gelen değer alınıyor.
                String model = rs.getString("model");
                String renk = rs.getString("renk");
                String boyutlar = rs.getString("boyutlar");
                String agirlik = rs.getString("agirlik");
                Integer urunTipi = rs.getInt("urun_tipi_id");


                urunTanimi.setId(Integer.valueOf(id!=null?id.toString():"null"));
                urunTanimi.setMarka(marka);
                urunTanimi.setUrunModel(model);
                urunTanimi.setUrunRenk(renk);
                urunTanimi.setUrunBoyutlar(boyutlar);
                urunTanimi.setUrunAgirlik(agirlik);
                UrunTipi findUrunTipi =urunTipiService.findUrunTipi(urunTipi);
                urunTanimi.setUrunTipi(findUrunTipi);

                uruntanimiList.add(urunTanimi);
            }
            for(int i=0; i<uruntanimiList.size(); i++) {
                if (uruntanimiList.get(i).getId()==urunTanimiId){
                    urunTanimi = uruntanimiList.get(i);
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
        return urunTanimi;
    }
}