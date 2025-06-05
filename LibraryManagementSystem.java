import java.util.*;

public class LibraryManagementSystem {
    private static LibraryManager library = new LibraryManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("-----WELCOME TO LIBRARY MANAGEMENT SYSTEM-----");
        // some sample books
        library.addBook("Book1", "TBH", "Fiction", 1);
        library.addBook("Book2", "IDK", "Fiction", 1);
        library.addBook("Book3", "MAYBE", "java", 1);
        library.addBook("Book4", "TORIYAMA", "ANIME", 10);

        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    searchBooks();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Thank you for using Library Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.println("\nPress Enter to continue...");
            sc.nextLine();
        }
    }

    private static void showMenu() {
        System.out.println("\n-----LIBRARY MANAGEMENT SYSTEM-----");
        System.out.println("1. Add New Book");
        System.out.println("2. View All Books");
        System.out.println("3. Search Books");
        System.out.println("4. Borrow Book");
        System.out.println("5. Return Book");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        try {
            int choice = Integer.parseInt(sc.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void addNewBook() {
        System.out.println("\n-----ADD NEW BOOK-----");
        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        System.out.print("Enter author name: ");
        String author = sc.nextLine();

        System.out.print("Enter genre: ");
        String genre = sc.nextLine();

        System.out.print("Enter number of copies: ");
        try {
            int copies = Integer.parseInt(sc.nextLine());
            if (copies > 0) {
                library.addBook(title, author, genre, copies);
            } else {
                System.out.println("Number of copies must be greater than 0.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for number of copies.");
        }
    }

    private static void viewAllBooks() {
        System.out.println("\n-----ALL BOOKS IN LIBRARY-----");
        library.viewAllBooks();
    }

    private static void searchBooks() {
        System.out.println("\n-----SEARCH BOOKS-----");
        System.out.println("1. Search by Title");
        System.out.println("2. Search by Author");
        System.out.println("3. Search by Genre");
        System.out.print("Enter your choice: ");

        int searchChoice = getChoice();
        String searchTerm;

        switch (searchChoice) {
            case 1:
                System.out.print("Enter title to search: ");
                searchTerm = sc.nextLine();
                library.searchByTitle(searchTerm);
                break;
            case 2:
                System.out.print("Enter author to search: ");
                searchTerm = sc.nextLine();
                library.searchByAuthor(searchTerm);
                break;
            case 3:
                System.out.print("Enter genre to search: ");
                searchTerm = sc.nextLine();
                library.searchByGenre(searchTerm);
                break;
            default:
                System.out.println("Invalid search option.");
        }
    }

    private static void borrowBook() {
        System.out.println("\n-----BORROW BOOK-----");
        library.viewAllBooks();
        System.out.print("\nEnter Book ID to borrow: ");

        try {
            int bookId = Integer.parseInt(sc.nextLine());
            library.borrowBook(bookId);
        } catch (NumberFormatException e) {
            System.out.println("Bhai Number Dalna nai ata?");
        }
    }

    private static void returnBook() {
        System.out.println("\n-----RETURN BOOK-----");
        System.out.print("Enter Book ID to return: ");

        try {
            int bookId = Integer.parseInt(sc.nextLine());
            library.returnBook(bookId);
        } catch (NumberFormatException e) {
            System.out.println("Bhai ko number dalna nai ata💀");
        }
    }
}