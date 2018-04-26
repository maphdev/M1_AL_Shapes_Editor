package menu;

import java.util.ArrayList;
import java.util.List;

import render.RenderShape;
import shape.IShape;
import shape.Point2DCartesian;
import shape.Rectangle;

public abstract class CanvasMenuAbstract implements CanvasMenu{
	
	protected List<ButtonShape> buttons;
	protected Button trash = new Button();
	
	public CanvasMenuAbstract() {
		buttons = new ArrayList<ButtonShape>();
		buttons.add(new ButtonShape(new Rectangle(new Point2DCartesian(20, 80),0, 0xFF0000, 200, 300, 5)));
		buttons.add(new ButtonShape(new Rectangle(new Point2DCartesian(100, 150),0, 0x00FF00, 50, 20, 5)));
	}
	
	public CanvasMenuAbstract(CanvasMenu m) {
		buttons = ((CanvasMenuAbstract) m).buttons;
	}
	
	public abstract void draw(IShape shape);
	public abstract void add(IShape shape);
	public abstract void delete(IShape shape);

}
