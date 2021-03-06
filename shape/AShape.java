package shape;

import java.util.List;

import render.RenderShape;

public abstract class AShape implements IShape {
	
	// constructor
	public AShape(IPoint2D position, double rotation, int color) {
		_position = position.clone();
		_rotation = rotation;
		_color = color;
	}
	
	public void add(IShape s) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(IShape s) {
		throw new UnsupportedOperationException();
	}
	
	public List<IShape> getGroupShapes(){
		throw new UnsupportedOperationException();
	}
	
	// getters - setters
	public Point2DCartesian getPosition() {
		return _position;
	}
	
	public void setPosition(double posX, double posY) {
		_position = new Point2DCartesian(posX, posY);
	}
	
	public void setPosition(IPoint2D p) {
		_position = p.clone();
	}
	
	public double getRotation() {
		return _rotation;
	}
	
	public void setRotation(double degree) {
		_rotation = degree;
	}
	
	public int getColor() {
		return _color;
	}
	
	public void setColor(int c) {
		_color = c;
	}
	
	// methods
	public void rotate(IPoint2D p, double degree) {
		_rotation += degree;
		_position.rotate(p, degree);
	}
	public void rotate(double posX, double posY, double degree) {
		rotate(new Point2DCartesian(posX, posY), degree);
	}
	
	public void translate(double x, double y) {
		_position.translate(x, y);
	}
	
	public abstract boolean belongsTo(double posX, double posY);
	
	public abstract void draw(RenderShape render);
	
	public AShape clone() {
		AShape s = null;
		try {
			s = (AShape) super.clone();
			s._position = _position.clone();
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
		str.append("\nColor : ");
		str.append(Integer.toString(getColor()));
		str.append("\n");
		return str.toString();
	}
	
	// object members
	private Point2DCartesian _position;
	private double _rotation;
	private int _color;
}
