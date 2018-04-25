package igraph;

import canvas.Canvas;
import canvas.CanvasFx;
import edit.Edit;
import javafx.scene.Group;
import menu.CanvasMenu;
import menu.CanvasMenuFx;
import menu.Menu;
import menu.MenuFx;

public class InterfaceFx implements InterfaceGraphique {
	
	private Group _root;
	
	public InterfaceFx(Group root) {
		_root = root;
	}
	
	public Menu createMenu() {
		return new MenuFx(_root);
	}
	public Menu createMenu(Menu barMenu) {
		return new MenuFx(barMenu, _root);
	}
	
	public CanvasMenu createCanvasMenu() {
		return new CanvasMenuFx(_root);
	}
	public CanvasMenu createCanvasMenu(CanvasMenu canvasMenu) {
		return new CanvasMenuFx(canvasMenu, _root);
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
