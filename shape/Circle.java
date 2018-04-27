package shape;

import render.RenderShape;

public class Circle extends AShape {

    private double radius;
    private double area;
	
	public Circle(IPoint2D position, double rotation, int color, double radius) {
		super(position, rotation, color);
		this.radius = radius;
		updateArea();
	}
	
    public double getArea(){
    	return area;
    }

    public Point2DCartesian getCenter(){
    	return getPosition().clone();
    }

    public void setCenter(Point2DCartesian p){
    	setPosition(p.clone());
    }

    public double getRadius(){
    	return radius;
    }

    public void setRadius(double radius){
    	this.radius = radius;
    	updateArea();
    }

    public Circle clone(){
    	return new Circle(getPosition(), getRotation(), getColor(), getRadius());
    }

    public String toString(){
		StringBuffer str = new StringBuffer("Cercle de centre ");
		str.append(getPosition().toString());
		str.append(", de rayon ");
		str.append(radius);
		str.append(" et d'aire ");
		str.append(area);
		str.append(".");
		return str.toString();
    }

    public boolean equals(Circle c){
		if(this == c)
		    return true;
		if(c == null)
		    return false;
		if(getClass() != c.getClass())
		    return false;
		return getPosition().equals(c.getPosition()) && radius == c.radius;
    }

    public boolean equals(IShape s){
    	if(s instanceof Circle)
	    	return equals((Circle)s);
		return false;
    }

    private void updateArea(){
    	area = Math.PI * radius * radius;
    }

	@Override
	public boolean belongsTo(double posX, double posY) {
		double dist = Math.sqrt( (getPosition().getX()-posX)*(getPosition().getX()-posX) + (getPosition().getY()-posY)*(getPosition().getY()-posY) );
		return dist <= getRadius();
	}

	@Override
	public void draw(RenderShape render) {
		render.draw(this);		
	}

}
