package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.Urun;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.service.UrunService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTanimiService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTipiService;

import javax.faces.context.FacesContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UrunDao {

    UrunTanimiService urunTanimiService =new UrunTanimiService();
    PreparedStatement ps=null;
    Connection con=null;

    Integer id=-1;
    int i=0;
    String errorMessage;

//    public List<Urun> getUrunler() {
//        try {
//
//            con = Database.getInstance().getConnection();
//            ps = con.prepareStatement(
//                    "select * from stajyer.urun");
//            ResultSet rs = ps.executeQuery();
//            List<Urun> urunList=new ArrayList<>();
//            while(rs.next())
//            {
//                Urun urun = new Urun();
//
//                Integer id  = rs.getInt("id");
//                Integer employee_id  = rs.getInt("employee_id");
//                String urun_fiyat = rs.getString("urun_fiyat");
//                String urun_adedi = rs.getString("urun_adedi");
//                Integer urunTanimi = rs.getInt("urun_tanimi_id");
//
//                //urun_tanimi_id, employee_id, urun_fiyat, urun_adedi
//
//                urun.setId(Integer.valueOf(id!=null?id.toString():"null"));
//                urun.setKullanici(employee_id);
//                urun.setUrun_fiyat(urun_fiyat);
//                urun.setUrun_adedi(urun_adedi);
//                //UrunTanimi findUrunTanimi = urunTanimiService(urunTanimi);
//                //urun.setUrun_tanimi_id(urunTanimi);
//                //UrunTanimi findUrunTanimi = urunTanimiService.findUrunTanimi(urunTanimi);
//
//                urunList.add(urun);
//
//            }
//            return urunList;
//
//        }
//        catch ( Exception exception) {
//            System.out.println("Bir hata meydana geldi:"+exception);
//            return null;
//        }
//        finally{
//            try {
//                if(con!=null){
//                    con.close();
//                }
//                if(ps!=null){
//                    ps.close();
//                }
//            } catch (Exception sqlException) {
//                System.out.println("Bir hata meydana geldi:"+sqlException);
//            }
//        }
//    }


    public String urunEkle(Urun urun, UrunTanimi urunTanimi, Kullanici kullanici)
    {
        try {
            con = Database.getInstance().getConnection();
            ps=con.prepareStatement("INSERT INTO stajyer.urun(urun_tanimi_id, employee_id, urun_fiyat, urun_adedi) VALUES(?, ?, ?, ?)");
            ps.setInt(1,  urunTanimi.getId());
            ps.setInt(2,  kullanici.getId());
            ps.setString(3,  urun.getUrunFiyat());
            ps.setString(4,  urun.getUrunAdedi());
            i=ps.executeUpdate();

        }
        catch(Exception exception)
        {
            System.out.println(exception);
            setErrorMessage(exception.toString());
        }
        finally
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
        if(i>0)
        {
            return "basarili?faces-redirect=true";
        }
        else
        {
            return "basarisiz?faces-redirect=true";
        }
    }

    public boolean urunSil(Urun silinecekUrun){
        FacesContext fc = FacesContext.getCurrentInstance();
        this.id = Integer.valueOf(silinecekUrun.getId());
        try {
            con = Database.getInstance().getConnection();
            ps=con.prepareStatement("DELETE FROM stajyer.urun WHERE id=?");
            ps.setInt(1, silinecekUrun.getId());
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
