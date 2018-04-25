package canvas;

import shape.IShape;

public interface Canvas {
	public void execute(CommandCanvas command);
	public void add(IShape shape);
	public void remove(IShape shape);
	public void draw();
	public Memento createMemento();
	public void restoreMemento(Memento m);
}
