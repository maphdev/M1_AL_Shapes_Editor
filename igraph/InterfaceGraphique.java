package igraph;

import canvas.Canvas;
import edit.Edit;
import menu.CanvasMenu;
import menu.Menu;

public interface InterfaceGraphique {
	
	public Menu createBarMenu();
	public Menu createBarMenu(Menu barMenu);
	
	public CanvasMenu createBarCanvas();
	public CanvasMenu createBarCanvas(CanvasMenu barCanvas);
	
	public Canvas createCanvas();
	public Canvas createCanvas(Canvas canvas);
	
	public Edit createEditMenu();
	public Edit createEditMenu(Edit edit);
}
