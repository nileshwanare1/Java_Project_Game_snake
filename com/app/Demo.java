package com.app;
import java.lang.*;
import java.sql.*;

public class Demo {
    private static final String DB_URL = "jdbc:mysql://database-1.cfy8amg82e1p.ap-south-1.rds.amazonaws.com:3306/mysqlfirst";
    private static final String USER = "admin";
    private static final String PASS = "Password1234";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver"; // Check correct class name for your driver version
    public static void main(String[] args) {
            // Retrieve these details from the AWS RDS console or environment variables

                try {
                    // Optional: Load the driver class (modern JDBC 4.0+ drivers register automatically)
                    Class.forName(DRIVER_CLASS);

                    // Establish the connection using try-with-resources for automatic resource closing
                    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                        System.out.println("Connection to AWS RDS established successfully!");

                        // You can now create a Statement and execute queries
                        try (Statement stmt = conn.createStatement();
                             ResultSet rs = stmt.executeQuery("SELECT * FROM Student")) {

                            while (rs.next()) {
                                // Process the result set
                                System.out.println("Data: " + rs.getString("sid")  +  rs.getString( "name"));
                            }
                        }
                        String sql = "INSERT INTO Student (sid, name) VALUES (?, ?)";
                        // Use correct parameter indexes (1-based) and matching types
                        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                            pstmt.setInt(1, 9);               // sid as an int
                            pstmt.setString(2, "Prakash");    // name as a String

                            int rowsInserted = pstmt.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("A new Student was inserted successfully!");
                            }
                        }
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    System.err.println("Database connection failed.");
                }
            }
        }
