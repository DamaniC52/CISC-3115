//Name: Damani Chung
import java.io.*;
import java.util.*;
public class lab4 {

    public static void main(String[] args) throws FileNotFoundException {

        String[] categories = new String[100];
        int[] amounts = new int[100];

        File file = new File("expenses.txt");

        if (!file.exists()) {
            System.out.println("Could not find expenses.txt");
            System.exit(1);
        }

        int count = readExpenses(file, categories, amounts);

        printExpenses(categories, amounts, count);

        int total = calculateTotal(amounts, count);
        int high = findHighest(amounts, count);
        int low = findLowest(amounts, count);

        System.out.println();
        System.out.println("Total Expenses: $" + total);
        System.out.println("Highest Expense: " + categories[high] + " ($" + amounts[high] + ")");
        System.out.println("Lowest Expense: " + categories[low] + " ($" + amounts[low] + ")");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your monthly budget: $");
        int budget = input.nextInt();

        if (total > budget) {
            System.out.println("You are over budget by $" + (total - budget));
        } else {
            System.out.println("You are under budget by $" + (budget - total));
        }
        sortByAmount(categories, amounts, count);

        writeReport(categories, amounts, count, total, budget);

        System.out.println("Expense report generated successfully - report.txt");

        input.close();
    }

    public static int readExpenses(File file, String[] categories, int[] amounts)
            throws FileNotFoundException {

        Scanner fileInput = new Scanner(file);
        int count = 0;

        while (fileInput.hasNext() && count < categories.length) {
            categories[count] = fileInput.next();
            amounts[count] = fileInput.nextInt();
            count++;
        }

        fileInput.close();
        return count;
    }

    public static void printExpenses(String[] categories, int[] amounts, int count) {

        System.out.println("Expenses read from file:");
        for (int i = 0; i < count; i++) {
            System.out.println(categories[i] + ": $" + amounts[i]);
        }
    }

    public static int calculateTotal(int[] amounts, int count) {

        int total = 0;
        for (int i = 0; i < count; i++) {
            total = total + amounts[i];
        }
        return total;
    }

    // returns the index of the biggest expense
    public static int findHighest(int[] amounts, int count) {

        int highest = 0;
        for (int i = 1; i < count; i++) {
            if (amounts[i] > amounts[highest]) {
                highest = i;
            }
        }
        return highest;
    }

    public static int findLowest(int[] amounts, int count) {

        int lowest = 0;
        for (int i = 1; i < count; i++) {
            if (amounts[i] < amounts[lowest]) {
                lowest = i;
            }
        }
        return lowest;
    }


    public static void sortByAmount(String[] categories, int[] amounts, int count) {

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {

                if (amounts[j] < amounts[j + 1]) {

                    int tempAmount = amounts[j];
                    amounts[j] = amounts[j + 1];
                    amounts[j + 1] = tempAmount;

                    String tempCategory = categories[j];
                    categories[j] = categories[j + 1];
                    categories[j + 1] = tempCategory;
                }
            }
        }
    }

    public static void writeReport(String[] categories, int[] amounts, int count,
            int total, int budget) throws FileNotFoundException {

        PrintWriter out = new PrintWriter("report.txt");

        out.println("Expense Report:");
        out.println("------------------------------");

        for (int i = 0; i < count; i++) {
            out.println(categories[i] + ": $" + amounts[i]);
        }

        out.println();
        out.println("Total Expenses: $" + total);
        out.println("Highest Expense: " + categories[0] + " ($" + amounts[0] + ")");
        out.println("Lowest Expense: " + categories[count - 1] + " ($" + amounts[count - 1] + ")");

        out.println();
        out.println("Budget: $" + budget);

        if (total > budget) {
            out.println("Status: Over budget by $" + (total - budget));
        } else {
            out.println("Status: Under budget by $" + (budget - total));
        }

        out.close();
    }
}
