public class Enum {
    public enum menu {

        BOOK_ADD(1, MenuText.AddBook()),
        BOOK_LIST(2, MenuText.Booklist()),
        BOOK_BORROW(3, MenuText.BorrowBook()),
        BOOK_RETURN(4, MenuText.ReturnBook()),
        BOOK_END(5, MenuText.Quit());

        public final int menuOption;
        public final String textMenu;

        menu(int menuOption, String textMenu) {
            this.menuOption = menuOption;
            this.textMenu = textMenu;
        }

        public int getMenuOption() {
            return menuOption;
        }

        public String getTextMenu() {
            return textMenu;
        }
    }

    public menu fromMenu(int input) {
        for (menu option : menu.values()) {
            if (option.getMenuOption() == input) {
                return option;
            }
        }
        return null;
    }
}
