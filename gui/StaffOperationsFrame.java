package gui;
import javax.swing.JFrame;

/**
 * staff operations frame to hold the operations of staff
 */
public class StaffOperationsFrame extends JFrame {
    /**
     * The standard width for the frame.
     */
    public static final int DEFAULT_WIDTH = 400;

    /**
     * The standard height for the frame.
     */
    public static final int DEFAULT_HEIGHT = 200;

    /**
     * Create the frame for the operations that involve Staff
     */
    public StaffOperationsFrame()
    {
        setTitle("Staff operations");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        StaffOperationsPanel panel = new StaffOperationsPanel();
        add(panel);
    }


    public static void main(String[] args)
    {
        StaffOperationsFrame frame = new StaffOperationsFrame();
        frame.setLocation(300, 300);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
}
