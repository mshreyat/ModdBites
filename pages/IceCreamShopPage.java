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

class IceCreamShopPage extends JPanel {
    MoodApp2 app;

    public IceCreamShopPage(MoodApp2 app) {
        this.app = app;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(255, 240, 245)); // Light pink background
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titleLabel = new JLabel("Recommended Ice Cream Shops");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(new Color(255, 105, 180)); // Hot pink header color
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        add(Box.createVerticalStrut(20)); // Space

        // Placeholder for recommended shops
        JTextArea shopDisplay = new JTextArea();
        shopDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(shopDisplay);
        scrollPane.setPreferredSize(new Dimension(400, 200));
        add(scrollPane);

        // Populate with some example ice cream shops
        String recommendations = "1. Keventers\n2. Naturals";
        shopDisplay.setText(recommendations);

        JButton backButton = new JButton("add to Cart");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setBackground(new Color(173, 216, 230)); // Light blue button
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                app.showScreen("cart"); // Navigate back to the cart page
            }
        });
        add(backButton);
    }
}