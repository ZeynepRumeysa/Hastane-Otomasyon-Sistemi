/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastaneprojesi;

/**
 *
 * @author Acer
 */
public class Hastane_Bilgi {
    private int id;
    private String ad;
    private String soyad;
    private String tc;
    private String doktor_adi;
    private String randevu_saati;
    private String bolum;

    public Hastane_Bilgi(int id, String ad, String soyad, String tc, String doktor_adi, String randevu_saati, String bolum) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
        this.doktor_adi = doktor_adi;
        this.randevu_saati = randevu_saati;
        this.bolum = bolum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getDoktor_adi() {
        return doktor_adi;
    }

    public void setDoktor_adi(String doktor_adi) {
        this.doktor_adi = doktor_adi;
    }

    public String getRandevu_saati() {
        return randevu_saati;
    }

    public void setRandevu_saati(String randevu_saati) {
        this.randevu_saati = randevu_saati;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }
   
}
