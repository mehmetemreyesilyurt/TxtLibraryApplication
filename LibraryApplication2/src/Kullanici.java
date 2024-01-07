public abstract class Kullanici{
    private String userName;
    private String password;

    public Kullanici(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public abstract void bilgileri_goster(String userName);

    public abstract void searchBookByName(String userName);

    public abstract void searchBookByAuthor(String author);

    public abstract void searchBookByTheme(String theme);

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract String getRole(String userName);
}
