/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastaneprojesi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Hastaİslemleri {
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    //hastane bilgilerimizi veritabanindan aldiğimiz fonksiyon
    public ArrayList<Hastane_Bilgi> calisanlariGetir() {
        
        ArrayList<Hastane_Bilgi> cikti = new ArrayList<Hastane_Bilgi>();
        
        try {
            statement =  con.createStatement();
            String sorgu =  "Select * From SYSTEM.HASTALAR";
            
            ResultSet rs =  statement.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String tc  = rs.getString("tc");
                String doktor_adi = rs.getString("doktor_adi");
                String randevu_saati=rs.getString("randevu_saati");
                String bolum=rs.getString("bolum");
                
                
                cikti.add(new Hastane_Bilgi(id, ad, soyad, tc, doktor_adi,randevu_saati,bolum));
                
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
        
        
        
        
    }
  /*  public ArrayList<String> veriGetir()
    {
       ArrayList<String> veriler_ad = new ArrayList<String>();
         try {
            statement =  con.createStatement();
            String sorgu =  "Select * From SYSTEM.DOKTORLAR";
            
            ResultSet rs =  statement.executeQuery(sorgu);
            
            while(rs.next()) {
                String adsoyad=rs.getString("adsoyad");
                
               veriler_ad.add(adsoyad);
            }
            return veriler_ad;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
    }
    */
    //hastane bilgilerimizi veritabanindan aldiğimiz fonksiyon
    public ArrayList<Calisan> doktorlarıGetir() {
        
        ArrayList<Calisan> cikti = new ArrayList<Calisan>();
        
        try {
            statement =  con.createStatement();
            String sorgu =  "Select * From SYSTEM.DOKTORLAR";
            
            ResultSet rs =  statement.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String tc = rs.getString("tc");
                String unvan = rs.getString("unvan");
                String ad = rs.getString("ad");
                String soyad = rs.getString("soyad");
                String bolum = rs.getString("bolum");
                String yas= rs.getString("yas");
                String cinsiyet = rs.getString("cinsiyet");
                String maas=rs.getString("maas");
                
                
                
                cikti.add(new Calisan(id,tc,unvan,ad,soyad,bolum,yas,cinsiyet,maas));
                
                
            }
            System.out.println("hasta işlermlerinden çağırıldı :"+cikti.size());
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
        
        
        
        
    }
  
    
    
    public void hasta_Guncelle(int id, String yeni_ad, String yeni_soyad, String yeni_tc, String yeni_doktor_adi, String yeni_randevu_saati, String yeni_bolum) {
        String sorgu =  "Update SYSTEM.HASTALAR set ad = ? , soyad = ? , tc = ? , doktor_adi = ? ,randevu_saati=?,bolum=? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,yeni_ad);
            preparedStatement.setString(2,yeni_soyad);
            preparedStatement.setString(3, yeni_tc);
            preparedStatement.setString(4,yeni_doktor_adi);
            preparedStatement.setString(5,yeni_randevu_saati);
             preparedStatement.setString(6,yeni_bolum);
            
            preparedStatement.setInt(7, id);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
     public void doktor_Guncelle(int id,String tc, String unvan, String ad,String soyad,String bolum ,String yas, String cinsiyet, String maas) {
        String sorgu = "Update SYSTEM.DOKTORLAR set tc=?, unvan =? , ad =? , soyad=?, bolum=?,  yas =? , cinsiyet=? , maas=? where  id=?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,tc);
            preparedStatement.setString(2,unvan);
            preparedStatement.setString(3, ad);
            preparedStatement.setString(4, soyad);
            preparedStatement.setString(5, bolum);
            preparedStatement.setString(6, yas);
            preparedStatement.setString(7,cinsiyet);
            preparedStatement.setString(8,maas);
             
            preparedStatement.setInt(9, id);
            
         
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void hasta_Sil(int id) {
        
        String sorgu = "Delete from SYSTEM.HASTALAR where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
     public void doktor_Sil(int id) {
        
        String sorgu = "Delete from SYSTEM.DOKTORLAR where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    //farkli bir ekleme kodu
    public void ekle_calisan(String a,String b,String c,String d,String e,String f)
    {
        try {
            statement=con.createStatement();
            String ad=a;
            String soyad=b;
            String tc=c;
            String doktor=d;
            String randevu=e;
            String bolum=f;
            String sorgu="Insert Into SYSTEM.HASTALAR (ad,soyad,,tc,doktor_adi,randevu_saati,bolum) "
                    + "Values ("+"'"+ad+"'," + "'" + soyad + "'," + "'" + tc + "'," + "'" + doktor + "'," + "'" + randevu + "'," + "'" + bolum + "')";
            
                statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //veritabanina girdilerimizi eklediğimiz fonksiyon
     public void hasta_Ekle(String ad,String soyad,String tc,String doktor_adi,String randevu_saati,String bolum) {
        
        String sorgu = "Insert Into SYSTEM.HASTALAR (ad,soyad,tc,doktor_adi,randevu_saati,bolum) VALUES(?,?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, tc);
            preparedStatement.setString(4, doktor_adi);
            preparedStatement.setString(5, randevu_saati);
             preparedStatement.setString(6, bolum);
            
          preparedStatement.executeUpdate();
          
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
        
        
        
        
        
    }
     public void kayitEkle1(String kullanici_adi,String sifre)
             
     {
         
         String sorgu= "Insert Into SYSTEM.ADMINLER (username,password) VALUES(?,?)";
         try {
             preparedStatement=con.prepareStatement(sorgu);
             
             preparedStatement.setString(1, kullanici_adi);
             preparedStatement.setString(2, sifre);
             
             preparedStatement.executeUpdate();
             
         } catch (Exception e) {
             
             
         }
     }
             
     public void doktor_Ekle(String tc,String unvan,String ad,String soyad,String bolum,String yas,String cinsiyet,String maas) {
        
        String sorgu = "Insert Into SYSTEM.DOKTORLAR (tc,unvan,ad,soyad,bolum,yas,cinsiyet,maas) VALUES(?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, tc);
            preparedStatement.setString(2, unvan);
            preparedStatement.setString(3, ad);
            preparedStatement.setString(4, soyad);
            preparedStatement.setString(5, bolum);
            preparedStatement.setString(6, yas);
            preparedStatement.setString(7, cinsiyet);
            preparedStatement.setString(8, maas);
            
              preparedStatement.executeUpdate();
          
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null , ex);
           
        }
        
        
        
        
        
        
    }
     //birinci panel'de veritabanimizdan aldiğiniz id' ve şifrelere göre giriş yapılıyor
    public boolean giris_Yap(String kullanici_adi,String parola) {
        
        String sorgu =  "Select * From SYSTEM.adminler where username = ? and password = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1,kullanici_adi);
            
            preparedStatement.setString(2,parola);
            
            ResultSet rs =  preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(Hastaİslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }  
        
        
    }
     public Hastaİslemleri() {
        
       // String url = "jdbc:oracle:thin:@//" + Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("oracle.jdbc.OracleDriver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        
        
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","5179");
            //con=DriverManager.getConnection(url);
           
            
            System.out.println("Bağlantı Başarılı...");
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }
        
        
    }
     
}
