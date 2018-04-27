package menu;

import java.util.ArrayList;
import java.util.List;

import application.AppInstance;
import canvas.Canvas;
import command.CommandCanvas;
import command.CommandRemove;
import shape.Circle;
import shape.IShape;
import shape.Point2DCartesian;
import shape.Rectangle;

public abstract class CanvasMenuAbstract implements CanvasMenu{
	
	protected List<ButtonShape> buttons;
	protected Button trash = new Button();
	
	public CanvasMenuAbstract() {
		buttons = new ArrayList<ButtonShape>();
		buttons.add(new ButtonShape(new Rectangle(new Point2DCartesian(20, 80),0, 0x119199, 300, 200, 5)));
		buttons.add(new ButtonShape(new Rectangle(new Point2DCartesian(100, 150),0, 0xd65076, 50, 20, 5)));
		buttons.add(new ButtonShape(new Circle(new Point2DCartesian(100, 150), 0, 0xf0da55, 50)));
	}
	
	public CanvasMenuAbstract(CanvasMenu m) {
		buttons = ((CanvasMenuAbstract) m).buttons;
	}
	
	public abstract void addButtonFx(IShape shape);
	public abstract void deleteShapeOnMenu(IShape shape);
	
	public void deleteShapeOnCanvas(List<IShape> shapes) {
		Canvas c = AppInstance.getInstance().getAppEditeur().getCanvas();
		CommandCanvas cmd = new CommandRemove(c, shapes);
		c.execute(cmd);
	}

}
