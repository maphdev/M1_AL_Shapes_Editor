package canvas;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CanvasFx extends CanvasAbstract{
	
	private Group root;
	private Group shapeGroup;
	private Rectangle page;
	
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
		this.root = new Group();
		root.getChildren().add(this.root);
		page = new Rectangle();
		page.setX(posX);
		page.setY(posY);
		page.setWidth(root.getScene().getWidth()-posX-marge);
		page.setHeight(root.getScene().getHeight()-posY-marge);
		page.setFill(Color.WHITE);
		page.setStroke(Color.BLACK);
		page.setStrokeWidth(stroke);
        this.root.getChildren().add(page);
        
        shapeGroup = new Group();
        renderShape = createRender();
	}

	@Override
	public RenderShape createRender() {
		return new RenderShapeFx(shapeGroup, posX, posY);
	}

}
