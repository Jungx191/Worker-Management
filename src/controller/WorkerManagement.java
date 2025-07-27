/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import model.History;
import model.SalaryStatus;
import model.Worker;

/**
 *
 * @author ADMIN
 */
public class WorkerManagement {

    private final ArrayList<Worker> workerList;

    private final ArrayList<History> history;

    public WorkerManagement() {
        this.workerList = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public void addWorker(Worker w) {
        if (checkIdExist(w.getCode())) {
            System.err.println("Code already existed!");
        } else {
            workerList.add(w);
            System.out.println("Worker added successfull!");
        }
    }

    public void changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        if (workerList.isEmpty()) {
            System.err.println("No worker available!");
            return;
        }

        Worker wor = getWorkerByCode(code);
        if (wor == null) {
            System.err.println("No worker found!");
            return;
        }

        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0!");
        }

        if (status == SalaryStatus.UP) {
            wor.setSalary(wor.getSalary() + amount);
            history.add(new History(wor.getCode(), wor.getSalary(), SalaryStatus.UP, getCurrentTime()));

        } else {
            if (amount > wor.getSalary()) {
                throw new Exception("Cannot reduce salary by more than current salary!");
            }

            wor.setSalary(wor.getSalary() - amount);
            history.add(new History(wor.getCode(), wor.getSalary(), SalaryStatus.DOWN, getCurrentTime()));
        }
    }

    public void getInformationSalary() {
        if (history.isEmpty()) {
            System.err.println("No worker available!");
        }

        Collections.sort(history);
        for (History h : history) {
            Worker w = getWorkerByCode(h.getCode());
            if (w != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                System.out.printf("%-7s%-15s%-10d%-10.2f%-10s%-20s\n",
                        h.getCode(), w.getName(), w.getAge(), h.getNewSalary(),
                        h.getStatus(), dateFormat.format(h.getDate()));
            }
        }
    }

    private boolean checkIdExist(String code) {
        for (Worker worker : workerList) {
            if (worker.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;

    }

    private Worker getWorkerByCode(String code) {
        for (Worker wor : workerList) {
            if (wor.getCode().equalsIgnoreCase(code)) {
                return wor;
            }
        }
        return null;
    }

    private Date getCurrentTime() {
        return new Date();
    }
}
