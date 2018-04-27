package command;

import java.util.List;

import canvas.Canvas;
import shape.GroupShapes;
import shape.IShape;

public class CommandGroup extends CommandAbstract {
	
	public CommandGroup(Canvas c, List<IShape> list) {
		super(c,list);
	}
	
	public void execute() {
		super.execute();
		GroupShapes g = new GroupShapes(list);
		c.remove(list);
		c.add(g);
		redo = c.createMemento();
	}
	
}
