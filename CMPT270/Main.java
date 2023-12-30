package CMPT270;

import gui.AnimalOperationsFrame;
import gui.*;

import javax.swing.*;

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
public class Main
{

    public static void main(String[] args)
    {
        //edit the staff remove option for drop accosication, fix this pls
        CreatePetStoreFrame frame = new CreatePetStoreFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
