package gui;

import CMPT270.Main;

import javax.swing.JFrame;

/**
 * Class to hold the Frame that involves the operations of main menu
 *
 */
public class MainMenuFrame extends JFrame {
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 400;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the operations that involve the petstore
     */
    public MainMenuFrame()
    {
        setTitle("Main Menu");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        MainMenuPanel panel = new MainMenuPanel();
        add(panel);
    }

    public static void main(String[] args)
    {
        MainMenuFrame frame = new MainMenuFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
}
