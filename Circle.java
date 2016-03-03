import java.awt.*;
import java.awt.geom.*;
/**
 * A Circle Shape class that draws a Circle with specific requirements.
 * 
 * @author Bennett Johnson 
 * @version v0.1a
 */
public class Circle extends Shape
{
    // The center of the Circle shape
    private Point2D.Double center;
    
    // The Radius of the Circle shape
    private double radius;
    
    // The color of the Circle shape
    private Color color;
    
    // The Ellipse2D object that is drawn
    private Ellipse2D.Double circle;
    
    /**
     * Circle constructor
     * 
     * @param center    The center of the Circle shape
     * @param radius    The radius of the Circle shape
     * @param color     The color of the Circle shape
     */
    public Circle(Point2D.Double center, double radius, Color color)
    {
        // Initialize Shape object as super
        super(center, radius, color);
        
        // Instansiate instance variables with passed parameters
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.circle = new Ellipse2D.Double(this.center.getX(), this.center.getY(), this.radius, this.radius);
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
            g2.fill(this.circle);
        }else{
            g2.draw(this.circle);
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
        return this.circle.contains(point);
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
    public Ellipse2D.Double getCircle()
    {
        return this.circle;
    }
    public void translate(double x, double y)
    {
        double xDelta = x - (this.circle.getWidth() / 2);
        double yDelta = y - (this.circle.getHeight() / 2);
        this.center.setLocation(x, y);
        this.circle.setFrame(xDelta, yDelta, this.circle.getWidth(), this.circle.getHeight());
    }
}
