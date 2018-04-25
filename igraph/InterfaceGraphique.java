package igraph;

import canvas.Canvas;
import edit.Edit;
import menu.CanvasMenu;
import menu.Menu;

public interface InterfaceGraphique {
	
	public Menu createMenu();
	public Menu createMenu(Menu barMenu);
	
	public CanvasMenu createCanvasMenu();
	public CanvasMenu createCanvasMenu(CanvasMenu barCanvas);
	
	public Canvas createCanvas();
	public Canvas createCanvas(Canvas canvas);
	
	public Edit createEditMenu();
	public Edit createEditMenu(Edit edit);
}
