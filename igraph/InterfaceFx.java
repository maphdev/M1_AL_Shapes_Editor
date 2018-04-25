package igraph;

import canvas.Canvas;
import canvas.CanvasFx;
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
		return new MenuFx(barMenu, _root);
	}
	
	public CanvasMenu createBarCanvas() {
		return null;
	}
	public CanvasMenu createBarCanvas(CanvasMenu barCanvas) {
		return null;
	}
	
	public Canvas createCanvas() {
		return new CanvasFx(_root);
	}
	public Canvas createCanvas(Canvas canvas) {
		return new CanvasFx(canvas, _root);
	}
	
	public Edit createEditMenu() {
		return null;
	}
	public Edit createEditMenu(Edit edit) {
		return null;
	}
	
}
