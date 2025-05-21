package ui;

import dao.AdminDAO;
import model.Admin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Car Rental System - Admin Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        JButton loginButton = new JButton("Login");
        add(loginButton);

        JButton exitButton = new JButton("Exit");
        add(exitButton);

        loginButton.addActionListener(e -> login());
        exitButton.addActionListener(e -> System.exit(0));
    }

    private void login() {
        String query = "SELECT * FROM admin WHERE username=? AND password=?";

        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        AdminDAO adminDAO = new AdminDAO();
        Admin admin = adminDAO.login(username, password);
        if (admin != null) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            dispose(); // close login window
            new AdminDashboardFrame().setVisible(true); // open dashboard
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
