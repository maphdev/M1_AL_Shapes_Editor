package canvas;

import canvas.CanvasAbstract.MementoCanvas;
import command.CommandCanvas;
import shape.IShape;

public interface Canvas {
	
	public void execute(CommandCanvas command);
	public void undo();
	public void redo();
	public void add(IShape shape);
	public void remove(IShape shape);
	public void draw();
	public MementoCanvas createMemento();
	public void restoreMemento(MementoCanvas m);
}
