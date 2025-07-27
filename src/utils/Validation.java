/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Validation {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInRange(String mess, int min, int max) {
        while (true) {
            System.out.print(mess);
            try {
                int x = Integer.parseInt(scanner.nextLine());
                if (x < min || x > max) {
                    throw new Exception();
                }
                return x;
            } catch (NumberFormatException e) {
                System.err.println("Please input an integer!");
            } catch (Exception e) {
                System.err.println("Please input an integer between " + "[" + min + ", " + max + "]");
            }
        }
    }

    public static String getString(String mess) {
        while (true) {
            System.out.print(mess);
            String s = scanner.nextLine().trim();
            if (s.isEmpty()) {
                System.err.println("Input cannot be empty!");
            } else {
                return s;
            }

        }
    }

    public static int getAge(String mess) {
        while (true) {
            System.out.print(mess);
            try {
                int age = Integer.parseInt(scanner.nextLine());
                if (age < 18 || age > 50) {
                    throw new Exception();

                }
                return age;
            } catch (NumberFormatException e) {
                System.err.println("Please input an integer! ");

            } catch (Exception e) {
                System.err.println("Age must be in range 18 to 50. ");
            }
        }

    }

    public static double getSalary(String mess) {
        while (true) {
            System.out.print(mess);
            try {
                double salary = Double.parseDouble(scanner.nextLine().trim());
                if (salary <= 0) {
                    throw new Exception();
                }
                return salary;
            } catch (NumberFormatException e) {
                System.err.println("Please input a number!");
            } catch (Exception e) {
                System.err.println("Salary must be greater than 0! Enter again: ");
            }
        }
    }
    
    public static double getDoubleInRange(String mess, double min, double max) {
        while (true) {
            System.out.print(mess);
            try {
                double x = Double.parseDouble(scanner.nextLine());
                if (x < min || x > max) {
                    throw new Exception();
                }
                return x;
            } catch (NumberFormatException e) {
                System.err.println("Please input a double value!");
            } catch (Exception e) {
                System.err.println("Please input a double value between " + "[" + min + ", " + max + "]");
            }
        }
    }
}
