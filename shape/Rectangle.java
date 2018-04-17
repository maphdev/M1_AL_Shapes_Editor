package shape;

public class Rectangle extends AShape {

	// constructor
	public Rectangle(Point2DCartesian position, double rotation, int color, double width, double height, double rounding) {
		super(position, rotation, color);
		_width = width;
		_height = height;
		_rounding = rounding;
		updateRotationCenter();
	}

	// getters - setters
	public double getWidth() {
		return _width;
	}
	
	public void setWidth(double w) {
		_width = w;
		updateRotationCenter();
	}
	
	public double getHeight() {
		return _height;
	}

	public void setHeight(double h) {
		_height = h;
		updateRotationCenter();
	}
	
	public double getRounding() {
		return _rounding;
	}
	
	public void setRounding(double r) {
		_rounding = r;
	}
	
	// methods
	@Override
	public Rectangle clone() {
		return (Rectangle) super.clone();
	}

	@Override
	public boolean equals(IShape shape) {
		return shape instanceof Rectangle && equals((Rectangle)shape);
	}
	
	public boolean equals(Rectangle r) {
		if(this == r)
			return true;
		if(r == null)
			return false;
		if(this.getClass() != r.getClass())
			return false;
		return getPosition().equals(r.getPosition()) 
				&& getRotation() == r.getRotation() 
				&& getRotationCenter().equals(r.getRotationCenter()) 
				&& getColor() == r.getColor()
				&& getWidth() == r.getWidth()
				&& getHeight() == r.getWidth()
				&& getRounding() == r.getRounding();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Width : ");
		str.append(Double.toString(getWidth()));
		str.append("\nHeight : ");
		str.append(Double.toString(getHeight()));
		str.append("\nRounding : ");
		str.append(Double.toString(getRounding()));
		str.append("\n");
		return super.toString() + str.toString();
	}

	@Override
	public void updateRotationCenter() {
		setRotationCenter(new Point2DCartesian(getPosition().getX() + getWidth()/2, getPosition().getY() + getHeight()/2));
	}

	// object members
	private double _width;
	private double _height;
	private double _rounding;
}