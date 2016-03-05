import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TitlesPanel
extends JPanel
implements ActionListener {
    private Graphics2D g2d;
    private Timer animation;
    private boolean is_done = true;
    private int start_angle = 0;
    private AbstractShape shape;

    /**
    * <p>Creates panel instance<p>
    * <p>For example: new TitlesPanel(11)<p>
    * 
    * @param _shape shape style used to create shape from ShapeFactory
    * @see ShapeFactory
    */
    public TitlesPanel(int _shape) {
        this.shape = ShapeFactory.createShapeOldStyle(_shape);
        this.animation = new Timer(50, this);
        this.animation.setInitialDelay(50);
        this.animation.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (this.is_done) {
            this.repaint();
        }
    }

    private void doDrawing(Graphics g) {
        this.is_done = false;
        this.g2d = (Graphics2D)g;
        this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension size = this.getSize();
        Insets insets = this.getInsets();
        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        AbstractShape shape = this.shape;
        this.g2d.setStroke(shape.getStroke());
        this.g2d.setPaint(shape.getPaint());
        double angle = this.start_angle++;
        if (this.start_angle > 360) {
            this.start_angle = 0;
        }
        double dr = 90.0 / ((double)w / ((double)shape.getWidth() * 1.5));
        int j = shape.getHeight();
        while (j < h) {
            int i = shape.getWidth();
            while (i < w) {
                angle = angle > 360.0 ? 0.0 : angle + dr;
                AffineTransform transform = new AffineTransform();
                transform.translate(i, j);
                transform.rotate(Math.toRadians(angle));
                this.g2d.draw(transform.createTransformedShape(shape.getShape()));
                i = (int)((double)i + (double)shape.getWidth() * 1.5);
            }
            j = (int)((double)j + (double)shape.getHeight() * 1.5);
        }
        this.is_done = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.doDrawing(g);
    }
}