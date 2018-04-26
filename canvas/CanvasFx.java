package canvas;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import render.RenderShapeFx;

public class CanvasFx extends CanvasAbstract{
	
	private Group root;
	private Group shapeGroup;
	private Rectangle board;
	
	private double posX = 60;
	private double posY = 60;
	private double height = 740;
	private double width = 740;
	private double marge = 6;
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
		
		posX += marge+stroke/2;
		posY += marge+stroke/2;
		height -= 2*(marge+stroke/2);
		width -= 2*(marge+stroke/2);
		
		board = new Rectangle();
		board.setX(0);
		board.setY(0);
		board.setWidth(width);
		board.setHeight(height);
		board.setFill(Color.WHITE);
		board.setStroke(Color.BLACK);
		board.setStrokeWidth(stroke);
		
		this.root = new Group();
        this.root.getChildren().add(board);
        
        StackPane pane = new StackPane();
	    pane.setMaxWidth(width);
	    pane.setMaxHeight(height);
	    pane.setLayoutX(posX);
	    pane.setLayoutY(posY);
	    pane.getChildren().add(this.root);
        root.getChildren().add(pane);
        
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
		
        
		pane = new StackPane();
	    pane.setMaxWidth(width-stroke);
	    pane.setMaxHeight(height-stroke);
	    pane.setLayoutX(posX+stroke/2);
	    pane.setLayoutY(posY+stroke/2);
	    
	    Rectangle clip = new Rectangle(height-stroke, width-stroke);
        clip.setLayoutX(stroke/2);
        clip.setLayoutY(stroke/2);
        
        shapeGroup = new Group();
        shapeGroup.setClip(clip);
	    shapeGroup.getChildren().add(pane);
        
        this.root.getChildren().add(shapeGroup);
        renderShape = new RenderShapeFx(shapeGroup);
        super.draw();
	}

}
