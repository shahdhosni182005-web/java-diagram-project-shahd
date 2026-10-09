package test;

import model.*;
import java.time.LocalDate;
import java.util.ArrayList;

/** Demo class: creates objects with sample data and exercises the system. */
public class MainTest {
    public static void main(String[] args) {
        MonthlyEmployee manager = new MonthlyEmployee(1, "Ahmed Ali", Gender.MALE,
                LocalDate.of(2018, 3, 15), 12000, 21, 10, true);
        CommissionEmployee sales = new CommissionEmployee(2, "Sara Hassan", Gender.FEMALE,
                LocalDate.of(2021, 7, 1), 5000, 0.05, 80000);
        HourlyEmployee worker = new HourlyEmployee(3, "Omar Khaled", Gender.MALE,
                LocalDate.of(2023, 1, 10), 50, 48, 1.5);

        Department dept = new Department(10, "Operations", manager, new ArrayList<>());
        dept.addEmployee(manager);
        dept.addEmployee(sales);
        dept.addEmployee(worker);

        System.out.println(dept);
        dept.printAllEmployees();
        System.out.printf("Total payroll: %.2f%n", dept.calculateTotalPayroll());

        System.out.println("\nFind employee 2: " + dept.findEmployee(2).getName());
        System.out.println("Commission earned: " + sales.calculateCommission());
        System.out.println("Extra vacation days (manager): " + manager.calculateAdditionalVacation());

        dept.removeEmployee(3);
        System.out.println("\nAfter removing employee 3:");
        dept.printAllEmployees();
        System.out.printf("Total payroll: %.2f%n", dept.calculateTotalPayroll());
    }
}
