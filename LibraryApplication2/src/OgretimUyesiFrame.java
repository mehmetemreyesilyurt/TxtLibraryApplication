import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OgretimUyesiFrame extends JFrame{
    OgretimUyesiFrame(String kullaniciAdi, String sifre){
        OgretimUyesi ou = new OgretimUyesi(kullaniciAdi,sifre);
        JFrame frame = new JFrame();
        frame.setTitle("Öğretim üyesi işlemleri");
        frame.setLocation(100,200);
        frame.setSize(800,200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,4,5,5));
        JButton buton1 = new JButton("Bilgileri göster");
        buton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ou.bilgileri_goster(kullaniciAdi);
            }
        });
        frame.add(buton1);
        JButton buton2 = new JButton("İsme göre kitap ara");
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = JOptionPane.showInputDialog("Kitabın ismini giriniz = ");
                ou.searchBookByName(bookName);
            }
        });
        frame.add(buton2);
        JButton buton3 = new JButton("Yazara göre kitap ara");
        buton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookAuthor = JOptionPane.showInputDialog("Yazarın ismini giriniz = ");
                ou.searchBookByAuthor(bookAuthor);
            }
        });
        frame.add(buton3);
        JButton buton4 = new JButton("Kitap türüne göre kitap ara");
        buton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookTheme = JOptionPane.showInputDialog("Kitabın türünü giriniz = ");
                ou.searchBookByTheme(bookTheme);
            }
        });
        frame.add(buton4);
        frame.setVisible(true);
    }
}
