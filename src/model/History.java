/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class History implements Comparable<History> {

    private String code;
    private double newSalary;
    private SalaryStatus status;
    private Date date;

    public History() {
    }

    public History(String code, double newSalary, SalaryStatus status, Date date) {
        this.code = code;
        this.newSalary = newSalary;
        this.status = status;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }

    public SalaryStatus getStatus() {
        return status;
    }

    public void setStatus(SalaryStatus status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int compareTo(History o) {
        return this.getCode().compareTo(o.getCode());
    }
}
