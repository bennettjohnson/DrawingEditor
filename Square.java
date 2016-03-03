import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;
/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Shape
{
    // The center of the Circle shape
    private Point2D.Double center;
    
    // The Radius of the Circle shape
    private double radius;
    
    // The color of the Circle shape
    private Color color;
    
    // The Ellipse2D object that is drawn
    private Rectangle2D.Double square;
    
    /**
     * Circle constructor
     * 
     * @param center    The center of the Circle shape
     * @param radius    The radius of the Circle shape
     * @param color     The color of the Circle shape
     */
    public Square(Point2D.Double center, double radius, Color color)
    {
        // Initialize Shape object as super
        super(center, radius, color);
        
        // Instansiate instance variables with passed parameters
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.square = new Rectangle2D.Double(this.center.getX() + (radius / 2), this.center.getY()  + (radius / 2), this.radius, this.radius);
    }
    /**
     * Abstract implementation of the abstract method draw that exists in the shape
     * object.
     * 
     * @param g2        Graphics2D object passed by paint component
     * @param filled    Toggle fill parameter
     */
    public void draw(Graphics2D g2, boolean filled)
    {
        // Set color to current color
        g2.setColor(this.color);
        
        // Fill object if filled is true, otherwise false
        if(filled)
        {
            g2.fill(this.square);
        }else{
            g2.draw(this.square);
        }
    }
    /**
     * Abstract implementation of the abstract method isInside that exists in the sd
     * shape object.
     * 
     * @param point The point at which to check is inside this shape
     * @return  Returns true if point exists in this shape, false otherwise
     */
    public boolean isInside(Point2D.Double point)
    {
        // Check if the coordinates exist within this shape
        return this.square.contains(point);
    }
    /**
     * Abstract implementation of the abstract method isOnBorder that exists in
     * the shape object.
     * 
     * @param point The point at which tocheck is approximately on the border of this shape
     * @return Returns true if point exists near the border, false otherwise
     */
    public boolean isOnBorder(Point2D.Double point)
    {
        // To be implemented
        return false;
    }
    public Rectangle2D.Double getSquare()
    {
        return this.square;
    }
    public void translate(double x, double y)
    {
        double xDelta = x - (this.square.getWidth() / 2);
        double yDelta = y - (this.square.getHeight() / 2);
        this.center.setLocation(x, y);
        this.square.setFrame(xDelta, yDelta, this.square.getWidth(), this.square.getHeight());
    }
}
