package menu;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuAbstract {
	
	protected List<Button> buttons;
	
	public MenuAbstract() {
		buttons = new ArrayList<Button>();
		buttons.add(new Button() {
			public void action() {
				saveCanvas();
			}
		});
		buttons.add(new Button() {
			public void action() {
				loadCanvas();
			}
		});
		buttons.add(new Button() {
			public void action() {
				undo();
			}
		});
		buttons.add(new Button() {
			public void action() {
				redo();
			}
		});
	}
	
	public void saveCanvas() {}
	public void loadCanvas() {}
	public void undo() {}
	public void redo() {}
}
