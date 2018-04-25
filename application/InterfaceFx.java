package application;

import bar.BarCanvas;
import bar.BarMenu;
import bar.BarMenuFx;
import javafx.scene.Group;

public class InterfaceFx implements InterfaceGraphique {
	
	private Group _root;
	
	public InterfaceFx(Group root) {
		_root = root;
	}
	
	public BarMenu createBarMenu() {
		return new BarMenuFx(_root);
	}
	public BarMenu createBarMenu(BarMenu barMenu) {
		return null;
	}
	
	public BarCanvas createBarCanvas() {
		return null;
	}
	public BarCanvas createBarCanvas(BarCanvas barCanvas) {
		return null;
	}
	
	public Canvas createCanvas() {
		return null;
	}
	public Canvas createCanvas(Canvas canvas) {
		return null;
	}
	
	public EditMenu createEditMenu() {
		return null;
	}
	public EditMenu createEditMenu(EditMenu editMenu) {
		return null;
	}
	
}
