package shape;

public class Test {
	public static void main(String[] argv) {
		Polygon poly = new Polygon(new Point2DCartesian(5, 10), 0, 0, 3, 5);
		System.out.println(poly.toString());
		Polygon poly2 = poly.clone();
		System.out.println(poly2.toString());
		poly2.setPosition(new Point2DCartesian(1,1));
		poly2.setRotation(90);
		poly2.setLengthSide(12);
		poly2.setNbSides(12);
		poly2.setColor(0);
		System.out.println("-----------");
		System.out.println(poly.toString());
		System.out.println(poly2.toString());
		System.out.println("-----------");
		Rectangle rect = new Rectangle(new Point2DCartesian(5, 10), 0, 0, 12, 13, 2);
		System.out.println(rect.toString());
		Rectangle rect2 = rect.clone();
		System.out.println(rect2.toString());
		System.out.println("-----------");
		rect2.setWidth(50);
		System.out.println(rect.toString());
		System.out.println(rect2.toString());
	}
}
