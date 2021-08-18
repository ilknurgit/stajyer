package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Urun;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;

import javax.faces.context.FacesContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UrunDao {

    PreparedStatement ps=null;
    Connection con=null;

    Integer id=-1;
    int i=0;
    String errorMessage;

    public List<Urun> getUrunler() {
        try {

            con = Database.getInstance().getConnection();
            ps = con.prepareStatement(
                    "select * from stajyer.urun");
            ResultSet rs = ps.executeQuery();
            List<Urun> urunList=new ArrayList<>();
            while(rs.next())
            {
                Urun urun = new Urun();

                Integer id  = rs.getInt("id");
                Integer urun_tanimi_id  = rs.getInt("urun_tanimi_id");
                Integer employee_id  = rs.getInt("employee_id");
                Integer urun_fiyat  = rs.getInt("urun_fiyat");
                Integer urun_adedi  = rs.getInt("urun_adedi");

                //urun_tanimi_id, employee_id, urun_fiyat, urun_adedi

                urun.setId(Integer.valueOf(id!=null?id.toString():"null"));
                urun.setUrun_tanimi_id(urun_tanimi_id);
                urun.setEmployee_id(employee_id);
                urun.setUrun_fiyat(urun_fiyat);
                urun.setUrun_adedi(urun_adedi);


                urunList.add(urun);

            }
            return urunList;

        }
        catch ( Exception exception) {
            System.out.println("Bir hata meydana geldi:"+exception);
            return null;
        }
        finally{
            try {
                if(con!=null){
                    con.close();
                }
                if(ps!=null){
                    ps.close();
                }
            } catch (Exception sqlException) {
                System.out.println("Bir hata meydana geldi:"+sqlException);
            }
        }
    }


    public String urunEkle(Urun urun)
    {
        try {
            con = Database.getInstance().getConnection();
            ps=con.prepareStatement("INSERT INTO stajyer.urun(urun_tanimi_id, employee_id, urun_fiyat, urun_adedi) VALUES(?, ?, ?, ?)");
            ps.setInt(1,  urun.getUrun_tanimi_id());
            ps.setInt(2,  urun.getEmployee_id());
            ps.setFloat(3,  urun.getUrun_fiyat());
            ps.setInt(4,  urun.getUrun_adedi());
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
