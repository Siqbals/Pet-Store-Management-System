package gui;

import javax.swing.*;

public class StaffAddFrame extends JFrame {

    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 350;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 300;

    /**
     * Create the frame to add a new animal
     */
    public StaffAddFrame()
    {
        this.setTitle("Staff addition");
        this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        StaffAddPanel panel = new StaffAddPanel();
        this.add(panel);
    }

    public static void main(String[] args) {
        JFrame frame = new StaffAddFrame();
        frame.setVisible(true);
    }

}
