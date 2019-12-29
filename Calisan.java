/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastaneprojesi;

/**
 *
 * @author mert
 */
public class Calisan {
    private int id;
    private String tc;
    private String unvan;
    private String ad;
    private String soyad;
    private String bolum;
    private String yas;
    private String cinsiyet;
    private String  maas;

    public Calisan(int id, String tc, String unvan, String ad, String soyad, String bolum, String yas, String cinsiyet, String maas) {
        this.id = id;
        this.tc = tc;
        this.unvan = unvan;
        this.ad = ad;
        this.soyad = soyad;
        this.bolum = bolum;
        this.yas = yas;
        this.cinsiyet = cinsiyet;
        this.maas = maas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public String getYas() {
        return yas;
    }

    public void setYas(String yas) {
        this.yas = yas;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getMaas() {
        return maas;
    }

    public void setMaas(String maas) {
        this.maas = maas;
    }

    

   

    
    
}
