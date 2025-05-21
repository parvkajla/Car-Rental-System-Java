package ui;

import dao.CustomerDAO;
import model.Customer;
import javax.swing.*;
import java.awt.*;

public class CustomerFrame extends JFrame {
    public CustomerFrame() {
        setTitle("Add Customer");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        add(nameField);

        add(new JLabel("Phone:"));
        JTextField phoneField = new JTextField();
        add(phoneField);

        JButton addButton = new JButton("Add");
        add(addButton);

        JButton cancelButton = new JButton("Cancel");
        add(cancelButton);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();

            Customer customer = new Customer();
            customer.setName(name);
            customer.setPhone(phone);

            boolean success = new CustomerDAO().addCustomer(customer);
            if (success) {
                JOptionPane.showMessageDialog(this, "Customer added!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add!");
            }
        });

        cancelButton.addActionListener(e -> dispose());
    }
}
