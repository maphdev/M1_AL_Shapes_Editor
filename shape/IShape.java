package shape;

public interface IShape extends Cloneable {
	// position
	Point2DCartesian getPosition();
	void setPosition(Point2DCartesian p);
	
	// rotation
	double getRotation();
	void setRotation(double r);
	
	// rotation center
	Point2DCartesian getRotationCenter();
	void setRotationCenter(Point2DCartesian p);

	// color
	int getColor();
	void setColor(int c);
	
	// methods
	void rotate(double r);
	void translate(double x, double y);

	// canonical form
	IShape clone();
	boolean equals(IShape shape);
	String toString();
}
