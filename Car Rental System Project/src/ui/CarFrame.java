package ui;

import dao.CarDAO;
import model.Car;
import javax.swing.*;
import java.awt.*;

public class CarFrame extends JFrame {
    public CarFrame() {
        setTitle("Add Car");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Model:"));
        JTextField modelField = new JTextField();
        add(modelField);

        add(new JLabel("Rent/day:"));
        JTextField rentField = new JTextField();
        add(rentField);

        JButton addButton = new JButton("Add");
        add(addButton);

        JButton cancelButton = new JButton("Cancel");
        add(cancelButton);

        addButton.addActionListener(e -> {
            String model = modelField.getText();
            double rent = Double.parseDouble(rentField.getText());

            Car car = new Car();
            car.setModel(model);
            car.setRent(rent);

            boolean success = new CarDAO().addCar(car);


            if (success) {
                JOptionPane.showMessageDialog(this, "Car added!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add car!");
            }
        });

        cancelButton.addActionListener(e -> dispose());
    }
}
