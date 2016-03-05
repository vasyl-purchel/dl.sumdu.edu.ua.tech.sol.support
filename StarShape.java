import java.awt.BasicStroke;
import java.awt.Paint;
import java.awt.Point;

/**
 * Concrete shape - rectangle
 */
public class StarShape extends AbstractShape {

	/**
	 * @param width
	 * @param height
	 * @param paint
	 * @param stroke
	 */
	public StarShape(int width, int height, Paint paint, BasicStroke stroke) {
		super(width, height, paint, stroke, StarPattern.create(5, new Point(0, 0), (double)width / 4.0, (double)width / 2.0));
	}
}
