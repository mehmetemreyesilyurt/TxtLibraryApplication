import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
            String kullaniciAdi = JOptionPane.showInputDialog("Kullanıcı adını giriniz = ");
            String sifre = JOptionPane.showInputDialog("Şifreyi giriniz = ");

            Hesaplar h = new Hesaplar(kullaniciAdi,sifre);
            if(h.login(kullaniciAdi,sifre)){
                if(h.getRole(kullaniciAdi).equals("Personel")){
                    if(kullaniciAdi.equals("admin")){
                        new MainFrame(kullaniciAdi,sifre);
                    }else {
                        new PersonelFrame(kullaniciAdi, sifre);
                    }
                }else if (h.getRole(kullaniciAdi).equals("Ogrenci")) {
                    new OgrenciFrame(kullaniciAdi,sifre);
                    }
                else{
                    new OgretimUyesiFrame(kullaniciAdi,sifre);
                }
            }
    }
}