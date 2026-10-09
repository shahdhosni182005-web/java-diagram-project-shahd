package model;

import java.time.LocalDate;

/** Employee paid per hour, with overtime beyond 40 hours. */
public class HourlyEmployee extends Employee {
    private static final double REGULAR_HOURS = 40;

    private double hourlyRate;
    private double hoursWorked;
    private double overtimeRate; // multiplier, e.g. 1.5

    public HourlyEmployee(int id, String name, Gender gender, LocalDate hireDate,
                          double hourlyRate, double hoursWorked, double overtimeRate) {
        super(id, name, gender, hireDate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.overtimeRate = overtimeRate;
    }

    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    public double getOvertimeRate() { return overtimeRate; }
    public void setOvertimeRate(double overtimeRate) { this.overtimeRate = overtimeRate; }

    @Override
    public double calculateSalary() {
        if (hoursWorked <= REGULAR_HOURS) {
            return hoursWorked * hourlyRate;
        }
        double overtime = hoursWorked - REGULAR_HOURS;
        return REGULAR_HOURS * hourlyRate + overtime * hourlyRate * overtimeRate;
    }

    @Override
    public String toString() {
        return "[Hourly] " + super.toString()
                + String.format(", Rate: %.2f, Hours: %.1f, Overtime x%.1f, Salary: %.2f",
                hourlyRate, hoursWorked, overtimeRate, calculateSalary());
    }
}
