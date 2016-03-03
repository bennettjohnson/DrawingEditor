import javax.swing.*;
import java.awt.*;
public class DrawingEditor extends JFrame
{
    private DrawingPanel drawingPanel;
    private ControlPanel controlPanel;
    private Container container;
    public DrawingEditor(DrawingPanel dpanel, ControlPanel cpanel)
    {
        super("Drawing Editor");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.drawingPanel = dpanel;
        this.controlPanel = cpanel;
        
        this.container = getContentPane();
        
        addComponentsToFrame();
        setVisible(true);
    }
    public void addComponentsToFrame()
    {
        this.container.add(this.controlPanel, BorderLayout.SOUTH);
        this.container.add(this.drawingPanel, BorderLayout.CENTER);
    }
    
    public static void main(String[] args)
    {
        DrawingPanel dpanel = new DrawingPanel();
        
        ControlPanel cpanel = new ControlPanel(dpanel);
        DrawingEditor editor = new DrawingEditor(dpanel, cpanel);
    }
}
