import DaoInterface.Dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public final class Bibliothek {
    private final Dao<Book> bookDao;

    Bibliothek(Dao<Book> bookDao) {
        this.bookDao = bookDao;
        this.bookDao.createBookDao();
    }

    public String borrowBook(int id){
        Book book = bookDao.getBook(id);
        book.borrow();
        bookDao.saveBook(id, book);
        return book.getTitle();
    }

    public String returnBook(int id) {
        Book book = bookDao.getBook(id);
        book.unborrow();
        bookDao.saveBook(id, book);
        return book.getTitle();
    }

    public String addBook(String bookTitle) throws IOException {
            int countItems = bookDao.getAll().size();
            Book newBook = new Book(countItems, bookTitle);
            //bookDao.addNew(newBook);

        String filePath = "src/test/user.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(newBook);

            return bookTitle;

    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
