import Exception.BookAlreadyBorrowedException;
import Exception.BookAlreadyUnborrowedException;

public class Book {
    private int id;
    private String title;
    private int borrow = 0;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setBorrow(int borrow_value) {
        borrow = borrow_value;
    }

    public void borrow() {
        if (borrow == 1) {
            throw new BookAlreadyBorrowedException();
        }
        this.borrow = 1;
    }

    public void unborrow() {
        if (borrow == 0) {
            throw new BookAlreadyUnborrowedException();
        }
        this.borrow = 0;
    }

    public int getBorrow() {
        return borrow;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}