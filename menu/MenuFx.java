package menu;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuFx extends MenuAbstract implements Menu{
	
	private double marge = 6;
	private double stroke = 2;
	private double buttonMarge = 5;
	
	private double posX = 0;
	private double posY = 0;
	private double width = 800;
	private double height = 60;
	
	private List<ButtonMenuFx> buttonsFx;
	
	private Group root;
	private Rectangle board;
	
	public MenuFx(Group root) {
		super();
		init(root);
	}
	
	public MenuFx(Menu m, Group root) {
		super(m);
		init(root);
	}
	
	private void init(Group root) {
		posX += marge+stroke/2;
		posY += marge+stroke/2;
		width = root.getScene().getWidth()-2*(marge+stroke/2);
		height -= marge+stroke/2;
		
		this.root = new Group();
		StackPane pane = new StackPane();
	    pane.setMaxWidth(width);
	    pane.setMaxHeight(height);
	    pane.setLayoutX(posX);
	    pane.setLayoutY(posY);
	    pane.getChildren().add(this.root);
        root.getChildren().add(pane);
		
		board = new Rectangle();
		board.setX(0);
		board.setY(0);
		board.setWidth(width);
		board.setHeight(height);
		board.setFill(Color.WHITE);
		board.setStroke(Color.BLACK);
		board.setStrokeWidth(stroke);
		this.root.getChildren().add(board);
        buttonsFx = new ArrayList<ButtonMenuFx>();
        for(ButtonImage b : buttons) {
        	addButton(b);
        }
	}
	
	private void addButton(ButtonImage b) {
		ButtonMenuFx _b = new ButtonImageFx(
				buttonsFx.size()*(height-buttonMarge)+buttonMarge,
				buttonMarge,
				height-2*buttonMarge,
				b, b.getPath());
		root.getChildren().add(_b);
		buttonsFx.add(_b);
	}
}
