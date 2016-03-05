import java.awt.BasicStroke;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Arc2D;

/**
 * Concrete shape - pacman
 */
public class PacmanShape extends AbstractShape {

	/**
	 * @param width
	 * @param height
	 * @param paint
	 * @param stroke
	 */
	public PacmanShape(int width, int height, Paint paint, BasicStroke stroke) {
		super(width, height, paint, stroke, createShape(width, height));
	}

	private static Shape createShape(int width, int height){
		return new Arc2D.Double((double)(- width) / 2.0, (double)(- height) / 2.0, width, height, 30.0, 300.0, 2);
	}
}
