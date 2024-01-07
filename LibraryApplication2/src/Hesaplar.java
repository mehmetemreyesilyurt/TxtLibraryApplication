import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Hesaplar {

    String userName;
    String password;
    public Hesaplar(String userName,String password){
        this.userName=userName;
        this.password=password;
    }
    public void addUser(String userName,String password,String role){
        try (FileReader reader = new FileReader("users.txt")){
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
        newList.add(userName+"/"+password+"/"+role+"/ /");

        try (FileWriter writer = new FileWriter("users.txt")) {
            for (String j : newList) {
                writer.write(j+"\n");
            }
            JOptionPane.showMessageDialog(null,userName+" adlı kullanıcı eklendi");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addUserDetails(String userName,String name,String surname,String email,String age,String no){
        boolean isFound = false;
        try (FileReader reader = new FileReader("users.txt")){
            int letter=0;
            String text="";
            while ((letter=reader.read()) !=-1) {
                text += (char) letter;
            }
            String[] metin_arr = text.split("\n");
            for(int i =0;i<metin_arr.length;i++){
                String[] line = metin_arr[i].split("/");
                if(line[0].equals(userName) & !(userName.equals("admin"))){
                    isFound = true;
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean isExist = false;
        try (FileReader reader = new FileReader("userdetails.txt")){
            int letter=0;
            String text="";
            while ((letter=reader.read()) !=-1) {
                text += (char) letter;
            }
            String[] metin_arr = text.split("\n");
            for(int i =0;i<metin_arr.length;i++){
                String[] line = metin_arr[i].split("/");
                if(line[0].equals(userName) & !(userName.equals("Username"))){
                    isExist = true;
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(isFound){
            try (FileReader reader = new FileReader("userdetails.txt")){
                int letter=0;
                String text="";
                while ((letter=reader.read()) !=-1) {
                    text += (char) letter;
                }
                String[] metin_arr = text.split("\n");
                ArrayList<String> newList = new ArrayList<String>();
                for(int i =0;i<metin_arr.length;i++){
                    String[] line = metin_arr[i].split("/");
                    if(isExist & line[0].equals(userName)){
                        continue;
                    }else{
                        newList.add(metin_arr[i]);
                    }
                }
                if(isExist){
                    newList.add(userName+"/"+name+"/"+surname+"/"+no+"/"+age+"/"+email+"/");
                    JOptionPane.showMessageDialog(null,"Kullanıcı detayları başarıyla güncellendi.");
                }else{
                    newList.add(userName+"/"+name+"/"+surname+"/"+no+"/"+age+"/"+email+"/");
                    JOptionPane.showMessageDialog(null,"Kullanıcı detayları başarıyla eklendi.");
                }
                try (FileWriter writer = new FileWriter("userdetails.txt")) {
                    for (String j : newList) {
                        writer.write(j+"\n");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Kullanıcı bulunamadı.");
        }
    }
    public void deleteUser(String userName){
        try (FileReader reader = new FileReader("users.txt")){
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
                if(line[0].equals(userName) & !(userName.equals("admin"))){
                    isFound = true;
                    continue;
                }
                newList.add(metin_arr[i]);
            }
            try (FileWriter writer = new FileWriter("users.txt")) {
                for (String j : newList) {
                    writer.write(j+"\n");
                }
                if(isFound){
                    JOptionPane.showMessageDialog(null,userName+" adlı Kullanıcı silindi.");
                }else{
                    if(userName.equals("admin")){
                        JOptionPane.showMessageDialog(null,"Silme hatası (admin).");
                    }else{
                        JOptionPane.showMessageDialog(null,"Kayıt bulunamadı.");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateUser(String userName,String newName,String newPassword,String newRole){
        try (FileReader reader = new FileReader("users.txt")){
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
                if(line[0].equals(userName)){
                    newList.add(newName+"/"+newPassword+"/"+newRole+"/ /");
                    isFound = true;
                    continue;
                }
                newList.add(metin_arr[i]);
            }
            try (FileWriter writer = new FileWriter("users.txt")) {
                for (String j : newList) {
                    writer.write(j+"\n");
                }
                if(isFound){
                    JOptionPane.showMessageDialog(null,userName+" adlı Kullanıcı güncellendi.");
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
    public boolean login(String userName,String password) throws IOException {
        try (FileReader reader = new FileReader("users.txt")){
            int letter=0;
            String text="";
            while ((letter=reader.read()) !=-1) {
                text += (char) letter;
            }
            String[] metin_arr = text.split("\n");

            SimpleDateFormat sekil = new SimpleDateFormat();
            Date date = new Date();
            boolean isLogin=false;
            boolean isUser=false;
            try (FileWriter writer = new FileWriter("logins.txt",true)) {
                for(int i =0;i<metin_arr.length;i++){
                    String[] line = metin_arr[i].split("/");
                    if(line[0].equals(userName)){
                        if(line[1].equals(password)){
                            writer.write(userName +" "+sekil.format(date)+"\n");
                            isLogin=true;
                            isUser=true;
                            JOptionPane.showMessageDialog(null,userName+" adlı kullanıcı giriş yaptı.");
                            break;
                        }else{
                            JOptionPane.showMessageDialog(null,"Kullanıcı adı veya şifre yanlış. Giriş yapılamadı.");
                            isUser=true;
                            break;
                        }
                    }

                }
                if(!isUser){
                    JOptionPane.showMessageDialog(null,"Kullanıcı bulunamadı.");
                }
                return isLogin;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
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
