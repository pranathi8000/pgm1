package pgm1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class Person {
    String name;
    LocalDate dob;

    // Constructor
    Person(String name, String dobStr) {
        this.name = name;

        // Check if format is DD-MM-YYYY
        if (dobStr.contains("-") && dobStr.indexOf('-') == 2) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            this.dob = LocalDate.parse(dobStr, formatter);
        } else {
            this.dob = LocalDate.parse(dobStr); // Default format: YYYY-MM-DD
        }
    }

    // Display person name and age
    void displayPersonDetails() {
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Employee inherits Person
class Employee extends Person {
    int emp_id;
    double salary;

    // Constructor
    Employee(String name, String dobStr, int emp_id, double salary) {
        super(name, dobStr); // Call constructor of Person
        this.emp_id = emp_id;
        this.salary = salary;
    }

    // Display employee details
    void displayEmployeeDetails() {
        displayPersonDetails(); // From Person class
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Salary: " + salary);
    }
}

public class MainProgram {
    public static void main(String[] args) {
        Employee emp = new Employee("Ravi", "15-08-1995", 101, 50000.0);
        emp.displayEmployeeDetails();
    }
}
