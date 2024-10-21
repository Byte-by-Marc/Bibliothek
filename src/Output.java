import java.util.List;

public class Output {

    public void drawMenu() {
        for (Enum.menu option : Enum.menu.values()) {
            System.out.println(option.getMenuOption() + "." + option.getTextMenu());
        }
    }

    public void drawBooklist(List<Book> bookList) {
        System.out.println("Liste der Bücher:");
        System.out.println("Buchnr.  |Leihstatus|Buchname");
        for (Book outputBook : bookList) {
            System.out.println(outputBook.getId() + 1 + "         " + outputBook.getBorrow() + "           " + outputBook.getTitle());
        }
        System.out.println("\n");
    }

    public void drawAddBook() {
        System.out.println("Tragen sie ein BuchTitel ein:");
    }

    public void drawAddBookFinish(String bookTitle) {
        if (bookTitle.isEmpty()) {
            System.out.println("Sie müssen etwas eingeben, es wurde kein Buch angelegt.\n");
        } else {
            System.out.println("Sie haben folgendes Buch hinzugefügt:" + bookTitle);
        }
    }

    public void drawErrorInput() {
        System.out.println("Wiederholen sie Ihre Menü Eingabe");
    }

    public void drawBorrowBook() {
        System.out.println("Geben sie die Buchnummer ein:");
    }

    public void drawBorrowBookFinish(String bookTitle) {
        if (bookTitle.isEmpty()) {
            System.out.println("Das Buch ist schon ausgeliehen.\n");
        } else {
            System.out.println("Sie haben sich folgendes Buch ausgeliehen:" + bookTitle + "\n");
        }
    }

    public void error(){
        System.out.println("Es ist ein Fehler aufgetretten. Bitte wiederholen sie die Eingabe.");
    }

    public void drawReturnBook(){
        System.out.println("Geben sie die Buchnummer ein, das sie zurück geben möchten.");
    }

    public void drawReturnBookFinish(String bookTitle) {
        if (bookTitle.isEmpty()) {
            System.out.println("Das Buch wurde nicht verliehen.\n");
        } else {
            System.out.println("Sie haben sich folgendes Buch zurückgegeben:" + bookTitle + "\n");
        }
    }
}
