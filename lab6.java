//Name: Damani Chung
import java.util.*;
class Company {

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];

        Date today = new Date();

        employees[0] = new Employee("Alice", 50000.0, today);
        employees[1] = new Employee("Bob", 60000.0, today);
        employees[2] = new Employee();
        employees[3] = new Employee("Carol", 75000.0, today);
        employees[4] = new Employee();

        double total = 0;
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getDetails());
            total += employees[i].getSalary();
        }

        double average = total / employees.length;
        System.out.printf("Average Salary: %.2f%n", average);
        System.out.println("Next available ID: " + Employee.getNextId());
    }
}

class Employee {

    private String name;
    private double salary;
    private Date hireDate;

    private static int nextId = 1;

    private int employeeId;

    public Employee() {
        name = "Unknown";
        salary = 0.0;
        hireDate = new Date();
        employeeId = nextId;
        nextId++;
    }

    public Employee(String n, double s, Date d) {
        name = n;
        salary = s;
        hireDate = d;
        employeeId = nextId;
        nextId++;
    }

    public String getDetails() {
        return "ID: " + employeeId + ", Name: " + name + ", Salary: " + salary + ", Hire Date: " + hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public static int getNextId() {
        return nextId;
    }
}
