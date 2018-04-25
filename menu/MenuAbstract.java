package menu;

import java.util.ArrayList;
import java.util.List;

public abstract class MenuAbstract {
	
	protected List<Button> _buttons;
	
	public MenuAbstract() {
		_buttons = new ArrayList<Button>();
		_buttons.add(new Button() {
			public void action() {
				saveCanvas();
			}
		});
		_buttons.add(new Button() {
			public void action() {
				loadCanvas();
			}
		});
		_buttons.add(new Button() {
			public void action() {
				undo();
			}
		});
		_buttons.add(new Button() {
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
