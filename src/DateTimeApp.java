import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DateTimeApp {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Date Input");
        frame.setTitle("Gregorian Calendar to 13 Month Calendar Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel to hold the components
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        // Set the frame visibility to true
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create JLabel for date
        JLabel dateLabel = new JLabel("Enter Date (MM/dd/yyyy):");
        dateLabel.setBounds(10, 20, 180, 25);
        panel.add(dateLabel);

        // Create JTextField for date input
        JTextField dateText = new JTextField(20);
        dateText.setBounds(200, 20, 165, 25);
        panel.add(dateText);

        // Create JButton for submitting input
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(10, 80, 150, 25);
        panel.add(submitButton);

        // Create JTextArea for displaying output
        JTextArea outputArea = new JTextArea();
        outputArea.setBounds(10, 110, 355, 125);
        outputArea.setEditable(false);
        panel.add(outputArea);

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String dateInput = dateText.getText();

                Time outime = new Time(dateInput);
                try {

                    // Call the method from the Time class
                    String newDate = outime.toString();
                    // Display the result in the output area
                    outputArea.setText("Gregorian Calendar: " + dateInput + "\n13 Month Calendar: "+ newDate);
                } catch (NumberFormatException ex) {
                    // Handle invalid number format
                    outputArea.setText("Invalid number format for days.");
                }
            }
        });
    }
}
