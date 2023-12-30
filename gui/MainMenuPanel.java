package gui;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * Panel to hold the buttons for the main menu
 */
public class MainMenuPanel extends JPanel {

    public MainMenuPanel() {
        //animal operations button
        JButton addButton = new JButton("Animal Operations");
        addButton.setMaximumSize(addButton.getPreferredSize());
        add(addButton);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                AnimalOperationsFrame frame = new AnimalOperationsFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        //staff member operations button
        JButton addButtonstaff = new JButton("Staff Operations");
        addButtonstaff.setMaximumSize(addButtonstaff.getPreferredSize());
        add(addButtonstaff);
        addButtonstaff.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButtonstaff.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                StaffOperationsFrame frame = new  StaffOperationsFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        //add kennel assignments button
        JButton addButtonKennel = new JButton("Kennel Assignments");
        addButtonKennel.setMaximumSize(addButtonstaff.getPreferredSize());
        add(addButtonKennel);
        addButtonKennel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButtonKennel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                JFrame kframe = new JFrame();
                kframe.setLocation(300, 300);
                kframe.setSize(600, 800);
                kframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                kframe.setVisible(true);

                KennelsPanel kennelPanel = new KennelsPanel();
                kframe.add(kennelPanel);
                kennelPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                kennelPanel.setMaximumSize(kennelPanel.getPreferredSize());
            }
        });
        add(Box.createVerticalGlue());

        //exit button
        final JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(exitButton.getPreferredSize());
        add(exitButton);
        exitButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        exitButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                exitButton.getTopLevelAncestor().setVisible(false);
            }
        });
        add(Box.createVerticalGlue());


    }
}
