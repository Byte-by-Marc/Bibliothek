import java.util.ArrayList;
import java.util.List;
import DaoInterface.Dao;
import Exception.NewBookException;

public class ArrayListBookDAO implements Dao<Book> {
    private final List<Book> books = new ArrayList<>();

    @Override
    public Book getBook(int IDbook) {
        return books.get(IDbook);
    }
    @Override
    public void saveBook(int id, Book Buch) {
        books.set(id, Buch);
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public void addNew(Book book) {
        if (book.getTitle().isEmpty()) {
            throw new NewBookException();
        }
        books.add(book);
    }

    @Override
    public void createBookDao() {
        books.add(new Book(0, "Die Einladung"));
        books.add(new Book(1, "Monster"));
        books.add(new Book(2, "Eine Frage der Chemie"));
        books.add(new Book(3, "Das späte Leben"));
        books.add(new Book(4, "Die Waffen des Lichts"));
    }
}

