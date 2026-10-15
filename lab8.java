//Name: Damani Chung
import java.math.BigInteger;
import java.util.Scanner;

class lab8 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Q1. BigInteger - Large Factorial
        System.out.print("Enter a number n: ");
        int n = input.nextInt();
        input.nextLine(); // consume leftover newline
        System.out.println(n + "! = " + factorial(n));

        // Q2. String Class - Palindrome Checker
        System.out.print("\nEnter a string: ");
        String text = input.nextLine();
        if (isPalindrome(text)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }

        // Q3. Regex - Email Validator
        System.out.print("\nEnter an email address: ");
        String email = input.nextLine();
        if (isValidEmail(email)) {
            System.out.println("Valid Email");
        } else {
            System.out.println("Invalid Email");
        }

        input.close();
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        String cleaned = s.replace(" ", "").toLowerCase();
        String reversed = "";
        for (int i = cleaned.length() - 1; i >= 0; i--) {
            reversed += cleaned.charAt(i);
        }
        return cleaned.equals(reversed);
    }

    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
}
