package canvas;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;

import shape.GroupShapes;

public class RenderShapeFx implements RenderShape{
	
	private Group _root;
	private double _posX;
	private double _posY;
	
	public RenderShapeFx(Group root, double posX, double posY) {
		_root = root;
		_posX = posX;
		_posY = posY;
	}
	
	public void draw(GroupShapes shape) {}
	
	public void draw(shape.Polygon shape) {
		Polygon polyg = new Polygon(new double[]{shape.getPosition().getX(), shape.getPosition().getY()});
	}
	
	public void draw(shape.Rectangle shape) {
		Rectangle rect = new Rectangle(_posX + shape.getPosition().getX(), _posY + shape.getPosition().getX(), _posX + shape.getPosition().getX() + shape.getWidth(), _posY + shape.getPosition().getX() + shape.getHeight());
		rect.setRotate(shape.getRotation());
		rect.setFill(Color.TRANSPARENT);
		rect.setStroke(Color.web(String.format("0x%06X", shape.getColor())));
		rect.setArcWidth(shape.getRounding());
		rect.setArcHeight(shape.getRounding());
		_root.getChildren().add(rect);
	}
	
}
