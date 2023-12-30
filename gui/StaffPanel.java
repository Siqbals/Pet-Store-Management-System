package gui;

import commands.Command;
import commands.CommandArguments;
import containers.AnimalMapAccess;
import containers.StaffMapAccess;
import entities.StaffMember;

import java.util.Collection;
import java.util.TreeMap;
import java.util.Map;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;
import entities.Manager;
import entities.Animal;
import entities.StaffMember;
import commands.AssignStaffToAnimal;
import commands.DropAssociation;

/**
 *display information for a staffMember
 */
public class StaffPanel extends JPanel{


    public StaffPanel(StaffMember staff) {
        build(staff);
    }

    /**
     * constructor method calls 3 functions for displaying staff member info and more operations
     * @param staff
     */
    private void build(StaffMember staff) {

        //print out general information of the staff member
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //(Box.createVerticalGlue());

        add(new JLabel("First Name: " + staff.getFirstName()));
        add(new JLabel("Last Name: " + staff.getLastName()));
        add(new JLabel("SIN: " + staff.getSocInsNum()));
        add(new JLabel("Employee ID: " + staff.getEmployeeID()));
        if (staff instanceof Manager){
            add(new JLabel(staff.getFirstName() + " is a Manager"));
        }
        add(new JLabel(""));

        add(new JLabel("Assigned Animals: "));
        LinkedList<Animal> animap = staff.getAssignedAnimals();
        for (int i = 0; i < animap.size(); i++){
            add(new JLabel("Name: " + animap.get(i).getName()));
            add(new JLabel("Type: " + animap.get(i).getAnimalType()));
            add(new JLabel("ID:: " + animap.get(i).getAnimalID()));
        }
        add(new JLabel(""));


        addAnimaltoStaff(staff);
        AccessStaffAnimal(staff);
        RemoveAnimal(staff);

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
     * adds animal to staff member based on ID
     * @precond - an animals ID
     * @param staff
     */
    private void addAnimaltoStaff(StaffMember staff){
        //text field and button to add and animal to the staff member list of assigned animals
        JPanel nestPanel = new JPanel();
        nestPanel.setLayout(new FlowLayout());
        nestPanel.setAlignmentX(LEFT_ALIGNMENT);

        JTextField textField = new JTextField(10);
        textField.setMaximumSize(new Dimension(100,20));
        nestPanel.add(textField);


        JButton addButton = new JButton("Add Animal ");
        addButton.setMaximumSize(addButton.getPreferredSize());
        nestPanel.add(addButton);
        add(nestPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animID = textField.getText();
                try {
                    Animal animal = AnimalMapAccess.getInstance().get(animID);
                    AssignStaffToAnimal cmd = new AssignStaffToAnimal();
                    CommandArguments cmdArguments = new CommandArguments();
                    cmdArguments.sID = staff.getEmployeeID();
                    cmdArguments.aPetID = animal.getAnimalID();
                    cmd.setCommnadArguments(cmdArguments);
                    cmd.execute();
                    if (cmd.wasSuccessful()) {
                        removeAll();
                        build(staff);
                        revalidate();
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(StaffPanel.this, cmd.getErrorMessage());
                    }
                }
                catch (NullPointerException ev) {
                    JOptionPane.showMessageDialog(StaffPanel.this, "Invalid Animal ID entered");
                }
            }
        });
    }

    /**
     * access a staff members assigned animal
     * @precond - an animal ID to access
     * @param staff
     */
    private void AccessStaffAnimal(StaffMember staff){
        //text field and button to access specific animal assigned to staff member
        JPanel nestPanel = new JPanel();
        nestPanel.setLayout(new FlowLayout());
        nestPanel.setAlignmentX(LEFT_ALIGNMENT);

        JTextField textField = new JTextField(10);
        textField.setMaximumSize(new Dimension(100,20));
        nestPanel.add(textField);

        JButton addButton = new JButton("Access Animal ");
        addButton.setMaximumSize(addButton.getPreferredSize());
        nestPanel.add(addButton);
        add(nestPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String animID = textField.getText();
                LinkedList<Animal> ani = staff.getAssignedAnimals();
                if (!(ani.contains(AnimalMapAccess.getInstance().get(animID)))) {
                    JOptionPane.showMessageDialog(StaffPanel.this, "Invalid Animal ID entered");
                }
                for (int i = 0; i < ani.size(); i++) {
                    if (animID.equals(ani.get(i).getAnimalID())) {
                        AnimalFrame accessFrame = new AnimalFrame(animID);
                        accessFrame.setLocation(300, 300);
                        accessFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        accessFrame.setVisible(true);
                        break;
                    }
                }
            }
        });
    }

    /**
     * removes an animal from the staffmembers list
     * @precond - an animal ID
     * @param staff
     */
    private void RemoveAnimal(StaffMember staff) {
        JPanel nestPanel = new JPanel();
        nestPanel.setLayout(new FlowLayout());
        nestPanel.setAlignmentX(LEFT_ALIGNMENT);

        JTextField textField = new JTextField(10);
        textField.setMaximumSize(new Dimension(100,20));
        nestPanel.add(textField);


        JButton addButton = new JButton("Remove Animal ");
        addButton.setMaximumSize(addButton.getPreferredSize());
        nestPanel.add(addButton);
        add(nestPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String AnimID = textField.getText();
                    DropAssociation cmd = new DropAssociation();
                    CommandArguments cmdArguments = new CommandArguments();
                    cmdArguments.aPetID = AnimID;
                    cmdArguments.sID = staff.getEmployeeID();
                    cmd.setCommnadArguments(cmdArguments);
                    cmd.execute();
                    if (cmd.wasSuccessful()){
                        removeAll();
                        build(staff);
                        revalidate();
                    }
                    else {
                        JOptionPane.showMessageDialog(StaffPanel.this, cmd.getErrorMessage());
                    }
                }
                catch (NullPointerException ev) {
                    JOptionPane.showMessageDialog(StaffPanel.this, "Invalid Animal ID entered");
                }

            }
        });
    }
}
