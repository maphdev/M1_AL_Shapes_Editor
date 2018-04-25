package menu;

import shape.IShape;

public interface CanvasMenu {
	
	public void draw(IShape shape);
	public void add(IShape shape);
	public void delete(IShape shape);
	
}
