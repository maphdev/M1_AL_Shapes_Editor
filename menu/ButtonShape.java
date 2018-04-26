package menu;

import shape.IShape;

public class ButtonShape extends Button{
	
	private IShape _s;
	
	public ButtonShape(IShape s) {
		super();
		_s = s;
	}
	
	public IShape getShape() {
		return _s;
	}
	
	public void action() {
		
	}
}
