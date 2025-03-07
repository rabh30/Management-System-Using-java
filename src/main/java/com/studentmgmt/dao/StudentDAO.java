package com.studentmgmt.dao;

import com.studentmgmt.model.Student;
import com.studentmgmt.dao.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    
    // Add a Student to the Database
    public void addStudent(Student student) {
        String query = "INSERT INTO students (name, age, course, fees, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getCourse());
            pstmt.setDouble(4, student.getFees());
            pstmt.setString(5, student.getEmail());
            pstmt.setString(6, student.getPhone());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student record added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve All Students from the Database
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setCourse(rs.getString("course"));
                student.setFees(rs.getDouble("fees"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // Update a Student Record
    public void updateStudent(Student student) {
        String query = "UPDATE students SET name=?, age=?, course=?, fees=?, email=?, phone=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getCourse());
            pstmt.setDouble(4, student.getFees());
            pstmt.setString(5, student.getEmail());
            pstmt.setString(6, student.getPhone());
            pstmt.setInt(7, student.getId());

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student record updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a Student Record
    public void deleteStudent(int studentId) {
        String query = "DELETE FROM students WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, studentId);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student record deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
