package canvas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import application.AppEditeurFx;
import application.AppInstance;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import render.RenderShapeFx;
import shape.IShape;

public class CanvasFx extends CanvasAbstract{
	
	private Group _root;
	private Group shapeGroup;
	
	private double posX = 60;
	private double posY = 60;
	private double height = 740;
	private double width = 740;
	private double marge = 6;
	private double stroke = 2;
	
	public final static DataFormat ShapeDataFormat = new DataFormat("Shape");
	public static List<IShape> DragShapes = new ArrayList<IShape>();
	
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
		
		Rectangle board = new Rectangle();
		board.setX(0);
		board.setY(0);
		board.setWidth(width);
		board.setHeight(height);
		board.setFill(Color.WHITE);
		board.setStroke(Color.BLACK);
		board.setStrokeWidth(stroke);
		
		this._root = new Group();
		this._root.getChildren().add(board);
        
        StackPane pane = new StackPane();
	    pane.setMaxWidth(width);
	    pane.setMaxHeight(height);
	    pane.setLayoutX(posX);
	    pane.setLayoutY(posY);
	    pane.getChildren().add(this._root);
        root.getChildren().add(pane);
        
        pane = new StackPane();
	    pane.setMaxWidth(width-stroke);
	    pane.setMaxHeight(height-stroke);
	    pane.setLayoutX(posX+stroke/2);
	    pane.setLayoutY(posY+stroke/2);
	    
	    Rectangle clip = new Rectangle(height-stroke, width-stroke);
        clip.setLayoutX(stroke/2);
        clip.setLayoutY(stroke/2);
        
        Group g = new Group();
        g.setClip(clip);
        g.getChildren().add(pane);	    
	    shapeGroup = new Group();
	    g.getChildren().add(shapeGroup);     
        this._root.getChildren().add(g);
        renderShape = new RenderShapeFx(shapeGroup);

        this._root.setOnDragDetected(new EventHandler<MouseEvent>() {
        	public void handle(MouseEvent event) {
                Dragboard db = _root.startDragAndDrop(TransferMode.ANY);
                IShape shape = null;
                for(IShape s : shapes) {
                	if(s.belongsTo(event.getX()-stroke/2, event.getY()-stroke/2)) {
                		shape = s;
                		break;
                	}
                }
                if(shape!=null) {
                	CanvasFx.DragShapes.add(shape);
                	ClipboardContent content = new ClipboardContent();
                    content.putString("CanvasFx");
                	db.setContent(content);
                }
                event.consume();
        	}
        });
        
        this._root.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
            	if (event.getGestureSource() == _root &&
                		event.getDragboard().hasString()) {
            		event.acceptTransferModes(TransferMode.MOVE);
                	}
            	event.consume();
            }    
        });
        
        this._root.setOnDragDropped(new EventHandler<DragEvent>() {
        	public void handle(DragEvent event) {
        		boolean success = false;
                if (event.getGestureSource() == _root &&
                		event.getDragboard().hasString()) {
                	Dragboard db = event.getDragboard();
                	if(db.getString().equals("CanvasFx")) {
                		IShape shape = null;
                		for(IShape s : CanvasFx.DragShapes) {
                			shape = s;
                		}
                		CanvasFx.DragShapes.clear();
                		if(shape!=null) {
                			shape.setPosition(event.getX()-stroke/2, event.getY()-stroke/2);
	                		AppInstance.getInstance().getAppEditeur().getCanvas().draw();
	                		success = true;
                		}
                	}
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });
        
        this._root.setOnDragDone(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
            	//if(event.isDropCompleted())
                event.consume();
            }
        });
        
        draw();
	}
	
	public void draw() {
		shapeGroup.getChildren().clear(); 
		super.draw();
	}

}
