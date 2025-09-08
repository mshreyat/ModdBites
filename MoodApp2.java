package com.moodapp.main;

import com.moodapp.pages.SignUpPage;
import com.moodapp.pages.LoginPage;
import com.moodapp.pages.QuestionnairePage;
import com.moodapp.pages.CartPage;
import com.moodapp.pages.PaymentPage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MoodApp2 {
    JFrame frame;
    CardLayout cardLayout;
    JPanel container;
    HashMap<String, String> users; // Simulating a user database
    ArrayList<String> cart; // Cart to store selected items

    public MoodApp2() {
        // Initialize user database (for demo purposes)
        users = new HashMap<>();
        cart = new ArrayList<>(); // Initialize the cart

        // Create the main frame
        frame = new JFrame("MoodApp2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // CardLayout to switch between screens
        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        // Add pages to the container
        container.add(new SignUpPage(this), "signup");
        container.add(new LoginPage(this), "login");
        container.add(new QuestionnairePage(this), "questionnaire");
        container.add(new CartPage(this), "cart"); // Add the cart page
        container.add(new PaymentPage(this), "payment"); // Add the payment page

        // Set the initial page
        cardLayout.show(container, "signup");

        // Add the container to the frame
        frame.add(container);
        frame.setVisible(true);
    }

    // Method to switch screens
    public void showScreen(String screenName) {
        cardLayout.show(container, screenName);
        // Update cart display when returning to cart
        if (screenName.equals("cart")) {
            ((CartPage) container.getComponent(3)).updateCartDisplay();
        }
    }

    public static void main(String[] args) {
        new MoodApp2();
    }
}
