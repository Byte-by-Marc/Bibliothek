import Exception.BookAlreadyBorrowedException;
import Exception.BookAlreadyUnborrowedException;
import Exception.NewBookException;

import java.io.IOException;

public class App {
    private boolean condition = true;
    private final Enum menu;
    private final Bibliothek bibliothek;
    private final Console console;
    private final Output output;

    public App() {
        output = new Output();
        console = new Console();
        bibliothek = new Bibliothek(new ArrayListBookDAO());
        menu = new Enum();

    }
    public void run() {
        while (this.condition) {
            appLoop();
        }
    }

    private void appLoop() {
        try {
            output.drawMenu();
            int userInput = console.userInput();
            if (userInput == 0) {
                output.drawErrorInput();
            } else {
                menuSwitch(userInput);
            }
        }
        catch(BookAlreadyBorrowedException e){
            System.out.println("Das Buch ist schon verliehen.");
        }
        catch(BookAlreadyUnborrowedException e){
            System.out.println("Das Buch wurde nicht verliehen");
        }
        catch(NewBookException e){
            System.out.println("Sie müssen ein Buchnamen für Ihr neues Buch eingeben");
        }
        catch(Exception e)
        {
            output.error();
        }
    }

    private void menuSwitch(int userInput) throws IOException {
        switch (menu.fromMenu(userInput)) {
            case BOOK_ADD:
                output.drawAddBook();
                output.drawAddBookFinish(bibliothek.addBook(console.insertBookName()));
                break;
            case BOOK_LIST:
                output.drawBooklist(bibliothek.getAll());
                break;
            case BOOK_BORROW:
                output.drawBorrowBook();
                output.drawBorrowBookFinish(bibliothek.borrowBook(console.userInput()-1));
                break;
            case BOOK_RETURN:
                output.drawReturnBook();
                output.drawReturnBookFinish(bibliothek.returnBook(console.userInput()-1));
                break;
            case BOOK_END:
                this.condition = false;
                break;
        }
    }
}


//String bookTitle2 = console.insertBookName();
//String addBookTitle = bibliothek.addBook(console.insertBookName());

//int bookId = console.userInput();
//String bookTitle = bibliothek.borrowBook(console.userInput());