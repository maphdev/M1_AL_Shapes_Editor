package shape;

public abstract class AShape implements IShape {
	
	// constructor
	public AShape(Point2DCartesian position, double rotation, int color) {
		_position = position.clone();
		_rotation = rotation;
		_rotationCenter = new Point2DCartesian();
		_color = color;
	}
	
	// getters - setters
	public Point2DCartesian getPosition() {
		return _position;
	}
	
	public void setPosition(Point2DCartesian p) {
		_position = p.clone();
	}
	
	public double getRotation() {
		return _rotation;
	}
	
	public void setRotation(double r) {
		_rotation = r;
	}
	
	public Point2DCartesian getRotationCenter() {
		return _rotationCenter;
	}
	
	public void setRotationCenter(Point2DCartesian p) {
		_rotationCenter = p.clone();
	}
	
	public int getColor() {
		return _color;
	}
	
	public void setColor(int c) {
		_color = c;
	}
	
	// methods
	public void rotate(double r) {
		_rotation += r;
	}
	
	public void translate(double x, double y) {
		_position.translate(x, y);
	}
	
	public AShape clone(){
		AShape s = null;
		try {
			s = (AShape) super.clone();
			s._position = _position.clone();
			s._rotationCenter = _rotationCenter.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return s;
    }
	
	public abstract boolean equals(IShape shape);

	public String toString() {
		StringBuilder str = new StringBuilder("Position : ");
		str.append(_position.toString());
		str.append("\nRotation : ");
		str.append(Double.toString(getRotation()));
		str.append("\nRotation center : ");
		str.append(_rotationCenter.toString());
		str.append("\nColor : ");
		str.append(Integer.toString(getColor()));
		str.append("\n");
		return str.toString();
	}

	public abstract void updateRotationCenter();
	
	// object members
	private Point2DCartesian _position;
	private double _rotation;
	private Point2DCartesian _rotationCenter;
	private int _color;
}
