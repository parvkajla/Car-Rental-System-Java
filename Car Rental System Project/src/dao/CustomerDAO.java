package dao;
import model.Customer;
import util.DBConnection;
import java.sql.*; import java.util.*;


public class CustomerDAO {
    public boolean addCustomer(Customer customer) {
        boolean success = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO customer (name, phone) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, customer.getName());
            pst.setString(2, customer.getPhone());

            int rowsAffected = pst.executeUpdate();
            success = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }


    public void deleteCustomer(int customerId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM customers WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, customerId);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Customer deleted successfully!");
            else
                System.out.println("Customer ID not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(Customer customer) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE customers SET name = ?, email = ?, phone = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getPhone());
            stmt.setInt(4, customer.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Customer updated successfully!");
            else
                System.out.println("Customer ID not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM customers";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customers.add(customer);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return customers;
    }
}