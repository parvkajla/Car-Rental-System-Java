package model;
import java.sql.Date;
public class Rental {
    int days;
    private int id, customerId, carId;
    private Date rentalDate, returnDate;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public int getCarId() { return carId; }
    public void setCarId(int carId) { this.carId = carId; }
    public Date getRentalDate() { return rentalDate; }
    public void setRentalDate(Date rentalDate) { this.rentalDate = rentalDate; }
    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }
    public void setDays(int days) {
        this.days = days;
    }

}