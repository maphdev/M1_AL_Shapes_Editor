package menu;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import render.RenderShape;
import render.RenderShapeFx;
import shape.IShape;

public class ButtonShapeFx extends ButtonMenuFx {
	
	private RenderShape render;
	
	public ButtonShapeFx(double posX, double posY, double length, ButtonShape button) {
		super(posX, posY, length, button);
		button.getShape().setPosition(370, 370);
		Rectangle clip = new Rectangle(_length, _length);
        clip.setLayoutX(0);
        clip.setLayoutY(0); 
        Group g = new Group();
        g.getChildren().add(clip);
        Scale scale = new Scale(); 
        scale.setX(_length/740); 
        scale.setY(_length/740);
        scale.setPivotX(0);
        scale.setPivotY(0);
        g.getTransforms().add(scale);
        this.getChildren().add(g);
        render = new RenderShapeFx(g);
        button.getShape().draw(render);
	}
	
	
	
}
