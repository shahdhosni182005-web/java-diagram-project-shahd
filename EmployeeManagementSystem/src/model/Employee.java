package model;

import java.time.LocalDate;

/** Abstract base class for all employee types. */
public abstract class Employee {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate hireDate;
    private Department department; // set when added to a Department

    public Employee(int id, String name, Gender gender, LocalDate hireDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }
    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    /** Each employee type computes its salary differently. */
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Gender: " + gender
                + ", Hired: " + hireDate
                + ", Department: " + (department != null ? department.getName() : "None");
    }
}
