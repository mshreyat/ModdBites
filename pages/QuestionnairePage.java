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

public class QuestionnairePage {
    class QuestionnairePage extends JPanel {
        MoodApp2 app;
        JComboBox<String> flavorOptions;
        JComboBox<String> textureOptions;
        JComboBox<String> weatherOptions;
        JComboBox<String> dietOptions;
        JComboBox<String> newOrOldOptions;


        public QuestionnairePage(MoodApp2 app) {
            this.app = app;
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(new Color(245, 245, 220)); // Beige background
            setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

            JLabel titleLabel = new JLabel("Mood Questionnaire");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
            titleLabel.setForeground(new Color(128, 0, 0)); // Dark red header color
            titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(titleLabel);

            add(Box.createVerticalStrut(20)); // Space

            add(UIHelper.createLabel("What type of cuisine or flavors are you in the mood for today?"));
            String[] flavors = {"Spicy", "Sweet", "Savory", "Other"};
            flavorOptions = new JComboBox<>(flavors);
            add(flavorOptions);
            flavorOptions.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            flavorOptions.setToolTipText("Select your preferred flavor");

            add(UIHelper.createLabel("Are you craving something light, filling, or a specific texture?"));
            String[] textures = {"Light", "Filling", "Crispy", "Creamy"};
            textureOptions = new JComboBox<>(textures);
            add(textureOptions);
            textureOptions.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            textureOptions.setToolTipText("Choose texture or filling preference");

            add(UIHelper.createLabel("What kind of weather are you experiencing today?"));
            String[] weathers = {"Sunny", "Rainy", "Cold", "Hot"};
            weatherOptions = new JComboBox<>(weathers);
            add(weatherOptions);
            weatherOptions.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            weatherOptions.setToolTipText("Select weather condition");

            add(UIHelper.createLabel("Do you have any dietary restrictions?"));
            String[] diets = {"None", "Vegetarian", "Vegan", "Gluten-Free", "Other"};
            dietOptions = new JComboBox<>(diets);
            add(dietOptions);
            dietOptions.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            dietOptions.setToolTipText("Choose dietary restriction");

            add(UIHelper.createLabel("Are you looking for something new or a favorite you know?"));
            String[] newOrOld = {"New", "Old"};
            newOrOldOptions = new JComboBox<>(newOrOld);
            add(newOrOldOptions);
            newOrOldOptions.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
            newOrOldOptions.setToolTipText("Select new or old preference");

            add(Box.createVerticalStrut(20)); // Space

            JButton submitButton = new JButton("Submit");
            submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            submitButton.setBackground(new Color(0, 128, 0)); // Dark green button
            submitButton.setForeground(Color.WHITE);
            submitButton.setFocusPainted(false);
            submitButton.setFont(new Font("Arial", Font.BOLD, 16));
            submitButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Collect user responses
                    String flavor = (String) flavorOptions.getSelectedItem();
                    String texture = (String) textureOptions.getSelectedItem();
                    String weather = (String) weatherOptions.getSelectedItem();
                    String diet = (String) dietOptions.getSelectedItem();
                    String newOrOld = (String) newOrOldOptions.getSelectedItem();

                    // Show selected preferences in a dialog
                    JOptionPane.showMessageDialog(QuestionnairePage.this,
                            "Your mood is 'HAPPY' \n recommending ICE CREAM"
                    );

                    // Move to ice cream shop recommendation page
                    app.showScreen("icecreamshops");
                }
            });

            add(submitButton);
        }
    }
}
