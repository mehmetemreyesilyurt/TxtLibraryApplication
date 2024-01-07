import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OgrenciFrame extends JFrame{
    OgrenciFrame(String kullaniciAdi, String sifre){
        Ogrenci o = new Ogrenci(kullaniciAdi,sifre);
        JFrame frame = new JFrame();
        frame.setTitle("Öğrenci işlemleri");
        frame.setLocation(100,200);
        frame.setSize(1200,200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,4,5,5));
        JButton buton1 = new JButton("Bilgileri göster");
        buton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                o.bilgileri_goster(kullaniciAdi);
            }
        });
        frame.add(buton1);
        JButton buton2 = new JButton("İsme göre kitap ara");
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = JOptionPane.showInputDialog("Kitabın ismini giriniz = ");
                o.searchBookByName(bookName);
            }
        });
        frame.add(buton2);
        JButton buton3 = new JButton("Yazara göre kitap ara");
        buton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookAuthor = JOptionPane.showInputDialog("Yazarın ismini giriniz = ");
                o.searchBookByAuthor(bookAuthor);
            }
        });
        frame.add(buton3);
        JButton buton4 = new JButton("Kitap türüne göre kitap ara");
        buton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookTheme = JOptionPane.showInputDialog("Kitabın türünü giriniz = ");
                o.searchBookByTheme(bookTheme);
            }
        });
        frame.add(buton4);
        JButton buton5 = new JButton("Kitap ödünç al");
        buton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = JOptionPane.showInputDialog("Ödünç alınacak kitabın ismini giriniz = ");
                o.borrow(kullaniciAdi,bookName);
            }
        });
        frame.add(buton5);
        JButton buton6 = new JButton("Kitap iade et");
        buton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = JOptionPane.showInputDialog("İade edilecek kitabın ismini giriniz = ");
                o.giveBack(kullaniciAdi,bookName);
            }
        });
        frame.add(buton6);
        JButton buton7 = new JButton("Alınan kitapları göster");
        buton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                o.getBooks(kullaniciAdi);
            }
        });
        frame.add(buton7);
        frame.setVisible(true);
    }
}
