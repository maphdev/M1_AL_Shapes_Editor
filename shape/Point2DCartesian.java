package shape;

public class Point2DCartesian implements IPoint2D {
	
	// constructor
    public Point2DCartesian(){
    }
    
    public Point2DCartesian(double x, double y){
    	_x = x;
    	_y = y;
    }
    
    // getters/setters
    public double getX(){
    	return _x;
    }

    public void	setX(double x){
    	_x = x;
    }

    public double getY(){
    	return _y;
    }

    public void	setY(double y){
    	_y = y;
    }
    
    // methods
    public void translate(double x, double y) {
    	_x += x;
    	_y += y;
    }
    
    public Point2DCartesian clone(){
        Point2DCartesian p = null;
        try {
            p = (Point2DCartesian) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    	return p;
    }
    
    public boolean equals(Point2DCartesian p){
    	return _x == p.getX() && _y == p.getY();
    }

    public boolean equals(IPoint2D p) {
        if (p instanceof Point2DCartesian)
            return equals((Point2DCartesian)p);
        return Math.abs(getX() - p.getX()) < EPSILON && Math.abs(getY() - p.getY()) < EPSILON;
    }
    
    public String toString(){
    	StringBuilder str = new StringBuilder("(");
    	str.append(_x);
    	str.append(", ");
    	str.append(_y);
    	str.append(")");
    	return str.toString();
    }
    
    // object members
    private double _x, _y;
    
}
