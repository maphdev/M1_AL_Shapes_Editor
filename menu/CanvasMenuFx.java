package menu;

import java.util.ArrayList;
import java.util.List;

import canvas.CanvasFx;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import shape.IShape;

public class CanvasMenuFx extends CanvasMenuAbstract{
	
	public static IShape DragShape;
	
	private double marge = 6;
	private double stroke = 2;
	private double buttonMarge = 5;
	
	private double posX = 0;
	private double posY = 60;
	private double width = 60;
	private double height = 740;
	
	private List<ButtonShapeFx> buttonsFx;
	
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
		
		posX += marge+stroke/2;
		posY += marge+stroke/2;
		width -= marge+stroke/2;
		height -= 2*(marge+stroke/2);
		
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
        buttonsFx = new ArrayList<ButtonShapeFx>();
        for(ButtonShape b : buttons) {
        	addButton(b);
        }
        
        this.root.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
            	event.acceptTransferModes(TransferMode.MOVE);
            	event.consume();
            }    
        });
        
        this.root.setOnDragDropped(new EventHandler<DragEvent>() {
        	public void handle(DragEvent event) {
        		boolean success = false;
                if(event.getDragboard().hasString()) {
                	Dragboard db = event.getDragboard();
                	if(db.getString().equals("CanvasFx")) {
                		IShape shape = null;
                		for(IShape s : CanvasFx.DragShapes) {
                			shape = s;
                		}
                		CanvasFx.DragShapes.clear();
                		if(shape!=null) {
                			ButtonShape b = new ButtonShape(shape.clone());
                			buttons.add(b);
                			addButton(b);
	                		success = true;
                		}
                	}
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });
        
        this.root.setOnDragDone(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                event.consume();
            }
        });
        
        
	}
	
	private void addButton(ButtonShape b) {
		ButtonShapeFx _b = new ButtonShapeFx(
 				buttonMarge,
 				buttonsFx.size()*(width-buttonMarge)+buttonMarge,
 				width-2*buttonMarge,
 				b);
 		root.getChildren().add(_b);
 		buttonsFx.add(_b);
 	}
	
	public void draw(IShape shape) {}
	public void add(IShape shape) {}
	public void delete(IShape shape) {}
}
