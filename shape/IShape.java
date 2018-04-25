package shape;

import canvas.RenderShape;

public interface IShape extends Cloneable {
	// position
	public IPoint2D getPosition();
	public void setPosition(IPoint2D p);

	// color
	public int getColor();
	public void setColor(int c);
	
	// methods
	public void rotate(IPoint2D p, double degree);
	public void translate(double x, double y);
	
	public void draw(RenderShape render);

	// canonical form
	public IShape clone();
	public boolean equals(IShape shape);
	public String toString();
}
