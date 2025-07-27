/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class Worker {

    private String code;
    private String name;
    private int age;
    private double salary;
    private String workLocation;

    public Worker() {
    }

    public Worker(String code, String name, int age, double salary, String workLocation) {
        if (code == null || code.trim().isEmpty() || name == null || name.trim().isEmpty() || age < 18 || age > 50 || salary <= 0 || workLocation == null || workLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input! Please enter again: ");
        }
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Code cannot be empty!");
        }
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 50) {
            throw new IllegalArgumentException("Age must be in range {18, 50}.");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater than 0!");
        }
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        if (workLocation == null || workLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Work Location cannot be empty!");
        }
        this.workLocation = workLocation;
    }

    public void input() {
        setCode(Validation.getString("Enter Code: "));
        setName(Validation.getString("Enter Name: "));
        setAge(Validation.getAge("Enter Age: "));
        setSalary(Validation.getSalary("Enter Salary: "));
        setWorkLocation(Validation.getString("Enter work location: "));
    }
}
