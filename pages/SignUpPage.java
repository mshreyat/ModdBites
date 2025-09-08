package com.moodapp.pages;

import com.moodapp.main.MoodApp2;
import com.moodapp.ui.UIHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPage extends JPanel {
    JTextField nameField, emailField;
    JPasswordField passwordField;
    MoodApp2 app;

    public SignUpPage(MoodApp2 app) {
        this.app = app;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255, 248, 220)); // Light pastel background
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30)); // Add padding

        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(34, 139, 34)); // Green header color
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        add(Box.createVerticalStrut(20)); // Space between components

        add(UIHelper.createLabel("Name:"));
        nameField = new JTextField();
        add(nameField);
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        add(UIHelper.createLabel("Email:"));
        emailField = new JTextField();
        add(emailField);
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        add(UIHelper.createLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        add(Box.createVerticalStrut(20)); // Space

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUpButton.setBackground(new Color(30, 144, 255)); // Bright blue button
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFocusPainted(false);
        signUpButton.setFont(new Font("Arial", Font.BOLD, 16));
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                // Validate user inputs
                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(SignUpPage.this, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Simulate storing user info
                app.users.put(email, password);
                JOptionPane.showMessageDialog(SignUpPage.this, "Sign-Up Successful!");

                // Clear fields
                nameField.setText("");
                emailField.setText("");
                passwordField.setText("");

                // Move to login page
                app.showScreen("login");
            }
        });
        add(signUpButton);
    }
}
