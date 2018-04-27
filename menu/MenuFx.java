package menu;

import java.util.ArrayList;
import java.util.List;

import application.AppInstance;
import canvas.Canvas;
import canvas.CanvasFx;
import command.CommandBreak;
import command.CommandCanvas;
import command.CommandGroup;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import shape.GroupShapes;
import shape.IShape;

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
        
        ButtonMenuFx _b = addButton(breaker);
        
        _b.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
            	Dragboard db = event.getDragboard();
            	if(db.getString().equals("CanvasFx"))
            		event.acceptTransferModes(TransferMode.MOVE);
            	event.consume();
            }
        });
        
        _b.setOnDragDropped(new EventHandler<DragEvent>() {
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
                		if(shape!=null && shape instanceof GroupShapes) {
                			Canvas c = AppInstance.getInstance().getAppEditeur().getCanvas();
                			CommandCanvas cmd = new CommandBreak(c, (GroupShapes)shape);
                			c.execute(cmd);
                			CanvasFx.DragShapes.clear();
	                		success = true;
                		}
                	}
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });
        
	}
	
	private ButtonMenuFx addButton(ButtonImage b) {
		ButtonMenuFx _b = new ButtonImageFx(
				buttonsFx.size()*(height-buttonMarge)+buttonMarge,
				buttonMarge,
				height-2*buttonMarge,
				b, b.getPath());
		root.getChildren().add(_b);
		buttonsFx.add(_b);
		return _b;
	}
	
	public void groupSelection() {
		if(CanvasFx.DragShapes.size()<=1)
			return;
		Canvas c = AppInstance.getInstance().getAppEditeur().getCanvas();
		CommandCanvas cmd = new CommandGroup(c, CanvasFx.DragShapes);
		c.execute(cmd);
		CanvasFx.DragShapes.clear();
	}
	public void breakSelection(IShape s) {}
}
