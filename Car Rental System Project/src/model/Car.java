package model;
public class Car {
    private int id;
    private String brand;
    private String model;
    private boolean available;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
    private double rent;

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getRent() {
        return rent;
    }

}