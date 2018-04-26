package render;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;

import shape.GroupShapes;

public class RenderShapeFx implements RenderShape{
	
	private Group _root;
	
	public RenderShapeFx(Group root) {
		_root = root;
	}
	
	public void draw(GroupShapes shape) {}
	
	public void draw(shape.Polygon shape) {
		Polygon polyg = new Polygon(new double[]{shape.getPosition().getX(), shape.getPosition().getY()});
	}
	
	public void draw(shape.Rectangle shape) {
		Rectangle rect = new Rectangle();
		rect.setX(shape.getPosition().getX()-shape.getWidth()/2);
		rect.setY(shape.getPosition().getY()-shape.getHeight()/2);
		rect.setWidth(shape.getWidth());
		rect.setHeight(shape.getHeight());
		rect.setRotate(shape.getRotation());
		rect.setFill(Color.web(String.format("0x%06X", shape.getColor())));
		rect.setArcWidth(shape.getRounding());
		rect.setArcHeight(shape.getRounding());
		_root.getChildren().add(rect);
	}
	
}
