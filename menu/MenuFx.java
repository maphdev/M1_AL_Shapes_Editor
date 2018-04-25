package menu;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MenuFx extends MenuAbstract implements Menu{
	
	private double _marge = 4;
	private double _stroke = 2;
	private double _buttonMarge = 5;
	
	private double _posX = 0;
	private double _posY = 0;
	private double _width = 800;
	private double _height = 60;
	
	private List<ButtonMenuFx> _buttonsFx;
	
	private Group _root;
	private Rectangle _zone;
	
	public MenuFx(Group root) {
		super();
		_posX += _marge+_stroke/2;
		_posY += _marge+_stroke/2;
		_root = new Group();
		root.getChildren().add(_root);
		_width = _root.getScene().getWidth()-2*(_marge+_stroke/2);
		_height -= 2*(_marge+_stroke/2);
		_zone = new Rectangle();
		_zone.setX(_posX);
		_zone.setY(_posY);
		_zone.setWidth(_width);
		_zone.setHeight(_height);
		_zone.setFill(Color.WHITE);
		_zone.setStroke(Color.BLACK);
		_zone.setStrokeWidth(_stroke);
        _root.getChildren().add(_zone);
        _buttonsFx = new ArrayList<ButtonMenuFx>();
        for(Button b : _buttons) {
        	addButton(b);
        }
	}
	
	private void addButton(Button b) {
		ButtonMenuFx _b = new ButtonMenuFx(
				_buttonsFx.size()*(_height+_buttonMarge)+_posX+_buttonMarge,
				_posY+_buttonMarge,
				_height-2*_buttonMarge,
				b);
		_root.getChildren().add(_b);
		_buttonsFx.add(_b);
	}
}
