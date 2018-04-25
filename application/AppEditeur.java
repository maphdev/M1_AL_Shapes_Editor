package application;

import canvas.Canvas;
import menu.CanvasMenu;
import menu.Menu;

public interface AppEditeur {
	
	public void startLaunch();
	public Menu getBarMenu();
	public CanvasMenu getBarCanvas();
	public Canvas getCanvas();
	
}
