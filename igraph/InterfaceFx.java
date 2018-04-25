package igraph;

import canvas.Canvas;
import edit.Edit;
import javafx.scene.Group;
import menu.CanvasMenu;
import menu.Menu;
import menu.MenuFx;

public class InterfaceFx implements InterfaceGraphique {
	
	private Group _root;
	
	public InterfaceFx(Group root) {
		_root = root;
	}
	
	public Menu createBarMenu() {
		return new MenuFx(_root);
	}
	public Menu createBarMenu(Menu barMenu) {
		return null;
	}
	
	public CanvasMenu createBarCanvas() {
		return null;
	}
	public CanvasMenu createBarCanvas(CanvasMenu barCanvas) {
		return null;
	}
	
	public Canvas createCanvas() {
		return null;
	}
	public Canvas createCanvas(Canvas canvas) {
		return null;
	}
	
	public Edit createEditMenu() {
		return null;
	}
	public Edit createEditMenu(Edit edit) {
		return null;
	}
	
}
