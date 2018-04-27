package command;

import canvas.Canvas;
import shape.IShape;

public class CommandAdd extends CommandAbstract{
	
	public CommandAdd(Canvas c, IShape s) {
		super(c,s);
	}
	
	public void execute() {
		super.execute();
		c.add(s);
	}
}
