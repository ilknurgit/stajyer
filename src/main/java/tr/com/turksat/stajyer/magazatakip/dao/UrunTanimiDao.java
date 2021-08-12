package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;

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
public class UrunTanimiDao {

    PreparedStatement ps=null;//SQL sorgumuzu tutacak ve çalıştıracak nesne.
    Connection con=null;//Veri tabanına bağlantı yapmamızı sağlayacak nesne.

    Integer id=-1;
    int i=0;
    String errorMessage;


    //ürün Tanimlerini listemeye yarayan veritabanından ürünleri çeken dao methodu
    public List<UrunTanimi> getUrunTanimleri() {
        try {

            con = Database.getInstance().getConnection();///Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.(properties-file config den alıyor)
            ps = con.prepareStatement(
                    "select * from stajyer.urun_tanimi "); //urun_Tanimi tablosundaki herşeyi çek diyoruz.
            ResultSet rs = ps.executeQuery(); //SQL Sorgusundan dönecek sonuç rs sonuç kümesi içinde tutulacak.
            List<UrunTanimi> urunTanimiList=new ArrayList<>();//AdiAlani sınıfı Taniminde liste tanımladık çünkü SQL Sorgusundan dönecek sonuç içindeki Adi Alani kısmına bu Tanimle ulaşacaz.
            while(rs.next())//Kayıt olduğu sürece her işlem sonunda 1 satır atla.
            {
                UrunTanimi urunTanimi = new UrunTanimi();//SQL Sorgusundan sütunları çekip bu değişkenin içinde type veya id kısmına atıyacağız.

                Integer id  = rs.getInt("id");//ResultSet içinden o anki indisdeki "id" anahtar kelimesine karşı gelen değer alınıyor.
                String marka = rs.getString("marka");//ResultSet içinden o anki indisdeki "type" anahtar kelimesine karşı gelen değer alınıyor.
                String model = rs.getString("model");
                String renk = rs.getString("renk");
                String boyut = rs.getString("boyut");
                String agirlik = rs.getString("agirlik");
                urunTanimi.setId(Integer.valueOf(id!=null?id.toString():"null"));
                urunTanimi.setUrunMarka(marka);
                urunTanimi.setUrunModel(model);
                urunTanimi.setUrunRenk(renk);
                urunTanimi.setUrunBoyut(boyut);
                urunTanimi.setUrunAgirlik(agirlik);
                urunTanimiList.add(urunTanimi);//Her bir dönen sonucu listeye ekliyoruz.

            }
            return urunTanimiList;//Listeyi return ediyoruz.

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

    //veritabanına ürüNTanimlerini eklememizi yarayan dao methodu
    public String urunTanimiEkle(UrunTanimi urunTanimi)//Sayfadan girilen verileri veri tabanına gönderem metot.
    {
        try {
            con = Database.getInstance().getConnection();///Bağlanacağı veri tabanını ve kullanacağı kullanıcı adı-parolayı bildiriyoruz.(properties-file config den alıyor)
            ps=con.prepareStatement("INSERT INTO stajyer.urun_tanimi(urun_tipi_id,marka,model,renk,boyut,agirlik) VALUES(?,?,?,?,?,?)");
            //ps nesnesine SQL komutunu bildiriyoruz.İsterseniz parametre olarak SQL kodu yerine üstteki sql de verebilirsiniz.
            // --id alanını eklemedik çünkü zaten otomatik set olacak.
            ps.setString(1, urunTanimi.getUrunMarka());//ps nesnesine gelen alanı koyduk.
            ps.setString(2, urunTanimi.getUrunModel());//ps nesnesine gelen alanı koyduk.
            ps.setString(3, urunTanimi.getUrunRenk());//ps nesnesine gelen alanı koyduk.
            ps.setString(4, urunTanimi.getUrunBoyut());//ps nesnesine gelen alanı koyduk.
            ps.setString(5, urunTanimi.getUrunAgirlik());//ps nesnesine gelen alanı koyduk.
            i=ps.executeUpdate();//executeUpdate verilen sorguyu çalıştırır ve integer değer döndürür.
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
    //ürünTanimlerini silmemeize yarayan dao methodu
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

}
