package ui;

import javax.swing.*;
import java.awt.*;

public class AdminDashboardFrame extends JFrame {
    public AdminDashboardFrame() {
        setTitle("Admin Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton manageCustomersButton = new JButton("Manage Customers");
        JButton manageCarsButton = new JButton("Manage Cars");
        JButton rentCarButton = new JButton("Rent Car");
        JButton changePasswordButton = new JButton("Change Admin Password");
        JButton logoutButton = new JButton("Logout");

        add(manageCustomersButton);
        add(manageCarsButton);
        add(rentCarButton);
        add(changePasswordButton);
        add(logoutButton);

        manageCustomersButton.addActionListener(e -> new CustomerFrame().setVisible(true));
        manageCarsButton.addActionListener(e -> new CarFrame().setVisible(true));
        rentCarButton.addActionListener(e -> new RentCarFrame().setVisible(true));
        changePasswordButton.addActionListener(e -> new ChangePasswordFrame().setVisible(true));

        logoutButton.addActionListener(e -> {
            dispose(); // close dashboard
            new LoginFrame().setVisible(true); // back to login
        });
    }
}
