/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package qlnv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public int getID() {
        return id;
    }

    public String toString() {
        return "ID: " + id + ", Ten: " + name + ", Tuoi: " + age + ", Phong ban: " + department + ", Ma: " + code + ", He so Luong: " + salaryRate;
    }
}

public class QLNV {
    private static List<Employee> employeeList = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeEmployees();

        while (true) {
            System.out.println("\nQuan ly Nhan vien");
            System.out.println("1. Danh sach Nhan vien");
            System.out.println("2. Them Nhan vien");
            System.out.println("3. Xoa Nhan vien");
            System.out.println("4. Thoat");
            System.out.print("Lua chon: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayEmployeeList();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void initializeEmployees() {
        for (int i = 0; i < 10; i++) {
            employeeList.add(new Employee(nextId++, "TenNhanvien" + (i + 1), 22 + i, "PhongBan" + (i % 3 + 1), "Ma" + (100 + i), 1000 + i * 1000));
        }
    }

    private static void displayEmployeeList() {
        System.out.println("\nDanh sach Nhan vien:");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    private static void addEmployee() {
        System.out.println("\nThong tin Nhan vien:");
        System.out.print("Ten: ");
        String name = scanner.nextLine();
        System.out.print("Tuoi: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Phong ban: ");
        String department = scanner.nextLine();
        System.out.print("Ma: ");
        String code = scanner.nextLine();
        System.out.print("He so Luong: ");
        double salaryRate = scanner.nextDouble();

        employeeList.add(new Employee(nextId++, name, age, department, code, salaryRate));
        System.out.println("Thanh cong!");
    }

    private static void deleteEmployee() {
        System.out.print("\nNhap ID Nhan vien muon xoa: ");
        int idToDelete = scanner.nextInt();
        boolean found = false;
        for (Employee employee : employeeList) {
            if (employee.getID() == idToDelete) {
                employeeList.remove(employee);
                found = true;
                System.out.println("Nhan vien co ID " + idToDelete + " da duoc xoa!");
                break;
            }
        }
        if (!found) {
            System.out.println("Khong co Nhan vien nao co ID " + idToDelete + "!");
        }
    }
}
