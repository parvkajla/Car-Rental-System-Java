package ui;

import dao.RentalDAO;
import model.Rental;
import javax.swing.*;
import java.awt.*;

public class RentCarFrame extends JFrame {
    public RentCarFrame() {
        setTitle("Rent Car");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Customer ID:"));
        JTextField customerIdField = new JTextField();
        add(customerIdField);

        add(new JLabel("Car ID:"));
        JTextField carIdField = new JTextField();
        add(carIdField);

        add(new JLabel("Days:"));
        JTextField daysField = new JTextField();
        add(daysField);

        JButton rentButton = new JButton("Rent");
        add(rentButton);

        JButton cancelButton = new JButton("Cancel");
        add(cancelButton);

        rentButton.addActionListener(e -> {
            int customerId = Integer.parseInt(customerIdField.getText());
            int carId = Integer.parseInt(carIdField.getText());
            int days = Integer.parseInt(daysField.getText());

            Rental rent = new Rental();
            rent.setCustomerId(customerId);
            rent.setCarId(carId);
            rent.setDays(days);

            boolean success = new RentalDAO().addRental(rent);
            if (success) {
                JOptionPane.showMessageDialog(this, "Car rented successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to rent car!");
            }
        }

        cancelButton.addActionListener(e -> dispose());
    }
}
