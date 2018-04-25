package shape;

import canvas.RenderShape;

public class Polygon extends AShape {
	
	// constructor
	public Polygon(IPoint2D position, double rotation, int color, int nbSides, double lengthSide) {
		super(position, rotation, color);
		_nbSides = nbSides;
		_lengthSide = lengthSide;
	}
	
	// getters - setters
	public int getNbSides() {
		return _nbSides;
	}
	
	public void setNbSides(int nbSides) {
		_nbSides = nbSides;
	}
	
	public double getLengthSide() {
		return _lengthSide;
	}
	
	public void setLengthSide(double lengthSide) {
		_lengthSide = lengthSide;
	}
	
	public void draw(RenderShape render) {
		render.draw(this);
	}
	
	// methods
	@Override
	public Polygon clone()  {
		return (Polygon) super.clone();
	}
	
	@Override
	public boolean equals(IShape shape) {
		return shape instanceof Polygon && equals((Polygon)shape);
	}
	
	public boolean equals(Polygon p) {
		if(this == p)
			return true;
		if(p == null)
			return false;
		if(this.getClass() != p.getClass())
			return false;
		return getPosition().equals(p.getPosition()) 
				&& getRotation() == p.getRotation() 
				&& getColor() == p.getColor()
				&& getNbSides() == p.getNbSides()
				&& getLengthSide() == p.getLengthSide();
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("Number of sides : ");
		str.append(Double.toString(getNbSides()));
		str.append("\nLength of side : ");
		str.append(Double.toString(getLengthSide()));
		str.append("\n");
		return super.toString() + str.toString();
	}

	// object members
	private int _nbSides;
	private double _lengthSide;
}
