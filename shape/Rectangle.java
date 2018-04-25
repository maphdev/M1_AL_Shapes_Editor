package shape;

import canvas.RenderShape;

public class Rectangle extends AShape {

	// constructor
	public Rectangle(IPoint2D position, double rotation, int color, double width, double height, double rounding) {
		super(position, rotation, color);
		_width = width;
		_height = height;
		_rounding = rounding;
	}

	// getters - setters
	public double getWidth() {
		return _width;
	}
	
	public void setWidth(double w) {
		_width = w;
	}
	
	public double getHeight() {
		return _height;
	}

	public void setHeight(double h) {
		_height = h;
	}
	
	public double getRounding() {
		return _rounding;
	}
	
	public void setRounding(double r) {
		_rounding = r;
	}
	
	public void draw(RenderShape render) {
		render.draw(this);
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

	// object members
	private double _width;
	private double _height;
	private double _rounding;
}
