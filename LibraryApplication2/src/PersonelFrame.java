import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonelFrame extends JFrame{
    PersonelFrame(String kullaniciAdi, String sifre){
        Personel p= new Personel(kullaniciAdi,sifre);
        JFrame frame = new JFrame();
        frame.setTitle("Personel işlemleri");
        frame.setLocation(100,200);
        frame.setSize(1200,200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1,4,5,5));
        JButton buton1 = new JButton("Bilgileri göster");
        buton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.bilgileri_goster(kullaniciAdi);
            }
        });
        frame.add(buton1);
        JButton buton2 = new JButton("İsme göre kitap ara");
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = JOptionPane.showInputDialog("Kitabın ismini giriniz = ");
                p.searchBookByName(bookName);
            }
        });
        frame.add(buton2);
        JButton buton3 = new JButton("Yazara göre kitap ara");
        buton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookAuthor = JOptionPane.showInputDialog("Yazarın ismini giriniz = ");
                p.searchBookByAuthor(bookAuthor);
            }
        });
        frame.add(buton3);
        JButton buton4 = new JButton("Kitap türüne göre kitap ara");
        buton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookTheme = JOptionPane.showInputDialog("Kitabın türünü giriniz = ");
                p.searchBookByTheme(bookTheme);
            }
        });
        frame.add(buton4);
        JButton buton5 = new JButton("Kitap ekle");
        buton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = JOptionPane.showInputDialog("Kitabın ismini giriniz = ");
                String bookAuthor = JOptionPane.showInputDialog("Yazarın ismini giriniz = ");
                String bookTheme = JOptionPane.showInputDialog("Kitabın türünü giriniz = ");
                p.addBook(bookName,bookAuthor,bookTheme);
            }
        });
        frame.add(buton5);
        JButton buton6 = new JButton("Kitap güncelle");
        buton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = JOptionPane.showInputDialog("Güncellenecek kitabın ismini giriniz = ");
                String newBookName = JOptionPane.showInputDialog("Yeni kitabın ismini giriniz = ");
                String bookAuthor = JOptionPane.showInputDialog("Kitabın yazarını giriniz = ");
                String bookTheme = JOptionPane.showInputDialog("Kitabın türünü giriniz = ");
                p.updateBook(bookName,newBookName,bookAuthor,bookTheme);
            }
        });
        frame.add(buton6);
        JButton buton7 = new JButton("Kitap sil");
        buton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = JOptionPane.showInputDialog("Silinecek kitabın ismini giriniz = ");
                p.deleteBook(bookName);
            }
        });
        frame.add(buton7);
        frame.setVisible(true);
    }
}
