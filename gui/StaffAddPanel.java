package gui;

import commands.AddStaff;
import commands.CommandArguments;
import entities.Manager;
import entities.StaffMember;

import javax.swing.*;
import java.awt.*;

public class StaffAddPanel extends JPanel {

    /**
     * A label and text box to enter the staff's first name
     */
    private ValueEntryPanel fnamePanel;

    /**
     * A label and text box to enter the staff's last name
     */
    private ValueEntryPanel lnamePanel;

    /**
     * A label and text box to enter the staff's SIN
     */
    private ValueEntryPanel sinPanel;

    /**
     * A label and text box to enter the staff's employee ID
     */
    private ValueEntryPanel idPanel;

    /**
     * A checkbox to indicate whether the staff is a manager
     */
    private JCheckBox isMgrCheckbox;

    /**
     * A button to submit the new staff member
     */
    private JButton submitButton;

    /**
     * A text area to be used to display an error if one should occur.
     */
    JTextArea error;

    public StaffAddPanel() {
        this.fnamePanel = new ValueEntryPanel("First name");
        this.lnamePanel = new ValueEntryPanel("Last name");
        this.idPanel = new ValueEntryPanel("Employee ID");
        this.sinPanel = new ValueEntryPanel("SIN");
        this.isMgrCheckbox = new JCheckBox("Manager");
        this.submitButton = new JButton("Submit");
        this.error = null; // not shown until an error occurs

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(Box.createVerticalGlue());

        // add a label with a prompt to enter the animal info
        JLabel prompt = new JLabel("Enter Employee Information");
        prompt.setMaximumSize(prompt.getPreferredSize());
        this.add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createVerticalGlue());

        // Add the input panels
        this.add(fnamePanel);
        this.add(Box.createVerticalGlue());
        this.add(lnamePanel);
        this.add(Box.createVerticalGlue());
        this.add(sinPanel);
        this.add(Box.createVerticalGlue());
        this.add(idPanel);
        this.add(Box.createVerticalGlue());
        this.add(isMgrCheckbox);

        // Add the submit button
        this.submitButton.addActionListener(e -> this.submit());
        this.add(this.submitButton);
    }

    private void submit() {
        // Delete the error message if there is one
        if (this.error != null) {
            this.remove(error);
            this.error = null;
        }

        // Get the user input from the input panels
        String fname = fnamePanel.getValueAsString();
        String lname = lnamePanel.getValueAsString();
        String sin = sinPanel.getValueAsString();
        String id = idPanel.getValueAsString();

        // Make the command object
        AddStaff addStaffCommand = new AddStaff();
        CommandArguments args = new CommandArguments();
        args.sFirstName = fname;
        args.sLastName = lname;
        args.sSIN = sin;
        args.sID = id;
        args.response = this.isMgrCheckbox.isSelected() ? "Y" : "N";
        addStaffCommand.setCommnadArguments(args);

        // Execute the command
        addStaffCommand.execute();

        // Check whether it worked
        if (addStaffCommand.wasSuccessful()) {
            // Close the window if it worked
            getTopLevelAncestor().setVisible(false);
        }
        else {
            // Set the error message if it didn't work
            this.error = new JTextArea(SplitString.at(addStaffCommand.getErrorMessage(), 40));
            this.add(error);
            this.revalidate();  // re-draw the window since we changed it.
        }
    }


}
