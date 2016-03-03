import java.awt.*;
import java.awt.geom.*;
/**
 * An abstract blanket class for shapes such as Rectangles and Circles
 * 
 * @author Bennett Johnson 
 * @version v0.1a
 */
public abstract class Shape
{
    // The center of the shape to draw
    private Point2D.Double center;
    
    // The radius of the shape to draw
    private double radius;
    
    // The color of the shape to draw.
    private Color color;
    
    /**
     * Creates a shape with the center at the specified point and with
     * the specified radius and color.
     * 
     * @param center    The center of the shape to draw
     * @param radius    The radius of the shape to draw
     * @param color     The color of the shape to draw
     */
    public Shape(Point2D.Double center, double radius, Color color)
    {
        // Set the corresponding instance variables to the passed local variables
        this.center = center;
        this.radius = radius;
        this.color = color;
    }
    
    /**
     * Returns the center of the shape.
     * 
     * @return  The Point2D.Double object that is the center of the object
     */
    public Point2D.Double getCenter()
    {
        // Return the center of the shape
        return this.center;
    }
    
    /**
     * Returns the radius of the shape.
     * 
     * @return  A double value that represents the radius of the shape
     */
    public double getRadius()
    {
        // Return the radius of the shape
        return this.radius;
    }
    
    /**
     * Displaces the center of the shape by the passed X and Y values.
     * 
     * @param x A double value that represents the amount of columns to displace the shape with
     * @param y A double value that represents the amount of rows to displace the shape with
     */
    public void move(double x, double y)
    {
        // Offset the center
        this.center.setLocation(this.center.getX() + x, this.center.getY() + y);
    }
    
    /**
     * Sets the radius of the shape.
     * 
     * @param radius    The new radius of the shape
     */
    public void setRadius(double radius)
    {
        // Set radius to the new radius
        this.radius = radius;
    }
    
    /**
     * Returns true if the point lies approximately on the border of this 
     * shape, false otherwise.
     * 
     * @param point The proposed point at which to check whether or not is inside of the shape
     */
    public abstract boolean isInside(Point2D.Double point);
    
    /**
     * Returns true if the point passed lies approximately on the border of this
     * shape, false otherwise.
     * 
     * @param point The proposed point to check whether is on the border
     */
    public abstract boolean isOnBorder(Point2D.Double point);
    
    /**
     * Draws this shape. Draws a filled shape if filled is true, and a hollow shape
     * otherwise.
     * 
     * @param g2        The casted Graphics object that is passed by the frame
     * @param filled    Boolean that toggles whether or not this shape is filled 
     */
    public abstract void draw(Graphics2D g2, boolean filled);
    
    public abstract void translate(double x, double y);
}
