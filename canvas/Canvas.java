package canvas;

import java.util.List;

import canvas.CanvasAbstract.MementoCanvas;
import command.CommandCanvas;
import shape.IShape;

public interface Canvas {
	
	public void execute(CommandCanvas commandCanvas);
	public void undo();
	public void redo();
	public void add(IShape shape);
	public void remove(IShape shape);
	public void remove(List<IShape> shape);
	public void draw();
	public MementoCanvas createMemento();
	public void restoreMemento(MementoCanvas m);
}
