package command;

import canvas.Canvas;
import shape.GroupShapes;
import shape.IShape;

public class CommandBreak extends CommandAbstract {
	
	public CommandBreak(Canvas c, GroupShapes s) {
		super(c,s);
	}
	
	public void execute() {
		super.execute();
		if(redo != null)
			c.restoreMemento(redo);
		else {
			c.remove(s);
			for(IShape shape : ((GroupShapes)s).getGroupShapes())
				c.add(shape.clone());
			redo = c.createMemento();
		}
	}

}
