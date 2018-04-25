package application;

import bar.BarCanvas;
import bar.BarMenu;

public interface AppEditeur {
	
	public void startLaunch();
	public BarMenu getBarMenu();
	public BarCanvas getBarCanvas();
	public Canvas getCanvas();
	
}
