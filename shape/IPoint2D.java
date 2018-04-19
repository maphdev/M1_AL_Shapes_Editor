package shape;

public interface IPoint2D extends Cloneable{
    public double getX();
    public void setX(double x);

    public double getY();
    public void setY(double y);

    public void translate(double x, double y);
    public void rotate(IPoint2D p, double degree);

    public Point2DCartesian clone();
    public boolean equals(IPoint2D p);
    public String toString();

    static final double EPSILON = 1E-6;
}
