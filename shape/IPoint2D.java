package shape;

public interface IPoint2D extends Cloneable{
    double getX();
    void setX(double x);

    double getY();
    void setY(double y);

    void translate(double x, double y);

    Point2DCartesian clone();
    boolean equals(IPoint2D p);
    String toString();

    static final double EPSILON = 1E-6;
}
