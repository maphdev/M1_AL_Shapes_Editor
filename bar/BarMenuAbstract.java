package bar;

public abstract class BarMenuAbstract {
	
	protected double _marge = 4;
	protected double _stroke = 2;
	protected double _posX = 0+_marge+_stroke/2;
	protected double _posY = 0+_marge+_stroke/2;
	protected double _width;
	protected double _height;
	
	protected double _buttonMarge = 5;
	
	public void saveCanvas() {}
	public void loadCanvas() {}
	public void undo() {}
	public void redo() {}
}
