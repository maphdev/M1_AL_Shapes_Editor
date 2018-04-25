package menu;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ButtonMenuFx extends Parent {
	
	private double _posX;
	private double _posY;
	private double _length;
	
	private Button _button;
    private Rectangle _buttonFx;
	
	private Color _color = Color.WHITE;
    

	public ButtonMenuFx(double posX, double posY, double length, Button button) {
		_posX = posX;
		_posY = posY;
		_length = length;
		
		_button = button;
		_buttonFx = new Rectangle(length, length, _color);
		this.getChildren().add(_buttonFx);
		this.setTranslateX(_posX);
        this.setTranslateY(_posY);
        
        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
            	_color = Color.LIGHTGREY;
            	_buttonFx.setFill(Color.LIGHTGREY);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
            	_color = Color.WHITE;
            	_buttonFx.setFill(_color);
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

    public void appuyer(){
    	_buttonFx.setFill(Color.DARKGREY);
        this.setTranslateY(_posY+2);
        _button.action();
    }
    
    public void relacher(){
    	_buttonFx.setFill(_color);
        this.setTranslateY(_posY);
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
		_buttonFx.setWidth(_length);
		_buttonFx.setHeight(_length);
	}
	
}