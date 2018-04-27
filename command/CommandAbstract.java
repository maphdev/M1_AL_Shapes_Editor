package command;

import java.util.List;

import canvas.Canvas;
import canvas.CanvasAbstract.MementoCanvas;
import shape.IShape;

public abstract class CommandAbstract implements CommandCanvas{
	
	protected Canvas c;
	protected MementoCanvas undo = null;
	protected MementoCanvas redo = null;
	protected IShape s = null;
	protected List<IShape> list = null;
	
	public CommandAbstract(Canvas c, IShape s) {
		this.c = c;
		this.s = s;
	}
	
	public CommandAbstract(Canvas c, List<IShape> list) {
		this.c = c;
		this.list = list;
	}
	
	public void execute() {
		if(redo != null)
			c.restoreMemento(redo);
		else
			undo = c.createMemento();
	}
	
	public void reverse() {
		c.restoreMemento(undo);
	}

}
