import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
/**
 * A specialized class of JPanel that displays Shape objects based on user input from the ControlPanel
 * class.
 * 
 * @author Bennett Johnson
 * @version v0.1a
 */
public class DrawingPanel extends JPanel
{
    // The current drawing color set by the Pick color method
    private Color currentColor;
    
    // The ArrayList of Shapes set by the user
    private ArrayList<Shape> shapeList = new ArrayList<Shape>();
    /**
     * Sets the background color to white and the initial
     * drawing color to a color of your choice. 
     * Adds this as the MouseListener, MouseMotionListener, and KeyListener.Creates
     * an empty shapes list. 
     */
    public DrawingPanel()
    {
        // Sets the background of the JPanel and the current color to white
        setBackground(Color.WHITE);
        this.currentColor = Color.WHITE;
        
        // initialize mouse listener and add it to JPanel
        MouseEventListener listener = new MouseEventListener();
        addMouseMotionListener(listener);
    }
    /**
     * Get the current drawing color.
     * 
     * @return Returns the current drawing color.
     */
    public Color getColor()
    {
        // Returns the current Color
        return this.currentColor;
    }
    /**
     * Called from ControlPanel when the “Pick Color” button is clicked. 
     * Brings up a JColorChooser and sets the chosen color as the new drawing color. 
     * Leaves the drawing color unchanged if the user clicks “Cancel.”
     */
    public void pickColor()
    {
        // Sets the current color to the returned value of JColorChooser
        this.currentColor = JColorChooser.showDialog(null, "Choose a Color", null);
    }
    /**
     * Called from ControlPanel when the "Add Circle" button is clicked. 
     * Adds a new circle to the list. The new circle has its center at the center 
     * of the drawing panel, a random radius (within a reasonable range) and the 
     * current drawing color. The new circle is designated as the “active shape.
     */
    public void addCircle()
    {
        // Add a circle object to the list of shapes
        this.shapeList.add(new Circle(new Point2D.Double(100, 100), 100, this.currentColor));
    }
    /**
     * Called from ControlPanel when the "Add Square" button is clicked. 
     * Adds a new square to the list. The new square has its center at the center 
     * of the drawing panel, a random radius (within a reasonable range) and the current 
     * drawing color. The new square is designated as the “active shape.”
     */
    public void addSquare()
    {
        // Add a rectangle object to the list of shapes
        this.shapeList.add(new Square(new Point2D.Double(100, 100), 100, this.currentColor));
    }
    /**
     * Draws all the shapes in the list. The shapes should be drawn in reverse 
     * from the order in which they were added to the list. However, if one of 
     * the shapes is “picked,” then this “active shape” should be drawn 
     * last, in outline only.
     * 
     * @param g the current Graphics object for the frame
     */
    public void paintComponent(Graphics g)
    {
        // Create a Graphics2D object by a cast of the passed Graphics object
        Graphics2D g2 = (Graphics2D) g;
        
        // Call the paintComponent method of the JPanel to avoid artifacting
        super.paintComponent(g);

        // Iterate through the ArrayList of Shape objects and draw them on screen at their current position
        for(Shape shape : this.shapeList)
        {
            // Draw current iterate
            shape.draw(g2, true);
        }
        
        // Call repaint method to refresh the screen with the current shapes drawn to screen
        repaint();
    }
    /**
     * Gets the Shape ArrayList
     * 
     * @return The Shape ArrayList
     */
    public ArrayList getShapeList()
    {
        // Return the Shape ArrayList
        return this.shapeList;
    }
    public void paint()
    {
        repaint();
    }
    /**
     * The mouse listener, listens for events sent by the mouse
     * 
     * @version v0.1a
     * @author Bennett Johnson
     */
    public class MouseEventListener implements MouseMotionListener
    {
        // The shape list passed by the getShapeList method
        private ArrayList<Shape> shapeList;
        
        private boolean pressed;
        
        private Point2D.Double point = new Point2D.Double();
        /**
         * Listener for mouse drag events
         * 
         * @param event The MouseEvent object passed by the initializer
         */
        public void mouseDragged(MouseEvent event)
        {
            this.shapeList = getShapeList();
            this.point.setLocation(event.getX(), event.getY());
            for(Shape shape: this.shapeList)
            {
                if(shape.isInside(point))
                {
                    shape.translate(event.getX(), event.getY());
                    break;
                }
            }
            paint();
        }
        public void mouseMoved(MouseEvent event){}
    }
}
