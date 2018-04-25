package application;

import bar.BarCanvas;
import bar.BarMenu;

public interface InterfaceGraphique {
	
	public BarMenu createBarMenu();
	public BarMenu createBarMenu(BarMenu barMenu);
	
	public BarCanvas createBarCanvas();
	public BarCanvas createBarCanvas(BarCanvas barCanvas);
	
	public Canvas createCanvas();
	public Canvas createCanvas(Canvas canvas);
	
	public EditMenu createEditMenu();
	public EditMenu createEditMenu(EditMenu editMenu);
}
