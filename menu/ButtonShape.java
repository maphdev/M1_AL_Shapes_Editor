package menu;

import shape.IShape;

public class ButtonShape extends Button implements Cloneable{
	
	private IShape _s;
	
	public ButtonShape(IShape s) {
		super();
		_s = s;
	}
	
	public IShape getShape() {
		return _s;
	}
	
	public void setShape(IShape s) {
		_s = s;
	}
	
	public void action() {
		
	}
	
	public ButtonShape clone() {
		ButtonShape b = null;
		try {
			b = (ButtonShape) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return b;
	}

}
