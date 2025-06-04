public class Book {
    private int bookId;
    private String title;
    private String author;
    private String genre;
    private int totalCopies;
    private int availableCopies;
    private static int nextId = 1;

    public Book(String title, String author, String genre, int totalCopies) {
        this.bookId = nextId++;
        //can be written like this,
        // this.bookId = nextId;
        //nextId++;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    // Methods for borrowing and returning
    public boolean borrowBook() {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        }
        return false;
    }

    public void returnBook() {
        if (availableCopies < totalCopies) {
            availableCopies++;
        }
    }


    public String toString() {
        return String.format("ID: %d | Title: %s | Author: %s | Genre: %s | Available: %d/%d",
                bookId, title, author, genre, availableCopies, totalCopies);
    }
}