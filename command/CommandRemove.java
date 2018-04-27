package command;

import java.util.List;

import canvas.Canvas;
import shape.IShape;

public class CommandRemove extends CommandAbstract{
	
	public CommandRemove(Canvas c, IShape s) {
		super(c,s);
	}
	
	public CommandRemove(Canvas c, List<IShape> list) {
		super(c,list);
	}
	
	public void execute() {
		super.execute();
		if(redo != null)
			return;
		if(s != null) 
			c.remove(s);
		if(list != null) 
			c.remove(list);
		redo = c.createMemento();
	}

}
