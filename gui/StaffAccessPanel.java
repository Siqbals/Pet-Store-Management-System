package gui;
/*
  CMPT 270 Course Material
  Copyright (c) 2022
  All rights reserved.

  This document contains resources for homework assigned to students of
  of CMPT 270 and shall not be distributed without permission.  Posting this
  file to a public or private website, or providing this file to any person
  not registered in CMPT 270 constitutes Academic Misconduct according to
  to the University of Saskatchewan Policy on Academic Misconduct.

  Synopsis: Starter file for Assignment 6
 */

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * The panel for the access of a specific Staff.
 *
 */
public class StaffAccessPanel extends JPanel
{
    /**
     * The text field for the entry of the animal's ID
     */
    JTextField textField;

    /**
     * Create the panel with the prompt label and text field. If data is entered into the text field
     * that is not a valid int value, a brief error message is entered at the front of the text
     * field. Otherwise, a new window is created with the staff's data and operations on the
     * staff
     */
    public StaffAccessPanel()
    {
        JLabel promptLabel = new JLabel("Access staff with ID");
        add(promptLabel);
        textField = new JTextField(10);
        add(textField);
        textField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                String valueAsString = textField.getText();
                String staffID = textField.getText();
                StaffFrame frame = null;
                try
                {
                    frame = new StaffFrame(staffID);
                }
                catch (RuntimeException e)
                {
                    textField.setText("Invalid id: " + textField.getText());
                    textField.revalidate();
                    return;
                }
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
                textField.setText("");
                textField.revalidate();

            }
        });
    }

    public static final long serialVersionUID = 1;
}
