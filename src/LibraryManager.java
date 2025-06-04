import java.util.*;

public class LibraryManager {
    private List<Book> books;

    public LibraryManager() {
        this.books = new ArrayList<>();
    }

    // adding a new book
    public void addBook(String title, String author, String genre, int copies) {
        if (copies>0) {
            Book book = new Book(title, author, genre, copies);
            books.add(book);
            System.out.println("Book added successfully! Book ID: " + book.getBookId());
        }
        else{
            System.out.println("COPIES <= 0 NOT ALLOWED");
        }
    }

    // printing all the books from books list
    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\n-----ALL BOOKS-----");
        for (Book book : books) {
            System.out.println(book);
        }
    }
//for searching we created seperate methods!
    // Search by title
    public void searchByTitle(String title) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(book);
            }
        }
        displaySearchResults(results, "Title: " + title);
    }

    // Search by author
    public void searchByAuthor(String author) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                results.add(book);
            }
        }
        displaySearchResults(results, "Author: " + author);
    }

    // Search by genre
    public void searchByGenre(String genre) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().toLowerCase().contains(genre.toLowerCase())) {
                results.add(book);
            }
        }
        displaySearchResults(results, "Genre: " + genre);
    }
//printing the result from here to reduce the lines
    private void displaySearchResults(List<Book> results, String criteria) {
        if (results.isEmpty()) {
            System.out.println("No books found for " + criteria);
            return;
        }

        System.out.println("\n-----SEARCH RESULTS FOR " + criteria.toUpperCase() + "-----");
        for (Book book : results) {
            System.out.println(book);
        }
    }

    // Borrow a book
    public void borrowBook(int bookId) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found with ID: " + bookId);
            return;
        }

        if (book.borrowBook()) {
            System.out.println("Book borrowed successfully!");
            System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
            System.out.println("Available copies now: " + book.getAvailableCopies());
        } else {
            System.out.println("Sorry, no copies available for this book.");
        }
    }

    // Return a book
    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found with ID: " + bookId);
            return;
        }

        book.returnBook();
        System.out.println("Book returned successfully!");
        System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
        System.out.println("Available copies now: " + book.getAvailableCopies());
    }

    private Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
}