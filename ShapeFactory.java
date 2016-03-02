import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ShapeFactory {
    public Shape shape;
    public BasicStroke stroke = new BasicStroke(3.0f);
    public Paint paint;
    public int width = 25;
    public int height = 25;

    /**
    * <p>Creates shape instance<p>
    * <p>For example: new ShapeFactory(11)<p>
    * Type of shape consists of two digits for shape and style
    * Shapes: <br/>
    *   1 - hexagon<br/>
    *   3 - 5 point star<br/>
    *   5 - rectangle<br/>
    *   7 - triangle<br/>
    *   9 - pacman<br/>
    * Styles:<br/>
    *   1 - black 3px borders<br/>
    *   3 - defaults (black 3px borders)<br/>
    *   4 - black 7px borders<br/>
    *   7 - gradient white to gray 3px borders<br/>
    *   8 - red 3px borders<br/>
    * @param shape_type type of shape that consists of two digits
    * @throws Error
    */
    public ShapeFactory(int shape_type) {
        switch (shape_type / 10) {
            case 1: {
                this.shape = ShapeFactory.createStar(3, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 2.0);
                break;
            }
            case 3: {
                this.shape = ShapeFactory.createStar(5, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 4.0);
                break;
            }
            case 5: {
                this.shape = new Rectangle2D.Double((double)(- this.width) / 2.0, (double)(- this.height) / 2.0, this.width, this.height);
                break;
            }
            case 7: {
                GeneralPath path = new GeneralPath();
                double tmp_height = Math.sqrt(2.0) / 2.0 * (double)this.height;
                path.moveTo((double)((- this.width) / 2), - tmp_height);
                path.lineTo(0.0, - tmp_height);
                path.lineTo((double)(this.width / 2), tmp_height);
                path.closePath();
                this.shape = path;
                break;
            }
            case 9: {
                this.shape = new Arc2D.Double((double)(- this.width) / 2.0, (double)(- this.height) / 2.0, this.width, this.height, 30.0, 300.0, 2);
                break;
            }
            default: {
                throw new Error("type is nusupported");
            }
        }
        switch (shape_type % 10) {
            case 1: {
                this.stroke = new BasicStroke(3.0f);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                this.stroke = new BasicStroke(7.0f);
                break;
            }
            case 7: {
                this.paint = new GradientPaint(- this.width, - this.height, Color.white, this.width, this.height, Color.gray, true);
                break;
            }
            case 8: {
                this.paint = Color.red;
                break;
            }
            default: {
                throw new Error("type is nusupported");
            }
        }
    }

    private static Shape createStar(int arms, Point center, double rOuter, double rInner) {
        double angle = 3.141592653589793 / (double)arms;
        GeneralPath path = new GeneralPath();
        int i = 0;
        while (i < 2 * arms) {
            double r = (i & 1) == 0 ? rOuter : rInner;
            Point2D.Double p = new Point2D.Double((double)center.x + Math.cos((double)i * angle) * r, (double)center.y + Math.sin((double)i * angle) * r);
            if (i == 0) {
                path.moveTo(p.getX(), p.getY());
            } else {
                path.lineTo(p.getX(), p.getY());
            }
            ++i;
        }
        path.closePath();
        return path;
    }
}
