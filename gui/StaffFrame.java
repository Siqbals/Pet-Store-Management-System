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

import javax.swing.*;


import containers.AnimalMapAccess;
import containers.StaffMapAccess;
import entities.Animal;
import entities.StaffMember;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

/**
 * The frame for the window to display the information for staffMember
 */
public class StaffFrame extends JFrame
{
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 350;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * Create the frame to display the information for staff.
     * @param staffID the ID of the animal
     * @precond ID of an animal
     */
    public StaffFrame(String staffid)
    {
        StaffMember staff = StaffMapAccess.getInstance().get(staffid);
        if (staff != null)
        {
            setTitle(staff.getFirstName() + " (" + staffid + ")");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            StaffPanel panel = new StaffPanel(staff);
            add(panel);



        } else
        {
            throw new RuntimeException("Invalid ID " + staff);
        }
    }

    public static final long serialVersionUID = 1;
}
