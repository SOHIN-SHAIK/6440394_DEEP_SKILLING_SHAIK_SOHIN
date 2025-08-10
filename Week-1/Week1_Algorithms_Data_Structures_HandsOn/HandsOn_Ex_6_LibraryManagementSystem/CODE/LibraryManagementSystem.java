import java.util.Arrays;

class Book implements Comparable<Book> {
    String bookId, title, author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int compareTo(Book other) {
        return this.title.compareToIgnoreCase(other.title);
    }

    public String toString() {
        return bookId + " | " + title + " | " + author;
    }
}

public class LibraryManagementSystem {
    Book[] books = new Book[100];
    int count = 0;

    public void add(Book b) {
        books[count++] = b;
    }

    public Book linearSearch(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) return books[i];
        }
        return null;
    }

    public Book binarySearch(String title) {
        Arrays.sort(books, 0, count);
        int left = 0, right = count - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lib = new LibraryManagementSystem();
        lib.add(new Book("B01", "Data Structures", "Mark Allen"));
        lib.add(new Book("B02", "Algorithms", "CLRS"));
        lib.add(new Book("B03", "Java Basics", "James Gosling"));

        Book found = lib.binarySearch("Java Basics");
        System.out.println("Binary Search Result: " + (found != null ? found : "Not Found"));

        Book linear = lib.linearSearch("Data Structures");
        System.out.println("Linear Search Result: " + (linear != null ? linear : "Not Found"));
    }
}
