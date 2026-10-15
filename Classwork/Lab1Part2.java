/*  Name: Damani Chung
 * Date: 09/08/2026
 */

import java.util.Scanner;

public class Lab1Part2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        question1(input);
        Question2(args);
        Question3(input);

        input.close();
    }

    // ---------- Question 1 ----------
    public static void question1(Scanner input) {

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        firstName = firstName.trim();
        lastName = lastName.trim();

        // 1. length of the first name
        System.out.println("First name length: " + firstName.length());

        // 2. first character of the first name
        System.out.println("First character: " + firstName.charAt(0));

        // 3. put the two names together with a space in between
        String fullName = firstName + " " + lastName;
        System.out.println("Full name: " + fullName);

        // 4. first name in lowercase
        System.out.println("First name lowercase: " + firstName.toLowerCase());

        // 5. last name in uppercase
        System.out.println("Last name uppercase: " + lastName.toUpperCase());
    }
        public static void Question2(String[] args) {

            for (char letter = 'A'; letter <= 'Z'; letter++) {
                System.out.print(letter + " ");
            }

            // move to a new line after the whole alphabet has printed
            System.out.println();
        }
        // ---------- Question 3 ----------
        public static void Question3(Scanner input) {

        System.out.print("Enter your full name: ");
        String fullname = input.nextLine().trim();

        int spaceIndex = fullname.indexOf(' ');

        String firstName = fullname.substring(0, spaceIndex);

        String lastName = fullname.substring(spaceIndex + 1);

        System.out.println();
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
    }
}
