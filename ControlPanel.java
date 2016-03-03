import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * A Specialized class of JPanel that displays buttons to 
 * call the corresponding method of a passed DrawingPanel object.
 * 
 * @author Bennett Johnson
 * @version v0.1a
 */
public class ControlPanel extends JPanel
{
    // Private variable to hold the DrawingPanel object that is passed in the constructor
    private DrawingPanel panel;
    
    // Private variable that holds the JPanel object displayColor that displays the current drawing color.
    private JPanel displayColor;
    /**
     * Populates the ControlPanel object with a series of buttons and panels to give
     * control a DrawingPanel object. Uses a JPanel to display current information 
     * relevant to the user.
     */
    public ControlPanel(DrawingPanel panel)
    {
        // Set the passed DrawingPanel object to the panel private variable
        this.panel = panel;
        
        // Create new event handler from EventListener object
        EventListener listener = new EventListener();
        
        // Create and add the event handler(listener) to a new JButton object with the label of "Pick Color", adds to JPanel class.
        JButton pickColor = new JButton("Pick Color");
        pickColor.addActionListener(listener);
        add(pickColor);
        
        // Create a JPanel object inside the instance variable displayColor that displays the current color passed from the DrawingPanel object by setting its background to the current color, adds to JPanel
        this.displayColor = new JPanel();
        displayColor.setBackground(this.panel.getColor());
        add(displayColor);
        
        // Create and add the event handler(listener) to a new JButton object with the label of "Add Square", adds to JPanel
        JButton addSquare = new JButton("Add Square");
        addSquare.addActionListener(listener);
        add(addSquare);
        
        // Create and add the event handler(listener) to a new JButton object with the label of "Add Circle", adds to JPanel
        JButton addCircle = new JButton("Add Circle");
        addCircle.addActionListener(listener);
        add(addCircle);
    }
    /**
     * Calls the pickColor method from the DrawingPanel object and sets the background
     * of displayColor to the current color.
     */
    public void chooseColor()
    {
        // Call pickColor from the DrawingPanel object
        this.panel.pickColor();
        
        // Set the background of displayColor to the current color.
        this.displayColor.setBackground(this.panel.getColor());
    }
    /**
     * Calls the addSquare method from the DrawingPanel object.
     */
    public void addSquare()
    {
        // Calls addSquare
        this.panel.addSquare();
    }
    /**
     * Calls the addCircle method from the DrawingPanel object.
     */
    public void addCircle()
    {
        // Calls addCircle
        this.panel.addCircle();
    }
    /**
     * An event listener that listens to buttons that are being pressed and calls the corresponding method.
     * 
     * @authod Bennett Johnson
     * @version v0.1a
     */
    class EventListener implements ActionListener
    {
        /**
         * Overrides the ActionListener objects actionPreformed and calls methods according
         * to the corresponding button.
         * 
         * @param event an ActionEvent object that is passed by the constructor of ActionListener
         */
        public void actionPerformed(ActionEvent event)
        {
            // Check if buttton is pressed and calls the corresponding methods accordingly
            switch(event.getActionCommand())
            {
                // Checks if "Pick Color" button was pressed and calls chooseColor method accordingly
                case "Pick Color":
                    chooseColor();
                    break;
                // Checks if "Add Square" button was pressed and calls addSquare method accordingly
                case "Add Square":
                    addSquare();
                    break;
                // Checks if "Add Circle" button was pressed and calls addCircle method accordingly
                case "Add Circle":
                    addCircle();
                    break;
            }
        }
    }
}
