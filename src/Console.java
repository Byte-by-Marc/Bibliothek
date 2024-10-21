import java.util.Scanner;

public class Console {
    public int userInput() {
            Scanner inputConsole = new Scanner(System.in);
            return inputConsole.nextInt();
    }

    public String insertBookName() {
            Scanner inputConsole = new Scanner(System.in);
            return inputConsole.nextLine();
        }
    }

