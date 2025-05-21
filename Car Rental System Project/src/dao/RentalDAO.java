package dao;
import model.Rental;
import util.DBConnection;
import java.sql.*; import java.util.*;


public class RentalDAO {
    public boolean addRental(Rental rental) {
        boolean success = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO rental (car_id, customer_id, rental_date, return_date) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, rental.getCarId());
            pst.setInt(2, rental.getCustomerId());
            pst.setDate(3, rental.getRentalDate());
            pst.setDate(4, rental.getReturnDate());

            int rowsAffected = pst.executeUpdate();
            success = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }


    public void deleteRental(int rentalId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM rentals WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, rentalId);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Rental record deleted successfully!");
            else
                System.out.println("Rental ID not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRental(Rental rental) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE rentals SET customer_id = ?, car_id = ?, rental_date = ?, return_date = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, rental.getCustomerId());
            stmt.setInt(2, rental.getCarId());
            stmt.setDate(3, rental.getRentalDate());
            stmt.setDate(4, rental.getReturnDate());
            stmt.setInt(5, rental.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Rental record updated successfully!");
            else
                System.out.println("Rental ID not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public List<Rental> getAllRentals() {
        List<Rental> rentals = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM rentals";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Rental rental = new Rental();
                rental.setId(rs.getInt("id"));
                rental.setCustomerId(rs.getInt("customer_id"));
                rental.setCarId(rs.getInt("car_id"));
                rental.setRentalDate(rs.getDate("rental_date"));
                rental.setReturnDate(rs.getDate("return_date"));
                rentals.add(rental);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return rentals;
    }
}