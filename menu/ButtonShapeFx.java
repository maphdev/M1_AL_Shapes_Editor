package menu;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import render.RenderShape;
import render.RenderShapeFx;

public class ButtonShapeFx extends ButtonMenuFx {
	
	private RenderShape render;
	private ButtonShapeFx root;
	
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
        
        root = this;
        root.setOnDragDetected(new EventHandler<MouseEvent>() {
        	public void handle(MouseEvent event) {
                Dragboard db = root.startDragAndDrop(TransferMode.ANY);
            	CanvasMenuFx.DragShape = button.getShape();
            	ClipboardContent content = new ClipboardContent();
                content.putString("CanvasMenuFx");
            	db.setContent(content);
                event.consume();
        	}
        });
        
        root.setOnDragDone(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                event.consume();
            }
        });
        
	}
	
	
	
}
