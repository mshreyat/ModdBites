package com.moodapp.pages;

import com.moodapp.main.MoodApp2;
import com.moodapp.ui.UIHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginPage extends JPanel {
        JTextField emailField;
        JPasswordField passwordField;
        MoodApp2 app;

        public LoginPage(MoodApp2 app) {
            this.app = app;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(new Color(240, 255, 255)); // Light cyan background
            setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30)); // Padding

            JLabel titleLabel = new JLabel("Login");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
            titleLabel.setForeground(new Color(0, 100, 0)); // Dark green header color
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(titleLabel);

            add(Box.createVerticalStrut(20)); // Space between components

            add(UIHelper.createLabel("Email:"));
            emailField = new JTextField();
            add(emailField);
            emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

            add(UIHelper.createLabel("Password:"));
            passwordField = new JPasswordField();
            add(passwordField);
            passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

            add(Box.createVerticalStrut(20)); // Space

            JButton loginButton = new JButton("Login");
            loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            loginButton.setBackground(new Color(0, 191, 255)); // Light blue button
            loginButton.setForeground(Color.WHITE);
            loginButton.setFocusPainted(false);
            loginButton.setFont(new Font("Arial", Font.BOLD, 16));
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String email = emailField.getText();
                    String password = new String(passwordField.getPassword());

                    // Validate inputs
                    if (email.isEmpty() || password.isEmpty()) {
                        JOptionPane.showMessageDialog(LoginPage.this, "Please enter both email and password!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (app.users.containsKey(email) && app.users.get(email).equals(password)) {
                        JOptionPane.showMessageDialog(LoginPage.this, "Login Successful!");
                        app.cardLayout.show(app.container, "address");  // Navigate to AddressPage
                    } else {
                        JOptionPane.showMessageDialog(LoginPage.this, "Invalid Credentials!");
                    }
                }
            });
            add(loginButton);
        }

    }
}
