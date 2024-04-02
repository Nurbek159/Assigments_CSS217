import java.util.HashMap;
import java.util.Map;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters and setters
}

class Magazine {
    private String title;
    private String editor;

    public Magazine(String title, String editor) {
        this.title = title;
        this.editor = editor;
    }

    // Getters and setters
}

class CD {
    private String title;
    private String artist;

    public CD(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    // Getters and setters
}

class ItemFactory {
    public static Item createItem(ItemType type, String title, String creator) {
        switch (type) {
            case BOOK:
                return new Book(title, creator);
            case MAGAZINE:
                return new Magazine(title, creator);
            case CD:
                return new CD(title, creator);
            default:
                throw new IllegalArgumentException("Invalid item type");
        }
    }
}

enum ItemType {
    BOOK,
    MAGAZINE,
    CD
}

abstract class Item {
    protected String title;
    protected String creator;
}

interface LibraryItem {
    void checkOut();
    void checkIn();
}

class LibraryCLI {
    private Map<Item, Boolean> catalog;

    public LibraryCLI() {
        catalog = new HashMap<>();
    }

    public void addItem(ItemType type, String title, String creator) {
        Item item = ItemFactory.createItem(type, title, creator);
        catalog.put(item, false);
    }

    public void checkOutItem(Item item) {
        if (catalog.containsKey(item) && !catalog.get(item)) {
            catalog.put(item, true);
            System.out.println(item.title + " checked out successfully.");
        } else {
            System.out.println("Item not available for checkout.");
        }
    }

    public void checkInItem(Item item) {
        if (catalog.containsKey(item) && catalog.get(item)) {
            catalog.put(item, false);
            System.out.println(item.title + " checked in successfully.");
        } else {
            System.out.println("Item not checked out.");
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryCLI librarianCLI = new LibraryCLI();

        // Adding items to the catalog
        librarianCLI.addItem(ItemType.BOOK, "The Great Gatsby", "F. Scott Fitzgerald");
        librarianCLI.addItem(ItemType.MAGAZINE, "National Geographic", "Various");
        librarianCLI.addItem(ItemType.CD, "Thriller", "Michael Jackson");

        // Checking out and checking in items
        Item item1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Item item2 = new Magazine("National Geographic", "Various");
        Item item3 = new CD("Thriller", "Michael Jackson");

        librarianCLI.checkOutItem(item1);
        librarianCLI.checkOutItem(item2);
        librarianCLI.checkOutItem(item3);

        librarianCLI.checkInItem(item1);
        librarianCLI.checkInItem(item2);
        librarianCLI.checkInItem(item3);
    }
}
