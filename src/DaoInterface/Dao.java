package DaoInterface;
import java.util.List;

public interface Dao<T> {
    T getBook(int id);
    void saveBook(int id, T t);
    List<T> getAll();
    void addNew(T t);
    void createBookDao();
}
