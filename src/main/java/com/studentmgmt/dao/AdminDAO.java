package com.studentmgmt.dao;

import com.studentmgmt.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    private static final String SELECT_ADMIN_QUERY = "SELECT * FROM admin WHERE username = ? AND password = ?";

    public static boolean validateAdmin(String username, String password) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_ADMIN_QUERY)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // If a record exists, admin is valid

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

