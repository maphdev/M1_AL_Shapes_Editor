package menu;

import java.util.ArrayList;
import java.util.List;

import application.AppInstance;
import canvas.Canvas;
import shape.IShape;

public abstract class MenuAbstract implements Menu{
	
	protected List<ButtonImage> buttons;
	protected ButtonImage breaker;
	
	public MenuAbstract() {
		buttons = new ArrayList<ButtonImage>();
		buttons.add(new ButtonImage("/icons/save.png") {
			public void action() {
				saveCanvas();
			}
		});
		buttons.add(new ButtonImage("/icons/upload.png") {
			public void action() {
				loadCanvas();
			}
		});
		buttons.add(new ButtonImage("/icons/arrow-left.png") {
			public void action() {
				undo();
			}
		});
		buttons.add(new ButtonImage("/icons/arrow-right.png") {
			public void action() {
				redo();
			}
		});
		buttons.add(new ButtonImage("/icons/lock.png") {
			public void action() {
				groupSelection();
			}
		});
		breaker = new ButtonImage("/icons/lock-open.png");
	}
	
	public MenuAbstract(Menu m) {
		buttons = ((MenuAbstract) m).buttons;
	}
	
	public void saveCanvas() {}
	public void loadCanvas() {}
	
	public abstract void groupSelection();
	public abstract void breakSelection(IShape s);
	
	public void undo() {
		Canvas c = AppInstance.getInstance().getAppEditeur().getCanvas();
		c.undo();
	}
	public void redo() {
		Canvas c = AppInstance.getInstance().getAppEditeur().getCanvas();
		c.redo();
	}
}
