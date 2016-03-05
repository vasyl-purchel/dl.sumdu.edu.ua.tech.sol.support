import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;

/**
 * Factory to create shapes
 */
public class ShapeFactory {

	/**
	 * Shape types enumeration
	 */
	public enum ShapeType {
		NONE(0), HEXAGON(1), STAR(3), RECTANGLE(5), TRIANGLE(7), PACMAN(9);
		private int value;
		
		private ShapeType(int value){
			this.value = value;
		}
		
		/**
		 * Convert integer value to ShapeType
		 * @param value
		 * @return ShapeType, ShapeType.NONE if unsupported shape type requested
		 */
		public static ShapeType fromInt(int value){
			ShapeType[] types = ShapeType.values();
			for(int i = 0; i < types.length; i++){
				if (types[i].value == value)
					return types[i];
			}
			return NONE;
		}
	}

	/**
	 * Shape styles enumeration
	 */
	public enum ShapeStyle {
		NONE(0), THIN(1), DEFAULT(3), BOLD(4), GRADIENT(7), RED(8);
		private int value;
		
		private ShapeStyle(int value){
			this.value = value;
		}
		
		/**
		 * Convert integer value to ShapeStyle
		 * @param value
		 * @return ShapeStyle, ShapeStyle.NONE if unsupported shape style requested
		 */
		public static ShapeStyle fromInt(int value){
			ShapeStyle[] styles = ShapeStyle.values();
			for(int i = 0; i < styles.length; i++){
				if (styles[i].value == value)
					return styles[i];
			}
			return NONE;
		}
	}

	/**
	 * Create new shape with specific type and style
	 * 
	 * @param shapeType
	 * @param shapeStyle
	 * @return AbstractShape instance of requested shape type and style
	 * @throws Error if type or style are unsupported
	 */
	public static AbstractShape createShape(ShapeType shapeType, ShapeStyle shapeStyle) {
		int width = 25;
		int height = 25;
		Paint paint = Color.black;
		BasicStroke stroke = new BasicStroke(3.0f);
		switch (shapeStyle){
			case THIN:
				stroke = new BasicStroke(3.0f);
				break;
			case DEFAULT:
				break;
			case BOLD:
				stroke = new BasicStroke(7.0f);
				break;
			case GRADIENT:
				paint = new GradientPaint(- width, - height, Color.white, width, height, Color.gray, true);
				break;
			case RED:
				paint = Color.red;
				break;
			default:
				throw new Error("style is unsupported");
		}
		switch (shapeType){
			case HEXAGON: return new HexagonShape(width, height, paint, stroke);
			case STAR: return new StarShape(width, height, paint, stroke);
			case RECTANGLE: return new RectangleShape(width, height, paint, stroke);
			case TRIANGLE: return new TriangleShape(width, height, paint, stroke);
			case PACMAN: return new PacmanShape(width, height, paint, stroke);
			default: throw new Error("type is unsupported");
		}
	}
	
    /**
    * <p>Backward compatibility support to create shapes from int type<p>
    * <p>For example: new ShapeFactory.createShapeOldStyle(11)<p>
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
	public static AbstractShape createShapeOldStyle(int shapeType){
		return createShape(ShapeType.fromInt(shapeType / 10), ShapeStyle.fromInt(shapeType % 10));
	}
}
