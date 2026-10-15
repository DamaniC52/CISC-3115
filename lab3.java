//Name: Damani Chung

import java.util.Scanner;

public class lab3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] ids = new int[100];
        String[] titles = new String[100];
        boolean[] available = new boolean[100];

        ids[0] = 101; titles[0] = "JavaBasics";     available[0] = true;
        ids[1] = 202; titles[1] = "DataStructures"; available[1] = true;
        ids[2] = 303; titles[2] = "Algorithms";     available[2] = false;

        int count = 3;

        System.out.println("Initial books:");
        for (int i = 0; i < count; i++) {
            if (available[i]) {
                System.out.println(ids[i] + " " + titles[i] + " (Available)");
            } else {
                System.out.println(ids[i] + " " + titles[i] + " (Borrowed)");
            }
        
        }

        int choice = 0;

        while (choice != 6) {

            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Borrow book");
            System.out.println("2. Return book");
            System.out.println("3. View available");
            System.out.println("4. View borrowed");
            System.out.println("5. Add book");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            if (choice == 1) {

                System.out.print("Enter ID to borrow: ");
                int id = input.nextInt();
                int index = findBook(ids, count, id);

                if (index == -1) {
                    System.out.println("Book not found.");
                } else if (available[index]) {
                    available[index] = false;
                    System.out.println("Book borrowed: " + titles[index]);
                } else {
                    System.out.println("Sorry, " + titles[index] + " is already borrowed.");
                }

            } else if (choice == 2) {

                System.out.print("Enter ID to return: ");
                int id = input.nextInt();
                int index = findBook(ids, count, id);

                if (index == -1) {
                    System.out.println("Book not found.");
                } else if (available[index]) {
                    System.out.println("Sorry, " + titles[index] + " was not borrowed.");
                } else {
                    available[index] = true;
                    System.out.println("Book returned: " + titles[index]);
                }

            } else if (choice == 3) {

                System.out.println("Available books:");
                for (int i = 0; i < count; i++) {
                    if (available[i]) {
                        System.out.println(ids[i] + " " + titles[i]);
                    }
                }

            } else if (choice == 4) {

                System.out.println("Borrowed books:");
                for (int i = 0; i < count; i++) {
                    if (!available[i]) {
                        System.out.println(ids[i] + " " + titles[i]);
                    }
                }

            } else if (choice == 5) {

                if (count == ids.length) {
                    System.out.println("Library is full, cannot add more books.");
                } else {

                    System.out.print("Enter new ID: ");
                    int id = input.nextInt();

                    if (findBook(ids, count, id) != -1) {
                        System.out.println("ID " + id + " is already used.");
                    } else {

                        System.out.print("Enter new title: ");
                        String title = input.next();

                        ids[count] = id;
                        titles[count] = title;
                        available[count] = true;
                        count++;

                        System.out.println("Book added: " + id + " " + title);
                    }
                }

            } else if (choice == 6) {

                System.out.println("Goodbye.");

            } else {

                System.out.println("Invalid choice, please pick 1 - 6.");
            }
        }

        input.close();
    }

    // Searches the ids array and returns the position of the book, or -1 if it is not there.
    public static int findBook(int[] ids, int count, int id) {
        for (int i = 0; i < count; i++) {
            if (ids[i] == id) {
                return i;
            }
        }
        return -1;
    }
}
