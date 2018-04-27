package canvas;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import command.CommandCanvas;
import render.RenderShape;
import shape.GroupShapes;
import shape.IShape;
import shape.Point2DCartesian;

public abstract class CanvasAbstract implements Canvas {
	
	public class MementoCanvas {
		private List<IShape> shapes;
		public MementoCanvas(Canvas c) {
			shapes = new ArrayList<IShape>();
			for(IShape shape : ((CanvasAbstract)c).shapes) {
				shapes.add(shape.clone());
			}
		}
	}
	
	private ArrayDeque<CommandCanvas> undoStack;
	private ArrayDeque<CommandCanvas> redoStack;
	
	protected List<IShape> shapes;
	
	protected RenderShape renderShape;
	
	public CanvasAbstract() {
		undoStack = new ArrayDeque<CommandCanvas>();
		redoStack = new ArrayDeque<CommandCanvas>();
		shapes = new ArrayList<IShape>();
		//shapes.add(new shape.Rectangle(new Point2DCartesian(150,50), 0, 0xFF0000, 30, 200, 10));
		List<IShape> l = new ArrayList<IShape>();
		l.add(new shape.Rectangle(new Point2DCartesian(150,50), 0, 0xFF0000, 80, 200, 10));
		l.add(new shape.Rectangle(new Point2DCartesian(400,250), 0, 0xFF0000, 60, 90, 10));
		shapes.add(new GroupShapes(l));
	}
	
	public CanvasAbstract(Canvas c) {
		undoStack = ((CanvasAbstract)c).undoStack;
		redoStack = ((CanvasAbstract)c).redoStack;
		shapes = ((CanvasAbstract)c).shapes;
		draw();
	}
	
	public void execute(CommandCanvas c) {
		undoStack.addFirst(c);
		c.execute();
		System.out.println(shapes);
		redoStack.clear();
		draw();
	}
	
	public void redo() {
		CommandCanvas c = redoStack.pollFirst();
		if(c != null) {
			undoStack.addFirst(c);
			c.execute();
			draw();
		}
	}
	
	public void undo() {
		CommandCanvas c = undoStack.pollFirst();
		if(c != null) {
			redoStack.addFirst(c);
			c.reverse();
		}
	}
	
	public void add(IShape shape) {
		shapes.add(shape);
	}
	public void remove(IShape shape) {
		shapes.remove(shape);
	}
	public void remove(List<IShape> shape) {
		shapes.removeAll(shape);
	}
	
	public void draw() {
		for(IShape shape : shapes) {
			shape.draw(renderShape);
		}
	}
	public MementoCanvas createMemento() {
		return new MementoCanvas(this);
	}
	public void restoreMemento(MementoCanvas m) {
		shapes = new ArrayList<IShape>();
		for(IShape shape : m.shapes) {
			shapes.add(shape.clone());
		}
		draw();
	}
	
}
