package command;

import java.util.List;

import canvas.Canvas;
import shape.GroupShapes;
import shape.IShape;

public class CommandSetPosition extends CommandAbstract{
	
	private double _x;
	private double _y;
	
	public CommandSetPosition(Canvas c, IShape s, double x, double y) {
		super(c,s);
		_x = x;
		_y = y;
	}
	
	public CommandSetPosition(Canvas c, List<IShape> list, double x, double y) {
		super(c,list);
		_x = x;
		_y = y;
	}
	
	public void execute() {
		super.execute();
		if(redo != null)
			return;
		if(s != null)
			s.setPosition(_x, _y);
		if(list != null) {
			IShape _s = new GroupShapes(list);
			_s.setPosition(_x, _y);
		}
		redo = c.createMemento();
	}

}
