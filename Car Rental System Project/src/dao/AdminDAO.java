package dao;

import model.Admin;
import util.DBConnection;
import java.sql.*;

public class AdminDAO {
    public boolean updateAdmin(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE admin SET username = ?, password = ? WHERE id = 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            int rows = stmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public Admin login(String username, String password) {
        Admin admin = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
