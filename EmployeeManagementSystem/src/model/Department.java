package model;

import java.util.ArrayList;
import java.util.List;

/** A department that has a manager and owns a list of employees. */
public class Department {
    private int id;
    private String name;
    private Employee manager;
    private List<Employee> employees;

    public Department(int id, String name, Employee manager, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.employees = new ArrayList<>();
        if (employees != null) {
            for (Employee e : employees) {
                addEmployee(e);
            }
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    public void addEmployee(Employee employee) {
        if (employee != null && !employees.contains(employee)) {
            employees.add(employee);
            employee.setDepartment(this);
        }
    }

    public void removeEmployee(int employeeId) {
        Employee e = findEmployee(employeeId);
        if (e != null) {
            employees.remove(e);
            e.setDepartment(null);
        }
    }

    /** Returns the employee with the given id, or null if not found. */
    public Employee findEmployee(int employeeId) {
        for (Employee e : employees) {
            if (e.getId() == employeeId) {
                return e;
            }
        }
        return null;
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }

    public void printAllEmployees() {
        System.out.println("Employees in " + name + ":");
        for (Employee e : employees) {
            System.out.println("  " + e);
        }
    }

    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "', manager="
                + (manager != null ? manager.getName() : "None")
                + ", employees=" + employees.size() + "}";
    }
}
