package menu;

import java.util.ArrayList;
import java.util.List;

import application.AppInstance;
import canvas.Canvas;

public abstract class MenuAbstract implements Menu{
	
	protected List<ButtonImage> buttons;
	
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
	}
	
	public MenuAbstract(Menu m) {
		buttons = ((MenuAbstract) m).buttons;
	}
	
	public void saveCanvas() {}
	public void loadCanvas() {}
	
	public void undo() {
		Canvas c = AppInstance.getInstance().getAppEditeur().getCanvas();
		c.undo();
	}
	public void redo() {
		Canvas c = AppInstance.getInstance().getAppEditeur().getCanvas();
		c.redo();
	}
}
