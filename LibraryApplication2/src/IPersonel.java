public interface IPersonel {
    void addBook(String name,String author,String theme);
    void updateBook(String name,String newName,String newAuthor,String newTheme);
    void deleteBook(String name);

}