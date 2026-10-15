//Name: Damani Chung

import java.util.Scanner;

public class lab2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = input.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter " + n + " integers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println();
        System.out.println("Menu:");
        System.out.println("1. Print array");
        System.out.println("2. Find maximum");
        System.out.println("3. Find minimum");
        System.out.println("4. Find average");
        System.out.println("5. Search for a number");
        System.out.println("6. Reverse array");
        System.out.println("7. Exit");

        int choice = 0;

        while (choice != 7) {

            System.out.println();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    printArray(arr);
                    break;
                case 2:
                    System.out.println("Maximum value = " + findMax(arr));
                    break;
                case 3:
                    System.out.println("Minimum value = " + findMin(arr));
                    break;
                case 4:
                    System.out.printf("Average value = %.2f%n", findAverage(arr));
                    break;
                case 5:
                    System.out.print("Enter number to search for: ");
                    int key = input.nextInt();
                    int index = search(arr, key);
                    if (index == -1) {
                        System.out.println(key + " not found in the array.");
                    } else {
                        System.out.println(key + " found at index " + index);
                    }
                    break;
                case 6:
                    reverseArray(arr);
                    System.out.println("Array reversed.");
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-7.");
            }
        }

        input.close();
    }

    // prints all elements
    public static void printArray(int[] arr) {
        System.out.print("Array =");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    // returns the largest element
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    // returns the smallest element
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    // returns the average of all elements
    public static double findAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / arr.length;
    }

    // returns the index of key, or -1 if not found
    public static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    // reverses the array in place by swapping from both ends
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
