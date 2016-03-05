import java.awt.BasicStroke;
import java.awt.Paint;
import java.awt.Shape;

/**
 * Abstract shape that represents immutable shape object
 */
public abstract class AbstractShape {
	private int width;
	private int height;
	private Paint paint;
	private BasicStroke stroke;
	private Shape shape;
	
	public AbstractShape(int width, int height, Paint paint, BasicStroke stroke, Shape shape){
		this.width = width;
		this.height = height;
		this.paint = paint;
		this.stroke = stroke;
		this.shape = shape;
	}

	/**
	 * @return width
	 */
	public int getWidth(){
		return width;
	}

	/**
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @return paint
	 */
	public Paint getPaint() {
		return paint;
	}

	/**
	 * @return stroke
	 */
	public BasicStroke getStroke() {
		return stroke;
	}

	/**
	 * @return shape
	 */
	public Shape getShape() {
		return shape;
	}
}
