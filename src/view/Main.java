/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.WorkerManagement;
import model.SalaryStatus;
import model.Worker;
import utils.Validation;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String[] args) throws Exception {
        WorkerManagement wm = new WorkerManagement();
        while (true) {
            int choice = getMenu();
            double amount;

            switch (choice) {
                case 1:
                    System.out.println("--------- Add Worker ---------");
                    Worker w = new Worker();
                    w.input();
                    wm.addWorker(w);
                    break;
                case 2:
                    System.out.println("------- Up Salary -------");
                    String codeUp = Validation.getString("Enter code: ");
                    amount = Validation.getDoubleInRange("Enter amount: ", Double.MIN_VALUE, Double.MAX_VALUE);
                    wm.changeSalary(SalaryStatus.UP, codeUp, amount);
                    System.out.println("Up Salary successful!");
                    break;
                case 3:
                    System.out.println("------- Down Salary -------");
                    String codeDown = Validation.getString("Enter code: ");
                    amount = Validation.getDoubleInRange("Enter amount: ", Double.MIN_VALUE, Double.MAX_VALUE);
                    wm.changeSalary(SalaryStatus.DOWN, codeDown, amount);
                    System.out.println("Down Salary successful!");
                    break;
                case 4:
                    System.out.println("-------------------- Display Information Salary --------------------");
                    System.out.printf("%-7s%-15s%-10s%-10s%-10s%-20s\n", "Code", "Name", "Age", "Salary", "Status", "Date");
                    wm.getInformationSalary();
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Invalid choice! Please enter again: ");
            }
            System.out.println();
        }
    }

    public static int getMenu() {
        System.out.println("======== Worker Management ========");
        System.out.println("1. Add Worker");
        System.out.println("2. Up salary");
        System.out.println("3. Down salary");
        System.out.println("4. Display Information salary");
        System.out.println("5. Exit");
        int choice = Validation.getIntInRange("Enter your choice: ", 1, 5);
        return choice;
    }

}
