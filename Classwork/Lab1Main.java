/*  Name: Damani Chung
 * Date: 09/06/2026
 */

import java.util.Random;
import java.util.Scanner;

public class Lab1Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== QUESTION 1: PROJECTILE SIMULATION =====");
        question1(input);

        System.out.println();
        System.out.println("===== QUESTION 2: SECURITY SYSTEM VALIDATOR =====");
        question2();

        input.close();
    }

    // ---------- Question 1 ----------
    public static void question1(Scanner input) {

        final double g = 9.80665;   
        final double PI = 3.14159;

        System.out.print("Enter mass (kg): ");
        double mass = input.nextDouble();

        System.out.print("Enter initial velocity (m/s): ");
        double vInitial = input.nextDouble();

        System.out.print("Enter launch angle (degrees): ");
        double angleDegrees = input.nextDouble();

        System.out.print("Enter platform height (meters): ");
        double h0 = input.nextDouble();

        System.out.print("Enter energy loss percentage (e.g. 15.5): ");
        double lossPercent = input.nextDouble();

        // A. convert the launch angle to radians
        double angleRadians = angleDegrees * (PI / 180);

        // B. break the velocity into x and y parts
        double vX = vInitial * Math.cos(angleRadians);
        double vY = vInitial * Math.sin(angleRadians);

        // C. maximum height
        double hMax = h0 + (vY * vY) / (2 * g);

        // D. kinetic and potential energy
        double KE = 0.5 * mass * vInitial * vInitial;
        double PE = mass * g * hMax;

        // E. final kinetic energy after air loss
        double KEfinal = (KE - PE) * (1 - lossPercent / 100);

        // F. final velocity
        double vFinal = Math.sqrt((2 * KEfinal) / mass);

        // G. time of flight
        double time = (vY + Math.sqrt(vY * vY + 2 * g * h0)) / g;

        // H. average velocity
        double vAvg = (vInitial + vFinal) / 2;

        // I. efficiency ratio
        double efficiency = KEfinal / KE;

        double energyLost = KE - KEfinal;

        System.out.println();
        System.out.printf("Mass: %.1f kg%n", mass);
        System.out.printf("Initial velocity: %.1f m/s at %.1f degrees%n", vInitial, angleDegrees);
        System.out.printf("Horizontal velocity: %.2f m/s%n", vX);
        System.out.printf("Vertical velocity: %.2f m/s%n", vY);
        System.out.printf("Max height: %.2f meters%n", hMax);
        System.out.printf("Kinetic energy: %.2f J%n", KE);
        System.out.printf("Potential energy: %.2f J%n", PE);
        System.out.printf("Total energy loss: %.2f J%n", energyLost);
        System.out.printf("Final velocity: %.2f m/s%n", vFinal);
        System.out.printf("Time of flight: %.2f seconds%n", time);
        System.out.printf("Average velocity: %.2f m/s%n", vAvg);
        System.out.printf("Efficiency (KE_final / KE_initial): %.2f%n", efficiency);
    }

    // ---------- Question 2 ----------
    public static void question2() {

        Random random = new Random();

        // random 4 digit code between 1000 and 9999
        int code = random.nextInt(9000) + 1000;

        // pull out each digit with / and %
        int digit1 = code / 1000;          // thousands
        int digit2 = (code / 100) % 10;    // hundreds
        int digit3 = (code / 10) % 10;     // tens
        int digit4 = code % 10;            // ones

        int sum = digit1 + digit2 + digit3 + digit4;

        // find the biggest and smallest digit
        int max = digit1;
        if (digit2 > max) max = digit2;
        if (digit3 > max) max = digit3;
        if (digit4 > max) max = digit4;

        int min = digit1;
        if (digit2 < min) min = digit2;
        if (digit3 < min) min = digit3;
        if (digit4 < min) min = digit4;

        // the four rules
        boolean startsEven = (digit1 % 2 == 0);
        boolean sumDivisibleBy5 = (sum % 5 == 0);
        boolean rangeAtLeast3 = (max - min >= 3);
        boolean hasAdjacentDuplicates = (digit1 == digit2) || (digit2 == digit3) || (digit3 == digit4);
        boolean noAdjacentDuplicates = !hasAdjacentDuplicates;

        int rulesMet = 0;
        if (startsEven) rulesMet++;
        if (sumDivisibleBy5) rulesMet++;
        if (rangeAtLeast3) rulesMet++;
        if (noAdjacentDuplicates) rulesMet++;

        System.out.println("Generated Security Code: " + code);
        System.out.println();
        System.out.println("Digits: " + digit1 + ", " + digit2 + ", " + digit3 + ", " + digit4);
        System.out.println("Sum of digits = " + sum);
        System.out.println("Starts with even? " + startsEven);
        System.out.println("Sum divisible by 5? " + sumDivisibleBy5);
        System.out.println("Max - Min >= 3? " + rangeAtLeast3);
        System.out.println("Adjacent duplicates? " + hasAdjacentDuplicates);
        System.out.println();

        if (rulesMet == 4) {
            System.out.println("Code is VALID. Welcome, Agent.");
        } else if (rulesMet >= 2) {
            System.out.println("Only " + rulesMet + " rule(s) met.");
            System.out.println("Suspicious code. Escalating to manual check.");
        } else {
            System.out.println("Only " + rulesMet + " rule(s) met.");
            System.out.println("Invalid security code. Access denied.");
        }
    }
}
