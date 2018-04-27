package canvas;

import java.util.ArrayList;
import java.util.List;

import application.AppInstance;
import command.CommandAdd;
import command.CommandCanvas;
import command.CommandSetPosition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import menu.CanvasMenuFx;
import render.RenderShapeFx;
import shape.IShape;

public class CanvasFx extends CanvasAbstract{
	
	public static List<IShape> DragShapes = new ArrayList<IShape>();
	
	private Group _root;
	private Group shapeGroup;
	
	private double posX = 60;
	private double posY = 60;
	private double height = 740;
	private double width = 740;
	private double marge = 6;
	private double stroke = 2;
	
	private Rectangle selection = new Rectangle();
	
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
                	if(CanvasFx.DragShapes.size() == 0 && !CanvasFx.DragShapes.contains(shape)){
                		CanvasFx.DragShapes.add(shape);
            		}
                	ClipboardContent content = new ClipboardContent();
                    content.putString("CanvasFx");
                	db.setContent(content);
                }
                else {
                	_root.getChildren().add(selection);
                	selection.setX(event.getX()-stroke/2);
                	selection.setY(event.getY()-stroke/2);
                	selection.setFill(Color.TRANSPARENT);
                	selection.setStroke(Color.BLACK);
                	ClipboardContent content = new ClipboardContent();
                	content.putString("Selection");
                	db.setContent(content);
                }
                event.consume();
        	}
        });
        
        this._root.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
            	Dragboard db = event.getDragboard();
            	if(db.getString().equals("CanvasFx") || db.getString().equals("CanvasMenuFx")) {
            		event.acceptTransferModes(TransferMode.MOVE);
                }
            	if(db.getString().equals("Selection")) {
            		event.acceptTransferModes(TransferMode.MOVE);
            		selection.setWidth(event.getX()-stroke/2-selection.getX());
            		selection.setHeight(event.getY()-stroke/2-selection.getY());
            	}
            	event.consume();
            }    
        });
        
        this._root.setOnDragDropped(new EventHandler<DragEvent>() {
        	public void handle(DragEvent event) {
        		boolean success = false;
            	Dragboard db = event.getDragboard();
            	if(db.getString().equals("CanvasFx")) {
            		IShape shape = null;
            		for(IShape s : CanvasFx.DragShapes) {
            			shape = s;
            		}
            		CanvasFx.DragShapes.clear();
            		if(shape!=null) {
            			Canvas c = AppInstance.getInstance().getAppEditeur().getCanvas();
            			CommandCanvas cmd = new CommandSetPosition(c, shape, event.getX()-stroke/2, event.getY()-stroke/2);
            			c.execute(cmd);
                		success = true;
            		}
            	}
            	else if(db.getString().equals("CanvasMenuFx")){
            		IShape shape = CanvasMenuFx.DragShape.clone();
            		CanvasMenuFx.DragShape = null;
            		shape.setPosition(event.getX()-stroke/2, event.getY()-stroke/2);
            		Canvas c = AppInstance.getInstance().getAppEditeur().getCanvas();
            		CommandCanvas cmd = new CommandAdd(c, shape);
            		c.execute(cmd);
            		success = true;
            	}
            	if(db.getString().equals("Selection")) {
            		if(selection.getWidth()>0 && selection.getHeight()>0) {
	            		for(IShape s: shapes) {
	            			if(s.getPosition().getX()-selection.getX()<selection.getWidth() &&
	            					s.getPosition().getY()-selection.getY()<selection.getHeight()) {
	            				CanvasFx.DragShapes.add(s);
	            			}
	            		}
            		}
            		_root.getChildren().remove(selection);
            	}
                event.setDropCompleted(success);
                event.consume();
            }
        });
        
        this._root.setOnDragDone(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
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
