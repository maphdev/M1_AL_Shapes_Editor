package menu;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ButtonImageFx extends ButtonMenuFx {
	
	Image image;
	ImageView imView;
	
	public ButtonImageFx(double posX, double posY, double length, Button button, String path) {
		super(posX, posY, length, button);
		System.out.println(path);
		image = new Image(getClass().getResourceAsStream(path));
		imView = new ImageView(image);
		imView.setFitHeight(length);
		imView.setFitWidth(length);
		imView.setPreserveRatio(true);
		
		Rectangle r = new Rectangle(length+8, length+8, Color.TRANSPARENT);
		r.setTranslateX(-4);
		r.setTranslateY(-4);
		this.getChildren().add(r);
		this.getChildren().add(imView);
		this.setTranslateX(posX);
		this.setTranslateY(posY);
		
		this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
            	r.setFill(Color.LIGHTGREY);
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
            	r.setFill(Color.TRANSPARENT);
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
    	getButton().action();
    }
    
    public void relacher(){
    	//
    }
}
