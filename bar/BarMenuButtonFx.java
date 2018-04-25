package bar;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BarMenuButtonFx extends Parent {
	
	protected double _posX;
	protected double _posY;
	protected double _length;

    private Rectangle _button;

	public BarMenuButtonFx(double posX, double posY, double length) {
		_posX = posX;
		_posY = posY;
		_length = length;
		
		_button = new Rectangle(length, length,Color.WHITE);
		this.getChildren().add(_button);
		this.setTranslateX(_posX);
        this.setTranslateY(_posY);
        
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
            	_button.setFill(Color.LIGHTGREY);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
            	_button.setFill(Color.WHITE);
            }
        });
        this.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                appuyer();
            }
        });
        this.setOnMouseReleased(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                relacher();
            }
        });
    }
	
	public void setPosX(double posX) {
		_posX = posX;
		this.setTranslateX(_posX);
	}
	
	public void setPosY(double posY) {
		_posY = posY;
		this.setTranslateY(_posY);
	}
	
	public void setLength(double length) {
		_length = length;
		_button.setWidth(_length);
		_button.setHeight(_length);
	}
	
    public void appuyer(){
    	_button.setFill(Color.DARKGREY);
        this.setTranslateY(_posY+2);
    }
    
    public void relacher(){
    	_button.setFill(Color.WHITE);
        this.setTranslateY(_posY);
    }	
}
