package dao;
import model.Car;
import util.DBConnection;
import java.sql.*; import java.util.*;


public class CarDAO {
    public boolean addCar(Car car) {
        boolean success = false;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO car (model, rent) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, car.getModel());
            pst.setDouble(2, car.getRent());

            int rowsAffected = pst.executeUpdate();
            success = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }


    public void updateCar(Car car) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE cars SET brand = ?, model = ?, available = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, car.getBrand());
            stmt.setString(2, car.getModel());
            stmt.setBoolean(3, car.isAvailable());
            stmt.setInt(4, car.getId());
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Car updated successfully!");
            else
                System.out.println("Car ID not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteCar(int carId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM cars WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, carId);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Car deleted successfully!");
            else
                System.out.println("Car ID not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM cars";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setId(rs.getInt("id"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setAvailable(rs.getBoolean("available"));
                cars.add(car);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return cars;
    }
}