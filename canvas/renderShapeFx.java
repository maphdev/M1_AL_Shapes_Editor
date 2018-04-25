package canvas;

import javafx.scene.Group;
import shape.GroupShapes;

public class renderShapeFx implements renderShape{
	
	private Group _root;
	private double _posX;
	private double _posY;
	
	public renderShapeFx(Group root, double posX, double posY) {
		_root = root;
		_posX = posX;
		_posY = posY;
	}
	
	public void draw(GroupShapes shape) {}
	
	public void draw(shape.Polygon shape) {}
	
	public void draw(shape.Rectangle shape) {}
	
}
