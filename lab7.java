//Name: Damani Chung
class Library {

    public static void main(String[] args) {

        // Create librarian
        Librarian john = new Librarian("John");

        // Create members
        Member alice = new Member("Alice");
        Member bob = new Member("Bob");

        // Create books
        Book mobyDick = new Book("Moby Dick");
        Book gatsby = new Book("The Great Gatsby");
        Book hobbit = new Book("The Hobbit");

        // Assign librarian to books
        john.addBook(mobyDick);
        john.addBook(gatsby);
        john.addBook(hobbit);

        // Members borrow books
        alice.borrowBook(mobyDick);
        alice.borrowBook(hobbit);
        bob.borrowBook(gatsby);

        // Print relationships
        Book[] books = {mobyDick, gatsby, hobbit};
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getBorrower().getName() + " borrowed "
                    + books[i].getTitle() + ", managed by Librarian "
                    + books[i].getLibrarian().getName());
        }

        System.out.println();
        alice.printBorrowedBooks();
        bob.printBorrowedBooks();
        john.printManagedBooks();
    }
}

class Book {

    private String title;
    private Member borrower;      
    private Librarian librarian;  

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Member getBorrower() {
        return borrower;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setBorrower(Member m) {
        borrower = m;
    }

    public void setLibrarian(Librarian l) {
        librarian = l;
    }
}

class Member {

    private String name;
    private Book[] borrowedBooks = new Book[10]; // up to 10 borrowed books
    private int count = 0;

    public Member(String name) {
        this.name = name;
    }

    public void borrowBook(Book b) {
        if (count < borrowedBooks.length) {
            borrowedBooks[count] = b;
            count++;
            b.setBorrower(this);
        } else {
            System.out.println(name + " cannot borrow more than " + borrowedBooks.length + " books.");
        }
    }

    public String getName() {
        return name;
    }

    public void printBorrowedBooks() {
        System.out.print(name + " has borrowed: ");
        for (int i = 0; i < count; i++) {
            System.out.print(borrowedBooks[i].getTitle());
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

class Librarian {

    private String name;
    private Book[] managedBooks = new Book[20]; 
    private int count = 0;

    public Librarian(String name) {
        this.name = name;
    }

    public void addBook(Book b) {
        if (count < managedBooks.length) {
            managedBooks[count] = b;
            count++;
            b.setLibrarian(this);
        } else {
            System.out.println("Librarian " + name + " cannot manage more than " + managedBooks.length + " books.");
        }
    }

    public String getName() {
        return name;
    }

    public void printManagedBooks() {
        System.out.print("Librarian " + name + " manages: ");
        for (int i = 0; i < count; i++) {
            System.out.print(managedBooks[i].getTitle());
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
