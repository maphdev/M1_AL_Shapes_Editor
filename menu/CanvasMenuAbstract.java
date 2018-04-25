package menu;

import java.util.ArrayList;
import java.util.List;

import canvas.RenderShape;
import shape.IShape;
import shape.Point2DCartesian;
import shape.Rectangle;

public abstract class CanvasMenuAbstract implements CanvasMenu{
	
	protected List<Button> buttons;
	protected RenderShape renderShape;
	protected Button trash = new Button();
	
	public CanvasMenuAbstract() {
		buttons = new ArrayList<Button>();
		buttons.add(new Button() {
			private IShape shape = new Rectangle(new Point2DCartesian(),
					0, 0xFF0000, 20, 50, 5);
			public void action() {
				draw(shape);
			}
		});
		buttons.add(new Button() {
			private IShape shape = new Rectangle(new Point2DCartesian(),
					0, 0x00FF00, 50, 20, 5);
			public void action() {
				draw(shape);
			}
		});
	}
	
	public CanvasMenuAbstract(CanvasMenu m) {
		buttons = ((CanvasMenuAbstract) m).buttons;
	}
	
	public abstract void draw(IShape shape);
	public abstract void add(IShape shape);
	public abstract void delete(IShape shape);

}
