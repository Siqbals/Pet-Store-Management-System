package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import containers.AnimalMapAccess;
import containers.StaffMapAccess;
import entities.Animal;
import entities.StaffMember;

/**
 * staff operations panel
 * class to call and add the staff operation buttons
 */
public class StaffOperationsPanel extends JPanel {
    JTextField textField;
    public StaffOperationsPanel() {
        // add a button to add a new staff Member
        JButton addButton = new JButton("Add StaffMember ");
        addButton.setMaximumSize(addButton.getPreferredSize());
        add(addButton);
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                StaffAddFrame frame = new StaffAddFrame();
                frame.setLocation(300, 300);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
        add(Box.createVerticalGlue());

        StaffAccessPanel accessPanel = new StaffAccessPanel();
        add(accessPanel);
        add(Box.createVerticalGlue());
        ListAllBtn();

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

    /**
     * ListAllBtn() - lists all staff members in the petstore
     * @precond - StaffMapAccess
     */
    private void ListAllBtn() {
        JButton listAllButton = new JButton("List all staff");
        listAllButton.setMaximumSize(listAllButton.getPreferredSize());
        add(listAllButton);
        listAllButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        listAllButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                Collection<StaffMember> allStaff = StaffMapAccess.getInstance().values();
                String animalsToShow = "";
                for (StaffMember a : allStaff)
                {
                    animalsToShow = animalsToShow + a + "\n";
                }
                if (animalsToShow.equals(""))
                    animalsToShow = "None";
                JOptionPane.showMessageDialog(null, animalsToShow);
            }
        });
        add(Box.createVerticalGlue());
    }
}
