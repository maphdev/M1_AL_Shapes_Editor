package canvas;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import shape.IShape;

public abstract class CanvasAbstract implements Canvas{
	
	public class MementoCanvas implements Memento{
		public MementoCanvas(Canvas c) {}
	}
	
	private ArrayDeque<CommandCanvas> undoStack;
	private ArrayDeque<CommandCanvas> redoStack;
	
	private List<IShape> shapes;
	
	public CanvasAbstract() {
		undoStack = new ArrayDeque<CommandCanvas>();
		redoStack = new ArrayDeque<CommandCanvas>();
		shapes = new ArrayList<IShape>();
	}
	
	public void execute(CommandCanvas command) {
		
	}
	public void add(IShape shape) {}
	public void remove(IShape shape) {}
	public void draw() {}
	public Memento createMemento() {
		return new MementoCanvas(this);
	}
	public void restoreMemento(Memento m) {}
	
	
}
