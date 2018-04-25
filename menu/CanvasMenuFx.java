package menu;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import shape.IShape;

public class CanvasMenuFx extends CanvasMenuAbstract{
	
	private double marge = 4;
	private double stroke = 2;
	private double buttonMarge = 5;
	
	private double posX = 0;
	private double posY = 60;
	private double width = 60;
	private double height = 740;
	
	private List<ButtonMenuFx> buttonsFx;
	
	private Group root;
	private Rectangle board;
	
	public CanvasMenuFx(Group root) {
		super();
		init(root);
	}
	
	public CanvasMenuFx(CanvasMenu m, Group root) {
		super(m);
		init(root);
	}
	
	private void init(Group root) {
		width -= 2*(marge+stroke/2);
		height = root.getScene().getWidth()-(marge+stroke/2)-posY;
		posX += marge+stroke/2;
		this.root = new Group();
		root.getChildren().add(this.root);
		board = new Rectangle();
		board.setX(posX);
		board.setY(posY);
		board.setWidth(width);
		board.setHeight(height);
		board.setFill(Color.WHITE);
		board.setStroke(Color.BLACK);
		board.setStrokeWidth(stroke);
		this.root.getChildren().add(board);
        buttonsFx = new ArrayList<ButtonMenuFx>();
        for(Button b : buttons) {
        	addButton(b);
        }
	}
	
	private void addButton(Button b) {
 		ButtonMenuFx _b = new ButtonMenuFx(
 				posX+buttonMarge,
 				buttonsFx.size()*(width+buttonMarge)+posY+buttonMarge,
 				width-2*buttonMarge,
 				b);
 		root.getChildren().add(_b);
 		buttonsFx.add(_b);
 	}
	
	public void draw(IShape shape) {}
	public void add(IShape shape) {}
	public void delete(IShape shape) {}
}
