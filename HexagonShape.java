import java.awt.BasicStroke;
import java.awt.Paint;
import java.awt.Point;

/**
 * Concrete shape - rectangle
 */
public class HexagonShape extends AbstractShape {

	/**
	 * @param width
	 * @param height
	 * @param paint
	 * @param stroke
	 */
	public HexagonShape(int width, int height, Paint paint, BasicStroke stroke) {
		super(width, height, paint, stroke, StarPattern.create(3, new Point(0, 0), (double)width / 2.0, (double)width / 2.0));
	}
}
