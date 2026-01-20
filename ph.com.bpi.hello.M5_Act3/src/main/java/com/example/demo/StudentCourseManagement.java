package com.example.demo;


import java.sql.*;
import java.util.Scanner;

public class StudentCourseManagement {

    private static final String DB_URL =
            "jdbc:postgresql://localhost:5432/training_db";
    private static final String DB_USER = "SPWAJE";    
    private static final String DB_PASS = "";          

  
public static void main(String[] args) {

    try (Connection conn = DriverManager.getConnection(
            DB_URL, DB_USER, DB_PASS);
         Scanner sc = new Scanner(System.in)) {

        while (true) {
            System.out.println("\n===== STUDENT COURSE MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Show Students");
            System.out.println("4. Show Courses");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    addStudent(conn, sc);
                    break;
                case 2:
                    addCourse(conn, sc);
                    break;
                case 3:
                    showStudents(conn);
                    break;
                case 4:
                    showCourses(conn);
                    break;
                case 0:
                    System.out.println("Exiting application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


     
    private static void addStudent(Connection conn, Scanner sc)
            throws SQLException {

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        String sql =
                "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, email);
            ps.executeUpdate();
            System.out.println("Student added successfully!");
        }
    }

  
    private static void addCourse(Connection conn, Scanner sc)
            throws SQLException {

        System.out.print("Enter student ID: ");
        int studentId = sc.nextInt();
        sc.nextLine();

        // Validate student
        String checkSql = "SELECT 1 FROM students WHERE id = ?";
        try (PreparedStatement check = conn.prepareStatement(checkSql)) {
            check.setInt(1, studentId);
            ResultSet rs = check.executeQuery();
            if (!rs.next()) {
                System.out.println("Invalid student ID!");
                return;
            }
        }

        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        System.out.print("Enter grade: ");
        int grade = sc.nextInt();
        sc.nextLine();

        String sql =
                "INSERT INTO courses (course, grade, student_id) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, course);
            ps.setInt(2, grade);
            ps.setInt(3, studentId);
            ps.executeUpdate();
            System.out.println("Course added successfully!");
        }
    }

 
    private static void showStudents(Connection conn)
            throws SQLException {

        String sql =
                "SELECT id, name, age, email FROM students ORDER BY id";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nID | Name | Age | Email");
            System.out.println("------------------------------------");

            while (rs.next()) {
                System.out.printf(
                        "%-2d | %-16s | %-3d | %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                );
            }
        }
    }

 
    private static void showCourses(Connection conn)
            throws SQLException {


String sql =
        "SELECT c.id, c.course, c.grade, s.name " +
        "FROM courses c " +
        "JOIN students s ON c.student_id = s.id " +
        "ORDER BY c.id";


        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\nID | Course | Grade | Student Name");
            System.out.println("------------------------------------");

            while (rs.next()) {
                System.out.printf(
                        "%-2d | %-8s | %-5d | %s%n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4)
                );
            }
        }
    }
}
