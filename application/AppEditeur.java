package application;

import canvas.Canvas;
import menu.CanvasMenu;
import menu.Menu;

public interface AppEditeur {
	
	public void startLaunch();
	public Menu getMenu();
	public CanvasMenu getCanvasMenu();
	public Canvas getCanvas();
	
}
