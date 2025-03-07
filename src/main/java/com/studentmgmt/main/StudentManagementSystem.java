package com.studentmgmt.main;

import com.studentmgmt.dao.AdminDAO;
import com.studentmgmt.dao.StudentDAO;
import com.studentmgmt.model.Student;

import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDAO studentDAO = new StudentDAO(); // Create instance of StudentDAO

    public static void main(String[] args) {
        if (!authenticateAdmin()) {
            System.out.println("Invalid credentials. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. View Records");
            System.out.println("2. Add Record");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit Application");
            System.out.print("Enter your choice: ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        viewRecords();
                        break;
                    case 2:
                        addRecord();
                        break;
                    case 3:
                        updateRecord();
                        break;
                    case 4:
                        deleteRecord();
                        break;
                    case 5:
                        System.out.println("Exiting Application...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static boolean authenticateAdmin() {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();
        return AdminDAO.validateAdmin(username, password);
    }

    private static void viewRecords() {
        List<Student> students = studentDAO.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        for (Student student : students) {
            System.out.println("ID: " + student.getId() +
                    ", Name: " + student.getName() +
                    ", Age: " + student.getAge() +
                    ", Course: " + student.getCourse() +
                    ", Fees: " + student.getFees() +
                    ", Email: " + student.getEmail() +
                    ", Phone: " + student.getPhone());
        }
    }

    private static void addRecord() {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();
        System.out.print("Enter Fees: ");
        double fees = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();

        Student student = new Student(0, name, age, course, fees, email, phone);
        studentDAO.addStudent(student);
    }

    private static void updateRecord() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter New Course: ");
        String course = scanner.nextLine();
        System.out.print("Enter New Fees: ");
        double fees = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter New Phone: ");
        String phone = scanner.nextLine();

        Student student = new Student(id, name, age, course, fees, email, phone);
        studentDAO.updateStudent(student);
    }

    private static void deleteRecord() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        studentDAO.deleteStudent(id);
    }
}
