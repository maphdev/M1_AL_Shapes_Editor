package canvas;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import render.RenderShape;
import render.RenderShapeFx;

public class CanvasFx extends CanvasAbstract{
	
	private Group root;
	private Group shapeGroup;
	private Rectangle board;
	
	private double posX = 60;
	private double posY = 60;
	private double marge = 10;
	private double stroke = 2;
	
	public CanvasFx(Group root) {
		super();
		init(root);
	}
	
	public CanvasFx(Canvas c, Group root) {
		super(c);
		init(root);
	}
	
	private void init(Group root) {
		board = new Rectangle();
		board.setX(posX);
		board.setY(posY);
		board.setWidth(root.getScene().getWidth()-posX-marge);
		board.setHeight(root.getScene().getHeight()-posY-marge);
		board.setFill(Color.WHITE);
		board.setStroke(Color.BLACK);
		board.setStrokeWidth(stroke);
		
		this.root = new Group();
        this.root.getChildren().add(board);
        root.getChildren().add(this.root);
        
        this.root.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
            	board.setFill(Color.LIGHTGREY);
            }
        });
		this.root.setOnMouseExited(new EventHandler<MouseEvent>(){
	        public void handle(MouseEvent me){
	        	board.setFill(Color.WHITE);
	        }
	    });
        shapeGroup = new Group();
        this.root.getChildren().add(shapeGroup);
        renderShape = createRender();
        super.draw();
	}

	@Override
	public RenderShape createRender() {
		return new RenderShapeFx(shapeGroup, posX, posY);
	}

}
