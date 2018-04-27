package render;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Circle;
import shape.GroupShapes;

public class RenderShapeFx implements RenderShape{
	
	private Group _root;
	
	public RenderShapeFx(Group root) {
		_root = root;
	}
	
	public void draw(GroupShapes shape) {}
	
	public void draw(shape.Polygon shape) {

		Double[] tab = new Double[2 * shape.getNbSides()];
        
        Polygon poly = new Polygon();
        for (int i = 0; i < 2 * shape.getNbSides(); i += 2) {
        	tab[i+0] = (shape.getPosition().getX() + 50 * Math.cos(i/2 * 2 * Math.PI / shape.getNbSides()));
        	tab[i+1] = (shape.getPosition().getY() + 50 * Math.sin(i/2 * 2 * Math.PI / shape.getNbSides()));
        }
        poly.getPoints().addAll(tab);
		poly.setRotate(shape.getRotation());
        poly.setFill(Color.web(String.format("0x%06X", shape.getColor())));
		poly.setStroke(Color.web(String.format("0x%06X", shape.getColor())).darker());
		
		_root.getChildren().add(poly);
	}
	
	public void draw(shape.Rectangle shape) {
		Rectangle rect = new Rectangle();
		rect.setX(shape.getPosition().getX()-shape.getWidth()/2);
		rect.setY(shape.getPosition().getY()-shape.getHeight()/2);
		rect.setWidth(shape.getWidth());
		rect.setHeight(shape.getHeight());
		rect.setRotate(shape.getRotation());
		rect.setFill(Color.web(String.format("0x%06X", shape.getColor())));
		rect.setStroke(Color.web(String.format("0x%06X", shape.getColor())).darker());
		rect.setArcWidth(shape.getRounding());
		rect.setArcHeight(shape.getRounding());
		_root.getChildren().add(rect);
	}

	@Override
	public void draw(shape.Circle shape) {
		Circle circle = new Circle(shape.getPosition().getX(), shape.getPosition().getY(), shape.getRadius());
		circle.setRotate(shape.getRotation());
		circle.setFill(Color.web(String.format("0x%06X", shape.getColor())));
		circle.setStroke(Color.web(String.format("0x%06X", shape.getColor())).darker());
		_root.getChildren().add(circle);
	}
	
}
