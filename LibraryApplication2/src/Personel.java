import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Personel extends Kullanici implements  IPersonel{
    public Personel(String userName, String password) {
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
            Boolean isFound = false;
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
    public void addBook(String name,String author,String theme) {
        try (FileReader reader = new FileReader("books.txt")){
            int letter=0;
            String text="";
            while ((letter=reader.read()) !=-1) {
                text += (char) letter;
            }
            String[] metin_arr = text.split("\n");
            ArrayList<String> newList = new ArrayList<String>();
            for(int i =0;i<metin_arr.length;i++){
                newList.add(metin_arr[i]);
            }
            newList.add(name+"/"+author+"/"+theme+"/Mevcut/1/");

            try (FileWriter writer = new FileWriter("books.txt")) {
                for (String j : newList) {
                    writer.write(j+"\n");
                }
                JOptionPane.showMessageDialog(null,name+" adlı kitap eklendi.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateBook(String name,String newName,String newAuthor,String newTheme) {
        try (FileReader reader = new FileReader("books.txt")){
            int letter=0;
            String text="";
            while ((letter=reader.read()) !=-1) {
                text += (char) letter;
            }
            String[] metin_arr = text.split("\n");
            ArrayList<String> newList = new ArrayList<String>();
            boolean isFound = false;
            for(int i =0;i<metin_arr.length;i++){
                String[] line = metin_arr[i].split("/");
                if(line[0].equals(name)& line[4].equals("1")& line[3].equals("Mevcut")){
                    newList.add(newName+"/"+newAuthor+"/"+newTheme+"/Mevcut/1/");
                    isFound = true;
                    continue;
                }
                newList.add(metin_arr[i]);
            }
            try (FileWriter writer = new FileWriter("books.txt")) {
                for (String j : newList) {
                    writer.write(j+"\n");
                }
                if(isFound){
                    JOptionPane.showMessageDialog(null,newName+" adlı kitap güncellendi.");
                }else{
                    JOptionPane.showMessageDialog(null,"Kayıt bulunamadı.");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBook(String name) {
        try (FileReader reader = new FileReader("books.txt")){
            int letter=0;
            String text="";
            while ((letter=reader.read()) !=-1) {
                text += (char) letter;
            }
            String[] metin_arr = text.split("\n");
            ArrayList<String> newList = new ArrayList<String>();
            boolean isFound = false;
            for(int i =0;i<metin_arr.length;i++){
                String[] line = metin_arr[i].split("/");
                if(line[0].equals(name) & line[4].equals("1")& line[3].equals("Mevcut")){
                    line[4]="0";
                    isFound = true;
                    newList.add(line[0]+"/"+line[1]+"/"+line[2]+"/"+line[3]+"/"+line[4]+"/");

                }else{
                    newList.add(metin_arr[i]);
                }

            }
            try (FileWriter writer = new FileWriter("books.txt")) {
                for (String j : newList) {
                    writer.write(j+"\n");
                }
                if(isFound){
                    JOptionPane.showMessageDialog(null,name+" adlı kitap silindi.");
                }else{
                    JOptionPane.showMessageDialog(null,"Kayıt bulunamadı.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
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
