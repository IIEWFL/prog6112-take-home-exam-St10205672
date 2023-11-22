
package progexam.q2;

/**
 *
 * @author Rebone Motshegare ST10205672
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EstateAgentApp extends JFrame {

    JComboBox<String> locationComboBox;
    private JTextField nameTextField, priceTextField, commissionTextField;
    private JTextArea reportTextArea;

    public EstateAgentApp() {
        setTitle("Estate Agent Commission Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
        String[] locations = {"Cape Town", "Durban", "Pretoria"};
        locationComboBox = new JComboBox<>(locations);
        nameTextField = new JTextField(20);
        priceTextField = new JTextField(20);
        commissionTextField = new JTextField(20);
        reportTextArea = new JTextArea(10, 30);

        // Creating  menu bar
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Creating File menu
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(exitMenuItem);

        // Creating Tools menu
        
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processReportMenuItem = new JMenuItem("Process Report");
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        JMenuItem saveReportMenuItem = new JMenuItem("Save Report");
        toolsMenu.add(processReportMenuItem);
        toolsMenu.add(clearMenuItem);
        toolsMenu.add(saveReportMenuItem);

      
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

       
        setLayout(new FlowLayout());
        add(new JLabel("Agent Location:"));
        add(locationComboBox);
        add(new JLabel("Agent Name:"));
        add(nameTextField);
        add(new JLabel("Property Price:"));
        add(priceTextField);
        add(new JLabel("Commission Percentage:"));
        add(commissionTextField);
        add(new JScrollPane(reportTextArea));

        // Adding action listeners
        //This code was adapted from Javapoint
        //Author: javapoint
        //Link:https://www.javatpoint.com/java-actionlistener
        exitMenuItem.addActionListener(e -> System.exit(0));

        processReportMenuItem.addActionListener(e -> processReport());

        clearMenuItem.addActionListener(e -> clearFields());

        saveReportMenuItem.addActionListener(e -> saveReportToFile());
    }

    private void processReport() {
        
        // Implementing the logic to calculate commission and display the report
       //This code was apated from W3schools
       //Author: W3schools
       //Link: https://www.google.com/url?q=https://www.w3schools.com/java/ref_keyword_double.asp&sa=U&ved=2ahUKEwiIrbGwidiCAxUc2wIHHc8WDDkQFnoECBkQAQ&usg=AOvVaw1DVfbW2L8VwgdKo5E2xdqr
       
        String agentLocation = String.valueOf(locationComboBox.getSelectedItem());
        String estateAgentName = nameTextField.getText();
        double propertyPrice = Double.parseDouble(priceTextField.getText());
        double commissionPercentage = Double.parseDouble(commissionTextField.getText());

        double calculatedCommission = propertyPrice * commissionPercentage;

        String report = String.format("AGENT LOCATION: %s\nAGENT NAME: %s\nPROPERTY PRICE: %s\nCOMMISSION PERCENTAGE: %s\nCALCULATED COMMISSION: %s\n",
                agentLocation, estateAgentName, propertyPrice, commissionPercentage, calculatedCommission);

        reportTextArea.setText(report);
    }

    private void clearFields() {
        
        // Implementing logic to clear input fields and text area
        
        locationComboBox.removeAllItems();
        nameTextField.setText("");
        priceTextField.setText("");
        commissionTextField.setText("");
    }

    private void saveReportToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
            writer.write(reportTextArea.getText());
            JOptionPane.showMessageDialog(this, "Report saved successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving report: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EstateAgentApp().setVisible(true));
    }
}