import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }
}

class DataStrucEx6 {
    static Book[] books = {
            new Book(1, "Java", "James"),
            new Book(2, "Python", "Guido"),
            new Book(3, "C++", "Bjarne")
    };

    public static Book linearSearch(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title))
                return b;
        }
        return null;
    }

    public static Book binarySearch(String title, Book[] sorted) {
        int l = 0, r = sorted.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int cmp = sorted[m].title.compareToIgnoreCase(title);
            if (cmp == 0)
                return sorted[m];
            if (cmp < 0)
                l = m + 1;
            else
                r = m - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Arrays.sort(books, Comparator.comparing(b -> b.title));
        System.out.println(linearSearch("Python").author);
        System.out.println(binarySearch("Python", books).author);
    }
}