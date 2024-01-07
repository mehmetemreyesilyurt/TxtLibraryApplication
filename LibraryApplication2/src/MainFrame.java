import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainFrame extends JFrame{
    MainFrame(String kullaniciAdi,String sifre){
        Personel p= new Personel(kullaniciAdi,sifre);
        Hesaplar h = new Hesaplar(kullaniciAdi,sifre);
        JFrame frame = new JFrame();
        frame.setTitle("Admin");
        frame.setLocation(100,200);
        frame.setSize(800,200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,4,5,5));
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
        JButton buton8 = new JButton("Kullanıcı ekle");
        buton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = JOptionPane.showInputDialog("Kullanıcı adını giriniz = ");
                String pword = JOptionPane.showInputDialog("Şifre giriniz = ");
                String role = JOptionPane.showInputDialog("Kullanıcı rolünü giriniz = ");
                h.addUser(uname,pword,role);
            }
        });
        frame.add(buton8);
        JButton buton9 = new JButton("Kullanıcı detayları ekle");
        buton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addDetailName = JOptionPane.showInputDialog("Detay eklenecek kullanıcıyı giriniz = ");
                String name = JOptionPane.showInputDialog("Adını giriniz = ");
                String surname = JOptionPane.showInputDialog("Soyadını giriniz = ");
                String no = JOptionPane.showInputDialog("Numarasını giriniz = ");
                String age = JOptionPane.showInputDialog("Yaşını giriniz = ");
                String email = JOptionPane.showInputDialog("Emailini giriniz = ");

                h.addUserDetails(addDetailName,name,surname,email,age,no);
            }
        });
        frame.add(buton9);
        JButton buton10 = new JButton("Kullanıcı güncelle");
        buton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUserName = JOptionPane.showInputDialog("Güncellenecek kullanıcıyı giriniz = ");
                String uname = JOptionPane.showInputDialog("Kullanıcı adını giriniz = ");
                String pword = JOptionPane.showInputDialog("Şifre giriniz = ");
                String role = JOptionPane.showInputDialog("Kullanıcı rolünü giriniz = ");
                h.updateUser(newUserName,uname,pword,role);
            }
        });
        frame.add(buton10);
        JButton buton11 = new JButton("Kullanıcı sil");
        buton11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = JOptionPane.showInputDialog("Silinecek kullanıcıyı giriniz = ");
                h.deleteUser(uname);
            }
        });
        frame.add(buton11);
        frame.setVisible(true);
    }
}
