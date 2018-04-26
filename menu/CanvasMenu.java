package menu;

import java.util.List;

import shape.IShape;

public interface CanvasMenu {
	
	public void addButtonFx(IShape shape);
	public void deleteShapeOnMenu(IShape shape);
	public void deleteShapeOnCanvas(List<IShape> shapes);
	
}
