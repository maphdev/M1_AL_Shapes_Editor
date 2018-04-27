package command;

import java.util.ArrayList;
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
		if(redo != null)
			c.restoreMemento(redo);
		else {
			c.remove(list);
			List<IShape> l = new ArrayList<IShape>();
			for(IShape shape : list)
				l.add(shape.clone()); 
			GroupShapes g = new GroupShapes(l);
			c.add(g);
			redo = c.createMemento();
		}
	}
	
}
