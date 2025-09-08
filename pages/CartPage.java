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

    class CartPage extends JPanel {
        MoodApp2 app;

        public CartPage(MoodApp2 app) {
            this.app = app;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(new Color(240, 255, 240)); // Light green background
            setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30)); // Padding

            JLabel titleLabel = new JLabel("Cart");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
            titleLabel.setForeground(new Color(0, 128, 0)); // Dark green header color
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(titleLabel);

            add(Box.createVerticalStrut(20)); // Space

            // Placeholder for cart items
            JTextArea cartDisplay = new JTextArea();
            cartDisplay.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(cartDisplay);
            scrollPane.setPreferredSize(new Dimension(400, 200));
            add(scrollPane);

            JButton checkoutButton = new JButton("Checkout");
            checkoutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            checkoutButton.setBackground(new Color(255, 140, 0)); // Dark orange button
            checkoutButton.setForeground(Color.WHITE);
            checkoutButton.setFocusPainted(false);
            checkoutButton.setFont(new Font("Arial", Font.BOLD, 16));
            add(checkoutButton);

            checkoutButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Move to payment page
                    app.showScreen("payment");
                }
            });
        }

        public void updateCartDisplay() {
            // This method would update the display of the cart contents
            // For demonstration, we'll simulate adding items to the cart
            // Assuming preferences have been stored
            JTextArea cartDisplay = (JTextArea)((JScrollPane)getComponent(1)).getViewport().getView();
            cartDisplay.setText("Items in cart:\n");
            cartDisplay.append("1. Selected flavors\n");
            cartDisplay.append("2. Selected textures\n");
            cartDisplay.append("3. Selected dietary options\n");
            // Add actual cart items here as needed
        }
    }
}
