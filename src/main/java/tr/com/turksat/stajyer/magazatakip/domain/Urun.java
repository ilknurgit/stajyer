package tr.com.turksat.stajyer.magazatakip.domain;


import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class Urun {

    @Column(name = "id",columnDefinition = "serial")
    private int id;

    @Column(name = "urun_tanimi_id",columnDefinition = "serial")
    private int urun_tanimi_id;

    @Column(name = "employee_id",columnDefinition = "serial")
    private int employee_id;

    @Column(name = "urun_fiyat",columnDefinition = "float")
    private float urun_fiyat;

    @Column(name = "urun_adedi",columnDefinition = "serial")
    private int urun_adedi;

    public int id(){
        return id;
    }

    public int urun_tanimi_id(){
        return urun_tanimi_id;
    }

    public int employee_id(){
        return employee_id;
    }

    public float urun_fiyat(){
        return urun_fiyat;
    }

    public int urun_adedi(){
        return urun_adedi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrun_tanimi_id() {
        return urun_tanimi_id;
    }

    public void setUrun_tanimi_id(int urun_tanimi_id) {
        this.urun_tanimi_id = urun_tanimi_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public float getUrun_fiyat() {
        return urun_fiyat;
    }

    public void setUrun_fiyat(float urun_fiyat) {
        this.urun_fiyat = urun_fiyat;
    }

    public int getUrun_adedi() {
        return urun_adedi;
    }

    public void setUrun_adedi(int urun_adedi) {
        this.urun_adedi = urun_adedi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Urun that = (Urun) o;
        return  Objects.equals(getId(), that.getId()) &&
                Objects.equals(getUrun_tanimi_id(),that.getUrun_tanimi_id()) &&
                Objects.equals(getEmployee_id(), that.getEmployee_id()) &&
                Objects.equals(getUrun_fiyat(), that.getUrun_fiyat()) &&
                Objects.equals(getUrun_adedi(), that.getUrun_adedi());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(),getUrun_tanimi_id(),getEmployee_id(),getUrun_fiyat(),getUrun_adedi());
    }
}