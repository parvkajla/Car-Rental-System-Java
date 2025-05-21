package ui;

import dao.AdminDAO;
import javax.swing.*;
import java.awt.*;

public class ChangePasswordFrame extends JFrame {
    public ChangePasswordFrame() {
        setTitle("Change Admin Password");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("New Username:"));
        JTextField usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("New Password:"));
        JPasswordField passwordField = new JPasswordField();
        add(passwordField);

        JButton changeButton = new JButton("Change");
        add(changeButton);

        JButton cancelButton = new JButton("Cancel");
        add(cancelButton);

        changeButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());

            boolean success = new AdminDAO().updateAdmin(username, password);
            if (success) {
                JOptionPane.showMessageDialog(this, "Admin credentials updated!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update!");
            }
        });

        cancelButton.addActionListener(e -> dispose());
    }
}
