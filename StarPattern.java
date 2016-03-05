import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

/**
 * Star-like shape creator
 */
public class StarPattern {
	/**
	 * Create star-like shape
	 * @param arms number of outer vertices
	 * @param center center point coordinates of shape
	 * @param innerRadius distance from center to inner vertices
	 * @param outerRadius distance from center to outer vertices
	 * @return star-like shape
	 */
	public static Shape create(int arms, Point center, double innerRadius, double outerRadius) {
		double angle = 3.141592653589793 / (double)arms;
        GeneralPath path = new GeneralPath();
        int i = 0;
        while (i < 2 * arms) {
            double r = (i & 1) == 0 ? outerRadius : innerRadius;
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
