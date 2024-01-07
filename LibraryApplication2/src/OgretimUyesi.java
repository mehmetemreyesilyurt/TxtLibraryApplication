import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;

public class OgretimUyesi extends Kullanici{

    public OgretimUyesi(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void bilgileri_goster(String userName) {
        try (FileReader reader = new FileReader("userdetails.txt")) {
            int letter = 0;
            String text = "";
            while ((letter = reader.read()) != -1) {
                text += (char) letter;
            }
            String[] metin_arr = text.split("\n");
            boolean isFound =false;
            for (int i = 0; i < metin_arr.length; i++) {
                String[] line = metin_arr[i].split("/");
                if (line[0].equals(userName)) {
                    isFound = true;
                    if(line.length>5){
                        JOptionPane.showMessageDialog(null,"Adı ="+line[1]+"\nSoyadı ="+line[2]
                                +"\nEmail ="+line[3]+"\nYaşı ="+line[4]+"\nNumarası ="+line[5]);
                    }else{
                        JOptionPane.showMessageDialog(null,"Tanımlanmış kişisel bilgisi bulunamadı.");
                    }
                }
            }
            if(!isFound){
                JOptionPane.showMessageDialog(null,"Tanımlanmış kişisel bilgisi bulunamadı.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void searchBookByName(String name) {
        try (FileReader appreader = new FileReader("books.txt")) {
            int appletter=0;
            String apptext="";
            while ((appletter=appreader.read()) !=-1) {
                apptext += (char) appletter;
            }
            String[] app_arr = apptext.split("\n");

            String author="";
            String theme="";
            String status="";

            boolean isFound = false;

            for(int i =0;i<app_arr.length;i++){
                String[] line = app_arr[i].split("/");
                if(line[0].equals(name)& line[4].equals("1")){

                    author=line[1];
                    theme=line[2];
                    status=line[3];

                    isFound=true;
                    break;
                }
            }
            if(isFound){
                JOptionPane.showMessageDialog(null,"Kitabın adı = "+name+"\nYazarı = "+author
                        +"\nKonusu = "+theme+"\nDurumu = "+status);
            }else{
                JOptionPane.showMessageDialog(null,"Herhangi bir kayıt bulunamadı.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void searchBookByAuthor(String author) {
        try (FileReader appreader = new FileReader("books.txt")) {
            int appletter=0;
            String apptext="";
            while ((appletter=appreader.read()) !=-1) {
                apptext += (char) appletter;
            }
            String[] app_arr = apptext.split("\n");

            boolean isFound = false;
            String result ="";

            for(int i =0;i<app_arr.length;i++){
                String[] line = app_arr[i].split("/");
                if(line[1].equals(author)& line[4].equals("1")){

                    result += line[0]+"-"+line[1]+"-"+line[2]+"-"+line[3]+"\n";

                    isFound=true;
                }
            }
            if(isFound){
                JOptionPane.showMessageDialog(null,result);
            }
            if(!isFound){
                JOptionPane.showMessageDialog(null,"Herhangi bir kayıt bulunamadı.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void searchBookByTheme(String theme) {
        try (FileReader appreader = new FileReader("books.txt")) {
            int appletter=0;
            String apptext="";
            while ((appletter=appreader.read()) !=-1) {
                apptext += (char) appletter;
            }
            String[] app_arr = apptext.split("\n");

            boolean isFound = false;
            String result ="";

            for(int i =0;i<app_arr.length;i++){
                String[] line = app_arr[i].split("/");
                if(line[2].equals(theme) & line[4].equals("1")){

                    result += line[0]+"-"+line[1]+"-"+line[2]+"-"+line[3]+"\n";

                    isFound=true;
                }
            }
            if(isFound){
                JOptionPane.showMessageDialog(null,result);
            }
            if(!isFound){
                JOptionPane.showMessageDialog(null,"Herhangi bir kayıt bulunamadı.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String getRole(String userName){
        String role ="";
        try (FileReader reader = new FileReader("users.txt")) {
            int letter = 0;
            String text = "";
            while ((letter = reader.read()) != -1) {
                text += (char) letter;
            }
            String[] metin_arr = text.split("\n");
            for (int i = 0; i < metin_arr.length; i++) {
                String[] line = metin_arr[i].split("/");
                if (line[0].equals(userName)) {
                    role = line[2];
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return role;
    }
}
