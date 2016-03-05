import java.awt.BasicStroke;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Concrete shape - rectangle
 */
public class RectangleShape extends AbstractShape {

	/**
	 * @param width
	 * @param height
	 * @param paint
	 * @param stroke
	 */
	public RectangleShape(int width, int height, Paint paint, BasicStroke stroke) {
		super(width, height, paint, stroke, createShape(width, height));
	}

	private static Shape createShape(int width, int height){
		return new Rectangle2D.Double((double)(- width) / 2.0, (double)(- height) / 2.0, width, height);
	}
}
